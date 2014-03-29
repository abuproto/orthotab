package com.abu.orthotab.domain;

import java.util.ArrayList;
import java.util.List;

public class InfosAccueil {
	private int nbcac;

	// timestamp du prochain niveau
	private long nbMillisNextJour;
	
	private List<String> listeNomObjet = new ArrayList<String>();
	
	private int nivcourant;

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

	public long getNbMillisNextJour() {
		return nbMillisNextJour;
	}

	public void setNbMillisNextJour(long nbMillisNextJour) {
		this.nbMillisNextJour = nbMillisNextJour;
	}

	public int getNivcourant() {
		return nivcourant;
	}

	public void setNivcourant(int nivcourant) {
		this.nivcourant = nivcourant;
	}
}
