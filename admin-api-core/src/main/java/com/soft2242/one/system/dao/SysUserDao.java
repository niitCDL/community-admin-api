package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author mqxu
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {


    Long getMaxId();

    String getTokenById(@Param("id") Long id);

    SysUserEntity getByUsername(@Param("username") String username);

<<<<<<< HEAD
    void saveAvatar(@Param("adminId")Long adminId,@Param("url")String url);
=======
    default SysUserEntity getByMobile(String mobile) {
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("phone", mobile));
    }
>>>>>>> origin/test
}