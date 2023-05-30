package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.CarportConvert;
import com.soft2242.one.convert.ParkRecordConvert;
import com.soft2242.one.dao.CarportDao;
import com.soft2242.one.dao.ParkRecordDao;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.entity.ParkRecord;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.query.ParkRecordQuery;
import com.soft2242.one.service.CarportService;
import com.soft2242.one.service.ParkRecordService;
import com.soft2242.one.vo.CarportVO;
import com.soft2242.one.vo.ParkRecordVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParkRecordServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 09:03
 */
@Service
@AllArgsConstructor
public class ParkRecordServiceImpl extends BaseServiceImpl<ParkRecordDao, ParkRecord> implements ParkRecordService {

    @Override
    public PageResult<ParkRecordVO> page(ParkRecordQuery query) {
        IPage<ParkRecord> page = getPage(query);
        Map<String,Object> params=getParams(query);
        params.put("page",page);
        List<ParkRecordVO> list = baseMapper.getList(params);
        return new PageResult<>(list,page.getTotal());
    }

    private Map<String,Object> getParams(ParkRecordQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("licence",query.getLicence());
        params.put("doorName",query.getDoorName());
        params.put("parkName",query.getParkName());
        params.put("type",query.getType());
        return params;
    }

    @Override
    public List<ParkRecordVO> getList() {
        ParkRecordQuery query = new ParkRecordQuery();
        List<ParkRecord> entityList = baseMapper.selectList(getWrapper(query));

        return ParkRecordConvert.INSTANCE.convertList(entityList);
    }
    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<ParkRecord> getWrapper(ParkRecordQuery query) {
        LambdaQueryWrapper<ParkRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getParkName()), ParkRecord::getType, query.getParkName());
        return wrapper;
    }
}
