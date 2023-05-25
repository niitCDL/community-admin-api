package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.DeviceConvert;
import com.soft2242.one.dao.DeviceDao;
import com.soft2242.one.entity.DeviceEntity;
import com.soft2242.one.query.DeviceQuery;
import com.soft2242.one.service.DeviceService;
import com.soft2242.one.vo.DeviceVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备表
 *
 * @author Flobby
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDao, DeviceEntity> implements DeviceService {

    @Override
    public PageResult<DeviceVO> page(DeviceQuery query) {
        List<DeviceVO> deviceVOList = baseMapper.selectDeviceByPage(query);
        IPage<DeviceEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(deviceVOList, page.getTotal());
    }

    private LambdaQueryWrapper<DeviceEntity> getWrapper(DeviceQuery query){
        LambdaQueryWrapper<DeviceEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getDeviceName()), DeviceEntity::getDeviceName, query.getDeviceName());
        wrapper.eq(query.getStatus() != null, DeviceEntity::getStatus, query.getStatus());
        wrapper.eq(query.getDeviceType() != null, DeviceEntity::getDeviceType, query.getDeviceType());
        wrapper.eq(query.getCommunityId() != null, DeviceEntity::getCommunityId, query.getCommunityId());
        wrapper.like(StringUtils.isNotEmpty(query.getAddress()), DeviceEntity::getAddress, query.getAddress());
        return wrapper;
    }

    @Override
    public void save(DeviceVO vo) {
        DeviceEntity entity = DeviceConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(DeviceVO vo) {
        DeviceEntity entity = DeviceConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}