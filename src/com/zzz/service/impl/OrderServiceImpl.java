package com.zzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.zzz.mapper.OrderItemMapper;
import com.zzz.mapper.itemsMapper;
import com.zzz.pojo.OrderItem;
import com.zzz.pojo.items;
import com.zzz.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
   @Autowired
    OrderItemMapper ordermapper;	
   
   @Autowired
   itemsMapper itemsMappers;
	
	@Override
	public void addorderitem(OrderItem oi) {
		ordermapper.insert(oi);
	}

	public OrderItem selectbyuserid(OrderItem oi) {
		List<OrderItem> oo = ordermapper.selectbyuserid(oi.getUserid());
		for (OrderItem orderItem : oo) {
			if(orderItem.getId()==oi.getId()) {
				return orderItem;
			}
		}
		return null;
	}
	
	public void updateitem(OrderItem oi) {
		ordermapper.updateByPrimaryKeySelective(oi);
	}

	 public List<OrderItem> selectall(Integer userid){
		 List<OrderItem> oo = ordermapper.selectbyuserid(userid);
		 for (OrderItem orderItem : oo) {
		    items temp = itemsMappers.selectByPrimaryKey(orderItem.getId());
		    orderItem.setItem(temp);
		}
		 return oo;
		 
	 }

	@Override
	public void deletebyid(Integer orderid) {
		ordermapper.deleteByPrimaryKey(orderid);
	}

	@Override
	public void deletebyitemid(Integer itemid) {
		ordermapper.deletebyitemid(itemid);
		
	}

	
	

}
