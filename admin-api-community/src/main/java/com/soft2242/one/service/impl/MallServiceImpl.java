package com.soft2242.one.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.myexcel.CustomExcelUtils;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.convert.MallConvert;
import com.soft2242.one.dao.BuildingDao;
import com.soft2242.one.dao.MallDao;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.mapper.MallMapper;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.MallQuery;
import com.soft2242.one.service.IBuildingService;
import com.soft2242.one.service.IMallService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.MallVO;
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
 * 商铺表 服务实现类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Service
@AllArgsConstructor
public class MallServiceImpl extends BaseServiceImpl<MallDao, Mall> implements IMallService {

    private final CustomExcelUtils customExcelUtils;

    @Override
    public PageResult<MallVO> page(MallQuery query) {
        IPage<Mall> page = getPage(query);
        Map<String, Object> params = getParams(query);
        params.put("page", page);
        List<MallVO> list = baseMapper.getList(params);
        return new PageResult<>(list, page.getTotal());
    }

    private Map<String, Object> getParams(MallQuery query) {
        System.out.println(query);
        Map<String, Object> params = new HashMap<>();
        params.put("realName", query.getRealName());
        params.put("communityName", query.getCommunityName());
        params.put("mallNumber", query.getMallNumber());
        return params;
    }

    @Override
    public List<MallVO> getList() {
        MallQuery query = new MallQuery();
        List<Mall> entityList = baseMapper.selectList(getWrapper(query));

        return MallConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MallVO vo) {
        Mall entity = MallConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MallVO vo) {
        Mall entity = MallConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void export() {
        MallQuery query = new MallQuery();
        Map<String, Object> params = getParams(query);
        List<MallVO> mallVOList = baseMapper.getList(params);
        try {
            customExcelUtils.export(mallVOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void importByExcel(MultipartFile file) {
        try {
            List<MallVO> dataVoList = new ArrayList<>();
            customExcelUtils.importExcel(file, MallVO.class,dataVoList);
            System.out.println("导入成功！！！！");
            List<Mall> malls = MallConvert.INSTANCE.convertListEntity(dataVoList);
            for (Mall mall : malls) {
                baseMapper.insert(mall);
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

    private Wrapper<Mall> getWrapper(MallQuery query) {
        LambdaQueryWrapper<Mall> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getMallNumber()), Mall::getMallNumber, query.getMallNumber());
        return wrapper;
    }

}
