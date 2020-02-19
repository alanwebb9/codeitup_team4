package com.jj.health.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.health.view.UserSignInView;
import com.jj.health.view.UserSignUpView;
import com.jj.health.view.UserView;
import com.jj.health.service.UserService;
@RestController
@CrossOrigin
@RequestMapping(value="/api/user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(path="/signup", method = RequestMethod.POST)
	 public ResponseEntity<?> addUser(@RequestBody @Valid UserSignUpView userSignUpView){
	 UserView userView = userService.addUser(userSignUpView);
	 if(userView==null)
	 {
		 return ResponseEntity.ok().body("Invalid Email/User already exist");
	 }
    return ResponseEntity.ok().body("Successfully Registered");
	
}
	@RequestMapping(path="/signin", method = RequestMethod.GET)
	public ResponseEntity<?> checkUser(@RequestBody @Valid UserSignInView userSignInView){
		String user1 = userService.checkUser(userSignInView);
		 if(user1==null)
		 {
			 return ResponseEntity.ok().body("Invalid User");
		 }
		  return ResponseEntity.ok(user1);
}
}