package com.abu.orthotab.service;

import com.abu.orthotab.domain.User;

public interface UserService {
	User authenticate(User user);
	
	void miseAJourNiveau(int userid, int niveau);
}
