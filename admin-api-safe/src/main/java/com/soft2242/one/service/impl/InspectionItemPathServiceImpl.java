package com.soft2242.one.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.dao.InspectionItemPathDao;
import com.soft2242.one.entity.InspectionItemPathEntity;
import com.soft2242.one.entity.PointsPathEntity;
import com.soft2242.one.service.InspectionItemPathService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 巡检项目于线路关系业务实现类
 * @author litao
 */
@Service
public class InspectionItemPathServiceImpl extends BaseServiceImpl<InspectionItemPathDao, InspectionItemPathEntity>
    implements InspectionItemPathService {
    /**
     *根据巡更路线id，获取巡检项目ID列表
     * @param pathId 路线ID
     * @return
     */
    @Override
    public List<Long> getInspectionItemIdList(Long pathId) {
        return baseMapper.getInspectionItemIdList(pathId);
    }

    /**
     *保存或修改，
     * @param inspectionItemIdList 巡检项目id列表
     * @param pathId
     */
    @Override
    public void saveOrUpdate(List<Long> inspectionItemIdList, Long pathId) {
        // 数据库菜单ID列表
        List<Long> dbItemList = getInspectionItemIdList(pathId);
        // 需要新增的菜单ID
        Collection<Long> insertItemIdList = CollUtil.subtract(inspectionItemIdList, dbItemList);
        if (CollUtil.isNotEmpty(insertItemIdList)) {
            List<InspectionItemPathEntity> itemList = insertItemIdList.stream().map(itemId -> {
                InspectionItemPathEntity entity = new InspectionItemPathEntity();
                entity.setItemId(itemId);
                entity.setPathId(pathId);
                return entity;
            }).collect(Collectors.toList());
            // 批量新增
            saveBatch(itemList);
        }
        // 需要删除的菜单ID
        Collection<Long> deleteItemList = CollUtil.subtract(dbItemList, inspectionItemIdList);
        if (CollUtil.isNotEmpty(deleteItemList)) {
            LambdaQueryWrapper<InspectionItemPathEntity> queryWrapper = new LambdaQueryWrapper<>();
            remove(queryWrapper.eq(InspectionItemPathEntity::getPathId, pathId).in(InspectionItemPathEntity::getItemId, deleteItemList));
        }
    }

    /**
     * 根据巡检项目id列表，删除巡检项目和路线之间的关系
     * @param inspectionItemIdList 巡检项目id列表
     */
    @Override
    public void deleteByInspectionItemId(List<Long> inspectionItemIdList) {
        remove(new LambdaQueryWrapper<InspectionItemPathEntity>().in(InspectionItemPathEntity::getItemId,inspectionItemIdList));
    }


    /**
     * 根据路线id,删除巡检项目和路线之间的关系
     * @param pathId 路线id
     */
    @Override
    public void deleteByPathId(Long pathId) {
        remove(new LambdaQueryWrapper<InspectionItemPathEntity>().eq(InspectionItemPathEntity::getPathId,pathId));
    }
}
