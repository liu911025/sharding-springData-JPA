package com.cxytiandi.sharding.service;

import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.repository.UserRepository;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


	@ShardingTransactionType(TransactionType.XA)
	@Transactional
	@Override
	public void addAll() {
		List<User> users = new ArrayList<>();
		for (long i = 0; i < 100; i++) {
			User user = new User();
			user.setCity("深圳" + i);
			user.setName("李四" + i);
			user.setAddTime(new Date());
			users.add(user);
		}
		userRepository.saveAll(users);
		throw new RuntimeException("抛个异常...");
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
