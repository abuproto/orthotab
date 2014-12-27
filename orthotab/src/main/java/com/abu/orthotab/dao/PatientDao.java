package com.abu.orthotab.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abu.orthotab.domain.Patient;

@Repository
public class PatientDao extends CommonHibernateDao {

	@SuppressWarnings("unchecked")
	public List<Patient> findAllPatient() {
		return getCurrentSession().createQuery("from Patient where id>0").list();
	}

	@SuppressWarnings("unchecked")
	public Patient findPatientByLogin(String login) {
		Patient patient = null;
		List<Patient> listPatient = getCurrentSession().createQuery(
				"from Patient where login = '" + login + "'").list();
		// TODO remplacer par preparedStatement ou equivalent
		// TEMP
		if (!listPatient.isEmpty()) {
			patient = listPatient.get(0);
		}
		return patient;
	}

	@SuppressWarnings("unchecked")
	public Patient findPatientByToken(String token) {
		Patient patient = null;
		List<Patient> listPatient = getCurrentSession().createQuery(
				"from Patient where token = '" + token + "'").list();
		// TODO remplacer par preparedStatement ou equivalent
		// TEMP
		if (!listPatient.isEmpty()) {
			patient = listPatient.get(0);
		}
		return patient;
	}

	public Patient findPatientById(int id) {
		Patient patient = (Patient) getCurrentSession().load(Patient.class,
				Long.valueOf(id));
		return patient;
	}
}
