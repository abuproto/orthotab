package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class MemoryMultipliant {

	private int valeur;
	
	private List<Case> listeCaseG = new ArrayList<Case>();
	
	private List<Case> listeCaseD = new ArrayList<Case>();

	
	
	public MemoryMultipliant(int valeur) {
		super();
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public List<Case> getListeCaseG() {
		return listeCaseG;
	}

	public void setListeCaseG(List<Case> listeCaseG) {
		this.listeCaseG = listeCaseG;
	}

	public List<Case> getListeCaseD() {
		return listeCaseD;
	}

	public void setListeCaseD(List<Case> listeCaseD) {
		this.listeCaseD = listeCaseD;
	}
	
	public void addCaseG(Case caseChoix){
		this.listeCaseG.add(caseChoix);
	}
	
	public void addCaseD(Case caseChoix){
		this.listeCaseD.add(caseChoix);
	}
}
