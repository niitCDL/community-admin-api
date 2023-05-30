package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.ParkRecord;
import com.soft2242.one.vo.ParkRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ParkRecord
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:52
 */
@Mapper
public interface ParkRecordDao extends BaseDao<ParkRecord> {
    List<ParkRecordVO> getList(Map<String,Object> params);
}
