package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.excel.ExcelFinishCallBack;
import com.soft2242.one.base.common.utils.ExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.OrderConvert;
import com.soft2242.one.dao.OrderMapper;
import com.soft2242.one.entity.House;
import com.soft2242.one.entity.Order;
import com.soft2242.one.query.OrderQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.service.IOrderService;
import com.soft2242.one.vo.OrderExcelVO;
import com.soft2242.one.vo.OrderRecordVO;
import com.soft2242.one.vo.OrderVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.soft2242.one.service.IHouseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类
 * @author ysh
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor

public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {
    //    @Autowired
    private final IHouseService houseService;
    private final ICommunityService communityService;


    private LambdaQueryWrapper<Order> getWrapper(OrderQuery query) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    //    时间格式转换
    private String changeForm(LocalDateTime create, LocalDateTime end) {
        return create.toString().substring(0, 10) + "~" + end.toString().substring(0, 10);
    }

    private List<OrderVO> changeVO(List<OrderVO> orderVOS) {
        orderVOS.forEach(orderVO -> {
            House house = houseService.getById(orderVO.getHouseId());
            if (house != null) {
                orderVO.setHouseNumber(house.getHouseNumber());
                orderVO.setCommunityName(communityService.getById(house.getCommunityId()).getCommunityName());
//                插入时间差
                orderVO.setOTime(changeForm(orderVO.getCreateTime(), orderVO.getEndTime()));
//                计算价格
                orderVO.setOrderMoney(
                        Double.parseDouble(orderVO.getPrice())* orderVO.getAmount()
                );
            }
        });
        return orderVOS;
    }


    @Override
    public PageResult<OrderVO> page(OrderQuery query) {
        IPage<Order> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<OrderVO> orderVOS = OrderConvert.INSTANCE.convertList(page.getRecords());
//        VO进行多表查询插入连表字段：插入房屋表的房屋编号字段和小区字段
        return new PageResult<>(changeVO(orderVOS), page.getTotal());
    }

    @Override
    public PageResult<OrderVO> recordPage(OrderQuery query) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery();
//        根据订单类型抄表水电费订单
        wrapper.eq(Order::getOrderType, 3).or().eq(Order::getOrderType, 4);
        IPage<Order> page = baseMapper.selectPage(getPage(query), wrapper);
//        获取vos
        List<OrderVO> orderVOS = OrderConvert.INSTANCE.convertList(page.getRecords());
//        VO进行多表查询插入连表字段：插入房屋表的房屋编号字段和小区
        return new PageResult<>(changeVO(orderVOS), page.getTotal());
    }


    @Override
    public void save(OrderVO vo) {
        baseMapper.insert(OrderConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(OrderVO vo) {
        updateById(OrderConvert.INSTANCE.convert(vo));
    }

    @Override
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importByExcel(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        ExcelUtils.readAnalysis(file, OrderExcelVO.class, new ExcelFinishCallBack<>() {
            @Override
            public void doAfterAllAnalysed(List<OrderExcelVO> result) {
                System.out.println(result);
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<OrderExcelVO> result) {
                System.out.println(result);
                saveUser(result);
            }

            private void saveUser(List<OrderExcelVO> result) {
                ExcelUtils.parseDict(result);
                List<Order> orders = OrderConvert.INSTANCE.convertListEntity(result);
//                保存
                saveBatch(orders);
            }
        });
    }

    @Override
    @SneakyThrows
    public void export() {
        List<Order> list = list(Wrappers.lambdaQuery(Order.class).eq(Order::getStatus, 0));

        System.out.println(list);
        List<OrderExcelVO> orderExcelVOS = OrderConvert.INSTANCE.convertList2(list);
        System.out.println(orderExcelVOS);
        ExcelUtils.excelExport(OrderExcelVO.class, "order_export", "sheet1", orderExcelVOS);
    }

    @Override
    @SneakyThrows
    public void export2() {
        List<OrderRecordVO> list = getRecordList();
        System.out.println(list);
        List<OrderRecordVO> orderExcelVOS = (list);
        System.out.println(orderExcelVOS);
        ExcelUtils.excelExport(OrderRecordVO.class, "orderRecord_export", "sheet1", orderExcelVOS);
    }

    @Override
    public List<Order> findByHouseId(Long id) {
        List<Order> list = list(Wrappers.lambdaQuery(Order.class).eq(Order::getHouseId, id));
        return list;
    }

    @Override
    public List<Order> getList() {
        List<Order> list = baseMapper.selectList(getWrapper(new OrderQuery()));
        return list;
    }

    @Override
    public List<OrderRecordVO> getRecordList() {
        List<Order> list = getList();
        List<OrderRecordVO> recordList = new ArrayList<>();

        List<OrderRecordVO> orderRecordVOS = new ArrayList<>();
        List<CheckBean> checkList = new ArrayList<>();

        for (Order order : list) {
            orderRecordVOS.add(OrderRecordVO.builder()
                    .comminityId(houseService.getById(order.getHouseId()).getCommunityId())
                    .houseId(order.getHouseId())
                    .communityName(communityService.getById(houseService.getById(order.getHouseId()).getCommunityId()).getCommunityName())
                    .houseNumber(houseService.getById(order.getHouseId()).getHouseNumber())
                    .status1(order.getStatus())
                    .status2(order.getStatus())
                    .waterFee(0.0)
                    .electricFee(0.0)
                    .propertyFee(0.0)
                    .endTime(order.getEndTime())
                    .build());
        }
//        遍历
        for (OrderRecordVO order : orderRecordVOS) {
            int count = 0;
            int status2 = 0;
            double percent = 0.0;
//        去除重复
            if (checkList.contains(new CheckBean(order.getHouseId(), order.getComminityId())))
                continue;

//            判断是否存在相同户号和社区号,如果存在则累计计算费用
            for (Order o : list) {
                if (order.getHouseId().equals(o.getHouseId()) && order.getComminityId().equals(houseService.getById(o.getHouseId()).getCommunityId())) {
//                    记录账单费用
                    if (o.getOrderType() == 3)
                        order.setWaterFee(o.getMoney());
                    else if (o.getOrderType() == 4)
                        order.setElectricFee(o.getMoney());
                    else if (o.getOrderType() == 5)
                        order.setPropertyFee(o.getMoney());
                    else {
                        order.setWaterFee(0.0);
                        order.setElectricFee(0.0);
                        order.setPropertyFee(0.0);
                    }
                    count = +1;
//                    记录订单完成状态
                    if (o.getStatus() == 1)
                        status2 = +1;
                }

            }
            if (status2 == 0) {
                percent = 0.0;
            } else
                percent = (double) status2 / count;
//            记录订单总金额和完成度

            order.setCount(order.getElectricFee() + order.getWaterFee() + order.getPropertyFee());
            order.setPercent(percent);
//                合成一条新的记录
            if (!recordList.contains(order)) {
                recordList.add(order);
                checkList.add(new CheckBean(order.getHouseId(), order.getComminityId()));
            }
        }
//        去除重复
//        List<OrderRecordVO> tamp = new ArrayList<>(new HashSet<>(recordList));

        return recordList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class CheckBean {
        private Long houseId;
        private Long comminityId;

    }
}
