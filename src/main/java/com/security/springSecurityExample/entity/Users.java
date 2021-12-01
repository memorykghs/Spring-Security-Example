package com.security.springSecurityExample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ENABLED")
	private char enabled;

}
