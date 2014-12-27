package com.abu.orthotab.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="parametre")
public class Parametre implements Serializable{
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "cle")
	private String cle;
	
	@Column(name = "valeur")
	private String valeur;
	
	@Column(name = "idpatient")
	private Long idpatient;

	@Transient
	private int heure;
	
	@Transient
	private int minute;
	
	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public enum Cle {
		EX_INTERVALLE, ECART_TIME
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Long getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(Long idpatient) {
		this.idpatient = idpatient;
	}


}
