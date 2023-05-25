package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.NoticeReaderEntity;

import com.soft2242.one.query.NoticeReaderQuery;

import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 9:09
 */

public interface NoticeReaderService extends BaseService<NoticeReaderEntity> {

    PageResult<NoticeReaderEntity> page(NoticeReaderQuery query);
    List<NoticeReaderEntity> getList(NoticeReaderQuery query);

//    void save(NoticeReaderVO vo);


}
