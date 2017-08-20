package com.zzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.mapper.userMapper;
import com.zzz.pojo.user;
import com.zzz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
     userMapper usermappers;
	@Override
	public void register(user user) {
		if(user==null)
		   return;
		usermappers.insert(user);
		
	}
	
	@Override
	public user selectByname(String username) {
		user temp = usermappers.selectByname(username);
		return temp;
	}

}
