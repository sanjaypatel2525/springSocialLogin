package com.sivalabs.springapp.util;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sivalabs.springapp.config.CustomUserDetails;
import com.sivalabs.springapp.entities.User;
 
public class SecurityUtil {
 
    public static void logInUser(User user) {
        CustomUserDetails userDetails = CustomUserDetails.getBuilder()
                .firstName(user.getName())
                .id(user.getId())
                .password(user.getPassword())
                .roles(user.getRoles())
                .username(user.getEmail())
                .build();
 
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}