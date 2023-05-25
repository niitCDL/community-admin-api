package com.soft2242.one.sms.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.sms.entity.SmsPlatformEntity;
import com.soft2242.one.sms.query.SmsPlatformQuery;
import com.soft2242.one.sms.sms.config.SmsConfig;
import com.soft2242.one.sms.vo.SmsPlatformVO;

import java.util.List;

/**
 * 短信平台
 *
 * @author mqxu
 */
public interface SmsPlatformService extends BaseService<SmsPlatformEntity> {

    PageResult<SmsPlatformVO> page(SmsPlatformQuery query);

    /**
     * 启用的短信平台列表
     */
    List<SmsConfig> listByEnable();

    void save(SmsPlatformVO vo);

    void update(SmsPlatformVO vo);

    void delete(List<Long> idList);

}