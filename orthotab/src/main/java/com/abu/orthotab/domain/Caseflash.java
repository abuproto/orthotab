package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class Caseflash {

	private String libelle;
	private int valeur;
	private String cssClass;
	
	private List<Caseflash> listeCaseflash = new ArrayList<Caseflash>();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public List<Caseflash> getListeCaseflash() {
		return listeCaseflash;
	}

	public void setListeCaseflash(List<Caseflash> listeCaseflash) {
		this.listeCaseflash = listeCaseflash;
	}

	public Caseflash(String libelle, int valeur) {
		super();
		this.libelle = libelle;
		this.valeur = valeur;
	}

	public Caseflash() {
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
}
