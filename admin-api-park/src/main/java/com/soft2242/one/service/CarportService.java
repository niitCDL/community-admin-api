package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.entity.Park;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.query.ParkQuery;
import com.soft2242.one.vo.CarportVO;
import com.soft2242.one.vo.ParkVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName CarportService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:22
 */
public interface CarportService extends BaseService<Carport> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<CarportVO> page(CarportQuery query);

    /**
     * 获取所有车位数据
     *
     * @return list
     */
    List<CarportVO> getList();

    /**
     * 新增车位
     *
     * @param vo vo
     */
    void save(CarportVO vo);

    /**
     * 修改车位
     *
     * @param vo vo
     */
    void update(CarportVO vo);

    /**
     * 根据id删除车位(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

    void export();
    void importByExcel(MultipartFile file);
}
