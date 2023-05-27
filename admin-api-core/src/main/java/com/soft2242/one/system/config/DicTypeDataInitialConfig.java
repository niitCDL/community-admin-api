package com.soft2242.one.system.config;

import com.soft2242.one.base.common.myexcel.SysDictVO;
import com.soft2242.one.system.service.SysDictDataService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class DicTypeDataInitialConfig {

    private SysDictDataService sysDictDataService;

    @Bean
    public Map<String,List<SysDictVO.DictData>> dictData() {
        List<SysDictVO> allDicData = sysDictDataService.getAllDicData();
        Map<String,List<SysDictVO.DictData>> map = new HashMap<>();
        for (SysDictVO dictVO : allDicData) {
            map.put(dictVO.getDictType(),dictVO.getDataList());
        }
        return map;
    }
}
