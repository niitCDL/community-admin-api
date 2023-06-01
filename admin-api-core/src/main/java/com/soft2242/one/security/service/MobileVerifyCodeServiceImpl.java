package com.soft2242.one.security.service;

import com.soft2242.one.api.SmsApi;
import com.soft2242.one.base.security.mobile.MobileVerifyCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile, code);
    }
}
