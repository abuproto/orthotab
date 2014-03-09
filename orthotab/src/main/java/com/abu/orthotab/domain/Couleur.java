package com.abu.orthotab.domain;

public class Couleur extends ElementJeu{
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Couleur(String code) {
		super();
		this.code = code;
	}

}
