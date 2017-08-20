package com.zzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.mapper.OrderItemMapper;
import com.zzz.pojo.OrderItem;
import com.zzz.pojo.items;


public interface OrderService {
   public void addorderitem(OrderItem oi);
   public OrderItem selectbyuserid(OrderItem oi);
   public void updateitem(OrderItem oi);
   public List<OrderItem> selectall(Integer userid);
   public void deletebyid(Integer orderid);
   public void deletebyitemid(Integer itemid);
}
