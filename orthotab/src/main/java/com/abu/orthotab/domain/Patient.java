package com.abu.orthotab.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nivcourant")
	private Long nivcourant;
			
	@Column(name = "token")
	private String token;
	
	@Column(name = "datechgtniv")
	private Date datechgtniv;
	
	@Column(name = "nbtotcac")
	private Long nbtotcac;
	
	@Transient
	private String role = "PATIENT"; // temp : pour éviter impacts côté client
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDatechgtniv() {
		return datechgtniv;
	}

	public void setDatechgtniv(Date datechgtniv) {
		this.datechgtniv = datechgtniv;
	}

	public Long getNbtotcac() {
		return nbtotcac;
	}

	public void setNbtotcac(Long nbtotcac) {
		this.nbtotcac = nbtotcac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getNivcourant() {
		return nivcourant;
	}

	public void setNivcourant(Long nivcourant) {
		this.nivcourant = nivcourant;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nivcourant=");
		builder.append(nivcourant);
		builder.append("]");
		return builder.toString();
	}
	
	

}
