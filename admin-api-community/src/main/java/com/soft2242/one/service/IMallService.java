package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Mall;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.MallQuery;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.MallVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 商铺表 服务类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
public interface IMallService extends BaseService<Mall> {

    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<MallVO> page(MallQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<MallVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(MallVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(MallVO vo);

    /**
     * 根据id删除通知(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

    void export();
    void importByExcel(MultipartFile file);
}
