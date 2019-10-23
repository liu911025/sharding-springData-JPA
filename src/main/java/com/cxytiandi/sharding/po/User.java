package com.cxytiandi.sharding.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 分表
 * @author yinjihuan
 *
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -1205226416664488559L;

	@Id
	private Long id;

	private String city = "";
	
	private String name = "";

	private Date addTime;
	
}
