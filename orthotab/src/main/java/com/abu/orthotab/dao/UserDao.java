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
		// TEMP
		if(!listUser.isEmpty()){
			user = listUser.get(0);
		}
		return user;
	}
}
