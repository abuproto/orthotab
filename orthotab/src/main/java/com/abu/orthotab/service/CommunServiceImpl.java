package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Couleur;

@Service
public class CommunServiceImpl implements CommunService {

	String[] codeCouleurs = {"#046380","#C03000","#8FCF3C","#F4FF3A","#C9001A","#495CFF","#F9A41E","#D400FF","#05966D","#FF0000"};
	
	public List<Couleur> getListeCouleurs(int nbCouleurs) {
		int nbMax = codeCouleurs.length;
		if(nbCouleurs<nbMax){
			nbMax = nbCouleurs;
		}
		// Couleurs
		List<Couleur> couleurs = new ArrayList<Couleur>();
		for(int i=0;i<nbMax;i++){
			Couleur c = new Couleur(codeCouleurs[i]);
			c.setActive(true);
			c.setCssClass("boutonCouleur");
			couleurs.add(c);
		}
		return couleurs;
	}

}
