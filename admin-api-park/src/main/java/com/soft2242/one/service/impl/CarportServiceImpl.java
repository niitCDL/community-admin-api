package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.dao.CarportDao;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.service.CarportService;
import com.soft2242.one.vo.CarportVO;
import lombok.AllArgsConstructor;
import com.soft2242.one.convert.CarportConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName CarportServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:23
 */
@Service
@AllArgsConstructor
public class CarportServiceImpl extends BaseServiceImpl<CarportDao, Carport> implements CarportService {
    private final CustomExcelUtils customExcelUtils;
    @Override
    public PageResult<CarportVO> page(CarportQuery query) {
        IPage<Carport> page = getPage(query);
        Map<String,Object> params=getParams(query);
        params.put("page",page);
        List<CarportVO> list = baseMapper.getList(params);
        return new PageResult<>(list,page.getTotal());
    }

    private Map<String,Object> getParams(CarportQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("licence",query.getLicence());
        params.put("realName",query.getRealName());
        params.put("parkName",query.getParkName());
        params.put("carportName",query.getCarportName());
        return params;
    }

    @Override
    public List<CarportVO> getList() {
        CarportQuery query = new CarportQuery();
        List<Carport> entityList = baseMapper.selectList(getWrapper(query));

        return CarportConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CarportVO vo) {
        Carport entity = CarportConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CarportVO vo) {
        Carport entity = CarportConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void export() {
        CarportQuery query = new CarportQuery();
        Map<String, Object> params = getParams(query);
        List<CarportVO> houseVOList = baseMapper.getList(params);
        try {
            customExcelUtils.export(houseVOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<CarportVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, CarportVO.class,dataVoList);
            System.out.println("导入成功！！！！");
            List<Carport> houses = CarportConvert.INSTANCE.convertListEntity(dataVoList);
            for (Carport house : houses) {
                baseMapper.insert(house);
            }
            System.out.println("导入成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<Carport> getWrapper(CarportQuery query) {
        LambdaQueryWrapper<Carport> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getCarportName()), Carport::getCarportName, query.getCarportName());
        return wrapper;
    }
}
