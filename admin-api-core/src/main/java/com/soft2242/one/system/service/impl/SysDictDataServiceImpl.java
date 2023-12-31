package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.SysDictVO;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.convert.SysDictDataConvert;
import com.soft2242.one.system.convert.SysDictTypeConvert;
import com.soft2242.one.system.dao.SysDictDataDao;
import com.soft2242.one.system.dao.SysDictTypeDao;
import com.soft2242.one.system.entity.SysDictDataEntity;
import com.soft2242.one.system.entity.SysDictTypeEntity;
import com.soft2242.one.system.query.SysDictDataQuery;
import com.soft2242.one.system.service.SysDictDataService;
import com.soft2242.one.system.vo.SysDictDataVO;
import com.soft2242.one.system.vo.SysDictTypeVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataDao, SysDictDataEntity> implements SysDictDataService {

    private SysDictTypeDao sysDictTypeDao;

    @Override
    public PageResult<SysDictDataVO> page(SysDictDataQuery query) {
        IPage<SysDictDataEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysDictDataConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<SysDictDataEntity> getWrapper(SysDictDataQuery query) {
        LambdaQueryWrapper<SysDictDataEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDictDataEntity::getDictTypeId, query.getDictTypeId());
        wrapper.orderByAsc(SysDictDataEntity::getSort);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictDataVO vo) {
        SysDictDataEntity entity = SysDictDataConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictDataVO vo) {
        SysDictDataEntity entity = SysDictDataConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public List<SysDictVO> getAllDicData() {
        List<SysDictTypeEntity> dictTypeList = sysDictTypeDao.selectList(null);
        List<SysDictVO> dictVOList = new ArrayList<>();
        for (SysDictTypeEntity dictTypeEntity : dictTypeList) {

            SysDictVO sysDictVO = new SysDictVO();
            sysDictVO.setDictType(dictTypeEntity.getDictType());

            List<SysDictDataEntity> sysDictDataEntities = baseMapper.selectList(new QueryWrapper<SysDictDataEntity>().eq("dict_type_id",dictTypeEntity.getId()));
            sysDictVO.setDataList(SysDictDataConvert.INSTANCE.convertList2(sysDictDataEntities));

            dictVOList.add(sysDictVO);
        }
        return dictVOList;
    }

}