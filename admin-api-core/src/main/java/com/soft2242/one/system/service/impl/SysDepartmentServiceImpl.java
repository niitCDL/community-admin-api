package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.TreeUtils;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.service.SysAdminDepartmentService;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysDepartmentConvert;
import com.soft2242.one.system.entity.SysDepartmentEntity;
import com.soft2242.one.system.query.SysDepartmentQuery;
import com.soft2242.one.system.vo.SysDepartmentVO;
import com.soft2242.one.system.dao.SysDepartmentDao;
import com.soft2242.one.system.service.SysDepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class SysDepartmentServiceImpl extends BaseServiceImpl<SysDepartmentDao, SysDepartmentEntity> implements SysDepartmentService {

    private final SysAdminDepartmentService sysAdminDepartmentService;
    @Override
    public List<SysDepartmentVO> getList() {
        Map<String, Object> params = new HashMap<>();

        // 数据权限
        params.put(Constant.DATA_SCOPE, getDataScope("t1", "id"));

        // 机构列表
        List<SysDepartmentEntity> entityList = baseMapper.getList(params);

        return TreeUtils.build(SysDepartmentConvert.INSTANCE.convertList(entityList));
    }

    @Override
    public void save(SysDepartmentVO vo) {
        SysDepartmentEntity entity = SysDepartmentConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysDepartmentVO vo) {
        SysDepartmentEntity entity = SysDepartmentConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        // 判断是否有子机构
        long orgCount = count(new QueryWrapper<SysDepartmentEntity>().eq("pid", id));
        if (orgCount > 0) {
            throw new ServerException("请先删除子机构");
        }

        // 判断机构下面是否有用户
        List<Long> uidListByDid = sysAdminDepartmentService.getUidListByDid(id);
        if (!uidListByDid.isEmpty()) {
            throw new ServerException("机构下面有用户，不能删除");
        }

        // 删除
        removeById(id);
    }

}