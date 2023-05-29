package com.soft2242.one.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Park;
import com.soft2242.one.vo.ParkVO;
import com.soft2242.one.query.ParkQuery;

import java.util.List;

/**
 * 停车场表
 *
 * @author Dr.King whfplus7@163.com
 * @since 1.0.0 2023-05-29
 */
public interface ParkService extends BaseService<Park> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<ParkVO> page(ParkQuery query);

    /**
     * 获取所有停车场数据
     *
     * @return list
     */
    List<ParkVO> getList();

    /**
     * 新增停车场
     *
     * @param vo vo
     */
    void save(ParkVO vo);

    /**
     * 修改停车场
     *
     * @param vo vo
     */
    void update(ParkVO vo);

    /**
     * 根据id删除停车场(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

//    void export();
//    void importByExcel(MultipartFile file);
}