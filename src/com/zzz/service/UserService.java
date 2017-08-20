package com.zzz.service;

import com.zzz.pojo.user;

public interface UserService {

	public void register(user user);
	public user selectByname(String username);

}
