package com.abu.orthotab.service;

import java.util.ArrayList;
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
import com.abu.orthotab.domain.InfosExercice;
import com.abu.orthotab.domain.User;

@Service
public class InfosExerciceServiceImpl implements InfosExerciceService {

	private final static Logger LOGGER = Logger
			.getLogger(InfosExerciceServiceImpl.class);
	
	private final static String CSS_BTN_INACTIF = "boutonGeneral2-inactif";
	
	private final static String CSS_BTN_ACTIF = "boutonGeneral2-actif";
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ExerciceDao exerciceDao;
	
	@Override
	@Transactional
	public List<InfosExercice> getListInfosExercice(int nojour, String token) {
		List<InfosExercice> listInfosExercice = new ArrayList<InfosExercice>();
		
		List<Exercice> listExercice = exerciceDao.findExerciceByNojour(Long.valueOf(nojour));
		if(listExercice==null || listExercice.isEmpty()){
			LOGGER.error("listExercice nulle ou vide pour nojour : " + nojour);
			return listInfosExercice;
		}
		
		User user = userDao.findUserByToken(token);
		
		if(user!=null){
			for(Exercice exercice : listExercice){
				InfosExercice infosExercice = new InfosExercice();
				infosExercice.setLibelle(exercice.getLibelle());
				
				Activity activity = activityDao.findLastActivityByExIdUser(exercice.getCode(), user.getId());
				if(activity!=null){
					infosExercice.setAction("inactif()");
					infosExercice.setCssClass(CSS_BTN_INACTIF);
					infosExercice.setMessage("Tu as gagné ");
					int nbCac = exercice.calculNbCac(activity.getNbEchec()==null?0:activity.getNbEchec().intValue());
					infosExercice.setNomImgCac("cac"+nbCac+".jpg");
					infosExercice.setNbcac(nbCac);
					infosExercice.setActif(false);
				}else{
					infosExercice.setAction(calculNomAction(exercice.getCode()));
					infosExercice.setCssClass(CSS_BTN_ACTIF);
					infosExercice.setMessage("");
					infosExercice.setNbcac(0);
					infosExercice.setActif(true);
				}
				
				listInfosExercice.add(infosExercice);
			}
		}else{
			LOGGER.error("user null pour token : " + token);
		}
		return listInfosExercice;
	}
	
	private String calculNomAction(String codeEx){
		StringBuilder sb = new StringBuilder();
		sb.append("exercices(");
		sb.append(codeEx.substring(1, 2));
		sb.append(",");
		sb.append(codeEx.substring(3, 4));
		sb.append(",");
		sb.append(codeEx.substring(5));
		sb.append(")");
		return sb.toString();
	}
}
