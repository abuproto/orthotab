package com.abu.orthotab.domain;

public class Case extends ElementJeu{
	private String type;
	private String libelle;
	private int valeur;
	private Loc loc;
	private String pos;

	public enum Type {
		OP, RES
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Case(String type, String libelle, int valeur) {
		super();
		this.type = type;
		this.libelle = libelle;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Loc getLoc() {
		return loc;
	}

	public void setLoc(Loc loc) {
		this.loc = loc;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

}
