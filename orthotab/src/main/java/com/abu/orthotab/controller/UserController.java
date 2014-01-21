package com.abu.orthotab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.User;
import com.abu.orthotab.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//@RequestMapping(value = "authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
    @ResponseBody
    public User authenticate(@RequestBody User user) {
        //return accueilService.getListeEtapes();
    	return userService.authenticate(user);
    }
	//User au
	//, method = RequestMethod.POST

}
