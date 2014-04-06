package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ParametreDao;
import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.InfosUtilisateur;
import com.abu.orthotab.domain.Parametre;
import com.abu.orthotab.domain.User;

@Service
public class InfosUtilisateurServiceImpl implements InfosUtilisateurService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ParametreDao parametreDao;
	
	@Override
	@Transactional
	public List<InfosUtilisateur> getListInfosUtilisateur() {
		
		List<InfosUtilisateur> listInfosUtilisateur = new ArrayList<InfosUtilisateur>();
		List<User> listUser = userDao.findAllUser();
		
		for(User user : listUser){
			InfosUtilisateur iu = new InfosUtilisateur();
			iu.setIdUser(user.getId());
			iu.setLibUtilisateur((user.getPrenom()==null?"":user.getPrenom() + " ") + user.getNom() + " (" + user.getId() + ")");
			iu.setNbTotCac(user.getNbtotcac());
			iu.setLibNivCourant(String.valueOf(user.getNivcourant()));
			
			Parametre parametre = parametreDao.findParametreByCleIdUser(Parametre.Cle.EX_INTERVALLE.name(), user.getId());
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
