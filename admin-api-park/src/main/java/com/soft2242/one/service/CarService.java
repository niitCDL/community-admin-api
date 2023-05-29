package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Car;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.query.CarQuery;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.vo.CarVO;
import com.soft2242.one.vo.CarportVO;

import java.util.List;

/**
 * @ClassName CarService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:24
 */
public interface CarService extends BaseService<Car> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<CarVO> page(CarQuery query);

    /**
     * 获取所有车位数据
     *
     * @return list
     */
    List<CarVO> getList();

    /**
     * 新增车位
     *
     * @param vo vo
     */
    void save(CarVO vo);

    /**
     * 修改车位
     *
     * @param vo vo
     */
    void update(CarVO vo);

    /**
     * 根据id删除车位(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

//    void export();
//    void importByExcel(MultipartFile file);
}
