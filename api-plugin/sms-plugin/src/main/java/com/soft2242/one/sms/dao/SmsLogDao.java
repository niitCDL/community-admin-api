package com.soft2242.one.sms.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.sms.entity.SmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信日志
 *
 * @author mqxu
 */
@Mapper
public interface SmsLogDao extends BaseDao<SmsLogEntity> {

}