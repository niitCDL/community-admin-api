package com.soft2242.one.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.VisitorInvitationConvert;
import com.soft2242.one.dao.VisitorInvitationMapper;
import com.soft2242.one.entity.VisitorInvitation;
import com.soft2242.one.query.VisitorInvitationQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.service.IHouseService;
import com.soft2242.one.service.IVisitorInvitationService;
import com.soft2242.one.service.IVisitorService;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.vo.VisitorInvitationVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor
public class VisitorInvitationServiceImpl extends BaseServiceImpl<VisitorInvitationMapper, VisitorInvitation> implements IVisitorInvitationService {
    private final IVisitorService visitorService;
    private final IHouseService houseService;
    private final ICommunityService communityService;
    private final SysUserService sysUserService;


    private LambdaQueryWrapper<VisitorInvitation> getWrapper(VisitorInvitationQuery query) {
        LambdaQueryWrapper<VisitorInvitation> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    private List<VisitorInvitationVO> addInfo(List<VisitorInvitationVO> vos) {
        try {
            vos.forEach(o -> {
                o.setHouseNumber(houseService.getById(o.getHouseId()).getHouseNumber());
    //            开门次数
                o.setCount(visitorService.getById(o.getVisitorId()).getCount());
    //            插入有效时间
                Duration duration = Duration.between(o.getCreateTime(), o.getEndTime());
                o.setValidTime(String.valueOf((duration.toMinutes() / 60)) + "小时");
    //            插入社区名称
    //            获取社区id
                Long communityId = houseService.getById(o.getHouseId()).getCommunityId();
                o.setCommunityName(communityService.getById(communityId).getCommunityName());
    //            根据adminId获取授权人
                SysUserInfoEntity user = sysUserService.getUserInfoByAdminId(o.getUserId());
                if (user ==null)
                    new ServerException("业务处理出现异常！");
                else {
                    o.setOwner(user.getRealName());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("业务处理出现异常！"+e.getMessage());
        }
        return vos;
    }

    @Override
    public PageResult<VisitorInvitationVO> page(VisitorInvitationQuery query) {
        IPage<VisitorInvitation> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<VisitorInvitationVO> vos = VisitorInvitationConvert.INSTANCE.convertList(page.getRecords());
        return new PageResult<>(addInfo(vos), page.getTotal());
    }

    @Override
    public PageResult<VisitorInvitationVO> getAll(Long userId) {
        List<VisitorInvitation> all = baseMapper.findAll(userId);
        List<VisitorInvitationVO> vos = VisitorInvitationConvert.INSTANCE.convertList(all);

        return new PageResult<>(addInfo(vos), all.size());

    }

    @Override
    public List<VisitorInvitation> getAll2(Long userId) {
        return baseMapper.findAll(userId);
    }

    @Override
    public List<VisitorInvitationVO> getInvitationList() {
        List<VisitorInvitation> visitorInvitations = baseMapper.selectList(getWrapper(new VisitorInvitationQuery()));
        List<VisitorInvitationVO> vos = VisitorInvitationConvert.INSTANCE.convertList(visitorInvitations);
        return addInfo(vos);
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
