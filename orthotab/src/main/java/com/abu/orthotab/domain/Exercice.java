package com.abu.orthotab.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="EXERCICE")
public class Exercice implements Serializable{

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CODE")
	private String code;
		
	@Column(name = "SEUILSUP3")
	private Long seuilsup3;
	
	@Column(name = "SEUILSUP2")
	private Long seuilsup2;
	
	@Column(name = "NOJOUR")
	private Long nojour;

	@Column(name = "IDTECHNIQUE")
	private Long idtechnique;
	
	
	private final static Map<Long, String> mapLibelle;
	static {
		mapLibelle = new HashMap<Long, String>();
		mapLibelle.put(Long.valueOf(1), "Associer des paires par couleur");
		mapLibelle.put(Long.valueOf(2), "Relier les colonnes");
		mapLibelle.put(Long.valueOf(3), "Calcul Flash");
		mapLibelle.put(Long.valueOf(4), "Mémory");
		mapLibelle.put(Long.valueOf(5), "Dominos");
		mapLibelle.put(Long.valueOf(6), "Boîtes à compléter");
		mapLibelle.put(Long.valueOf(7), "Mémory multipliant");
		mapLibelle.put(Long.valueOf(8), "Calcul à trou");
		mapLibelle.put(Long.valueOf(9), "Remettre dans le bon ordre");
	}
	
	public Long getIdtechnique() {
		return idtechnique;
	}

	public void setIdtechnique(Long idtechnique) {
		this.idtechnique = idtechnique;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSeuilsup3() {
		return seuilsup3;
	}

	public void setSeuilsup3(Long seuilsup3) {
		this.seuilsup3 = seuilsup3;
	}

	public Long getSeuilsup2() {
		return seuilsup2;
	}

	public void setSeuilsup2(Long seuilsup2) {
		this.seuilsup2 = seuilsup2;
	}

	public Long getNojour() {
		return nojour;
	}

	public void setNojour(Long nojour) {
		this.nojour = nojour;
	}
	
	public String getLibelle(){
		return mapLibelle.get(this.idtechnique);
	}
	
	public int calculNbCac(int nbEchec){
		int nbCac = 1;
		
		if(nbEchec<=this.seuilsup3){
			nbCac = 3;
		}else if(nbEchec<=this.seuilsup2){
			nbCac = 2;
		}
		
		return nbCac;
	}
}
