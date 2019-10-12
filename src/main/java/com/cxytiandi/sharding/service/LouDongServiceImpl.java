package com.cxytiandi.sharding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxytiandi.sharding.po.LouDong;
import com.cxytiandi.sharding.repository.LouDongRepository;

@Service
public class LouDongServiceImpl implements LouDongService {

	@Autowired
	private LouDongRepository louDongRepository;
	
	@Override
	public List<LouDong> list() {
		return louDongRepository.findAll();
	}

	@Override
	public void addLouDong(LouDong louDong) {
		louDongRepository.save(louDong);
	}

}
