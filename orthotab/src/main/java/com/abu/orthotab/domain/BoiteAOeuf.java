package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class BoiteAOeuf {
	private int valmax;
	
	private int valacquis;
	
	private int valrestant;
	
	private String librestant;
	
	private List<Case> listeCaseChoix = new ArrayList<Case>();
	
	
	
	public BoiteAOeuf(int valmax, int valacquis) {
		super();
		this.valmax = valmax;
		this.valacquis = valacquis;
		this.valrestant = this.valmax-this.valacquis;
		this.librestant = "?";
	}



	public int getValmax() {
		return valmax;
	}



	public void setValmax(int valmax) {
		this.valmax = valmax;
	}



	public int getValacquis() {
		return valacquis;
	}



	public void setValacquis(int valacquis) {
		this.valacquis = valacquis;
	}



	public int getValrestant() {
		return valrestant;
	}



	public void setValrestant(int valrestant) {
		this.valrestant = valrestant;
	}



	public String getLibrestant() {
		return librestant;
	}



	public void setLibrestant(String librestant) {
		this.librestant = librestant;
	}



	public List<Case> getListeCaseChoix() {
		return listeCaseChoix;
	}



	public void setListeCaseChoix(List<Case> listeCaseChoix) {
		this.listeCaseChoix = listeCaseChoix;
	}



	public void addCaseChoix(Case caseChoix){
		this.listeCaseChoix.add(caseChoix);
	}
}
