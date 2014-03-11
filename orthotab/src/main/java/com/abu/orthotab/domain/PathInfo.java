package com.abu.orthotab.domain;

public class PathInfo {
	private String loc;
	private String cssClass;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public PathInfo(String loc, String cssClass) {
		super();
		this.loc = loc;
		this.cssClass = cssClass;
	}
}
