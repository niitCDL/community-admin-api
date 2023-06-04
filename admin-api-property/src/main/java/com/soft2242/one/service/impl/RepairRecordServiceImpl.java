package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.RepairRecordConvert;
import com.soft2242.one.dao.NoticeDao;
import com.soft2242.one.dao.RepairRecordDao;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.vo.RepairRecordVO;
import com.soft2242.one.vo.RepairVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 报修处理表
 *
 * @author xuelong
 * @since 1.0.0 2023-06-04
 */
@Service
@AllArgsConstructor
public class RepairRecordServiceImpl extends BaseServiceImpl<RepairRecordDao, RepairRecordEntity> implements RepairRecordService {

    private final RepairRecordDao repairRecordDao;

    @Override
    public PageResult<RepairRecordVO> page(RepairRecordQuery query) {
        IPage<RepairRecordEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(RepairRecordConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<RepairRecordEntity> getWrapper(RepairRecordQuery query) {
        LambdaQueryWrapper<RepairRecordEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(RepairRecordVO vo) {
        RepairRecordEntity entity = RepairRecordConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void sOrUOrD(HashMap<String, Object> map) {
        Object repairId = map.get("repairId");
        //先得到这个报修的记录
        LambdaQueryWrapper<RepairRecordEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(RepairRecordEntity::getRepairId, repairId);
        List<RepairRecordEntity> list = repairRecordDao.selectList(wrapper);

        List<String> strings = list.stream().map(RepairRecordEntity::getEmployeeIds).toList();
        HashSet<String> recordSet = new HashSet<String>(strings);
        //得到负责人ids
        String[] eIds = (String[]) map.get("eIds");
        HashSet<String> handleSet = new HashSet<String>(Arrays.asList(eIds));
        //之差(记录-处理),要删掉的数据
        HashSet temSet = new HashSet<>(recordSet);
        temSet.removeAll(handleSet);
        if (!temSet.isEmpty()) {

            wrapper = Wrappers.lambdaQuery();
            wrapper.eq(RepairRecordEntity::getRepairId, repairId)
                    .in(RepairRecordEntity::getEmployeeIds, temSet.toArray());
            baseMapper.delete(wrapper);
        }

        //之差(处理-记录),要新增呢的数据
        temSet = new HashSet<>(handleSet);
        temSet.removeAll(recordSet);
        if (!temSet.isEmpty()) {
            for (Object id : temSet) {
                RepairRecordEntity repairRecordEntity = new RepairRecordEntity();
                repairRecordEntity.setRepairId((Long) repairId);
                repairRecordEntity.setEmployeeIds(String.valueOf(id));
                save(repairRecordEntity);
            }
        }

        //公共数据，要修改数据
//        temSet = new HashSet<>(handleSet);
//        temSet.retainAll(recordSet);
//        if (!temSet.isEmpty()) {
//            wrapper = Wrappers.lambdaQuery();
//            wrapper.eq(RepairRecordEntity::getRepairId, repairId)
//                    .in(RepairRecordEntity::getEmployeeIds, temSet.toArray());
//            update(wrapper);
//        }

    }

    @Override
    public void update(RepairRecordVO vo) {
        RepairRecordEntity entity = RepairRecordConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }


}
