package com.soft2242.one.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.user.SecurityUser;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.dao.SysUserDao;
import com.soft2242.one.system.dao.SysUserInfoDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.enums.UserGenderEnum;
import com.soft2242.one.system.enums.UserOnlineEnum;
import com.soft2242.one.system.enums.UserStatusEnum;
import com.soft2242.one.system.query.SysUserQuery;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserExcelVO;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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

    private final TokenStoreCache tokenStoreCache;

    private final CustomExcelUtils customExcelUtils;

    public SysUserInfoEntity getUserInfoByAdminId(Long id) {
        return sysUserInfoDao.getByAdminId(id);
    }

    @Override
    public void save(SysUserInfoVO user) {

        Date currentDate = new Date();
        Long creatorId = SecurityUser.getUserId();

        //保存到admin表中
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(sysUserDao.getMaxId() + 1);
        sysUserEntity.setUsername(user.getUsername());
        sysUserEntity.setPassword(user.getPassword());
        sysUserEntity.setAccountStatus(UserStatusEnum.ENABLED.getValue());
        sysUserEntity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        sysUserEntity.setSuperAdmin(user.getSuperAdmin());
        sysUserEntity.setDeleted(0);
        sysUserEntity.setCreator(creatorId);
        sysUserEntity.setCreateTime(currentDate);
        sysUserEntity.setUpdater(creatorId);
        sysUserEntity.setUpdateTime(currentDate);
        sysUserDao.insert(sysUserEntity);

        //保存到sys_admin_info表中 提供默认名称与头像
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        sysUserInfoEntity.setAdminId(sysUserEntity.getId());
        sysUserInfoEntity.setRealName("默认用户名");
        sysUserInfoEntity.setAvatar("hangzhou.aliyuncs.com/avatar/me.png");
        sysUserInfoEntity.setSort(0);
        sysUserInfoEntity.setGender(UserGenderEnum.SECRET.getValue());
        sysUserInfoEntity.setDeleted(0);
        sysUserInfoEntity.setCreator(creatorId);
        sysUserInfoEntity.setCreateTime(currentDate);
        sysUserInfoEntity.setUpdater(creatorId);
        sysUserInfoEntity.setUpdateTime(currentDate);
        sysUserInfoDao.insert(sysUserInfoEntity);
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
    public PageResult<SysUserVO> page(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        // 分页查询
        IPage<SysUserInfoEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysUserVO> list = sysUserInfoDao.getList(params);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public void delete(List<Long> idList) {
        for (Long id : idList) {
            sysUserInfoDao.delete(new QueryWrapper<SysUserInfoEntity>().eq("admin_id", id));
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
    public void export(String toPath) {
        List<SysUserExcelVO> userEntities = SysUserConvert.INSTANCE.convertList(sysUserDao.selectList(null));
        try {
            customExcelUtils.export(toPath,userEntities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<SysUserExcelVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, SysUserExcelVO.class,dataVoList);
            List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertList2(dataVoList);
            for (SysUserEntity sysUserEntity : sysUserEntities) {
                sysUserDao.insert(sysUserEntity);
            }
            System.out.println("导入成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Map<String, Object> getParams(SysUserQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", query.getUsername());
        params.put("phone", query.getPhone());
        params.put("gender", query.getGender());
        return params;
    }

    @Override
    public String getTokenById(Long id) {
        return sysUserDao.getTokenById(id);
    }

}
