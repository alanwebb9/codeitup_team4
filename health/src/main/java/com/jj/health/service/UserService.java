package com.jj.health.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.health.view.UserSignInView;
import com.jj.health.view.UserSignUpView;
import com.jj.health.view.UserView;

import com.jj.health.repository.UserRepository;
import com.jj.health.model.User;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	public UserView addUser(@Valid UserSignUpView userSignUpView) {
		// TODO Auto-generated method stub
		User user = new User() ;
		if(userRepository.validbyEmail(userSignUpView.getEmail())!=1)
		{
		
		user.setPassword(userSignUpView.getPassword());
        user.setName(userSignUpView.getName());
       
        user.setEmail(userSignUpView.getEmail());
        User userSaved = userRepository.save(user);

        
        UserView userView = new UserView(userSaved);
       

        return userView;
        }
		return null;
	}
	public String checkUser(@Valid UserSignInView userSignInView) {
		// TODO Auto-generated method stub
		if(userRepository.findbyEmail(userSignInView.getEmail(), userSignInView.getPassword())==1) {
			return userSignInView.getEmail();
		}
		return null;
	}

	
}
