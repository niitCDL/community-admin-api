package com.soft2242.one.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.soft2242.one.sms.convert.SmsLogConvert;
import com.soft2242.one.sms.dao.SmsLogDao;
import com.soft2242.one.sms.entity.SmsLogEntity;
import com.soft2242.one.sms.query.SmsLogQuery;
import com.soft2242.one.sms.service.SmsLogService;
import com.soft2242.one.sms.vo.SmsLogVO;

/**
 * 短信日志
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SmsLogServiceImpl extends BaseServiceImpl<SmsLogDao, SmsLogEntity> implements SmsLogService {

    @Override
    public PageResult<SmsLogVO> page(SmsLogQuery query) {
        IPage<SmsLogEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(SmsLogConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<SmsLogEntity> getWrapper(SmsLogQuery query) {
        LambdaQueryWrapper<SmsLogEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getPlatform() != null, SmsLogEntity::getPlatform, query.getPlatform());
        wrapper.like(query.getPlatformId() != null, SmsLogEntity::getPlatformId, query.getPlatformId());
        wrapper.orderByDesc(SmsLogEntity::getId);
        return wrapper;
    }

}