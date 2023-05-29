package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.ParkConvert;
import com.soft2242.one.dao.ParkDao;
import com.soft2242.one.entity.Park;
import com.soft2242.one.query.ParkQuery;
import com.soft2242.one.service.ParkService;
import com.soft2242.one.vo.ParkVO;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 停车场表
 *
 * @author Dr.King whfplus7@163.com
 * @since 1.0.0 2023-05-29
 */
@Service
@AllArgsConstructor
public class ParkServiceImpl extends BaseServiceImpl<ParkDao, Park> implements ParkService {

    @Override
    public PageResult<ParkVO> page(ParkQuery query) {
        IPage<Park> page = getPage(query);
        Map<String, Object> params = getParams(query);
        params.put("page", page);
        List<ParkVO> list = baseMapper.getList(params);
        return new PageResult<>(list, page.getTotal());
    }

    private Map<String, Object> getParams(ParkQuery query) {
        System.out.println(query);
        Map<String, Object> params = new HashMap<>();
        params.put("parkName", query.getParkName());
        params.put("communityName", query.getCommunityName());
        return params;
    }

    @Override
    public List<ParkVO> getList() {
        ParkQuery query = new ParkQuery();
        List<Park> entityList = baseMapper.selectList(getWrapper(query));

        return ParkConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ParkVO vo) {
        Park entity = ParkConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ParkVO vo) {
        Park entity = ParkConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    private Wrapper<Park> getWrapper(ParkQuery query) {
        LambdaQueryWrapper<Park> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getParkName()), Park::getParkName, query.getParkName());
        return wrapper;
    }
}