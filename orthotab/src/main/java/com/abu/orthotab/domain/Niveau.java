package com.abu.orthotab.domain;

import java.util.List;

public class Niveau {
	private List<Couleur> couleurs;
	private List<Case> cases;

	public List<Couleur> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(List<Couleur> couleurs) {
		this.couleurs = couleurs;
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

}
