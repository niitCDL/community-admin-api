package com.soft2242.one.base.mybatis.handler;

import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.base.security.user.SecurityUser;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * mybatis-plus 自动填充字段
 *
 * @author moqi
 */
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATE_TIME = "createTime";
    private final static String CREATOR = "creator";
    private final static String UPDATE_TIME = "updateTime";
    private final static String UPDATER = "updater";
    private final static String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        UserDetail user = SecurityUser.getUser();
        Date date = new Date();

        // 创建者
        strictInsertFill(metaObject, CREATOR, Long.class, user.getId());
        // 创建时间
        strictInsertFill(metaObject, CREATE_TIME, Date.class, date);
        // 更新者
        strictInsertFill(metaObject, UPDATER, Long.class, user.getId());
        // 更新时间
        strictInsertFill(metaObject, UPDATE_TIME, Date.class, date);
        // 删除标识
        strictInsertFill(metaObject, DELETED, Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新者
        strictUpdateFill(metaObject, UPDATER, Long.class, SecurityUser.getUserId());
        // 更新时间
        strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }

}