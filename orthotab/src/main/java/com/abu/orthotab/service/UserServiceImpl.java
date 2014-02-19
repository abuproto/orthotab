package com.abu.orthotab.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.User;

@Service
public class UserServiceImpl implements UserService {

	private final static Logger LOGGER = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User authenticate(User user) {
		User userVerifie = null;
		User userTemp = userDao.findUserByLogin(user.getLogin());
		if (userTemp.getPassword().equals(user.getPassword())) {
			userVerifie = userTemp;
			// userVerifie.setPassword(null);
			LOGGER.info("Authentification OK pour user " + userVerifie);
		} else {
			LOGGER.warn("Authentification KO pour login " + user.getLogin());
		}

		return userVerifie;
	}

	@Override
	@Transactional
	public User miseAJourNiveau(int userid, int niveau) {
		User user = userDao.finduserById(userid);
		if (user == null) {
			LOGGER.error("User non trouve pour identifiant " + userid);
		} else {
			int oldNiveau = user.getNivcourant();
			if (niveau > oldNiveau) {
				user.setNivcourant(niveau);
				LOGGER.info("Mise a jour niveau courant pour user " + user + " , " + oldNiveau + "-->" + niveau);
			}
		}
		return user;
	}

	@Override
	@Transactional
	public User findByToken(String token) {
		return userDao.findUserByToken(token);
	}

	
	
}
