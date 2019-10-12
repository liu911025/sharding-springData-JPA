package com.cxytiandi.sharding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> list() {
		return userRepository.findAll();
	}

	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public void addAll(List<User> users) {
		userRepository.saveAll(users);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

}
