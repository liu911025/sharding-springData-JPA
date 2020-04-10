package com.cxytiandi.sharding.service;

import java.util.List;

import com.cxytiandi.sharding.po.User;

public interface UserService {

	List<User> list();
	
	void add(User user);

	void addAll();

	User findById(Long id);
	
	User findByName(String name);
	
}
