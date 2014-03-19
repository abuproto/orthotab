package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculATrou {

	private int idtrou;
	
	private List<Case> listeCaseChoix = new ArrayList<Case>();
	
	private List<Case> listeCaseCible = new ArrayList<Case>();

	
	
	public CalculATrou() {
	}

	public int getIdtrou() {
		return idtrou;
	}

	public void setIdtrou(int idtrou) {
		this.idtrou = idtrou;
	}

	public List<Case> getListeCaseChoix() {
		return listeCaseChoix;
	}

	public void setListeCaseChoix(List<Case> listeCaseChoix) {
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
	
	public void addCaseChoix(Case caseChoix){
		this.listeCaseChoix.add(caseChoix);
	}
}
