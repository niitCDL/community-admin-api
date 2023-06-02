package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.CarConvert;
import com.soft2242.one.convert.CarportConvert;
import com.soft2242.one.dao.CarDao;
import com.soft2242.one.dao.CarportDao;
import com.soft2242.one.entity.Car;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.query.CarQuery;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.service.CarService;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.soft2242.one.vo.CarVO;
import com.soft2242.one.vo.CarportVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CarServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:25
 */
@Service
@AllArgsConstructor
public class CarServiceImpl extends BaseServiceImpl<CarDao, Car> implements CarService {

    private final CustomExcelUtils customExcelUtils;
    @Override
    public PageResult<CarVO> page(CarQuery query) {
        IPage<Car> page = getPage(query);
        Map<String,Object> params=getParams(query);
        params.put("page",page);
        List<CarVO> list = baseMapper.getList(params);
        return new PageResult<>(list,page.getTotal());
    }

    private Map<String,Object> getParams(CarQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("licence",query.getLicence());
        params.put("realName",query.getRealName());
        params.put("brand",query.getBrand());
        return params;
    }

    @Override
    public List<CarVO> getList() {
        CarQuery query = new CarQuery();
        List<Car> entityList = baseMapper.selectList(getWrapper(query));

        return CarConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CarVO vo) {
        Car entity = CarConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CarVO vo) {
        Car entity = CarConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void export() {
        CarQuery query = new CarQuery();
        Map<String, Object> params = getParams(query);
        List<CarVO> carList = baseMapper.getList(params);
        try {
            customExcelUtils.export(carList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<CarVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, CarVO.class,dataVoList);
            System.out.println("导入成功！！！！");
            List<Car> cars = CarConvert.INSTANCE.convertListEntity(dataVoList);
            for (Car car : cars) {
                baseMapper.insert(car);
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

    private Wrapper<Car> getWrapper(CarQuery query) {
        LambdaQueryWrapper<Car> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getLicence()), Car::getLicence, query.getLicence());
        return wrapper;
    }
}
