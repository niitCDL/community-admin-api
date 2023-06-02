package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.convert.SysDepartmentConvert;
import com.soft2242.one.system.convert.SysPostConvert;
import com.soft2242.one.system.dao.SysAdminPostDao;
import com.soft2242.one.system.dao.SysPostDao;
import com.soft2242.one.system.entity.SysAdminPostEntity;
import com.soft2242.one.system.entity.SysDepartmentEntity;
import com.soft2242.one.system.entity.SysPostEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.query.SysPostQuery;
import com.soft2242.one.system.query.SysUserQuery;
import com.soft2242.one.system.service.SysPostService;
import com.soft2242.one.system.vo.SysDepartmentVO;
import com.soft2242.one.system.vo.SysPostVO;
import com.soft2242.one.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SysPostServiceImpl extends BaseServiceImpl<SysPostDao, SysPostEntity> implements SysPostService {

    private SysAdminPostDao sysAdminPostDao;

    @Override
    public PageResult<SysPostVO> page(SysPostQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        // 分页查询
        IPage<SysPostEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysPostVO> list = SysPostConvert.INSTANCE.convertList(baseMapper.getList(params));
        return new PageResult<>(list, page.getTotal());
    }

    private Map<String, Object> getParams(SysPostQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("postCode", query.getPostCode());
        params.put("postName", query.getPostName());
        return params;
    }

    @Override
    public List<SysPostVO> getList() {
        return SysPostConvert.INSTANCE.convertList(baseMapper.selectList(null));
    }

    @Override
    public void save(SysPostVO vo) {
        SysPostEntity entity = SysPostConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysPostVO vo) {
        SysPostEntity entity = SysPostConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        //删除用户与岗位关联表
        for (Long postId : idList) {
            sysAdminPostDao.delete(new QueryWrapper<SysAdminPostEntity>().eq("post_id",postId));
        }
        baseMapper.deleteBatchIds(idList);
    }

}
