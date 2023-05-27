package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.one.query.CommunityQuery;
import com.soft2242.one.query.HouseQuery;
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.HouseVO;

import java.util.List;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
public interface IHouseService extends BaseService<House> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<HouseVO> page(HouseQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<HouseVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(HouseVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(HouseVO vo);

    /**
     * 根据id删除通知(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

}
