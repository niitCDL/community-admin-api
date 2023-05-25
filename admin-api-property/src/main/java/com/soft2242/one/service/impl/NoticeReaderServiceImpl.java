package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.utils.PageResult;

import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.dao.NoticeReaderDao;
import com.soft2242.one.entity.NoticeReaderEntity;
import com.soft2242.one.query.NoticeReaderQuery;
import com.soft2242.one.service.NoticeReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 19:38
 */
@Service
@AllArgsConstructor
public class NoticeReaderServiceImpl extends BaseServiceImpl<NoticeReaderDao, NoticeReaderEntity> implements NoticeReaderService {
    @Override
    public PageResult<NoticeReaderEntity> page(NoticeReaderQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);

        // 分页查询
        IPage<NoticeReaderEntity> page = getPage(query);
        params.put(Constant.PAGE, page);
        List<NoticeReaderEntity> list = baseMapper.getList(params);
        System.out.println(list);
       return new PageResult<>(list,page.getTotal());
    }

    @Override
    public List<NoticeReaderEntity> getList(NoticeReaderQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        List<NoticeReaderEntity> list = baseMapper.getList(params);
        return list;
    }

//    @Override
//    public void save(NoticeReaderVO vo) {
//        NoticeReaderEntity entity = NoticeReaderConvert.INSTANCE.convert(vo);
//        baseMapper.insert(entity);
//    }


    private Map<String, Object> getParams(NoticeReaderQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("noticeId", query.getNoticeId());
        params.put("userId", query.getUserId());
        // 数据权限
//        params.put(Constant.DATA_SCOPE, getDataScope("t1", null));
        return params;
    }


}
