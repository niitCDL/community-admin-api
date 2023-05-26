package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.VisitorInvitation;
import com.soft2242.one.query.VisitorInvitationQuery;
import com.soft2242.one.vo.VisitorInvitationVO;

import java.util.List;

/**
 * <p>
 * 服务类
import com.soft2242.one.entity.VisitorInvitation;
import com.baomidou.mybatisplus.extension.service.IService;

 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */

public interface IVisitorInvitationService extends BaseService<VisitorInvitation> {
    PageResult<VisitorInvitationVO> page(VisitorInvitationQuery query);
    PageResult<VisitorInvitationVO> getAll(Long userId);

    void save(VisitorInvitationVO vo);

    void update(VisitorInvitationVO vo);


    List<VisitorInvitation> getAll2(Long userId);

}
