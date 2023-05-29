package com.soft2242.one.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.UserVO;
import com.soft2242.one.query.UserQuery;
import com.soft2242.one.entity.UserEntity;

import java.util.List;

/**
 * 用户信息表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */
public interface UserService extends BaseService<UserEntity> {

    PageResult<UserVO> page(UserQuery query);

    void save(UserVO vo);

    void update(UserVO vo);

    void delete(List<Long> idList);
}