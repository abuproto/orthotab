package com.abu.orthotab.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.PatientDao;
import com.abu.orthotab.domain.Patient;

@Service
public class UserServiceImpl implements UserService {

	private final static Logger LOGGER = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private PatientDao patientDao;

	@Override
	@Transactional
	public Patient authenticate(Patient patient) {
		Patient userVerifie = null;
		Patient userTemp = patientDao.findPatientByLogin(patient.getLogin());
		if (userTemp.getPassword().equals(patient.getPassword())) {
			userVerifie = userTemp;
			// userVerifie.setPassword(null);
			LOGGER.info("Authentification OK pour user " + userVerifie);
		} else {
			LOGGER.warn("Authentification KO pour login " + patient.getLogin());
		}

		return userVerifie;
	}

	@Override
	@Transactional
	public Patient miseAJourNiveau(int userid, int niveau) {
		Patient patient = patientDao.findPatientById(userid);
		if (patient == null) {
			LOGGER.error("Patient non trouve pour identifiant " + userid);
		} else {
			int oldNiveau = (patient.getNivcourant()==null?0:patient.getNivcourant().intValue());
			if (niveau > oldNiveau) {
				patient.setNivcourant(Long.valueOf(niveau));
				LOGGER.info("Mise a jour niveau courant pour user " + patient + " , " + oldNiveau + "-->" + niveau);
			}
		}
		return patient;
	}

	@Override
	@Transactional
	public Patient findByToken(String token) {
		return patientDao.findPatientByToken(token);
	}

	
	
}
