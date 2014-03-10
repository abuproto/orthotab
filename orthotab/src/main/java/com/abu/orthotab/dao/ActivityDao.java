package com.abu.orthotab.dao;

import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Activity;

@Repository
public class ActivityDao extends CommonHibernateDao {

	public Long createActivity(Activity activity) {
		return (Long) getCurrentSession().save(activity);
	}
}
