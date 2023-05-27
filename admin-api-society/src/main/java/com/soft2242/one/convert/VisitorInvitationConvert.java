package com.soft2242.one.convert;

import com.soft2242.one.entity.VisitorInvitation;
import com.soft2242.one.vo.VisitorInvitationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: James
 * Date: 2023/5/25 14:54
 * Describe:
 */

@Mapper

public interface VisitorInvitationConvert {
    VisitorInvitationConvert INSTANCE = Mappers.getMapper(VisitorInvitationConvert.class);
    VisitorInvitation convert(VisitorInvitationVO vo);

    VisitorInvitationVO convert(VisitorInvitation entity);

    List<VisitorInvitationVO> convertList(List<VisitorInvitation> list);

}
