package com.abu.orthotab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.dao.ExerciceDao;
import com.abu.orthotab.dao.ParametreDao;
import com.abu.orthotab.dao.PatientDao;
import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.domain.Exercice;
import com.abu.orthotab.domain.Patient;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final static Logger LOGGER = Logger
			.getLogger(ActivityServiceImpl.class);

	//private final static String ROLE_ADMIN = "ADMIN";

	private final static String TYPE_ACT_LOGIN = "LOGIN";

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ExerciceDao exerciceDao;

	@Autowired
	private ParametreDao parametreDao;

	@Override
	@Transactional
	public Long createActivity(Activity activity) {

		Long idActivity = null;

		if (activity.getIdpatient() == null
				|| activity.getIdpatient().intValue() == 0) {
			LOGGER.info("Recherche user par token : " + activity.getToken());
			Patient patient = patientDao.findPatientByToken(activity.getToken());
			if (patient != null) {
				Long idPatient = patient.getId();
				LOGGER.info("patient par token trouve : " + idPatient);
				if (doitEtreCree(patient, activity)) {
					activity.setIdpatient(idPatient);
					LOGGER.info("date et heure cote client : " + activity.getDateActivite().toString() + " pour patient " + patient.getLogin() + "(" + idPatient + ")");
					activity.setDateActivite(parametreDao.calculVraieDateHeure());
					boolean rejeuExercice = rejeuExercice(activity);

					if (rejeuExercice) {
						activity.setDetails("REJEU");
					}
					idActivity = activityDao.createActivity(activity);

					// si activity de type exercice
					if (!rejeuExercice) {
						String type = activity.getType();
						if (type.indexOf("s") == 0 && type.indexOf("j") == 2) {
							String codeExPart = activity.getType().substring(0,
									4);
							int nojour = calculNoJour(activity.getType());

							// maj nbtotcac
							int nbtotcac = patient.getNbtotcac() == null ? 0
									: patient.getNbtotcac().intValue();
							Exercice exerciceCac = exerciceDao
									.findExerciceByCode(type);
							int nbCac = exerciceCac.calculNbCac(activity
									.getNbEchec() == null ? 0 : activity
									.getNbEchec().intValue());
							patient.setNbtotcac(Long.valueOf(nbtotcac + nbCac));

							// recherche activity du même jour (niveau)
							List<Activity> listeActivity = activityDao
									.findActivityByIdpatientJour(idPatient,
											codeExPart);
							List<Exercice> listeExercice = exerciceDao
									.findExerciceByNojour(Long.valueOf(nojour));

							// boolean isJourTermine = false;
							int nbExTermine = 0;

							// vérification si jour terminé
							for (Exercice exercice : listeExercice) {
								if (exercice.getCode().equals(type)
										|| isExerciceEffectue(listeActivity,
												exercice.getCode())) {
									nbExTermine++;
								}
							}

							if (nbExTermine == listeExercice.size()) {
								int oldNiveau = (patient.getNivcourant() == null ? 0
										: patient.getNivcourant().intValue());
								int niveau = oldNiveau + 1;
								patient.setDatechgtniv(activity.getDateActivite());
								patient.setNivcourant(Long.valueOf(niveau));
								LOGGER.info("Mise a jour niveau courant pour patient "
										+ patient
										+ " , "
										+ oldNiveau
										+ "-->"
										+ niveau);
							} else {
								patient.setDatechgtniv(null);
							}
						}
					}
				}
			}
		}
		return idActivity;
	}

	private int calculNoJour(String codeEx) {
		int nojour = 0;

		try {
			String strnosem = codeEx.substring(1, 2);
			String strnoj = codeEx.substring(3, 4);

			int nosem = Integer.valueOf(strnosem);
			int noj = Integer.valueOf(strnoj);

			nojour = (nosem - 1) * 5 + noj;
		} catch (Exception e) {
			LOGGER.error("erreur de calculNoJour avec codeEx :" + codeEx, e);
		}

		return nojour;
	}

	private boolean isExerciceEffectue(List<Activity> listeActivity,
			String codeEx) {
		boolean isExerciceEffectue = false;

		for (Activity activity : listeActivity) {
			if (codeEx.equals(activity.getType())) {
				isExerciceEffectue = true;
				break;
			}
		}
		return isExerciceEffectue;
	}

	// pour les ADMIN, on cree uniquement les activites de type LOGIN
	private boolean doitEtreCree(Patient patient, Activity activity) {
		boolean doitEtreCree = true;
		// plus de notion de role ici
		//if (ROLE_ADMIN.equals(user.getRole())
		//		&& !TYPE_ACT_LOGIN.equals(activity.getType())) {
		//	doitEtreCree = false;
		//}
		return doitEtreCree;
	}

	// detection de rejeu d'un exercice
	private boolean rejeuExercice(Activity activity) {
		boolean rejeuExercice = false;
		if (!TYPE_ACT_LOGIN.equals(activity.getType())) {
			Activity activityExistante = activityDao
					.findLastActivityByExIdPatient(activity.getType(),
							activity.getIdpatient());
			if (activityExistante != null) {
				rejeuExercice = true;
			}
		}
		return rejeuExercice;
	}
}
