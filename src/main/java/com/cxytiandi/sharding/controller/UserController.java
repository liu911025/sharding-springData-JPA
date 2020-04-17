package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.config.MySpringBootConfigurationProperties;
import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

	@Value("${my.config.inline.name}")
	private String name;
	@Autowired
	private UserService userService;
	@Autowired
	private MySpringBootConfigurationProperties config;
	
	@GetMapping("/users")
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/addAll")
	public Object addAll() {
		userService.addAll();
		return "success";
	}

	@GetMapping("add")
	public Object add() {
		/*SnowflakeIdWorker2 idWorker = new SnowflakeIdWorker2(0, 0);
		long nextId = idWorker.nextId();*/
		/*Long nextId = SnowflakeIdWorker.generateId();
		System.out.println("nextId: " + nextId);
		System.out.println("nextId % 5: " + nextId % 5);*/
		User user = new User();
		//user.setId(nextId);
		user.setCity("深圳");
		user.setName("李四");
		user.setAddTime(new Date());
		userService.add(user);
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		String card = config.getInline().getCard();
		String name = config.getInline().getName();
		return userService.findById(id);
	}
	
	@GetMapping("/users/query")
	public Object get(String name) {
		return userService.findByName(name);
	}
	
}
