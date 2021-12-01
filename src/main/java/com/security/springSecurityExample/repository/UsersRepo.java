package com.security.springSecurityExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.springSecurityExample.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, String>{

}
