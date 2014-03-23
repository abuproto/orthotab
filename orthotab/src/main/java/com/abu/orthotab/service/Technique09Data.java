package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.CaseRm;
import com.abu.orthotab.domain.RemettreOrdre;

public class Technique09Data extends TechniqueDataUtil{
	private Technique09Data() {
	};

	private final static Technique09Data instance = new Technique09Data();

	public static Technique09Data getInstance() {
		return instance;
	}
	
	private RemettreOrdre construitRemettreOrdre(String[][] elements){
		RemettreOrdre rm = new RemettreOrdre();
		
		int nbocc = elements.length;
		
		for(String[] crm : elements){
			CaseRm caseRm = new CaseRm(crm[0],crm[1]);
			caseRm.setBackgrdStyle(STYLE_BGRD_GRIS);
			rm.addCaseChoix(caseRm);
		}
		
		rm.setListeCaseCible(construitListeCaseCible(nbocc));
		return rm;
	}
	
	public List<RemettreOrdre> listeRemettreOrdre(String niveau){
		List<RemettreOrdre> listeRemettreOrdre = new ArrayList<RemettreOrdre>();
		
		switch (niveau) {
		case "s4j5e1":
			break;
		case "s3j2e1":
			break;
		case "s3j4e2":
			break;
		case "s4j2e3":
			break;
		case "s4j4e3":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"3","0;2;4"},{"127","0;2;4"},{"62","0;2;4"},{"=","5"},{"192","6"}}));
			break;
		}
		
		return listeRemettreOrdre;
	}
	
	
	private List<Case> construitListeCaseCible(int nbocc){
		List<Case> lstCase = new ArrayList<Case>();
		for(int i=0;i<nbocc;i++){
			Case caseCible = new Case("","?",0);
			caseCible.setActive(true);
			caseCible.setBackgrdStyle(STYLE_BGRD_GRIS);
			lstCase.add(caseCible);
		}
		return lstCase;
	}
}
