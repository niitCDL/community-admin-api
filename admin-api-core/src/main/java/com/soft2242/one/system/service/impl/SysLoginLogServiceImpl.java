package com.soft2242.one.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.*;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.convert.SysLoginLogConvert;
import com.soft2242.one.system.dao.SysLoginLogDao;
import com.soft2242.one.system.dao.SysUserInfoDao;
import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.entity.SysRoleEntity;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.query.SysLoginLogQuery;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.service.SysLoginLogService;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysLoginLogExcelVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogDao, SysLoginLogEntity> implements SysLoginLogService {

    private final CustomExcelUtils customExcelUtils;

    /**
     * 记录用户日志
     */
    public void record(UserDetail user) {

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
            sysLoginLogEntity.setCreator(user.getId());
            sysLoginLogEntity.setCreatorName(user.getUsername());
            baseMapper.insert(sysLoginLogEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void export() {
        List<SysLoginLogExcelVO> excelVOS = SysLoginLogConvert.INSTANCE.convertList(baseMapper.selectList(null));
        try {
            customExcelUtils.export(excelVOS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageResult<SysLoginLogExcelVO> page(SysLoginLogQuery query) {
        IPage<SysLoginLogEntity> page = baseMapper.getCusPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysLoginLogConvert.INSTANCE.convertList(page.getRecords()),page.getTotal());
    }

    private LambdaQueryWrapper<SysLoginLogEntity> getWrapper(SysLoginLogQuery query){
        LambdaQueryWrapper<SysLoginLogEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getCreatorName()), SysLoginLogEntity::getCreatorName, query.getCreatorName());
        return wrapper;
    }

}
