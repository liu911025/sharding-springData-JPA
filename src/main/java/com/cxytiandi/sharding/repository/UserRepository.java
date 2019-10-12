package com.cxytiandi.sharding.repository;

import com.cxytiandi.sharding.po.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
