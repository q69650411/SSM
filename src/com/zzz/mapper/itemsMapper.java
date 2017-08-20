package com.zzz.mapper;

import com.zzz.pojo.items;

public interface itemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(items record);

    int insertSelective(items record);

    items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(items record);

    int updateByPrimaryKeyWithBLOBs(items record);

    int updateByPrimaryKey(items record);
    
    
    
}