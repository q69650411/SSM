package com.zzz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzz.pojo.ItemsCustom;
import com.zzz.pojo.user;
import com.zzz.service.ItemsService;
import com.zzz.service.UserService;
import com.zzz.util.Page;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/reg")
	public String reg() {
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(user u) {
		if(u==null)
			return "register";
		else {
			if(userService.selectByname(u.getUsername())!=null)
				return "register";
			else {
				userService.register(u);
				return "itemsList";
			}
			
		}
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login(user u,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/items/queryItems");
		user user = userService.selectByname(u.getUsername());
		if(user==null) {
			session.setAttribute("error",  "账号不存在");
			return mav;
		}
		else if(!user.getPassword().equals(u.getPassword())){
			session.setAttribute("error", "密码错误");
			return mav;
		}
		else {
			session.setAttribute("user", user);
			session.setAttribute("userid", user.getUserid());
			List<ItemsCustom> li = itemsService.findItemsList(null);
			mav.addObject("itemsList", li);
			mav.setViewName("buy");
			return mav;
		}
			
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/items/queryItems");
		return mav;
		
	}
	

   
}
