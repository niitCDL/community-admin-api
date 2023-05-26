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
import org.springframework.stereotype.Service;

/**
 * <p>
<<<<<<< HEAD
 * 服务实现类
=======
 *  服务实现类
>>>>>>> origin/test
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service

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


}
