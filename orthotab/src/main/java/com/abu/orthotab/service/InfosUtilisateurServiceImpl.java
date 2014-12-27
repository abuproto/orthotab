package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ParametreDao;
import com.abu.orthotab.dao.PatientDao;
import com.abu.orthotab.domain.InfosUtilisateur;
import com.abu.orthotab.domain.Parametre;
import com.abu.orthotab.domain.Patient;

@Service
public class InfosUtilisateurServiceImpl implements InfosUtilisateurService {

    @Autowired
    private PatientDao patientDao;
    
    @Autowired
    private ParametreDao parametreDao;
	
	@Override
	@Transactional
	public List<InfosUtilisateur> getListInfosUtilisateur() {
		
		List<InfosUtilisateur> listInfosUtilisateur = new ArrayList<InfosUtilisateur>();
		List<Patient> listUser = patientDao.findAllPatient();
		
		for(Patient patient : listUser){
			InfosUtilisateur iu = new InfosUtilisateur();
			iu.setIdUser(patient.getId());
			iu.setLibUtilisateur((patient.getPrenom()==null?"":patient.getPrenom() + " ") + patient.getNom() + " (" + patient.getId() + ")");
			iu.setNbTotCac(patient.getNbtotcac());
			iu.setLibNivCourant(String.valueOf(patient.getNivcourant()));
			
			Parametre parametre = parametreDao.findParametreByCleIdpatient(Parametre.Cle.EX_INTERVALLE.name(), patient.getId());
			StringBuilder paramInterJour = new StringBuilder("");
			if(parametre!=null){
				String valeur = parametre.getValeur();
				int valnum = Integer.valueOf(valeur);
				
				paramInterJour.append(String.format("%dj %02d h %02d mn", valnum / 1440,
						(valnum % 1440) / 60, (valnum % 60)));
			}
			iu.setParamInterjour(paramInterJour.toString());
			listInfosUtilisateur.add(iu);
		}
		
		return listInfosUtilisateur;
	}

}
