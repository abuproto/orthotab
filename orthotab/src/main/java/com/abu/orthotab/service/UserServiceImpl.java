package com.abu.orthotab.service;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User authenticate(User user) {
		// TODO Auto-generated method stub
		User userVerifie = new User();
		userVerifie.setActif(true);
		userVerifie.setNom("Nom Patient01");
		userVerifie.setPrenom("Prenom Patient01");
		
		return userVerifie;
	}

}
