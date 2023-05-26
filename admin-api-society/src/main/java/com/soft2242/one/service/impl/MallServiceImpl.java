package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.MallConvert;
import com.soft2242.one.dao.MallMapper;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.query.MallQuery;
import com.soft2242.one.service.IMallService;
import com.soft2242.one.vo.MallVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商铺表 服务实现类
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service

public class MallServiceImpl extends BaseServiceImpl<MallMapper, Mall> implements IMallService {

    private LambdaQueryWrapper<Mall> getWrapper(MallQuery query) {
        LambdaQueryWrapper<Mall> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }


    @Override
    public PageResult<MallVO> page(MallQuery query) {
        IPage<Mall> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(MallConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public void save(MallVO vo) {
        baseMapper.insert(MallConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(MallVO vo) {
        updateById(MallConvert.INSTANCE.convert(vo));
    }

}
