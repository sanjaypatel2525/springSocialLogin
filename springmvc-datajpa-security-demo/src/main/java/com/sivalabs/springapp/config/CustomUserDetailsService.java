/**
 * 
 */
package com.sivalabs.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.springapp.entities.User;
import com.sivalabs.springapp.services.UserService;
import com.sivalabs.springapp.web.config.SecurityUser;


@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userService.findUserByEmail(userName);
		
		CustomUserDetails principal = CustomUserDetails.getBuilder()
                .firstName(user.getName())
                .id(user.getId())
                .password(user.getPassword())
                .roles(user.getRoles())
                .username(user.getEmail())
                .build();
 
        return principal;
		//return new SecurityUser(user);
	}

}
