package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.convert.HouseConvert;
import com.soft2242.one.dao.HouseDao;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.House;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.HouseQuery;
import com.soft2242.one.service.IHouseService;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.HouseVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务实现类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor
public class HouseServiceImpl extends BaseServiceImpl<HouseDao, House> implements IHouseService {
    //    @Override
//    public PageResult<BuildingVO> page(BuildingQuery query) {
//        Map<String,Object> params = getParams(query);
//        IPage<Building> page = baseMapper.selectPage(getPage(query), getWrapper(query));
//        params.put(Constant.PAGE,page);
//        List<BuildingVO> list = baseMapper.getList(params);
//        return new PageResult<>(list, page.getTotal());
//        //return new PageResult<>(CommunityConvert.INSTANCE.convertList(list),page.getTotal());
//    }
    private final CustomExcelUtils customExcelUtils;
    @Override
    public PageResult<HouseVO> page(HouseQuery query) {
        IPage<House> page = getPage(query);
        Map<String,Object> params=getParams(query);
        params.put("page",page);
        List<HouseVO> list = baseMapper.getList(params);
        return new PageResult<>(list,page.getTotal());
    }

    private Map<String,Object> getParams(HouseQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("buildingName",query.getBuildingName());
        params.put("communityName",query.getCommunityName());
        params.put("units",query.getUnits());
        params.put("houseNumber",query.getHouseNumber());
        return params;
    }

    @Override
    public List<HouseVO> getList() {
        HouseQuery query = new HouseQuery();
        List<House> entityList = baseMapper.selectList(getWrapper(query));

        return HouseConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(HouseVO vo) {
        House entity = HouseConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(HouseVO vo) {
        House entity = HouseConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void export() {
        HouseQuery query = new HouseQuery();
        Map<String, Object> params = getParams(query);
        List<HouseVO> houseVOList = baseMapper.getList(params);
        try {
            customExcelUtils.export(houseVOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<HouseVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, HouseVO.class,dataVoList);
            System.out.println("导入成功！！！！");
            List<House> houses = HouseConvert.INSTANCE.convertListEntity(dataVoList);
            for (House house : houses) {
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

    private Wrapper<House> getWrapper(HouseQuery query) {
        LambdaQueryWrapper<House> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getHouseNumber()), House::getHouseNumber, query.getHouseNumber());
        return wrapper;
    }

}
