package com.soft2242.one.system.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysDictDataEntity;
import com.soft2242.one.system.query.SysDictDataQuery;
import com.soft2242.one.system.vo.SysDictDataVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author moqi
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);

}