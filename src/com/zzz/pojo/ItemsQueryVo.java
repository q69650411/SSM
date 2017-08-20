package com.zzz.pojo;

import java.util.List;

public class ItemsQueryVo {
	//information of goods
   private ItemsCustom itemsCustom;
   
 //定义一个list 用于接受批量修改的数据
 	private List<ItemsCustom> itemsList;


public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

public ItemsCustom getItemsCustom() {
	return itemsCustom;
}

public void setItemsCustom(ItemsCustom itemsCustom) {
	this.itemsCustom = itemsCustom;
}
   
}
