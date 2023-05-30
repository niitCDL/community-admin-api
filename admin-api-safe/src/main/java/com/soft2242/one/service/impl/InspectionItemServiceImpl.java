package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.InspectionItemEntityConvert;
import com.soft2242.one.dao.InspectionItemDao;
import com.soft2242.one.entity.Community;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.query.InspectionItemQuery;
import com.soft2242.one.query.PatrolPlanQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.service.InspectionItemPathService;
import com.soft2242.one.service.InspectionItemService;
import com.soft2242.one.vo.InspectionItemVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 巡检项目
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class InspectionItemServiceImpl extends BaseServiceImpl<InspectionItemDao, InspectionItemEntity> implements InspectionItemService {
    private  final ICommunityService communityService;
    private  final InspectionItemPathService inspectionItemPathService;

    @Override
    public PageResult<InspectionItemVO> page(InspectionItemQuery query) {
//        IPage<InspectionItemEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
//
//        List<InspectionItemVO> itemVOS = InspectionItemEntityConvert.INSTANCE.convertList(page.getRecords());
//        List<InspectionItemVO> collect = itemVOS.stream().map(item -> {
//            Community community = communityService.getById(item.getCommunityId());
//            item.setCommunityName(community.getCommunityName());
//            return item;
//        }).collect(Collectors.toList());
//        return new PageResult<>(collect, page.getTotal());

        IPage<InspectionItemEntity> page = getPage(query);
        Map<String,Object> params=getParams(query);
        params.put("page",page);
        List<InspectionItemVO> inspectionList = baseMapper.getInspectionList(params);
        return new PageResult<>(inspectionList,page.getTotal());

    }

//    private LambdaQueryWrapper<InspectionItemEntity> getWrapper(InspectionItemQuery query){
//        LambdaQueryWrapper<InspectionItemEntity> wrapper = Wrappers.lambdaQuery();
////        wrapper.eq(StringUtils.isNotEmpty(query.ge), InspectionItemEntity::getCommunityId, query.getCommunityId());
//        wrapper.like(StringUtils.isNotEmpty(query.getCommunityName()), InspectionItemEntity::getCommunityName, query.getCommunityName());
//        wrapper.like(StringUtils.isNotEmpty(query.getName()), InspectionItemEntity::getName, query.getName());
//        return wrapper;
//    }

        private Map<String,Object> getParams(InspectionItemQuery query){
            Map<String,Object> parmas=new HashMap<>();
            parmas.put("communityId",query.getCommunityId());
            parmas.put("name",query.getName());
            return parmas;
}

    @Override
    public void save(InspectionItemVO vo) {
        InspectionItemEntity entity = InspectionItemEntityConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }


    @Override
    public void update(InspectionItemVO vo) {
        InspectionItemEntity entity = InspectionItemEntityConvert.INSTANCE.convert(vo);
        updateById(entity);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
        //同时删除巡检项目和线路的关联
        inspectionItemPathService.deleteByInspectionItemId(idList);
    }

    /**
     * 根据小区id，删除该小区的巡检项目
     * @param communityId
     */
    @Override
    public void deleteByCommunityId(Long communityId) {
        remove(new LambdaQueryWrapper<InspectionItemEntity>().eq(InspectionItemEntity::getCommunityId,communityId));
    }

}