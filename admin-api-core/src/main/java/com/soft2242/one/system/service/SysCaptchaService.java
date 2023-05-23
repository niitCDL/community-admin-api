package com.soft2242.one.system.service;


import com.soft2242.one.system.vo.SysCaptchaVO;

/**
 * 验证码
 *
 * @author ao&dl
 */
public interface SysCaptchaService {
    /**
     * 生成验证码
     */
    SysCaptchaVO generate();

    /**
     * 验证码效验
     *
     * @param key  key
     * @param code 验证码
     * @return true：成功  false：失败
     */
    boolean validate(String key, String code);
}
