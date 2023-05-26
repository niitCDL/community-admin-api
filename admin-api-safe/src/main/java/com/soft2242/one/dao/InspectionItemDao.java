package com.soft2242.one.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.vo.InspectionItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* 巡检项目
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface InspectionItemDao extends BaseDao<InspectionItemEntity> {
//    @Select("select * from t_inspection_item a left join t_community b on a.community_id=b.id")
//    IPage<InspectionItemVO> selectpage1(IPage page, @Param("ew") Wrapper queryWrapper);
}