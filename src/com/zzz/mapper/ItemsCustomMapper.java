package com.zzz.mapper;

import java.util.List;

import com.zzz.pojo.ItemsCustom;
import com.zzz.pojo.ItemsQueryVo;
import com.zzz.util.Page;

public interface ItemsCustomMapper {
	// 商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;
	//查询总数
	int total();
	
	//分页查询
	List<ItemsCustom> list(Page page);
	
	
}