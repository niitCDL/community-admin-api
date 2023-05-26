package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.BillConvert;
import com.soft2242.one.dao.BillMapper;
import com.soft2242.one.entity.Bill;
import com.soft2242.one.query.BillQuery;
import com.soft2242.one.service.IBillService;
import com.soft2242.one.vo.BillVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Service
public class BillServiceImpl extends BaseServiceImpl<BillMapper, Bill> implements IBillService {

    private LambdaQueryWrapper<Bill> getWrapper(BillQuery query) {
        LambdaQueryWrapper<Bill> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public PageResult<BillVO> page(BillQuery query) {
        IPage<Bill> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(BillConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public void save(BillVO vo) {
        baseMapper.insert(BillConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(BillVO vo) {
        updateById(BillConvert.INSTANCE.convert(vo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)

    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}
