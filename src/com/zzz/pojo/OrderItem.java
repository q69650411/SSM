package com.zzz.pojo;

public class OrderItem {
    private Integer orderid;

    private Integer userid;

    private Integer id;

    private Integer num;
    
    private items item;

   

	public items getItem() {
		return item;
	}

	public void setItem(items item) {
		this.item = item;
	}

	public Integer getOrderid() {
        return orderid;
    }

	public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}