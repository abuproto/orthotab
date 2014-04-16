package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;
import com.abu.orthotab.domain.Loc;

public abstract class UtilServiceImpl {

	protected final static String CSS_BOUTON_CASE = "boutonCase";
	protected final static String CSS_BOUTON_CASE_FLASH = "boutonCase-flash";
	protected final static String CSS_BOUTON_CASE_SMALL = "boutonCase-small";
	protected final static String STYLE_BGRD_GRIS = "#B5B276";
	
	private final static Map<String, List<String>> mapIntrus;
	static {
		mapIntrus = new HashMap<String, List<String>>();
		String[] tabs1j4e1 = { "3", "11", "13", "22", "30" };
		mapIntrus.put("s1j4e1", Arrays.asList(tabs1j4e1));
		String[] tabs1j5e1G = { "3", "15", "21"};
		mapIntrus.put("s1j5e1G", Arrays.asList(tabs1j5e1G));
		String[] tabs1j5e1D = { "24", "26", "9"};
		mapIntrus.put("s1j5e1D", Arrays.asList(tabs1j5e1D));
		String[] tabs3j3e1G = { "200", "30", "70"};
		mapIntrus.put("s3j3e1G", Arrays.asList(tabs3j3e1G));
		String[] tabs3j3e1D = { "55", "110", "25"};
		mapIntrus.put("s3j3e1D", Arrays.asList(tabs3j3e1D));
		String[] tabs3j4e1G = { "110", "25"};
		mapIntrus.put("s3j4e1G", Arrays.asList(tabs3j4e1G));
		String[] tabs3j4e1D = { "23","35"};
		mapIntrus.put("s3j4e1D", Arrays.asList(tabs3j4e1D));
		String[] tabs4j3e1 = { "40", "25", "120", "135", "180" };
		mapIntrus.put("s4j3e1", Arrays.asList(tabs4j3e1));
		String[] s2j5e2G = {"3","27"};
		mapIntrus.put("s2j5e2G", Arrays.asList(s2j5e2G));
		String[] s2j5e2D = {"10","7"};
		mapIntrus.put("s2j5e2D", Arrays.asList(s2j5e2D));
		String[] s5j4e2G = {"4","54","10"};
		mapIntrus.put("s5j4e2G", Arrays.asList(s5j4e2G));
		String[] s5j4e2D = {"29","20","1"};
		mapIntrus.put("s5j4e2D", Arrays.asList(s5j4e2D));
	}

	protected List<Case> melange(List<Case> listeCase) {
		long seed = System.nanoTime();
		Collections.shuffle(listeCase, new Random(seed));
		return listeCase;
	}

	protected List<Case> ajoutIntrus(String niveau, List<Case> listeACompleter, String cssClass) {

		List<String> listIntrus = mapIntrus.get(niveau);
		if (listIntrus != null) {
			for (String intrus : listIntrus) {
				Case caseIntrus = new Case(Case.Type.INTRUS.name(), intrus,
						Integer.valueOf(intrus));
				caseIntrus.setActive(true);
				caseIntrus.setCssClass(cssClass);
				caseIntrus.setBackgrdStyle(STYLE_BGRD_GRIS);
				listeACompleter.add(caseIntrus);
			}
		}
		return listeACompleter;
	}

	protected List<Case> completeRow(int nbInRow, List<Case> listeACompleter) {

		List<Case> listeNouvelle = new ArrayList<Case>();
		int row = 1;
		int i = 0;
		for (Case caseACompleter : listeACompleter) {
			row = (i/nbInRow)+1;
			caseACompleter.setRow(String.valueOf(row));
			listeNouvelle.add(caseACompleter);
			i++;
		}
		return listeNouvelle;
	}

	protected List<Case> completeLoc(List<Case> listeCase, String pos) {
		List<Case> listeCaseComplete = new ArrayList<Case>();

		int x = 0;
		if ("G".equals(pos)) {
			x = 5;
		} else if ("D".equals(pos)) {
			x = 195;
		}

		int ydepart = 20;
		int y = ydepart;

		int pasvertical = 40;

		for (int i = 0; i < listeCase.size(); i++) {
			Case caseACompleter = listeCase.get(i);
			y = ydepart + pasvertical * i;
			caseACompleter.setLoc(new Loc(x, y));
			listeCaseComplete.add(caseACompleter);
		}
		return listeCaseComplete;
	}

	
	protected Caseflash fabriqueCaseflashCompleteSomme(int premierTerme, String[] tabchoix) {
		Caseflash c = new Caseflash(String.valueOf(premierTerme)+"+"+String.valueOf(premierTerme),premierTerme+premierTerme);
		return completeCaseflash(c, tabchoix);
	}
	
	protected Caseflash fabriqueCaseflashCompleteExp(String expression, String[] tabchoix) {
		Caseflash c = new Caseflash(expression, TechniqueDataUtil.getInstance().evalueExpression(expression));
		return completeCaseflash(c, tabchoix);
	}
	
	protected Caseflash completeCaseflash(Caseflash caseflash, String[] tabchoix) {
		List<String> listChoix = Arrays.asList(tabchoix);
		List<Caseflash> listeCaseflash = new ArrayList<Caseflash>();
		for (String choix : listChoix) {
			Caseflash cf = new Caseflash(choix, Integer.valueOf(choix));
			cf.setCssClass(CSS_BOUTON_CASE);
			listeCaseflash.add(cf);
		}
		caseflash.setListeCaseflash(listeCaseflash);
		return caseflash;
	}
}
