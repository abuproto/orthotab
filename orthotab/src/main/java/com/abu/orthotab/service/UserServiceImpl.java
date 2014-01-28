package com.abu.orthotab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
	
	@Override
	@Transactional
	public User authenticate(User user) {
		// TODO Auto-generated method stub
		// Recherche user en bdd par login
		// si trouve, vérification du mot de passe
		// si ok, renvoie le user (mot de passe à null)
		// si KO, renvoie null
		//User userVerifie = new User();
		//userVerifie.setActif(true);
		//userVerifie.setNom("Nom Patient01");
		//userVerifie.setPrenom("Prenom Patient01");
		User userVerifie = null;
		User userTemp = userDao.findUserByLogin(user.getLogin());
		if(userTemp.getPassword().equals(user.getPassword())){
			userVerifie = userTemp;
			//userVerifie.setPassword(null);
		}
		
		return userVerifie;
	}

	@Override
	@Transactional
	public void miseAJourNiveau(int userid, int niveau) {
		User user = userDao.finduserById(userid);
		if(user!=null){
			user.setNivcourant(niveau);
		}
	}

}
