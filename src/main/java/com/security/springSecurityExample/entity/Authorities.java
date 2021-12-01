package com.security.springSecurityExample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AUTHORITIES")
@IdClass(value = AuthoritiesPK.class)
@Data
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERNAME")
	private String userName;
	
	@Id
	@Column(name = "AUTHORITY")
	private String authority;
}
