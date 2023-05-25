package com.soft2242.one.system.service;


import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.entity.SysMenuEntity;
import com.soft2242.one.system.vo.SysMenuVO;

import java.util.List;
import java.util.Set;


/**
 * 菜单管理
 *
 * @author moqi
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(Long id);

    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取子菜单的数量
     *
     * @param pid 父菜单ID
     */
    Long getSubMenuCount(Long pid);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}
