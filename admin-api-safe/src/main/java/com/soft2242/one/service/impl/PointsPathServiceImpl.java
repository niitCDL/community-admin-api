package com.soft2242.one.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;

import com.soft2242.one.dao.PointsPathDao;
import com.soft2242.one.entity.PointsPathEntity;
import com.soft2242.one.service.PointsPathService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *巡更点与线路关系业务实现
 * @author litao
 */

@Service
public class PointsPathServiceImpl extends BaseServiceImpl<PointsPathDao, PointsPathEntity> implements PointsPathService {

    /**
     *根据巡更路线id，获取巡更点ID列表
     * @param pathId 路线ID
     * @return
     */
    @Override
    public List<Long> getPointIdList(Long pathId) {
        return baseMapper.getPointIdList(pathId);
    }

    /**
     *保存或修改，
     * @param pointIds
     * @param pathId
     */
    @Override
    public void saveOrUpdate(List<Long> pointIds, Long pathId) {
        // 数据库菜单ID列表
        List<Long> dbPointList = getPointIdList(pathId);
        // 需要新增的菜单ID
        Collection<Long> insertPointIdList = CollUtil.subtract(pointIds, dbPointList);
        if (CollUtil.isNotEmpty(insertPointIdList)) {
            List<PointsPathEntity> menuList = insertPointIdList.stream().map(pointId -> {
                PointsPathEntity entity = new PointsPathEntity();
                entity.setPointId(pointId);
                entity.setPathId(pathId);
                return entity;
            }).collect(Collectors.toList());
            // 批量新增
            saveBatch(menuList);
        }
        // 需要删除的菜单ID
        Collection<Long> deletePointList = CollUtil.subtract(dbPointList, pointIds);
        if (CollUtil.isNotEmpty(deletePointList)) {
            LambdaQueryWrapper<PointsPathEntity> queryWrapper = new LambdaQueryWrapper<>();
            remove(queryWrapper.eq(PointsPathEntity::getPathId, pathId).in(PointsPathEntity::getPointId, deletePointList));
        }
    }

    /**
     * 根据巡更点id，删除巡更点和路线之间的关系
     * @param pointId 巡更点
     */
    @Override
    public void deleteByPointId(Long pointId) {
        remove(new LambdaQueryWrapper<PointsPathEntity>().eq(PointsPathEntity::getPointId,pointId));
    }

    /**
     * 根据路线id,删除巡更点和路线之间的关系
     * @param pathId 路线id
     */
    @Override
    public void deleteByPathId(Long pathId) {
        remove(new LambdaQueryWrapper<PointsPathEntity>().eq(PointsPathEntity::getPathId,pathId));
    }
}
