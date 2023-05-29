package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.convert.CommunityConvert;
import com.soft2242.one.dao.CommunityDao;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Community;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.CommunityQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.vo.SysUserExcelVO;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.CommunityVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 社区表 服务实现类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor
public class CommunityServiceImpl extends BaseServiceImpl<CommunityDao, Community> implements ICommunityService {

    private final CustomExcelUtils customExcelUtils;
    @Override
    public PageResult<CommunityVO> page(CommunityQuery query) {
        Map<String,Object> params = getParams(query);
        IPage<Community> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        params.put(Constant.PAGE,page);
        List<Community> list = baseMapper.getList(params);
        return new PageResult<>(CommunityConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
        //return new PageResult<>(CommunityConvert.INSTANCE.convertList(list),page.getTotal());
    }

    private Map<String,Object> getParams(CommunityQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("communityName",query.getCommunityName());
        params.put("address",query.getAddress());
        return params;
    }

    @Override
    public List<CommunityVO> getList() {
        CommunityQuery query = new CommunityQuery();
        List<Community> entityList = baseMapper.selectList(getWrapper(query));

        return CommunityConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CommunityVO vo) {
        Community entity = CommunityConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CommunityVO vo) {
        Community entity = CommunityConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void export() {
        List<CommunityVO> communityVOList = CommunityConvert.INSTANCE.convertList(baseMapper.selectList(null));
        try {
            customExcelUtils.export(communityVOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<CommunityVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, CommunityVO.class,dataVoList);
            System.out.println("导入成功！！！！");
            List<Community> communities = CommunityConvert.INSTANCE.convertListEntity(dataVoList);
            for (Community community : communities) {
                baseMapper.insert(community);
            }
            System.out.println("导入成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<Community> getWrapper(CommunityQuery query) {
        LambdaQueryWrapper<Community> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getCommunityName()), Community::getCommunityName, query.getCommunityName());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()), Community::getAddress, query.getAddress());
        return wrapper;
    }

}
