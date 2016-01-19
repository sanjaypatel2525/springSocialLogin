/**
 * 
 */
package com.sivalabs.springapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sivalabs.springapp.dao.UserDao;
import com.sivalabs.springapp.entities.User;
import com.sivalabs.springapp.entities.form.RegistrationForm;
import com.sivalabs.springapp.exception.DuplicateEmailException;
import com.sivalabs.springapp.repositories.UserRepository;


@Service
@Transactional
public class UserService 
{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email,password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	@Transactional
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException {
        if (emailExist(userAccountData.getEmail())) {
            throw new DuplicateEmailException("The email address: " + userAccountData.getEmail() + " is already in use.");
        }
 
 
        User user = new User();
        user.setEmail(userAccountData.getEmail());
        user.setName(userAccountData.getFirstName());
        user.setPassword(userAccountData.getPassword());
 /*
        if (userAccountData.isSocialSignIn()) {
            user.signInProvider(userAccountData.getSignInProvider());
        }
 */
 
        return userRepository.save(user);
    }
 
    private boolean emailExist(String email) {
        User user = userRepository.findUserByEmail(email);
 
        if (user != null) {
            return true;
        }
 
        return false;
    }
	
}

