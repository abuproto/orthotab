package com.abu.orthotab.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Parametre;

@Repository
public class ParametreDao extends CommonHibernateDao {

	private final static Long ID_USERTECHNIQUE = 0L;
	
	@SuppressWarnings("unchecked")
	public Parametre findParametreByCleIdpatient(String cle, Long idpatient) {

		Parametre parametre = null;
		Query query = getCurrentSession().createQuery(
				"from Parametre where cle = :cle and idpatient = :idpatient");
		query.setString("cle", cle);
		query.setLong("idpatient", idpatient);
		List<Parametre> listParametre = query.list();

		if (!listParametre.isEmpty()) {
			parametre = listParametre.get(0);
		}
		return parametre;
	}

	
	// calcul vraies date et heure en prenant en compte
	// le parametre ECART_TIME : decalage horaire entre heure serveur et heure
	// france
	public Date calculVraieDateHeure() {
		Calendar cal = Calendar.getInstance();
		Parametre parametre = this.findParametreByCleIdpatient(
				Parametre.Cle.ECART_TIME.name(), ID_USERTECHNIQUE);
		String strecart = "0";
		if (parametre != null) {
			strecart = parametre.getValeur();
			cal.add(Calendar.HOUR, Integer.valueOf(strecart));
		}
		return cal.getTime();
	}
}
