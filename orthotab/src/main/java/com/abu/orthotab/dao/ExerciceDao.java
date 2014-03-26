package com.abu.orthotab.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Exercice;

@Repository
public class ExerciceDao extends CommonHibernateDao {

	@SuppressWarnings("unchecked")
	public List<Exercice> findExerciceByNojour(Long nojour) {
		List<Exercice> listExercice = null;

		Query query = getCurrentSession().createQuery(
				"from Exercice where nojour = :nojour order by code");
		query.setLong("nojour", nojour);
		listExercice = query.list();
		return listExercice;
	}
}
