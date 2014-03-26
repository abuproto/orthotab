package com.abu.orthotab.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.domain.User;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final static Logger LOGGER = Logger
			.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public Long createActivity(Activity activity) {
		
		if(activity.getIdUser()==null || activity.getIdUser().intValue()==0){
			LOGGER.info("Recherche user par token : " + activity.getToken());
			User user = userDao.findUserByToken(activity.getToken());
			if(user!=null){
				Long idUser = user.getId();
				LOGGER.info("user par token trouve : " + idUser);
				activity.setIdUser(idUser);
			}
		}
		return activityDao.createActivity(activity);
	}

}
