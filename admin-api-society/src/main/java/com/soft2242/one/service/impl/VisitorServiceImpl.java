package com.soft2242.one.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.VisitorConvert;
import com.soft2242.one.dao.VisitorMapper;
import com.soft2242.one.entity.Visitor;
import com.soft2242.one.query.VisitorQuery;
import com.soft2242.one.service.IVisitorService;
import com.soft2242.one.vo.VisitorVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor

public class VisitorServiceImpl extends BaseServiceImpl<VisitorMapper, Visitor> implements IVisitorService {

    private LambdaQueryWrapper<Visitor> getWrapper(VisitorQuery query) {
        LambdaQueryWrapper<Visitor> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public PageResult<VisitorVO> page(VisitorQuery query) {
        IPage<Visitor> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(VisitorConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public void save(VisitorVO vo) {
        baseMapper.insert(VisitorConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(VisitorVO vo) {
        updateById(VisitorConvert.INSTANCE.convert(vo));
    }

    @Override
    public List<VisitorVO> getListById(Long id) {
        List<Visitor> visitors = baseMapper.selectList(getWrapper(new VisitorQuery()).eq(Visitor::getId, id));
        return VisitorConvert.INSTANCE.convertList(visitors);

    }


}
