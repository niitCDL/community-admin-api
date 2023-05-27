package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.dao.BuildingDao;
import com.soft2242.one.entity.Building;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.service.IBuildingService;
import com.soft2242.one.vo.BuildingVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼宇表 服务实现类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor
public class BuildingServiceImpl extends BaseServiceImpl<BuildingDao, Building> implements IBuildingService {

    @Override
    public PageResult<BuildingVO> page(BuildingQuery query) {
        Map<String,Object> params = getParams(query);
        IPage<Building> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        params.put(Constant.PAGE,page);
        List<BuildingVO> list = baseMapper.getList(params);
        return new PageResult<>(list, page.getTotal());
        //return new PageResult<>(CommunityConvert.INSTANCE.convertList(list),page.getTotal());
    }

    private Map<String,Object> getParams(BuildingQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("buildingName",query.getBuildingName());
        return params;
    }

    @Override
    public List<BuildingVO> getList() {
        BuildingQuery query = new BuildingQuery();
        List<Building> entityList = baseMapper.selectList(getWrapper(query));

        return BuildingConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BuildingVO vo) {
        Building entity = BuildingConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(BuildingVO vo) {
        Building entity = BuildingConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<Building> getWrapper(BuildingQuery query) {
        LambdaQueryWrapper<Building> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getBuildingName()), Building::getBuildingName, query.getBuildingName());
        return wrapper;
    }
}
