package com.sivalabs.springapp.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

import com.sivalabs.springapp.entities.Role;
 
public class CustomUserDetails extends SocialUser {
	 
    private Integer id;
 
    private String firstName;
 
    private String lastName;
 
    private Set<Role> roles;
 
    private String socialSignInProvider;
 
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
 
 
    public static class Builder {
 
        private Integer id;
 
        private String username;
 
        private String firstName;
 
        private String lastName;
 
        private String password;
 
        private Set<Role> roles;
 
 
        private Set<GrantedAuthority> authorities;
 
        public Builder() {
            this.authorities = new HashSet<>();
        }
 
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
 
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
 
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
 
        public Builder password(String password) {
            if (password == null) {
                password = "SocialUser";
            }
 
            this.password = password;
            return this;
        }
 
        public Builder roles(Set<Role> roles) {
            this.roles = roles;
 
            Set<SimpleGrantedAuthority> authority = new HashSet<SimpleGrantedAuthority>();
            for(Role role : roles){
                authority.add(new SimpleGrantedAuthority(role.toString()));
            }
            this.authorities.addAll(authority);
 
            return this;
        }
 
 
        public Builder username(String username) {
            this.username = username;
            return this;
        }
 
        public CustomUserDetails build() {
        	CustomUserDetails user = new CustomUserDetails(username, password, authorities);
 
            user.id = id;
            user.firstName = firstName;
            user.lastName = lastName;
            user.roles = roles;
            return user;
        }
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getSocialSignInProvider() {
		return socialSignInProvider;
	}


	public void setSocialSignInProvider(String socialSignInProvider) {
		this.socialSignInProvider = socialSignInProvider;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public static Builder getBuilder() {
		return new CustomUserDetails.Builder();
	}
    
    
}