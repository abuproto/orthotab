package com.abu.orthotab.domain;

public class Etape {
	private String circleCssClass;
	private String pathCssClass;
	
	private int r;
	
	private int cx;
	
	private int cy;
	
	private String d;

	private String ngclick;
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getNgclick() {
		return ngclick;
	}

	public void setNgclick(String ngclick) {
		this.ngclick = ngclick;
	}

	public String getCircleCssClass() {
		return circleCssClass;
	}

	public void setCircleCssClass(String circleCssClass) {
		this.circleCssClass = circleCssClass;
	}

	public String getPathCssClass() {
		return pathCssClass;
	}

	public void setPathCssClass(String pathCssClass) {
		this.pathCssClass = pathCssClass;
	}

}
