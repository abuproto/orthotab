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

	private Case construitCase(String exp) {
		Case caseRes = new Case(Case.Type.RES.name(), "?", evalueExpression(exp));
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
			casesBrut.add(construitCase("3+9"));
			casesBrut.add(construitCase("14"));
			casesBrut.add(construitCase("4+9"));
			casesBrut.add(construitCase("(6+10)-1"));
			casesBrut.add(construitCase("(7+10)-1"));
			casesBrut.add(construitCase("8+9"));
			casesBrut.add(construitCase("(6+10)-2"));
			casesBrut.add(construitCase("12"));
			casesBrut.add(construitCase("5+8"));
			casesBrut.add(construitCase("(4+10)-1"));
			casesBrut.add(construitCase("6+9"));
			casesBrut.add(construitCase("12"));
			casesBrut.add(construitCase("5+9"));
			casesBrut.add(construitCase("13"));
			casesBrut.add(construitCase("(4+10)-2"));
			casesBrut.add(construitCase("7+9"));
			casesBrut.add(construitCase("17"));
			casesBrut.add(construitCase("6+8"));
			break;
		case "s4j1e2":
			casesBrut.add(construitCase("3+9"));
			casesBrut.add(construitCase("(17+10)-1"));
			casesBrut.add(construitCase("13"));
			casesBrut.add(construitCase("5+8"));
			casesBrut.add(construitCase("(5+10)-1"));
			casesBrut.add(construitCase("27"));
			casesBrut.add(construitCase("12"));
			casesBrut.add(construitCase("7+9"));
			casesBrut.add(construitCase("(15+10)-1"));
			casesBrut.add(construitCase("(6+10)-2"));
			casesBrut.add(construitCase("5+9"));
			casesBrut.add(construitCase("16"));
			casesBrut.add(construitCase("(5+10)-2"));
			casesBrut.add(construitCase("13"));
			casesBrut.add(construitCase("6+8"));
			casesBrut.add(construitCase("24"));
			casesBrut.add(construitCase("17+9"));
			casesBrut.add(construitCase("(3+10)-1"));
			casesBrut.add(construitCase("(18+10)-1"));
			casesBrut.add(construitCase("4+8"));
			break;
		}
		return casesBrut;
	}
}
