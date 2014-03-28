package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class InfosAccueil {
	private int nbcac;

	// timestamp du prochain niveau
	private int nbMillisNextJour;
	
	private List<String> listeNomObjet = new ArrayList<String>();

	public int getNbcac() {
		return nbcac;
	}

	public void setNbcac(int nbcac) {
		this.nbcac = nbcac;
	}

	public List<String> getListeNomObjet() {
		return listeNomObjet;
	}

	public void setListeNomObjet(List<String> listeNomObjet) {
		this.listeNomObjet = listeNomObjet;
	}
	
	public void addNomObjet(String nomObjet){
		this.listeNomObjet.add(nomObjet);
	}

	public int getNbMillisNextJour() {
		return nbMillisNextJour;
	}

	public void setNbMillisNextJour(int nbMillisNextJour) {
		this.nbMillisNextJour = nbMillisNextJour;
	}
}
