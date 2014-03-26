package com.abu.orthotab.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Parametre;

@Repository
public class ParametreDao extends CommonHibernateDao {

	@SuppressWarnings("unchecked")
	public Parametre findParametreByCleIdUser(String cle, Long idUser) {

		Parametre parametre = null;
		Query query = getCurrentSession().createQuery(
				"from Parametre where cle = :cle and idUser = :idUser");
		query.setString("cle", cle);
		query.setLong("idUser", idUser);
		List<Parametre> listParametre = query.list();

		if (!listParametre.isEmpty()) {
			parametre = listParametre.get(0);
		}
		return parametre;
	}

}
