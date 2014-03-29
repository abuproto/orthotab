package com.abu.orthotab.domain;

public class InfosExercice {
	private String cssClass;
	
	private String action;
	
	private String message;
	
	private int nbcac;
	
	private String libelle;
	
	private String nomImgCac;
	
	private boolean actif;
	
	private int semaine;
	
	private int jour;
	
	private int ex;

	public int getSemaine() {
		return semaine;
	}

	public void setSemaine(int semaine) {
		this.semaine = semaine;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getEx() {
		return ex;
	}

	public void setEx(int ex) {
		this.ex = ex;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNbcac() {
		return nbcac;
	}

	public void setNbcac(int nbcac) {
		this.nbcac = nbcac;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomImgCac() {
		return nomImgCac;
	}

	public void setNomImgCac(String nomImgCac) {
		this.nomImgCac = nomImgCac;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
