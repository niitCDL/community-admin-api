package com.soft2242.one.system.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fhs.trans.service.impl.TransService;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.excel.ExcelFinishCallBack;
import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.common.utils.ExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.dao.*;
import com.soft2242.one.system.entity.*;
import com.soft2242.one.system.enums.SuperAdminEnum;
import com.soft2242.one.system.enums.UserOnlineEnum;
import com.soft2242.one.system.enums.UserStatusEnum;
import com.soft2242.one.system.query.SysUserQuery;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserExcelVO;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.apache.poi.util.StringUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * 用户管理
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserInfoDao, SysUserInfoEntity> implements SysUserService {

    private SysUserDao sysUserDao;

    private SysUserInfoDao sysUserInfoDao;

    private SysUserRoleDao sysUserRoleDao;

    private SysAdminPostDao sysAdminPostDao;

    private SysAdminDepartmentDao sysAdminDepartmentDao;

    private final TokenStoreCache tokenStoreCache;
    private final TransService transService;

    private final PasswordEncoder passwordEncoder;

    public SysUserInfoEntity getUserInfoByAdminId(Long id) {
        return sysUserInfoDao.getByAdminId(id);
    }

    public SysUserInfoVO getUserInfo(Long id) {

        SysUserInfoVO userInfo = sysUserInfoDao.getUserInfo(id);
        userInfo.setPassword(null);
        userInfo.setOrgId(sysUserInfoDao.getDepartmentByAdminId(userInfo.getAdminId()));
        userInfo.setRoleIdList(sysUserRoleDao.getRoleIdList(userInfo.getAdminId()));
        userInfo.setPostIdList(sysUserInfoDao.getPostIdList(userInfo.getAdminId()));
        return userInfo;
    }


    @Override
    @Transactional
    public void save(SysUserInfoVO user) {

        SysUserEntity byUsernameEntity = sysUserDao.getByUsername(user.getUsername());
        if (byUsernameEntity != null) {
            throw new ServerException("该用户名已被占用,请重新更换！");
        }
        List<SysUserEntity> byPhoneEntity = sysUserDao.selectList(new QueryWrapper<SysUserEntity>().eq("phone", user.getPhone()));
        if (byPhoneEntity.size() > 0) {
            throw new ServerException("手机号已被绑定,请重新更换!");
        }
        List<SysUserInfoEntity> byEmailEntity = sysUserInfoDao.selectList(new QueryWrapper<SysUserInfoEntity>().eq("email", user.getEmail()));
        if (byEmailEntity.size() > 0) {
            throw new ServerException("该邮箱已被绑定,请重新更换!");
        }

        //保存到admin表中
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(sysUserDao.getMaxId() + 1);
        sysUserEntity.setUsername(user.getUsername());
        sysUserEntity.setPassword(user.getPassword());
        sysUserEntity.setPhone(user.getPhone());
        sysUserEntity.setAccountStatus(user.getAccountStatus());
        sysUserEntity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        sysUserEntity.setSuperAdmin(SuperAdminEnum.NO.getValue());
        sysUserDao.insert(sysUserEntity);

        //保存到sys_admin_info表中 提供默认名称与头像
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        sysUserInfoEntity.setAdminId(sysUserEntity.getId());
        sysUserInfoEntity.setRealName(user.getRealName());
        sysUserInfoEntity.setEmail(user.getEmail());
        sysUserInfoEntity.setAvatar("https://flobby.oss-cn-shenzhen.aliyuncs.com/avatar1/bg_yidenglu.png");
        sysUserInfoEntity.setSort(0);
        sysUserInfoEntity.setGender(user.getGender());
        sysUserInfoDao.insert(sysUserInfoEntity);

        //角色与用户的关联
        List<Long> roleIdList = user.getRoleIdList();
        for (Long roleId : roleIdList) {
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setAdminId(sysUserEntity.getId());
            sysUserRoleEntity.setRoleId(roleId);
            sysUserRoleDao.insert(sysUserRoleEntity);
        }

        //职位与用户的关联
        List<Long> postIdList = user.getPostIdList();
        for (Long postId : postIdList) {
            SysAdminPostEntity sysAdminPostEntity = new SysAdminPostEntity();
            sysAdminPostEntity.setAdminId(sysUserEntity.getId());
            sysAdminPostEntity.setPostId(postId);
            sysAdminPostDao.insert(sysAdminPostEntity);
        }

        //部门与用户的关联
        SysAdminDepartmentEntity sysAdminDepartmentEntity = new SysAdminDepartmentEntity();
        sysAdminDepartmentEntity.setAdminId(sysUserEntity.getId());
        sysAdminDepartmentEntity.setDepartmentId(user.getOrgId());
        sysAdminDepartmentDao.insert(sysAdminDepartmentEntity);

    }

    @Override
    public void recordLastLoginTime(String date, Long id) {
        sysUserInfoDao.recordLastLoginTime(date, id);
    }

    /**
     * 修改用户状态
     *
     * @param id            用户ID
     * @param accountStatus 用户状态
     */
    @Override
    public void changeAccountStatus(Long id, Integer accountStatus) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(id);
        sysUserEntity.setAccountStatus(accountStatus);
        if (UserStatusEnum.DISABLE.getValue() == accountStatus) {
            tokenStoreCache.deleteUser(getTokenById(id));
            sysUserEntity.setToken("");
            sysUserEntity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        }
        update(sysUserEntity);

    }

    @Override
    public void update(SysUserEntity sysUserEntity) {
        sysUserDao.updateById(sysUserEntity);
    }

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageResult<SysUserInfoVO> page(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        // 分页查询
        IPage<SysUserInfoEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysUserInfoVO> list = sysUserInfoDao.getList(params);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public PageResult<SysUserInfoVO> pageByRole(SysUserQuery query) {
        return null;
    }

    public List<SysUserVO> getList() {
        List<SysUserVO> list = sysUserInfoDao.getList2();
        return list;
    }

    @Override
    @Transactional
    public void delete(List<Long> idList) {
        for (Long id : idList) {
            sysUserInfoDao.delete(new QueryWrapper<SysUserInfoEntity>().eq("admin_id", id));
            sysUserRoleDao.delete(new QueryWrapper<SysUserRoleEntity>().eq("admin_id", id));
            sysAdminPostDao.delete(new QueryWrapper<SysAdminPostEntity>().eq("admin_id", id));
            sysAdminDepartmentDao.delete(new QueryWrapper<SysAdminDepartmentEntity>().eq("admin_id", id));
        }
        sysUserDao.deleteBatchIds(idList);
    }

    @Override
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = new SysUserEntity();
        user.setId(id);
        user.setPassword(newPassword);

        sysUserDao.updateById(user);
    }

    @Override
    public void export() {
        List<SysUserExcelVO> userExcelVOS = SysUserConvert.INSTANCE.convertList(sysUserDao.selectList(null));
        transService.transBatch(userExcelVOS);
        ExcelUtils.excelExport(SysUserExcelVO.class, "system_admin_excel" + DateUtils.format(new Date()), null, userExcelVOS);
    }

    @Override
    public void importByExcel(MultipartFile file) {

        ExcelUtils.readAnalysis(file, SysUserExcelVO.class, new ExcelFinishCallBack<SysUserExcelVO>() {
            @Override
            public void doAfterAllAnalysed(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            private void saveUser(List<SysUserExcelVO> result) {
                ExcelUtils.parseDict(result);
                List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertList2(result);
                for (SysUserEntity sysUserEntity : sysUserEntities) {
                    sysUserDao.insert(sysUserEntity);
                }
                System.out.println("导入成功");
            }
        });
    }

    @Override
    @Transactional
    public void updateByVo(SysUserInfoVO sysUserInfoVO) {

        List<SysUserEntity> userEntities = sysUserDao.selectList(new QueryWrapper<SysUserEntity>().notIn("id", sysUserInfoVO.getAdminId()));
        for (SysUserEntity userEntity : userEntities) {
            if (userEntity.getUsername() != null && userEntity.getUsername().equals(sysUserInfoVO.getUsername())) {
                throw new ServerException("该用户名已被占用,请重新更换！");
            }
            if (userEntity.getPhone() != null && userEntity.getPhone().equals(sysUserInfoVO.getPhone())) {
                throw new ServerException("手机号已被绑定,请重新更换!");
            }
        }
        List<SysUserInfoEntity> sysUserInfoEntities = sysUserInfoDao.getByNotInAdminId(sysUserInfoVO.getAdminId());
        for (SysUserInfoEntity sysUserInfoEntity : sysUserInfoEntities) {
            if (sysUserInfoEntity.getEmail() != null && sysUserInfoEntity.getEmail().equals(sysUserInfoVO.getEmail())) {
                throw new ServerException("该邮箱已被绑定,请重新更换!");
            }
        }


        //修改用户表
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(sysUserInfoVO.getAdminId());
        sysUserEntity.setUsername(sysUserInfoVO.getUsername());
        if (StrUtil.isNotBlank(sysUserInfoVO.getPassword())){
            sysUserEntity.setPassword(passwordEncoder.encode(sysUserInfoVO.getPassword()));
        }else {
            sysUserEntity.setPassword(sysUserDao.selectById(sysUserInfoVO.getAdminId()).getPassword());
        }
        sysUserEntity.setPhone(sysUserInfoVO.getPhone());
        sysUserDao.updateById(sysUserEntity);
        changeAccountStatus(sysUserEntity.getId(), sysUserInfoVO.getAccountStatus());

        //修改用户信息表
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        sysUserInfoEntity.setAdminId(sysUserInfoVO.getAdminId());
        sysUserInfoEntity.setRealName(sysUserInfoVO.getRealName());
        sysUserInfoEntity.setEmail(sysUserInfoVO.getEmail());
        sysUserInfoEntity.setGender(sysUserInfoVO.getGender());
        sysUserInfoDao.update(sysUserInfoEntity, new QueryWrapper<SysUserInfoEntity>().eq("admin_id", sysUserInfoEntity.getAdminId()));

        //修改用户与部门关联表
        SysAdminDepartmentEntity sysAdminDepartmentEntity = new SysAdminDepartmentEntity();
        sysAdminDepartmentEntity.setAdminId(sysUserInfoVO.getAdminId());
        sysAdminDepartmentEntity.setDepartmentId(sysUserInfoVO.getOrgId());
        sysAdminDepartmentDao.update(sysAdminDepartmentEntity, new QueryWrapper<SysAdminDepartmentEntity>().eq("admin_id", sysAdminDepartmentEntity.getAdminId()));


        //先删除所对应的用户角色关联表与用户岗位关联表
        sysUserRoleDao.delete(new QueryWrapper<SysUserRoleEntity>().eq("admin_id", sysUserInfoVO.getAdminId()));
        sysAdminPostDao.delete(new QueryWrapper<SysAdminPostEntity>().eq("admin_id", sysUserInfoVO.getAdminId()));

        //在把所有的关联都插入表中
        List<Long> roleIdList = sysUserInfoVO.getRoleIdList();
        for (Long roleId : roleIdList) {
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setAdminId(sysUserInfoVO.getAdminId());
            sysUserRoleEntity.setRoleId(roleId);
            sysUserRoleDao.insert(sysUserRoleEntity);
        }
        List<Long> postIdList = sysUserInfoVO.getPostIdList();
        for (Long postId : postIdList) {
            SysAdminPostEntity sysAdminPostEntity = new SysAdminPostEntity();
            sysAdminPostEntity.setAdminId(sysUserInfoVO.getAdminId());
            sysAdminPostEntity.setPostId(postId);
            sysAdminPostDao.insert(sysAdminPostEntity);
        }


    }

    @Override
    public SysUserVO getByMobile(String mobile) {
        SysUserEntity user = sysUserDao.getByMobile(mobile);
        return SysUserConvert.INSTANCE.convert(user);
    }

    @Override
    public PageResult<SysUserInfoVO> page2(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        // 分页查询
        IPage<SysUserInfoEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysUserInfoVO> list = sysUserInfoDao.getListByRoleId(params);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public PageResult<SysUserInfoVO> page3(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        // 分页查询
        IPage<SysUserInfoEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        List<Long> adminIdList = sysUserInfoDao.getAdminIdByRoleId(query.getRoleId());
        params.put("excludeAdminIdList",adminIdList);
        // 数据列表
        List<SysUserInfoVO> list = sysUserInfoDao.getListByNotInRoleId(params);
        return new PageResult<>(list, page.getTotal());
    }


    private Map<String, Object> getParams(SysUserQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleId",query.getRoleId());
        params.put("username", query.getUsername());
        params.put("phone", query.getPhone());
        params.put("gender", query.getGender());

        params.put(Constant.DATA_SCOPE, getDataScope("t4", "department_id"));
        return params;
    }

    @Override
    public String getTokenById(Long id) {
        return sysUserDao.getTokenById(id);
    }

}
