package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.DeviceTypeConvert;
import com.soft2242.one.dao.DeviceTypeDao;
import com.soft2242.one.entity.DeviceTypeEntity;
import com.soft2242.one.enums.EnabledEnumFlag;
import com.soft2242.one.query.DeviceTypeQuery;
import com.soft2242.one.service.DeviceTypeService;
import com.soft2242.one.vo.DeviceTypeVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备类别表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class DeviceTypeServiceImpl extends BaseServiceImpl<DeviceTypeDao, DeviceTypeEntity> implements DeviceTypeService {

    @Override
    public PageResult<DeviceTypeVO> page(DeviceTypeQuery query) {
        IPage<DeviceTypeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(DeviceTypeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<DeviceTypeEntity> getWrapper(DeviceTypeQuery query){
        LambdaQueryWrapper<DeviceTypeEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getType()), DeviceTypeEntity::getType, query.getType());
        wrapper.like(StringUtils.isNotEmpty(query.getDes()), DeviceTypeEntity::getDes, query.getDes());
        wrapper.eq(query.getEnabled() != null, DeviceTypeEntity::getEnabled, query.getEnabled());
        if (query.isAsc()) {
            wrapper.orderByAsc(DeviceTypeEntity::getOrderd);
        } else {
            wrapper.orderByDesc(DeviceTypeEntity::getOrderd);
        }
        return wrapper;
    }

    @Override
    public List<DeviceTypeEntity> availableList() {
        LambdaQueryWrapper<DeviceTypeEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(DeviceTypeEntity::getEnabled, EnabledEnumFlag.ENABLED.getValue());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void save(DeviceTypeVO vo) {
        DeviceTypeEntity entity = DeviceTypeConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(DeviceTypeVO vo) {
        DeviceTypeEntity entity = DeviceTypeConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}