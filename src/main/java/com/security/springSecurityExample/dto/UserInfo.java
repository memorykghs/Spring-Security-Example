package com.security.springSecurityExample.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("username")
	private String userName;
	
	@JsonProperty
	private String password;
}
