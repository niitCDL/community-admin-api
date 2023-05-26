package com.soft2242.one.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.VisitorInvitationConvert;
import com.soft2242.one.dao.VisitorInvitationMapper;
import com.soft2242.one.entity.VisitorInvitation;
import com.soft2242.one.query.VisitorInvitationQuery;
import com.soft2242.one.service.IVisitorInvitationService;
import com.soft2242.one.vo.VisitorInvitationVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 * @author ysh
 * @since 2023-05-25
 */
@Service

public class VisitorInvitationServiceImpl extends BaseServiceImpl<VisitorInvitationMapper, VisitorInvitation> implements IVisitorInvitationService {

    private LambdaQueryWrapper<VisitorInvitation> getWrapper(VisitorInvitationQuery query) {
        LambdaQueryWrapper<VisitorInvitation> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public PageResult<VisitorInvitationVO> page(VisitorInvitationQuery query) {
        IPage<VisitorInvitation> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(VisitorInvitationConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public PageResult<VisitorInvitationVO> getAll(Long userId) {
        List<VisitorInvitation> all = baseMapper.findAll(userId);
        PageResult<VisitorInvitationVO> visitorInvitationVOPageResult =
                new PageResult<>(VisitorInvitationConvert.INSTANCE.convertList(all), all.size());

        System.out.println(visitorInvitationVOPageResult);
        return visitorInvitationVOPageResult;

    }

    @Override
    public List<VisitorInvitation> getAll2(Long userId) {
        return baseMapper.findAll(userId);
    }

    @Override
    public void save(VisitorInvitationVO vo) {
        baseMapper.insert(VisitorInvitationConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(VisitorInvitationVO vo) {
        updateById(VisitorInvitationConvert.INSTANCE.convert(vo));
    }

}
