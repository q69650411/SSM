package com.zzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzz.pojo.ItemsCustom;
import com.zzz.pojo.OrderItem;
import com.zzz.service.ItemsService;
import com.zzz.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderItemsController {
	@Autowired
	OrderService orderservice;
	
	@Autowired
	ItemsService itemsService;
	
	
	@RequestMapping("/ok")
	public ModelAndView ok() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<ItemsCustom> li = itemsService.findItemsList(null);
		mav.addObject("itemsList", li);
		mav.setViewName("buy");
		return mav;
	}

	@RequestMapping("/add")
	public String add(OrderItem ot) {
		OrderItem temp = orderservice.selectbyuserid(ot);
		if(temp==null)
		orderservice.addorderitem(ot);
		else {
			temp.setNum(temp.getNum()+ot.getNum());
			orderservice.updateitem(temp);
		}
		return "redirect:/order/ok";
	}
	
	@RequestMapping("/cart")
	public String cart(Integer userid,Model model) {
		List<OrderItem> oi = orderservice.selectall(userid);
		model.addAttribute("ois", oi);
		return "cart";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer userid) {
		if(userid!=null) {
			orderservice.deletebyid(userid);
		}
		return "redirect:/order/cart";
		
		
	}
}
