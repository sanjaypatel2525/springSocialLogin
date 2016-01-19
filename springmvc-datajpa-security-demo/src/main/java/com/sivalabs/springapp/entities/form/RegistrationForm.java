package com.sivalabs.springapp.entities.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class RegistrationForm {
 
    @Email
    @NotEmpty
    @Size(max = 100)
    private String email;
 
    @NotEmpty
    @Size(max = 100)
    private String firstName;
 
    private String lastName;
 
    private String password;
 
    private String passwordVerification;
 
    private String signInProvider;
 
     
    public boolean isNormalRegistration() {
        return signInProvider==null;
    }
 
    public boolean isSocialSignIn() {
        return signInProvider != null;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerification() {
		return passwordVerification;
	}

	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}

	public String getSignInProvider() {
		return signInProvider;
	}

	public void setSignInProvider(String signInProvider) {
		this.signInProvider = signInProvider;
	}
     
}