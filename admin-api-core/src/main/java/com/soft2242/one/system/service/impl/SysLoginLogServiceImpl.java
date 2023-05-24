package com.soft2242.one.system.service.impl;

import com.soft2242.one.base.common.utils.AddressUtils;
import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.common.utils.HttpContextUtils;
import com.soft2242.one.base.common.utils.IpUtils;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.dao.SysLoginLogDao;
import com.soft2242.one.system.dao.SysUserInfoDao;
import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysLoginLogService;
import com.soft2242.one.system.service.SysUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

@Service
@AllArgsConstructor
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogDao, SysLoginLogEntity> implements SysLoginLogService {

    /**
     * 记录用户日志
     */
    public void record() {

        try {
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            String ip = IpUtils.getIpAddr(request);
            String address = AddressUtils.getAddressByIp(ip);
            String deviceName = InetAddress.getLocalHost().getHostName();
            String deviceMac = IpUtils.getLocalMac(ip);
            String browserType = request.getHeader("user-agent");
            String os = System.getProperty("os.name");
            String terminalType;
            if (os.contains("Windows")) {
                terminalType = "Windows终端";
            } else if (os.contains("Linux")) {
                terminalType = "Linux终端";
            } else {
                terminalType = "其他终端";
            }


            String currentDate = DateUtils.format(DateUtils.CURRENT_DATE, DateUtils.DATE_TIME_PATTERN);
            //记录用户日志
            SysLoginLogEntity sysLoginLogEntity = new SysLoginLogEntity();
            sysLoginLogEntity.setLoginIp(ip);
            sysLoginLogEntity.setBrowserType(browserType);
            sysLoginLogEntity.setOs(os);
            sysLoginLogEntity.setAddress(address);
            sysLoginLogEntity.setTerminalType(terminalType);
            sysLoginLogEntity.setDeleted(0);
            sysLoginLogEntity.setDeviceName(deviceName);
            sysLoginLogEntity.setDeviceMac(deviceMac);
            sysLoginLogEntity.setLoginTime(currentDate);
            sysLoginLogEntity.setCreateTime(currentDate);

            baseMapper.insert(sysLoginLogEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
