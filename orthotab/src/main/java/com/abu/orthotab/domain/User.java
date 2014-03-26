package com.abu.orthotab.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class User {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "PRENOM")
	private String prenom;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NIVCOURANT")
	private Long nivcourant;
		
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "DATECHGTNIV")
	private Date datechgtniv;
	
	@Column(name = "NBTOTCAC")
	private Long nbtotcac;
	
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
	
	

}
