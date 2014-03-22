package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.BoiteAOeuf;
import com.abu.orthotab.domain.CalculATrou;
import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;
import com.abu.orthotab.domain.Domino;

@Service
public class TechniqueServiceImpl extends UtilServiceImpl implements
		TechniqueService {

	public List<Case> getTechnique01(String niveau, int nbInRow, int debut,
			int fin, int pas) {

		// cases
		List<Case> cases = new ArrayList<Case>();
		for (int i = debut; i <= fin; i = i + pas) {
			Case caseOp = new Case(Case.Type.OP.name(), i + "+" + i, i + i);
			caseOp.setActive(true);
			caseOp.setCssClass(CSS_BOUTON_CASE);
			caseOp.setBackgrdStyle(STYLE_BGRD_GRIS);
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(),
					String.valueOf(i + i), i + i);
			caseRes.setActive(true);
			caseRes.setCssClass(CSS_BOUTON_CASE);
			caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
			cases.add(caseRes);
		}
		return completeRow(nbInRow,
				melange(ajoutIntrus(niveau, cases, CSS_BOUTON_CASE)));
	}

	private List<Case> listeBrutTechnique02(int debut, int fin, int pas,
			String pos) {
		List<Case> cases = new ArrayList<Case>();
		for (int i = debut; i <= fin; i = i + pas) {

			String libelle = "";
			if ("G".equals(pos)) {
				libelle = i + "+" + i;
			} else if ("D".equals(pos)) {
				libelle = String.valueOf(i + i);
			}
			Case caseRes = new Case(Case.Type.RES.name(), libelle, i + i);
			caseRes.setActive(true);
			caseRes.setPos(pos);
			caseRes.setCssClass(CSS_BOUTON_CASE_SMALL);
			caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
			cases.add(caseRes);
		}
		return cases;
	}

	@Override
	public List<Case> getTechnique02(int debut, int fin, int pas, String pos,
			String niveau) {
		List<Case> cases = listeBrutTechnique02(debut, fin, pas, pos);

		switch (niveau) {
		case "s3j4e1":
			cases.addAll(listeBrutTechnique02(11, 15, 1, pos));
			break;
		}

		return completeLoc(
				melange(ajoutIntrus(niveau + pos, cases, CSS_BOUTON_CASE_SMALL)),
				pos);
	}

	@Override
	public List<Case> getTechnique02Variante(String pos, String niveau) {
		List<Case> cases = Technique02Data.getInstance().listeBrutCase(niveau, pos);
		return completeLoc(
				melange(ajoutIntrus(niveau + pos, cases, CSS_BOUTON_CASE_SMALL)),
				pos);
	}
	
	@Override
	public List<Caseflash> getTechnique03(String niveau) {

		List<Caseflash> listCaseflash = new ArrayList<Caseflash>();

		switch (niveau) {
		case "s2j1e1":
			listCaseflash.add(fabriqueCaseflashCompleteSomme(1, new String[] { "2",
					"1" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(5, new String[] { "15",
					"10" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(9, new String[] { "18",
					"16" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(2, new String[] { "2",
					"4", "3" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(3, new String[] { "4",
					"5", "6" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(8, new String[] { "16",
					"14", "12" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(4, new String[] { "8",
					"6", "4", "10" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(10, new String[] {
					"10", "20", "15", "30" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(6, new String[] { "11",
					"13", "12", "14" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(7, new String[] { "12",
					"16", "14", "15" }));
			break;
		case "s2j4e1":
			listCaseflash.add(fabriqueCaseflashCompleteSomme(5, new String[] { "10",
					"15" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(11, new String[] {
					"22", "28" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(13, new String[] {
					"23", "26" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(14, new String[] {
					"24", "28" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(12, new String[] {
					"12", "24", "36" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(6, new String[] { "10",
					"12", "14" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(9, new String[] { "18",
					"20", "19" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(7, new String[] { "10",
					"14", "18" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(8, new String[] { "16",
					"18", "20" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(10, new String[] {
					"15", "20", "30" }));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(15, new String[] {
					"30", "40", "20" }));
			break;
		case "s5j4e1":
			listCaseflash.add(fabriqueCaseflashCompleteSomme(2, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(4, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(6, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(8, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(10, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(12, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(14, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(25, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(30, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(50, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(70, new String[] {}));
			listCaseflash.add(fabriqueCaseflashCompleteSomme(85, new String[] {}));
			break;
		case  "s1j2e2":
			listCaseflash.add(fabriqueCaseflashCompleteExp("4", new String[] { "6","9","4" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("5", new String[] { "5","3","4" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("2", new String[] { "7","9","8" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("7", new String[] { "5","3","4" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("9", new String[] { "1","2","9" }));
			break;
		case "s1j4e2":
			// somme = 10
			listCaseflash.add(fabriqueCaseflashCompleteExp("1", new String[] { "4","6","9","8" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("3", new String[] { "7","3","4","8" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6", new String[] { "7","4","5","3" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("8", new String[] { "2","3","4","1" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("9", new String[] { "5","2","1","3" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("5", new String[] { "4","5","3","6" }));
			break;
		case "s4j5e2":
			listCaseflash.add(fabriqueCaseflashCompleteExp("(4+10)-2", new String[] { "9","12","14" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("(6+10)-1", new String[] { "8","11","15" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("(12+10)-1", new String[] { "21","24","18" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("(15+10)-1", new String[] { "19","27","24" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("(7+10)-2", new String[] { "15","11","17" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("(3+10)-1", new String[] { "14","9","12" }));
			break;
		case "s5j2e2":
			listCaseflash.add(fabriqueCaseflashCompleteExp("5+9", new String[] { "8","17","14" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("7+9", new String[] { "6","16","22" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("3+9", new String[] { "12","7","14" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("13+9", new String[] { "20","22","18" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("8+9", new String[] { "15","18","17" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("15+9", new String[] { "24","21","27" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4+9", new String[] { "13","11","16" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("5+8", new String[] { "12","13","15" }));
			break;
		case "s3j5e2":
			listCaseflash.add(fabriqueCaseflashCompleteExp("7x9", new String[] { "49","59","42" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x6", new String[] { "35","36","37" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x8", new String[] { "28","32","36" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("7x8", new String[] { "54","55","56" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x7", new String[] { "42","49","36" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x9", new String[] { "36","40","44","32" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("7x7", new String[] { "49","50","51","52" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x8", new String[] { "50","48","42","44" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x9", new String[] { "54","56","58","60" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x7", new String[] { "28","29","27","26" }));
			break;
		case "s5j5e2":
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x9", new String[] { "48","54","42" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x6", new String[] { "35","36","37" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x7", new String[] { "28","32","36" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x8", new String[] { "30","32","34" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("4x4", new String[] { "15","16","14","12" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("5x3", new String[] { "15","10","20","25" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("7x5", new String[] { "30","35","40","45" }));
			listCaseflash.add(fabriqueCaseflashCompleteExp("6x8", new String[] { "50","48","42","44" }));
			break;
		}		
		return listCaseflash;
	}

	private List<Case> listeBrutTechnique04(int debut, int fin, int pas) {
		List<Case> cases = new ArrayList<Case>();
		for (int i = debut; i <= fin; i = i + pas) {
			Case caseOp = new Case(Case.Type.OP.name(), "", i + i);
			caseOp.setRealLibelle(i + "+" + i);
			caseOp.setActive(true);
			caseOp.setCssClass(CSS_BOUTON_CASE_SMALL);
			caseOp.setBackgrdStyle(STYLE_BGRD_GRIS);
			caseOp.setSens("VERSO");
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(), "", i + i);
			caseRes.setRealLibelle(String.valueOf(i + i));
			caseRes.setActive(true);
			caseRes.setCssClass(CSS_BOUTON_CASE_SMALL);
			caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
			caseRes.setSens("VERSO");
			cases.add(caseRes);
		}
		return cases;
	}

	@Override
	public List<Case> getTechnique04(String niveau, int nbInRow, int debut,
			int fin, int pas) {
		List<Case> cases = listeBrutTechnique04(debut, fin, pas);

		switch (niveau) {
		case "s5j2e1":
			cases.addAll(listeBrutTechnique04(20, 80, 20));
			cases.addAll(listeBrutTechnique04(35, 55, 10));
			cases.addAll(listeBrutTechnique04(90, 95, 5));
			cases.addAll(listeBrutTechnique04(75, 75, 1));
			break;
		}

		return completeRow(nbInRow,
				melange(ajoutIntrus(niveau, cases, CSS_BOUTON_CASE_SMALL)));
	}
	
	public List<Case> getTechnique04Variante(int nbInRow,String niveau) {
		List<Case> cases = Technique04Data.getInstance().listeBrutCase(niveau);
		return completeRow(nbInRow,melange(cases));
	}

	@Override
	public List<Domino> getTechnique05Choix(String niveau) {
		return Technique05Data.getInstance().listeDominoChoix(niveau);
	}

	@Override
	public List<Domino> getTechnique05Cible(String niveau) {
		int nbocc=0;
		switch (niveau) {
		case "s1j1e3":
			nbocc=5;
			break;
		case "s1j3e2":
		case "s2j4e2":
		case "s2j5e3":
			nbocc=7;
			break;
		case "s1j5e2":
		case "s2j1e2":
		case "s3j1e2":
		case "s3j3e3":
		case "s4j1e3":
		case "s4j3e3":
			nbocc=8;
			break;
		case "s2j3e2":
			nbocc=6;
			break;
		case "s3j4e3":
			nbocc=9;
			break;
		}
		return Technique05Data.getInstance().listeDominoCible(niveau, nbocc);
	}

	@Override
	public List<BoiteAOeuf> getTechnique06(String niveau) {
		return Technique06Data.getInstance().listeBoiteAOeuf(niveau);
	}
	
	@Override
	public List<CalculATrou> getTechnique08(String niveau) {
		return Technique08Data.getInstance().listeCalculATrou(niveau);
	}

}
