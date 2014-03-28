package com.abu.orthotab.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Exercice;

@Repository
public class ExerciceDao extends CommonHibernateDao {

	private final static Logger LOGGER = Logger
			.getLogger(ExerciceDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Exercice> findExerciceByNojour(Long nojour) {
		List<Exercice> listExercice = null;

		Query query = getCurrentSession().createQuery(
				"from Exercice where nojour = :nojour order by code");
		query.setLong("nojour", nojour);
		listExercice = query.list();
		return listExercice;
	}
	
	@SuppressWarnings("unchecked")
	public Exercice findExerciceByCode(String code) {
		Exercice exercice = null;
		Query query = getCurrentSession().createQuery(
				"from Exercice where code = :code");
		query.setString("code", code);
		List<Exercice> listExercice = query.list();
		if(listExercice!=null && !listExercice.isEmpty()){
			exercice = listExercice.get(0);
		}else{
			LOGGER.info("exercice nul pour code :" + code);
		}
		return exercice;
	}
}
