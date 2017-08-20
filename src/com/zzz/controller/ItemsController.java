package com.zzz.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.zzz.pojo.ItemsCustom;
import com.zzz.pojo.ItemsQueryVo;
import com.zzz.pojo.items;
import com.zzz.service.ItemsService;
import com.zzz.service.OrderService;
import com.zzz.util.Page;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	@Autowired
	private OrderService orderService;
    
	@RequestMapping("/queryItems")
	public String queryItems(Page page,Model model) {
		int total = itemsService.total();
		if(page.getStart()<0)
			page.setStart(0);
		List<ItemsCustom> li = itemsService.list(page);
		
		page.caculateLast(total);
		model.addAttribute("itemsList",li);
		return "itemsList";
	}
	
	@RequestMapping(value="/editItems")
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer id) throws Exception{
		
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		model.addAttribute("item", itemsCustom);
		
		return "editItem";

	}
	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,ItemsCustom itemsCustom) throws Exception{
	/*	String str1=itemsCustom.getName();
		String ss=new String(str1.getBytes("ISO-8859-1"),"utf-8");
		String str2=itemsCustom.getDetail();
		String ss2=new String(str2.getBytes("ISO-8859-1"),"utf-8");
		itemsCustom.setName(ss);
		itemsCustom.setDetail(ss2);*/
		itemsService.updateItems(itemsCustom);
		model.addAttribute("item", itemsCustom);
		return "editItem";
	}
	
	@RequestMapping("/getItemsType")
	@ModelAttribute("itemsType")
	public Map<String,String> getItemsType() throws Exception{
		HashMap<String, String> itemsType= new HashMap<>();
		itemsType.put("001", "type1");
		itemsType.put("002", "type2");
		return itemsType;
	}
	
	//批量删除
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] selected_id,Model model) throws Exception {
		if(selected_id==null) {
			List<ItemsCustom> itemsList=itemsService.findItemsList(null);
			model.addAttribute("itemsList", itemsList);
			System.out.println("null");
			return "itemsList";
		}
			
		for (Integer integer : selected_id) {
			itemsService.delteItems(integer);
			orderService.deletebyitemid(integer);
		}
		return "redirect:/items/queryItems";
		
		
	}
	
	//批量修改
	@RequestMapping("/editItemsList")
	public ModelAndView editItemsList() throws Exception{
		//调用servie来查询商品列表
	       List<ItemsCustom> itemsList=itemsService.findItemsList(null);

	       ModelAndView modelAndView=new ModelAndView();
	       modelAndView.addObject("itemsList",itemsList);
	       //指定逻辑视图名itemsList.jsp
	       modelAndView.setViewName("editItemsList");

	       return modelAndView;
		
	}
	//提交修改  把修改过后的数据回显在页面上submit the changes
	@RequestMapping("/editItemsListSubmit")
	public String editItemsListSubmit(ItemsQueryVo itemsQueryVo,Model model) throws Exception{
		List<ItemsCustom> itemsList = itemsQueryVo.getItemsList();
		for (ItemsCustom itemsCustom : itemsList) {
			itemsService.updateItems(itemsCustom);
		}
		List<ItemsCustom> itemsList1=itemsService.findItemsList(null);
		model.addAttribute("itemsList",itemsList1);
		return "editItemsList";
	}
	
	//分页查询
	@RequestMapping("/pagination")
	public String pagination(Page page,Model model) throws Exception{
		List<ItemsCustom> cs = itemsService.list(page);
		int total = itemsService.total();
		page.caculateLast(total);
		model.addAttribute("cs", cs);
		return "pagination";
	}
	
	@RequestMapping("/register")
	public String  register() {
		return "register";
	}
	
	
}
