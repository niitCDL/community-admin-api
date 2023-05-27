package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.base.security.utils.TokenUtils;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysRoleOperationLogConvert;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;
import com.soft2242.one.system.dao.SysRoleOperationLogDao;
import com.soft2242.one.system.service.SysRoleOperationLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;

/**
 * 角色操作记录表
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class SysRoleOperationLogServiceImpl extends BaseServiceImpl<SysRoleOperationLogDao, SysRoleOperationLogEntity> implements SysRoleOperationLogService {

    private final TokenStoreCache tokenStoreCache;
    private final CustomExcelUtils customExcelUtils;
    @Override
    public PageResult<SysRoleOperationLogVO> page(SysRoleOperationLogQuery query) {
        IPage<SysRoleOperationLogEntity> cusPage = baseMapper.getCusPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysRoleOperationLogConvert.INSTANCE.convertList(cusPage.getRecords()), cusPage.getTotal());
    }

    private LambdaQueryWrapper<SysRoleOperationLogEntity> getWrapper(SysRoleOperationLogQuery query){
        LambdaQueryWrapper<SysRoleOperationLogEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(SysRoleOperationLogVO vo) {
        SysRoleOperationLogEntity entity = SysRoleOperationLogConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void log(Long operationObject, String operation, String reason) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        UserDetail user = tokenStoreCache.getUser(TokenUtils.getAccessToken(request));

        SysRoleOperationLogEntity logEntity = new SysRoleOperationLogEntity();
        logEntity.setCreateTime(new Date());
        logEntity.setUpdateTime(new Date());
        logEntity.setUpdater(user.getId());
        logEntity.setCreator(user.getId());

        logEntity.setOperationObject(operationObject);
        logEntity.setOperate(operation);
        logEntity.setReason(reason);

         save(logEntity);
    }

    @Override
    public void update(SysRoleOperationLogVO vo) {
        SysRoleOperationLogEntity entity = SysRoleOperationLogConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public void export(String toPath) {
        SysRoleOperationLogQuery sysRoleOperationLogQuery = new SysRoleOperationLogQuery();
        sysRoleOperationLogQuery.setPage(1);
        sysRoleOperationLogQuery.setLimit(999);

        IPage<SysRoleOperationLogEntity> cusPage = baseMapper.getCusPage(getPage(sysRoleOperationLogQuery), getWrapper(sysRoleOperationLogQuery));
        List<SysRoleOperationLogVO> list = SysRoleOperationLogConvert.INSTANCE.convertList(cusPage.getRecords());

        try {
            customExcelUtils.export(toPath,list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}