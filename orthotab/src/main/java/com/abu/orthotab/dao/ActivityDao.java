package com.abu.orthotab.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Activity;

@Repository
public class ActivityDao extends CommonHibernateDao {

	private final static Logger LOGGER = Logger.getLogger(ActivityDao.class);

	public Long createActivity(Activity activity) {
		return (Long) getCurrentSession().save(activity);
	}

	@SuppressWarnings("unchecked")
	public Activity findLastActivityByExIdUser(String codeEx, Long idUser) {
		Activity activity = null;
		Query query = getCurrentSession()
				.createQuery(
						"from Activity where type = :type and idUser = :idUser order by dateActivite desc");
		query.setString("type", codeEx);
		query.setLong("idUser", idUser);
		List<Activity> listActivity = query.list();
		if (listActivity != null && !listActivity.isEmpty()) {
			activity = listActivity.get(0);
		} else {
			LOGGER.info("activity nulle pour codeEx :" + codeEx
					+ " et iduser :" + idUser);
		}
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List<Activity> findActivityByIdUserJour(Long idUser,
			String codeExPart) {
		Query query = getCurrentSession()
				.createQuery(
						"from Activity where idUser = :idUser and type like :type order by dateActivite desc");
		query.setString("type", codeExPart + "%");
		query.setLong("idUser", idUser);
		List<Activity> listActivity = query.list();
		return listActivity;
	}

	@SuppressWarnings("unchecked")
	public List<Activity> findAllActivity() {
		return getCurrentSession().createQuery(
				"from Activity order by dateActivite desc").list();
	}
}
