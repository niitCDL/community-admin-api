package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Building;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.vo.BuildingVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 楼宇表 服务类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
public interface IBuildingService extends BaseService<Building> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<BuildingVO> page(BuildingQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<BuildingVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(BuildingVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(BuildingVO vo);

    /**
     * 根据id删除通知(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);


    void export();
    void importByExcel(MultipartFile file);
}
