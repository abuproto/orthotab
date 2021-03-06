package com.abu.orthotab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Patient;
import com.abu.orthotab.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
    @ResponseBody
    public Patient authenticate(@RequestBody Patient user) {
    	return userService.authenticate(user);
    }
	
	@RequestMapping(value = "findByToken/{token}", method = RequestMethod.POST)
    @ResponseBody
    public Patient findByToken(@PathVariable String token) {
    	return userService.findByToken(token);
    }
	
	@RequestMapping(value = "authenticate2/{login}/{passw}", method = RequestMethod.POST)
    @ResponseBody
    public Patient authenticate2(@PathVariable("login") String login, @PathVariable("passw") String passw) {
		Patient user = new Patient();
		user.setLogin(login);
		user.setPassword(passw);
    	return userService.authenticate(user);
    }
	
	@RequestMapping(value = "majniveau/{userid}/{niveau}", method = RequestMethod.POST)
    @ResponseBody
	public Patient miseAJourNiveau(@PathVariable("userid") int userid, @PathVariable("niveau") int niveau){
		return userService.miseAJourNiveau(userid, niveau);
	}
}
