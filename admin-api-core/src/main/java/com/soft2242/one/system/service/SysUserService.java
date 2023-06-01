package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.query.SysUserQuery;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SysUserService extends BaseService<SysUserInfoEntity> {
    SysUserInfoEntity getUserInfoByAdminId(Long id);

    SysUserInfoVO getUserInfo(Long id);
    void save(SysUserInfoVO user);

    void recordLastLoginTime(@Param("lastLoginTime")String date, @Param("id")Long id);

    String getTokenById(Long id);

    void changeAccountStatus(Long id, Integer accountStatus);

    void update(SysUserEntity sysUserEntity);

    PageResult<SysUserInfoVO> page(SysUserQuery query);
    List<SysUserVO> getList();

    void delete(List<Long> idList);

    void updatePassword(Long id, String encode);

    void export();

    void importByExcel(MultipartFile file);

    void updateByVo(SysUserInfoVO sysUserInfoVO);

    void saveAvatar(Long adminId,MultipartFile file) throws IOException;
}
