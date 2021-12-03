package com.security.springSecurityExample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.springSecurityExample.entity.Users;
import com.security.springSecurityExample.repository.UsersRepo;

/**
 * <pre>
 * 自訂取得 user 資訊方式
 * from databases
 * </pre>
 * 
 * @author memorykghs
 */
//@Component
public class CustomUserDetailsService implements UserDetailsService {

	/** UsersRepo */
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepo.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User is not found."));

//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

//		for (UserRole role : user.getUserRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getRole()));
//		}

		UserDetails userDetails = User.builder()
				.username(user.getUserName())
				.password(user.getPassword())
				.build();

		return userDetails;
	}
}
