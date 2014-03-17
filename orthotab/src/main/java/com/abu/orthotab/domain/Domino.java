package com.abu.orthotab.domain;

public class Domino {
	private String libg;
	private int valg;
	private String libd;
	private int vald;
	private String cssClass;
	
	
	
	public Domino() {
		this.libg="";
		this.libd="";
	}
	public String getLibg() {
		return libg;
	}
	public void setLibg(String libg) {
		this.libg = libg;
	}
	public int getValg() {
		return valg;
	}
	public void setValg(int valg) {
		this.valg = valg;
	}
	public String getLibd() {
		return libd;
	}
	public void setLibd(String libd) {
		this.libd = libd;
	}
	public int getVald() {
		return vald;
	}
	public void setVald(int vald) {
		this.vald = vald;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
