package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.dao.ExerciceDao;
import com.abu.orthotab.dao.PatientDao;
import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.domain.Exercice;
import com.abu.orthotab.domain.InfosExercice;
import com.abu.orthotab.domain.Patient;

@Service
public class InfosExerciceServiceImpl implements InfosExerciceService {

	private final static Logger LOGGER = Logger
			.getLogger(InfosExerciceServiceImpl.class);
	
	private final static String CSS_BTN_INACTIF = "boutonGeneral2-inactif";
	
	private final static String CSS_BTN_ACTIF = "boutonGeneral2-actif";
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ExerciceDao exerciceDao;
	
	@Override
	@Transactional
	public List<InfosExercice> getListInfosExercice(String groupe, String token) {
		List<InfosExercice> listInfosExercice = new ArrayList<InfosExercice>();
		
		int nojour = calculNoJour(groupe);
		
		List<Exercice> listExercice = exerciceDao.findExerciceByNojour(Long.valueOf(nojour));
		if(listExercice==null || listExercice.isEmpty()){
			LOGGER.error("listExercice nulle ou vide pour nojour : " + nojour);
			return listInfosExercice;
		}
		
		Patient patient = patientDao.findPatientByToken(token);
		
		if(patient!=null){
			
			if(patient.getNivcourant().intValue() != nojour){
				LOGGER.warn("Nojour : " + nojour + " et nivcourant : " + patient.getNivcourant());
			}
			
			for(Exercice exercice : listExercice){
				InfosExercice infosExercice = new InfosExercice();
				infosExercice.setLibelle(exercice.getLibelle());
				
				Activity activity = activityDao.findLastActivityByExIdPatient(exercice.getCode(), patient.getId());
				if(activity!=null){
					//infosExercice.setAction("0,0,0");
					infosExercice.setSemaine(0);
					infosExercice.setJour(0);
					infosExercice.setEx(0);
					infosExercice.setCssClass(CSS_BTN_INACTIF);
					infosExercice.setMessage("Tu as gagné ");
					int nbCac = exercice.calculNbCac(activity.getNbEchec()==null?0:activity.getNbEchec().intValue());
					infosExercice.setNomImgCac("cac"+nbCac+"_reduit.jpg");
					infosExercice.setNbcac(nbCac);
					infosExercice.setActif(false);
				}else{
					//infosExercice.setAction(calculNomAction(exercice.getCode()));
					infosExercice.setNomImgCac("cac1_reduit.jpg");
					infosExercice.setCssClass(CSS_BTN_ACTIF);
					infosExercice.setMessage("");
					infosExercice.setNbcac(0);
					infosExercice.setActif(true);
					infosExercice.setSemaine(Integer.valueOf(exercice.getCode().substring(1, 2)));
					infosExercice.setJour(Integer.valueOf(exercice.getCode().substring(3, 4)));
					infosExercice.setEx(Integer.valueOf(exercice.getCode().substring(5)));
				}
				
				listInfosExercice.add(infosExercice);
			}
		}else{
			LOGGER.error("user null pour token : " + token);
		}
		return listInfosExercice;
	}
	
	
	private int calculNoJour(String codeEx){
		int nojour = 0;
		
		try {
			String strnosem = codeEx.substring(1, 2);
			String strnoj = codeEx.substring(3);
			
			int nosem = Integer.valueOf(strnosem);
			int noj = Integer.valueOf(strnoj);
			
			nojour = (nosem-1)*5 + noj;
		} catch (Exception e) {
			LOGGER.error("erreur de calculNoJour avec codeEx :" + codeEx, e);
		}
		
		return nojour;
	}
}
