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

	private final static Map<String, List<String>> mapIntrus;
	static {
		mapIntrus = new HashMap<String, List<String>>();
		String[] tabs1j4e1 = { "3", "11", "13", "22", "30" };
		mapIntrus.put("s1j4e1", Arrays.asList(tabs1j4e1));
	}

	protected List<Case> melange(List<Case> listeCase) {
		long seed = System.nanoTime();
		Collections.shuffle(listeCase, new Random(seed));
		return listeCase;
	}

	protected List<Case> ajoutIntrus(String niveau, List<Case> listeACompleter) {

		List<String> listIntrus = mapIntrus.get(niveau);
		if (listIntrus != null) {
			for (String intrus : listIntrus) {
				Case caseIntrus = new Case(Case.Type.INTRUS.name(), intrus,
						Integer.valueOf(intrus));
				caseIntrus.setActive(true);
				caseIntrus.setCssClass("boutonCase");
				caseIntrus.setBackgrdStyle("#B5B276");
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

	protected Caseflash completeCaseflash(Caseflash caseflash, String[] tabchoix) {
		List<String> listChoix = Arrays.asList(tabchoix);
		List<Caseflash> listeCaseflash = new ArrayList<Caseflash>();
		for (String choix : listChoix) {
			Caseflash cf = new Caseflash(choix, Integer.valueOf(choix));
			cf.setCssClass("boutonCase");
			listeCaseflash.add(cf);
		}
		caseflash.setListeCaseflash(listeCaseflash);
		return caseflash;
	}
}
