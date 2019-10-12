package com.cxytiandi.sharding.po;

import lombok.Data;

import javax.persistence.*;

/**
 * 不分表
 * @author yinjihuan
 *
 */
@Entity
@Table(name = "loudong")
@Data
public class LouDong {

	@Id
	private Long id;
	
	private String city;
	
	private String region;
	
	private String name;
	
	private String ldNum;
	
	private String unitNum;


}
