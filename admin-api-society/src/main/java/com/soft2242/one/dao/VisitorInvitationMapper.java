package com.soft2242.one.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.one.entity.VisitorInvitation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Mapper
public interface VisitorInvitationMapper extends BaseMapper<VisitorInvitation> {

    List<VisitorInvitation> findAll(Long userId);


}
