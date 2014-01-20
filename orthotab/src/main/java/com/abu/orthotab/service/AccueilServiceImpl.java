package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Etape;

@Service
public class AccueilServiceImpl implements AccueilService {

	public List<Etape> getListeEtapes() {
		List<Etape> etapes = new ArrayList<Etape>();
		
		int nbNiveau = 3;
		int noNiveauActif = 2; // commence a 1
		
		String CSS_CLASS_AVANT = "avant";
		String CSS_CLASS_ACTIF = "actif";
		String CSS_CLASS_APRES = "apres";
		
		for(int i=1;i<=nbNiveau;i++){
			Etape etape = new Etape();
			if(i<noNiveauActif){
				etape.setCircleCssClass(CSS_CLASS_AVANT);
				etape.setPathCssClass(CSS_CLASS_AVANT);
			}else if(i==noNiveauActif){
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
