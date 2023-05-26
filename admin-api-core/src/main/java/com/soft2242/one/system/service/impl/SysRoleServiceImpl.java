package com.soft2242.one.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.base.security.utils.TokenUtils;
import com.soft2242.one.system.convert.SysRoleConvert;
import com.soft2242.one.system.convert.SysRoleOperationLogConvert;
import com.soft2242.one.system.dao.SysRoleDao;
import com.soft2242.one.system.entity.SysRoleEntity;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.enums.DataScopeEnum;
import com.soft2242.one.system.query.SysRoleQuery;
import com.soft2242.one.system.service.*;
import com.soft2242.one.system.vo.SysRoleDataScopeVO;
import com.soft2242.one.system.vo.SysRoleVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 角色
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    private final SysRoleMenuService sysRoleMenuService;
    private final SysRoleDataScopeService sysRoleDataScopeService;
    private final SysUserRoleService sysUserRoleService;
    private final SysRoleOperationLogService sysRoleOperationLogService;
    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        IPage<SysRoleEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysRoleConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<SysRoleVO> getList(SysRoleQuery query) {
        List<SysRoleEntity> entityList = baseMapper.selectList(getWrapper(query));

        return SysRoleConvert.INSTANCE.convertList(entityList);
    }

    private Wrapper<SysRoleEntity> getWrapper(SysRoleQuery query) {
        LambdaQueryWrapper<SysRoleEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getName()), SysRoleEntity::getName, query.getName());

        // 数据权限
        dataScopeWrapper(wrapper);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);

        // 保存角色
        entity.setDataScope(DataScopeEnum.SELF.getValue());
        baseMapper.insert(entity);

        // 新增操作日志
        sysRoleOperationLogService.log(entity.getId(),"新增","");

        // 保存角色菜单关系
        sysRoleMenuService.saveOrUpdate(entity.getId(), vo.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);

        // 更新角色
        updateById(entity);

        // 更新角色菜单关系
        sysRoleMenuService.saveOrUpdate(entity.getId(), vo.getMenuIdList());

        // 新增操作日志
        sysRoleOperationLogService.log(entity.getId(),"修改","");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dataScope(SysRoleDataScopeVO vo) {
        SysRoleEntity entity = getById(vo.getId());
        entity.setDataScope(vo.getDataScope());
        // 更新角色
        updateById(entity);

        // 更新角色数据权限关系
        if (vo.getDataScope().equals(DataScopeEnum.CUSTOM.getValue())) {
            sysRoleDataScopeService.saveOrUpdate(entity.getId(), vo.getOrgIdList());
        } else {
            sysRoleDataScopeService.deleteByRoleIdList(Collections.singletonList(vo.getId()));
        }

        // 新增操作日志
        sysRoleOperationLogService.log(entity.getId(),"更新角色数据权限","");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        // 删除角色
        removeByIds(idList);

        // 删除用户角色关系
        sysUserRoleService.deleteByRoleIdList(idList);

        // 删除角色菜单关系
        sysRoleMenuService.deleteByRoleIdList(idList);

        // 删除角色数据权限关系
        sysRoleDataScopeService.deleteByRoleIdList(idList);

        // 新增操作日志
        for (Long id:idList
             ) {
            sysRoleOperationLogService.log(id,"新增","");
        }
    }

}