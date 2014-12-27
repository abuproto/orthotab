package com.abu.orthotab.service;

import com.abu.orthotab.domain.Patient;

public interface UserService {
	Patient authenticate(Patient user);
	
	Patient miseAJourNiveau(int userid, int niveau);
	
	Patient findByToken(String token);
}
