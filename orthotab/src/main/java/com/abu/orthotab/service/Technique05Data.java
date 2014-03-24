package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abu.orthotab.domain.Domino;

public class Technique05Data extends TechniqueDataUtil {
	
	private Technique05Data() {
	};

	private final static Technique05Data instance = new Technique05Data();

	public static Technique05Data getInstance() {
		return instance;
	}

	private final static String CSS_DOMINO_G_POINTILLE = "domino-groupe domino-groupe-pointille";
	private final static String CSS_DOMINO_G_PLEIN = "domino-groupe domino-groupe-plein";
	private final static String CSS_DOMINO_G_ACTIF = "domino-groupe domino-groupe-actif";

	private final static Map<String, List<String>> mapDominoCible;

	private final static Map<String, List<String[]>> mapDominoChoix;

	static {
		mapDominoCible = new HashMap<String, List<String>>();
		
		String[] s1j1e3 = { "1", "1" };
		mapDominoCible.put("s1j1e3", Arrays.asList(s1j1e3));
		
		String[] s1j3e3 = { "3", "3" };
		mapDominoCible.put("s1j3e3", Arrays.asList(s1j3e3));
		
		String[] s1j5e3 = { "5", "5" };
		mapDominoCible.put("s1j5e3", Arrays.asList(s1j5e3));
		
		String[] s2j1e3 = { "7", "7" };
		mapDominoCible.put("s2j1e3", Arrays.asList(s2j1e3));
		
		String[] s2j4e2 = { "8", "8" };
		mapDominoCible.put("s2j4e2", Arrays.asList(s2j4e2));
		
		String[] s2j3e2 = { "14", "5+9" };
		mapDominoCible.put("s2j3e2", Arrays.asList(s2j3e2));
		
		String[] s3j1e2 = { "13", "4+9" };
		mapDominoCible.put("s3j1e2", Arrays.asList(s3j1e2));
		
		String[] s2j5e3 = { "5", "2x4" };
		mapDominoCible.put("s2j5e3", Arrays.asList(s2j5e3));

		String[] s3j3e3 = { "7", "7x2" };
		mapDominoCible.put("s3j3e3", Arrays.asList(s3j3e3));
		
		String[] s3j4e3 = { "7", "7x5" };
		mapDominoCible.put("s3j4e3", Arrays.asList(s3j4e3));
		
		String[] s4j1e3 = { "8", "8x2" };
		mapDominoCible.put("s4j1e3", Arrays.asList(s4j1e3));
		
		String[] s4j3e3 = { "8", "8x3" };
		mapDominoCible.put("s4j3e3", Arrays.asList(s4j3e3));
	}

	static {
		mapDominoChoix = new HashMap<String, List<String[]>>();
		
		String[][] s1j1e3 = { { "9", "4" }, { "6", "5" }, { "5", "7" },
				{ "3", "2" }, { "8", "9" } };
		mapDominoChoix.put("s1j1e3", Arrays.asList(s1j1e3));
		
		String[][] s1j3e3 = { { "7", "6" }, { "4", "5" }, { "5", "1" },
				{ "9", "2" }, { "8", "7" }, { "3", "9" }, { "1", "3" } };
		mapDominoChoix.put("s1j3e3", Arrays.asList(s1j3e3));

		String[][] s1j5e3 = { { "5", "6" }, { "4", "3" }, { "7", "2" },
				{ "8", "1" }, { "9", "4" }, { "6", "7" }, { "3", "9" }, { "1", "5" } };
		mapDominoChoix.put("s1j5e3", Arrays.asList(s1j5e3));
		
		String[][] s2j1e3 = { { "3", "6" }, { "4", "8" }, { "2", "1" },
				{ "9", "4" }, { "6", "3" }, { "7", "9" }, { "5", "9" }, { "1", "5" } };
		mapDominoChoix.put("s2j1e3", Arrays.asList(s2j1e3));
		
		String[][] s2j4e2 = { { "2", "3" }, { "7", "7" }, { "3", "1" },
				{ "9", "6" }, { "4", "5" }, { "5", "9" }, { "1", "1" }, { "6", "2" }, { "8", "3" } };
		mapDominoChoix.put("s2j4e2", Arrays.asList(s2j4e2));
		
		String[][] s2j3e2 = { { "(5+10)-1", "8+9" }, { "17", "2+9" }, { "(2+10)-1", "15" },
				{ "6+9", "(13+10)-1" }, { "13+9", "4+8" }, { "12", "(5+10)-2" } };
		mapDominoChoix.put("s2j3e2", Arrays.asList(s2j3e2));
		
		String[][] s3j1e2 = { { "(4+10)-1", "7+9" }, { "16", "24" }, { "(15+10)-1", "6+8" },
				{ "(6+10)-2", "14" }, { "5+9", "(3+10)-1" }, { "12", "5+8" }, { "(5+10)-2", "26" }, { "17+9", "2+9" } };
		mapDominoChoix.put("s3j1e2", Arrays.asList(s3j1e2));
		
		String[][] s2j5e3 = { { "8", "3x7" }, { "21", "5x6" }, { "30", "3x6" },
				{ "18", "2x8" }, { "16", "5x2" }, { "10", "5x10" }, { "50", "2x2" } };
		mapDominoChoix.put("s2j5e3", Arrays.asList(s2j5e3));

		String[][] s3j3e3 = { {"14","7x8"},{"56","7x6"},{"42","7x4"},{"28","7x7"},
				{"49","7x5"},{"35","7x9"},{"63","7x10"},{"70","7x1"} };
		mapDominoChoix.put("s3j3e3", Arrays.asList(s3j3e3));
		
		String[][] s3j4e3 = { {"35","6x5"},{"30","4x7"},{"28","4x9"},{"36","7x8"},
				{"56","6x9"},{"54","7x7"},{"49","6x6"},{"36","4x4"},{"16","4x2"} };
		mapDominoChoix.put("s3j4e3", Arrays.asList(s3j4e3));
		
		String[][] s4j1e3 = { {"16","8x7"},{"56","8x6"},{"48","8x5"},{"40","8x8"},
				{"64","8x4"},{"32","8x9"},{"72","8x10"},{"80","8x1"} };
		mapDominoChoix.put("s4j1e3", Arrays.asList(s4j1e3));
		
		String[][] s4j3e3 = { {"24","9x4"},{"36","8x7"},{"56","9x5"},{"45","8x8"},{"64","9x9"},
				{"81","8x9"},{"72","9x7"},{"63","8x1"},{"40","9x3"},{"54","9x6"} };
		mapDominoChoix.put("s4j3e3", Arrays.asList(s4j3e3));
	}



	List<Domino> listeDominoCible(String niveau, int nbocc) {
		List<Domino> listeDominoCible = new ArrayList<Domino>();

		List<String> listeVal = mapDominoCible.get(niveau);
		if (listeVal != null) {
			Domino domino = new Domino();
			domino.setValg(evalueExpression(listeVal.get(0)));
			domino.setLibg(listeVal.get(0));
			domino.setVald(evalueExpression(listeVal.get(1)));
			domino.setLibd(listeVal.get(1));
			domino.setCssClass(CSS_DOMINO_G_PLEIN);
			listeDominoCible.add(domino);
		}

		for (int i = 0; i < nbocc; i++) {
			Domino domino = new Domino();
			if(i==0){
				domino.setCssClass(CSS_DOMINO_G_ACTIF);
			}else{
				domino.setCssClass(CSS_DOMINO_G_POINTILLE);
			}
			domino.setLibg("?");
			domino.setLibd("?");
			listeDominoCible.add(domino);
		}

		return listeDominoCible;
	}

	List<Domino> listeDominoChoix(String niveau) {
		List<Domino> listeDominoChoix = new ArrayList<Domino>();

		List<String[]> listeVal = mapDominoChoix.get(niveau);
		if (listeVal != null) {
			for (String[] tab : listeVal) {

				Domino domino = new Domino();
				domino.setValg(evalueExpression(tab[0]));
				domino.setLibg(tab[0]);
				domino.setVald(evalueExpression(tab[1]));
				domino.setLibd(tab[1]);
				domino.setCssClass(CSS_DOMINO_G_PLEIN);
				listeDominoChoix.add(domino);
			}
		}
		return melange(listeDominoChoix);
	}
}
