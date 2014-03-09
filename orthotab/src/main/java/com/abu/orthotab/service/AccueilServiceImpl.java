package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.domain.User;

@Service
public class AccueilServiceImpl implements AccueilService {

    @Autowired
    private UserDao userDao;
	
    @Transactional
	public List<Etape> getListeEtapes(int userid) {
		List<Etape> etapes = new ArrayList<Etape>();
		
		int nivcourant = 1;
		User userConnecte = userDao.finduserById(userid);
		if(userConnecte!=null){
			nivcourant = userConnecte.getNivcourant();
		}
		
		int nbNiveau = 3;
		//int noNiveauActif = 2; // commence a 1
		
		String CSS_CLASS_AVANT = "avant";
		String CSS_CLASS_ACTIF = "actif";
		String CSS_CLASS_APRES = "apres";
		
		for(int i=1;i<=nbNiveau;i++){
			Etape etape = new Etape();
			if(i<nivcourant){
				etape.setCircleCssClass(CSS_CLASS_AVANT);
				etape.setPathCssClass(CSS_CLASS_AVANT);
			}else if(i==nivcourant){
				etape.setCircleCssClass(CSS_CLASS_ACTIF);
				etape.setPathCssClass(CSS_CLASS_APRES);
			}else{
				etape.setCircleCssClass(CSS_CLASS_APRES);
				etape.setPathCssClass(CSS_CLASS_APRES);
			}
			etapes.add(etape);
		}
		return etapes;
	}

}
