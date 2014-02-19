package com.abu.orthotab.service;

import com.abu.orthotab.domain.User;

public interface UserService {
	User authenticate(User user);
	
	User miseAJourNiveau(int userid, int niveau);
	
	User findByToken(String token);
}
