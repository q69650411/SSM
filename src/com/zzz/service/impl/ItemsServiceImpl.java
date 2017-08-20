package com.zzz.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.mapper.*;
import com.zzz.pojo.ItemsCustom;
import com.zzz.pojo.ItemsQueryVo;
import com.zzz.pojo.items;
import com.zzz.service.ItemsService;
import com.zzz.util.Page;
@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsCustomMapper itemsCustomMapperMapper;
	
	@Autowired
	private itemsMapper itemsmappers;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return itemsCustomMapperMapper.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
	    items itms = itemsmappers.selectByPrimaryKey(id);
	  //在这里以后随着需求的变化，需要查询商品的其它相关信息，返回到controller
	      //所以这个时候用到扩展类更好，如下
	    ItemsCustom itemsCustom = new ItemsCustom();
	    //将items的属性拷贝到itemsCustom
	    BeanUtils.copyProperties(itms, itemsCustom);
	    return itemsCustom;
	}

	@Override
	public void updateItems(ItemsCustom itemsCustom) throws Exception {	
	//
		itemsmappers.updateByPrimaryKeySelective(itemsCustom);
	}

	@Override
	public void delteItems(Integer id) throws Exception {
		itemsmappers.deleteByPrimaryKey(id);
		
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return itemsCustomMapperMapper.total();
	}

	@Override
	public List<ItemsCustom> list(Page page) {
		// TODO Auto-generated method stub
		return itemsCustomMapperMapper.list(page);
	}


}
