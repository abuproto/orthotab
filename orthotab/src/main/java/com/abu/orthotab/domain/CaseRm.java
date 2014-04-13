package com.abu.orthotab.domain;

public class CaseRm {
	private String libelle;
	
	private String exppos;
	
	private boolean active;
	
	private String backgrdStyle;
	
	private String cssClass;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getExppos() {
		return exppos;
	}

	public void setExppos(String exppos) {
		this.exppos = exppos;
	}

	public CaseRm(String libelle, String exppos) {
		super();
		this.libelle = libelle;
		this.exppos = exppos;
		this.setActive(true);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBackgrdStyle() {
		return backgrdStyle;
	}

	public void setBackgrdStyle(String backgrdStyle) {
		this.backgrdStyle = backgrdStyle;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
