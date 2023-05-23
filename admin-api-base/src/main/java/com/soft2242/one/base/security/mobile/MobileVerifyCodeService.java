package com.soft2242.one.base.security.mobile;

/**
 * 手机短信登录，验证码效验
 *
 * @author moqi
 */
public interface MobileVerifyCodeService {

    boolean verifyCode(String mobile, String code);
}
