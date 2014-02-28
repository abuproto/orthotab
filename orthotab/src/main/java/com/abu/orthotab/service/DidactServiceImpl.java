package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Loc;

@Service
public class DidactServiceImpl implements DidactService {

	
	private List<Case> melange(List<Case> listeCase ){
		long seed = System.nanoTime();
		Collections.shuffle(listeCase,new Random(seed));
		return listeCase;
	}
	
	private static String[][] tabClass = {{"btn-case btn-case-etoile","1"},{"btn-case btn-case-fleche","2"},
		{"btn-case btn-case-croix","3"},{"btn-case btn-case-rond","4"},{"btn-case btn-case-lune","5"}};
	
	@Override
	public List<Case> getDidact01(int nbCombi) {
		
		
		// cases
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			Case caseOp = new Case(Case.Type.OP.name(),"",Integer.valueOf(tabClass[i-1][1]));
			caseOp.setActive(true);
			caseOp.setCssClass(tabClass[i-1][0]);
			caseOp.setBackgrdStyle("#B5B276");
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(),"",Integer.valueOf(tabClass[i-1][1]));
			caseRes.setActive(true);
			caseRes.setCssClass(tabClass[i-1][0]);
			caseRes.setBackgrdStyle("#B5B276");
			cases.add(caseRes);
		}
		
		return melange(cases);
	}
	
	
	@Override
	public List<Case> getDidact02(int nbCombi, String pos) {
		
		// cases
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			Case caseRes = new Case(Case.Type.RES.name(),"",Integer.valueOf(tabClass[i-1][1]));
			caseRes.setActive(true);
			caseRes.setPos(pos);
			caseRes.setCssClass(tabClass[i-1][0]);
			caseRes.setBackgrdStyle("#B5B276");
			cases.add(caseRes);
		}
		
		return completeLoc(melange(cases),pos);
	}

	
	private List<Case> completeLoc(List<Case> listeCase, String pos){
		List<Case> listeCaseComplete = new ArrayList<Case>();
		
		int x = 0;
		if("G".equals(pos)){
			x=20;
		}else if("D".equals(pos)){
			x=180;
		}
		
		int ydepart = 20;
		int y = ydepart;
		
		int pasvertical = 100;
		
		for(int i=0; i<listeCase.size(); i++){
			Case caseACompleter = listeCase.get(i);
			y = ydepart + pasvertical*i;
			caseACompleter.setLoc(new Loc(x,y));
			listeCaseComplete.add(caseACompleter);
		}		
		return listeCaseComplete;
	}
}
