package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import com.soft2242.one.convert.UserConvert;
import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.query.UserQuery;
import com.soft2242.one.vo.UserVO;
import com.soft2242.one.dao.UserDao;
import com.soft2242.one.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageResult<UserVO> page(UserQuery query) {
        IPage<UserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(UserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<UserEntity> getWrapper(UserQuery query){
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(Long.toString(query.getId())), UserEntity::getId, query.getId());
        return wrapper;
    }

    @Override
    public void save(UserVO vo) {
        UserEntity entity = UserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(UserVO vo) {
        UserEntity entity = UserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}