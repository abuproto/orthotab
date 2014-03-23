package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class RemettreOrdre {
	private List<CaseRm> listeCaseChoix = new ArrayList<CaseRm>();
	
	private List<Case> listeCaseCible = new ArrayList<Case>();

	public List<CaseRm> getListeCaseChoix() {
		return listeCaseChoix;
	}

	public void setListeCaseChoix(List<CaseRm> listeCaseChoix) {
		this.listeCaseChoix = listeCaseChoix;
	}

	public List<Case> getListeCaseCible() {
		return listeCaseCible;
	}

	public void setListeCaseCible(List<Case> listeCaseCible) {
		this.listeCaseCible = listeCaseCible;
	}
	
	public void addCaseCible(Case caseCible){
		this.listeCaseCible.add(caseCible);
	}
	
	public void addCaseChoix(CaseRm caseChoix){
		this.listeCaseChoix.add(caseChoix);
	}
}
