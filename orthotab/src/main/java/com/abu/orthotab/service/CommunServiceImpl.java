package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Couleur;
import com.abu.orthotab.domain.PathInfo;

@Service
public class CommunServiceImpl implements CommunService {

	String[] codeCouleurs = {"#046380","#C03000","#8FCF3C","#F4FF3A","#495CFF","#C9001A","#F9A41E","#D400FF","#05966D","#FF0000","#E8CC06"};
	
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

	@Override
	public List<PathInfo> getListPathInfos(int nb) {
		
		List<PathInfo> listPathInfo = new ArrayList<PathInfo>();
		int i=0;
		while(i<nb){
			PathInfo pi = new PathInfo("M0,0 L0,0","masque");
			listPathInfo.add(pi);
			i++;
		}
		return listPathInfo;
	}

}
