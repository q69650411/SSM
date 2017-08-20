package com.zzz.mapper;

import java.util.List;

import com.zzz.pojo.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
    
    List<OrderItem> selectbyuserid(Integer userid);
    
    void deletebyitemid(Integer itemid);
}