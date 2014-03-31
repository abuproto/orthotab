package com.abu.orthotab.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.domain.InfosActivity;
import com.abu.orthotab.domain.User;

@Service
public class InfosActivityServiceImpl implements InfosActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<InfosActivity> getListInfosActivity() {
		List<InfosActivity> listInfosActivity = new ArrayList<InfosActivity>();

		List<Activity> listActivity = activityDao.findAllActivity();

		for (Activity activity : listActivity) {
			InfosActivity ia = new InfosActivity();
			User user = userDao.finduserById(activity.getIdUser().intValue());
			String libUtilisateur = "";
			if (user != null) {
				libUtilisateur = user.getPrenom() == null ? user.getNom()
						: user.getPrenom();
			}
			ia.setLibUtilisateur(libUtilisateur);
			ia.setExercice(activity.getType());

			ia.setNoSemaine(activity.getType().startsWith("s") ? activity
					.getType().substring(1, 2) : "");
			String libduree = "";
			if (activity.getDuree() != null) {
				int nbs = activity.getDuree().intValue()/1000;
				libduree = String.format("%d:%02d:%02d", nbs / 3600,
						(nbs % 3600) / 60, (nbs % 60));
				ia.setDuree(libduree);
			}

			ia.setNbEchec(activity.getNbEchec()==null?"":activity.getNbEchec().toString());
			
			String libDateIa = "";
			if(activity.getDateActivite()!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss", Locale.FRANCE);
				libDateIa = sdf.format(activity.getDateActivite());
				ia.setDateIa(libDateIa);
			}
			
			listInfosActivity.add(ia);
		}

		return listInfosActivity;
	}

}
