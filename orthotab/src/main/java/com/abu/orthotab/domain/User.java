package com.abu.orthotab.domain;

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
	private int nivcourant;
	
	//private Date dateNaissance;
	
	//private boolean actif;
	
	@Column(name = "ROLE")
	private String role;

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

	public int getNivcourant() {
		return nivcourant;
	}

	public void setNivcourant(int nivcourant) {
		this.nivcourant = nivcourant;
	}

}
