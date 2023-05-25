package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.query.NoticeQuery;
import com.soft2242.one.vo.NoticeVO;


import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 9:09
 */

public interface NoticeService extends BaseService<NoticeEntity> {

    PageResult<NoticeVO> page(NoticeQuery query);


    void save(NoticeVO vo);

    void update(NoticeVO vo);

    void delete(List<Long> ids);





}
