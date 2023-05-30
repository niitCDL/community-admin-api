package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.ComplaintConvert;
import com.soft2242.one.dao.ComplaintDao;
import com.soft2242.one.entity.ComplaintEntity;
import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.query.ComplaintQuery;
import com.soft2242.one.service.ComplaintService;
import com.soft2242.one.utils.MyUtils;
import com.soft2242.one.vo.ComplaintVO;
import com.soft2242.one.vo.NoticeVO;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 投诉
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */
@Service
@AllArgsConstructor
public class ComplaintServiceImpl extends BaseServiceImpl<ComplaintDao, ComplaintEntity> implements ComplaintService {

    private final ComplaintDao complaintDao;
    @Override
    public PageResult<ComplaintVO> page(ComplaintQuery query) {
//        IPage<ComplaintEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        Map<String, Object> map = null;
        try {
            map = MyUtils.objectToMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IPage<ComplaintEntity> page = getPage(query);
//        map.put("queryWrapper",page);
        map.put("page",getWrapper(query));
        map.put("communityId", MyUtils.convertToString(query.getCommunityId()));
        if (ArrayUtils.isNotEmpty(query.getCreateTime())){
            Date begin = ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null;
            Date end = ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null;
            map.put("createTime", query.getCreateTime());
            map.put("begin", begin);
            map.put("end", end);
        }
        List<ComplaintVO> list = complaintDao.getList(map);
        return new PageResult<>(list, page.getTotal());

    }

    private LambdaQueryWrapper<ComplaintEntity> getWrapper(ComplaintQuery query){
        LambdaQueryWrapper<ComplaintEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.in(ArrayUtils.isNotEmpty(query.getCommunityId()), ComplaintEntity::getCommunityId, query.getCommunityId());
        wrapper.eq(StringUtils.isNotEmpty(query.getType()), ComplaintEntity::getType, query.getType());
        wrapper.eq(StringUtils.isNotEmpty(query.getState()), ComplaintEntity::getState, query.getState());
        wrapper.between(ArrayUtils.isNotEmpty(query.getCreateTime()),
                ComplaintEntity::getCreateTime,
                ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null,
                ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null);
        return wrapper;
    }

    @Override
    public void save(ComplaintVO vo) {
        ComplaintEntity entity = ComplaintConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(ComplaintVO vo) {
        ComplaintEntity entity = ComplaintConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
