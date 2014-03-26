package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;

public class Technique01Data extends TechniqueDataUtil {

	private Technique01Data() {
	};

	private final static Technique01Data instance = new Technique01Data();

	public static Technique01Data getInstance() {
		return instance;
	}

	private List<Case> construitCases(String expOp, String expRes) {
		List<Case> listeCasePartielle = new ArrayList<Case>();

		Case caseOp = new Case(Case.Type.OP.name(), expOp,
				evalueExpression(expOp));
		caseOp.setActive(true);
		caseOp.setCssClass(CSS_BOUTON_CASE);
		caseOp.setBackgrdStyle(STYLE_BGRD_GRIS);
		listeCasePartielle.add(caseOp);
		Case caseRes = new Case(Case.Type.RES.name(), expRes,
				evalueExpression(expRes));
		caseRes.setActive(true);
		caseRes.setCssClass(CSS_BOUTON_CASE);
		caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
		listeCasePartielle.add(caseRes);

		return listeCasePartielle;
	}

	private List<Case> construitCases(String expOp) {
		List<Case> listeCasePartielle = new ArrayList<Case>();

		int valeur = evalueExpression(expOp);
		Case caseOp = new Case(Case.Type.OP.name(), expOp, valeur);
		caseOp.setActive(true);
		caseOp.setCssClass(CSS_BOUTON_CASE);
		caseOp.setBackgrdStyle(STYLE_BGRD_GRIS);
		listeCasePartielle.add(caseOp);
		Case caseRes = new Case(Case.Type.RES.name(), String.valueOf(valeur),
				valeur);
		caseRes.setActive(true);
		caseRes.setCssClass(CSS_BOUTON_CASE);
		caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
		listeCasePartielle.add(caseRes);

		return listeCasePartielle;
	}

	public List<Case> listeCase(String niveau, int nbInRow) {

		List<Case> listeCase = new ArrayList<Case>();

		switch (niveau) {
		case "s1j3e2":
			listeCase.addAll(construitCases("3+9", "(3+10)-1"));
			listeCase.addAll(construitCases("4+9", "(4+10)-1"));
			listeCase.addAll(construitCases("5+9", "(5+10)-1"));
			listeCase.addAll(construitCases("6+9", "(6+10)-1"));
			listeCase.addAll(construitCases("7+9", "(7+10)-1"));
			listeCase.addAll(construitCases("8+9", "(8+10)-1"));
			//listeCase.addAll(construitCases("4+8", "(4+10)-2"));
			//listeCase.addAll(construitCases("5+8", "(5+10)-2"));
			//listeCase.addAll(construitCases("6+8", "(6+10)-2"));
			break;
     	case "s2j2e3":
     		listeCase.addAll(construitCases("2x3"));
     		listeCase.addAll(construitCases("2x4"));
     		listeCase.addAll(construitCases("2x5"));
     		listeCase.addAll(construitCases("2x6"));
     		listeCase.addAll(construitCases("2x7"));
     		listeCase.addAll(construitCases("2x8"));
     		listeCase.addAll(construitCases("2x9"));
     		listeCase.addAll(construitCases("2x10"));
     		break;
      	case "s3j2e2":
      		listeCase.addAll(construitCases("4x4"));
      		listeCase.addAll(construitCases("4x6"));
      		listeCase.addAll(construitCases("4x7"));
      		listeCase.addAll(construitCases("4x8"));
      		listeCase.addAll(construitCases("4x9"));
      		listeCase.addAll(construitCases("4x10"));
      		listeCase.addAll(construitCases("6x6"));
      		listeCase.addAll(construitCases("6x7"));
      		listeCase.addAll(construitCases("6x8"));
      		listeCase.addAll(construitCases("6x9"));
      		listeCase.addAll(construitCases("6x10"));
    		break;
      	case "s4j2e2":
      		listeCase.addAll(construitCases("9x1"));
      		listeCase.addAll(construitCases("9x2"));
      		listeCase.addAll(construitCases("9x3"));
      		listeCase.addAll(construitCases("9x4"));
      		listeCase.addAll(construitCases("9x5"));
      		listeCase.addAll(construitCases("9x6"));
      		listeCase.addAll(construitCases("9x7"));
      		listeCase.addAll(construitCases("9x8"));
      		listeCase.addAll(construitCases("9x9"));
      		listeCase.addAll(construitCases("9x10"));
      		break;
		}
		return completeRow(nbInRow, melange(listeCase));
	}
}
