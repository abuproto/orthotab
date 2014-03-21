package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;

public class Technique02Data extends TechniqueDataUtil {
	
	private Technique02Data() {
	};

	private final static Technique02Data instance = new Technique02Data();

	public static Technique02Data getInstance() {
		return instance;
	}

	
	private Case construitCase(String exp, String pos) {
		Case caseRes = new Case(Case.Type.RES.name(), exp, evalueExpression(exp));
		caseRes.setActive(true);
		caseRes.setPos(pos);
		caseRes.setCssClass(CSS_BOUTON_CASE_SMALL);
		caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
		return caseRes;
	}
	
	public List<Case> listeBrutCase(String niveau, String pos) {
		List<Case> casesBrut = new ArrayList<Case>();
		
		switch (niveau+pos) {
		case "s1j2e2G":
			casesBrut.add(construitCase("", pos));
			break;
		case "s1j2e2D":
			casesBrut.add(construitCase("", pos));
			break;
		}
		return casesBrut;
	}
	
	
}
