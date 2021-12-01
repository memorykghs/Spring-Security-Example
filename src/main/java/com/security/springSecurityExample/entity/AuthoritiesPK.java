package com.security.springSecurityExample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class AuthoritiesPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "AUTHORITY")
	private String authority;
}
