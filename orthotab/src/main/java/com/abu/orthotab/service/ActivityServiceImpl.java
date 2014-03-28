package com.abu.orthotab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.dao.ExerciceDao;
import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.domain.Exercice;
import com.abu.orthotab.domain.User;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final static Logger LOGGER = Logger
			.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ExerciceDao exerciceDao;
	
	@Override
	@Transactional
	public Long createActivity(Activity activity) {
		
		Long idActivity = null;
		
		if(activity.getIdUser()==null || activity.getIdUser().intValue()==0){
			LOGGER.info("Recherche user par token : " + activity.getToken());
			User user = userDao.findUserByToken(activity.getToken());
			if(user!=null){
				Long idUser = user.getId();
				LOGGER.info("user par token trouve : " + idUser);
				activity.setIdUser(idUser);
				idActivity = activityDao.createActivity(activity);
				
				// si activity de type exercice
				String type = activity.getType();
				if(type.indexOf("s")==0 && type.indexOf("j")==2){
					String codeExPart = activity.getType().substring(0, 4);
					int nojour = calculNoJour(activity.getType());
					
					// maj nbtotcac
					int nbtotcac = user.getNbtotcac()==null?0:user.getNbtotcac().intValue();
					Exercice exerciceCac = exerciceDao.findExerciceByCode(type);
					int nbCac = exerciceCac.calculNbCac(activity.getNbEchec()==null?0:activity.getNbEchec().intValue());
					user.setNbtotcac(Long.valueOf(nbtotcac+nbCac));
					
					// recherche activity du même jour (niveau)
					List<Activity> listeActivity = activityDao.findActivityByIdUserJour(idUser, codeExPart);
					List<Exercice> listeExercice = exerciceDao.findExerciceByNojour(Long.valueOf(nojour));
					
					//boolean isJourTermine = false;
					int nbExTermine = 0;
					
					// vérification si jour terminé
					for(Exercice exercice : listeExercice){
						if(exercice.getCode().equals(type) || isExerciceEffectue(listeActivity, type)){
							nbExTermine++;
						}
					}
					
					if(nbExTermine==listeExercice.size()){
						int oldNiveau = (user.getNivcourant()==null?0:user.getNivcourant().intValue());
						int niveau = oldNiveau+1;
						user.setDatechgtniv(activity.getDateActivite());
						user.setNivcourant(Long.valueOf(niveau));
						LOGGER.info("Mise a jour niveau courant pour user " + user + " , " + oldNiveau + "-->" + niveau);
					}
				}
			}
		}
		return idActivity;
	}
	
	private int calculNoJour(String codeEx){
		int nojour = 0;
		
		try {
			String strnosem = codeEx.substring(1, 2);
			String strnoj = codeEx.substring(3, 4);
			
			int nosem = Integer.valueOf(strnosem);
			int noj = Integer.valueOf(strnoj);
			
			nojour = (nosem-1)*5 + noj;
		} catch (Exception e) {
			LOGGER.error("erreur de calculNoJour avec codeEx :" + codeEx, e);
		}
		
		return nojour;
	}

	private boolean isExerciceEffectue(List<Activity> listeActivity, String codeEx){
		boolean isExerciceEffectue = false;
		
		for(Activity activity : listeActivity){
			if(codeEx.equals(activity.getType())){
				isExerciceEffectue = true;
				break;
			}
		}
		return isExerciceEffectue;
	}
	
}
