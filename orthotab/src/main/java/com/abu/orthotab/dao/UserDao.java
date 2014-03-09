package com.abu.orthotab.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.User;

@Repository
public class UserDao extends CommonHibernateDao {
	@SuppressWarnings("unchecked")
	public User findUserByLogin(String login) {
		User user = null;
		List<User> listUser = getCurrentSession().createQuery("from User where login = '" + login + "'")
                .list();
		// TODO remplacer par preparedStatement ou equivalent
		// TEMP
		if(!listUser.isEmpty()){
			user = listUser.get(0);
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User findUserByToken(String token) {
		User user = null;
		List<User> listUser = getCurrentSession().createQuery("from User where token = '" + token + "'")
                .list();
		// TODO remplacer par preparedStatement ou equivalent
		// TEMP
		if(!listUser.isEmpty()){
			user = listUser.get(0);
		}
		return user;
	}
	
	public User finduserById(int id){
		User user = (User) getCurrentSession().load(User.class, Long.valueOf(id));
		return user;
	}
}
