package com.abu.orthotab.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="ACTIVITY")
public class Activity implements Serializable{
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "DATEACTIVITE")
	private Date dateActivite;
	
	@Column(name = "DUREE")
	private Long duree;
	
	@Column(name = "DETAILS")
	private String details;
	
	@Column(name = "IDUSER")
	private Long idUser;
	
	@Column(name = "NBECHEC")
	private Long nbEchec;

	@Transient
	private String token;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateActivite() {
		return dateActivite;
	}

	public void setDateActivite(Date dateActivite) {
		this.dateActivite = dateActivite;
	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getNbEchec() {
		return nbEchec;
	}

	public void setNbEchec(Long nbEchec) {
		this.nbEchec = nbEchec;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
