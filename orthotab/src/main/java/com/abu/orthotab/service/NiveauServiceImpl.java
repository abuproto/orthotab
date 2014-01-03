package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Case;

@Service
public class NiveauServiceImpl implements NiveauService {

	//String[] codeCouleurs = {"#046380","#C03000","#8FCF3C","#F4FF3A","#C9001A","#495CFF","#F9A41E","#D400FF","#05966D","#FF0000"};
	
	int nbCombi = 10;
	
	@Override
	//public Niveau getNiveau01() {
	public List<Case> getNiveau01() {
		
		//Niveau niveau = new Niveau();
		
		// Couleurs
		//List<Couleur> couleurs = new ArrayList<Couleur>();
		//for(int i=0;i<codeCouleurs.length;i++){
		//	couleurs.add(new Couleur(codeCouleurs[i]));
		//}
		//niveau.setCouleurs(couleurs);
		
		// cases
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			Case caseOp = new Case(Case.Type.OP.name(),i + " + " + i,i+i);
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(),String.valueOf(i+i),i+i);
			cases.add(caseRes);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(cases,new Random(seed));
		return cases;
		//niveau.setCases(cases);

		//return niveau;
	}

}
