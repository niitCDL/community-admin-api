package com.soft2242.one.sms.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.sms.entity.SmsLogEntity;
import com.soft2242.one.sms.query.SmsLogQuery;
import com.soft2242.one.sms.vo.SmsLogVO;

/**
 * 短信日志
 *
 * @author mqxu
 */
public interface SmsLogService extends BaseService<SmsLogEntity> {

    PageResult<SmsLogVO> page(SmsLogQuery query);

}