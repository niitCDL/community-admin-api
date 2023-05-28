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
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.OrderExcelVO;
import com.soft2242.one.vo.OrderRecordVO;
import com.soft2242.one.vo.OrderVO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.soft2242.one.service.IHouseService;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor

public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    IHouseService houseService;
    private final ICommunityService communityService;


    private LambdaQueryWrapper<Order> getWrapper(OrderQuery query) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public PageResult<OrderVO> page(OrderQuery query) {
        IPage<Order> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<OrderVO> orderVOS = OrderConvert.INSTANCE.convertList(page.getRecords());
//        VO进行多表查询插入连表字段：插入房屋表的房屋编号字段和小区字段
        orderVOS.forEach(orderVO -> {
            House house = houseService.getById(orderVO.getHouseId());
            orderVO.setHouseNumber(house.getHouseNumber());
            orderVO.setCommunityName(communityService.getById(house.getCommunityId()).getCommunityName());
        });

        return new PageResult<>(orderVOS, page.getTotal());
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
        List<OrderRecordVO> orderRecordVOS = new ArrayList<>();

//        遍历
        for (Order order : list) {

            orderRecordVOS.add(OrderRecordVO.builder()
                    .comminityId(order.getComminityId())
                    .houseId(order.getHouseId())
                    .communityName(communityService.getById(houseService.getById(order.getHouseId()).getCommunityId()).getCommunityName())
                    .houseNumber(houseService.getById(order.getHouseId()).getHouseNumber())
                    .waterFee(order.getMoney())
                    .electricFee(order.getMoney())
                    .propertyFee(order.getMoney())
                    .status1(order.getStatus())
                    .status2(order.getStatus())
                    .build());
        }
        return orderRecordVOS;
    }
}
