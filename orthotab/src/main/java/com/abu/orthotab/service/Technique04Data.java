package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;

public class Technique04Data extends TechniqueDataUtil {

	private Technique04Data() {
	};

	private final static Technique04Data instance = new Technique04Data();

	public static Technique04Data getInstance() {
		return instance;
	}

	private Case construitCase(String exp, String type) {
		Case caseRes = new Case(type, "?", evalueExpression(exp));
		caseRes.setRealLibelle(exp);
		caseRes.setActive(true);
		caseRes.setCssClass(CSS_BOUTON_CASE_SMALL);
		caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
		caseRes.setSens("VERSO");
		return caseRes;
	}

	public List<Case> listeBrutCase(String niveau) {
		List<Case> casesBrut = new ArrayList<Case>();

		switch (niveau) {
		case "s2j1e2":
			casesBrut.add(construitCase("3+9","OP"));
			casesBrut.add(construitCase("14","OP"));
			//casesBrut.add(construitCase("4+9","OP"));
			casesBrut.add(construitCase("(6+10)-1","OP"));
			//casesBrut.add(construitCase("(7+10)-1","OP"));
			casesBrut.add(construitCase("8+9","OP"));
			//casesBrut.add(construitCase("(6+10)-2","OP"));
			casesBrut.add(construitCase("12","OP"));
			//casesBrut.add(construitCase("5+8","OP"));
			//casesBrut.add(construitCase("(4+10)-1","RES"));
			casesBrut.add(construitCase("6+9","RES"));
			casesBrut.add(construitCase("12","RES"));
			casesBrut.add(construitCase("5+9","RES"));
			//casesBrut.add(construitCase("13","RES"));
			casesBrut.add(construitCase("(4+10)-2","RES"));
			//casesBrut.add(construitCase("7+9","RES"));
			casesBrut.add(construitCase("17","RES"));
			//casesBrut.add(construitCase("6+8","RES"));
			break;
		case "s4j1e2":
			casesBrut.add(construitCase("3+9","OP"));
			//casesBrut.add(construitCase("(17+10)-1","OP"));
			casesBrut.add(construitCase("13","OP"));
			//casesBrut.add(construitCase("5+8","OP"));
			casesBrut.add(construitCase("(5+10)-1","OP"));
			casesBrut.add(construitCase("27","OP"));
			//casesBrut.add(construitCase("12","OP"));
			//casesBrut.add(construitCase("7+9","OP"));
			casesBrut.add(construitCase("(15+10)-1","OP"));
			casesBrut.add(construitCase("(6+10)-2","OP"));
			casesBrut.add(construitCase("5+9","RES"));
			//casesBrut.add(construitCase("16","RES"));
			casesBrut.add(construitCase("(5+10)-2","RES"));
			//casesBrut.add(construitCase("13","RES"));
			casesBrut.add(construitCase("6+8","RES"));
			casesBrut.add(construitCase("24","RES"));
			//casesBrut.add(construitCase("17+9","RES"));
			casesBrut.add(construitCase("(3+10)-1","RES"));
			casesBrut.add(construitCase("(18+10)-1","RES"));
			//casesBrut.add(construitCase("4+8","RES"));
			break;
		case "s2j2e1":
			casesBrut.add(construitCase("5+5","OP"));
			casesBrut.add(construitCase("8+8","OP"));
			casesBrut.add(construitCase("9+9","OP"));
			casesBrut.add(construitCase("10+10","OP"));
			casesBrut.add(construitCase("11+11","OP"));
			casesBrut.add(construitCase("13+13","OP"));
			casesBrut.add(construitCase("15+15","OP"));
			casesBrut.add(construitCase("10","RES"));
			casesBrut.add(construitCase("16","RES"));
			casesBrut.add(construitCase("18","RES"));
			casesBrut.add(construitCase("20","RES"));
			casesBrut.add(construitCase("22","RES"));
			casesBrut.add(construitCase("26","RES"));
			casesBrut.add(construitCase("30","RES"));
			break;
		case "s2j5e1":
			casesBrut.add(construitCase("6+6","OP"));
			casesBrut.add(construitCase("7+7","OP"));
			casesBrut.add(construitCase("8+8","OP"));
			casesBrut.add(construitCase("10+10","OP"));
			casesBrut.add(construitCase("12+12","OP"));
			casesBrut.add(construitCase("14+14","OP"));
			casesBrut.add(construitCase("12","RES"));
			casesBrut.add(construitCase("14","RES"));
			casesBrut.add(construitCase("16","RES"));
			casesBrut.add(construitCase("20","RES"));
			casesBrut.add(construitCase("24","RES"));
			casesBrut.add(construitCase("28","RES"));
			break;
		case "s5j2e1":
			casesBrut.add(construitCase("7+7","OP"));
			casesBrut.add(construitCase("13+13","OP"));
			casesBrut.add(construitCase("20+20","OP"));
			casesBrut.add(construitCase("35+35","OP"));
			casesBrut.add(construitCase("45+45","OP"));
			casesBrut.add(construitCase("75+75","OP"));
			casesBrut.add(construitCase("90+90","OP"));
			casesBrut.add(construitCase("14","RES"));
			casesBrut.add(construitCase("26","RES"));
			casesBrut.add(construitCase("40","RES"));
			casesBrut.add(construitCase("70","RES"));
			casesBrut.add(construitCase("90","RES"));
			casesBrut.add(construitCase("150","RES"));
			casesBrut.add(construitCase("180","RES"));
			break;
		}
		return casesBrut;
	}
}
