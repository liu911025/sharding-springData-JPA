package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.util.IdWorker;
import com.cxytiandi.sharding.util.SnowflakeIdWorker;
import com.cxytiandi.sharding.util.SnowflakeIdWorker2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private IdWorker idWorker;
	
	@GetMapping("/users")
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/addAll")
	public Object addAll() {
		List<User> users = new ArrayList<>();
		for (long i = 0; i < 100; i++) {
			User user = new User();
			long id = i + 1;
			//user.setId(id);
			/*long nextId = SnowflakeIdWorker.generateId();
			System.out.println("nextId: " + nextId);
			System.out.println("nextId % 4: " + nextId % 4);
			user.setId(nextId);*/
			user.setCity("深圳" + id);
			user.setName("李四" + id);
			users.add(user);
		}
		userService.addAll(users);
		return "success";
	}

	@GetMapping("add")
	public Object add() {
		/*SnowflakeIdWorker2 idWorker = new SnowflakeIdWorker2(0, 0);
		long nextId = idWorker.nextId();*/
		Long nextId = SnowflakeIdWorker.generateId();
		System.out.println("nextId: " + nextId);
		System.out.println("nextId % 5: " + nextId % 5);
		User user = new User();
		user.setId(nextId);
		user.setCity("深圳");
		user.setName("李四");
		userService.add(user);
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/users/query")
	public Object get(String name) {
		return userService.findByName(name);
	}
	
}
