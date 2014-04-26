package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.MemoryMultipliant;

public class Technique07Data extends TechniqueDataUtil{

	private Technique07Data() {
	};

	private final static Technique07Data instance = new Technique07Data();

	public static Technique07Data getInstance() {
		return instance;
	}
	
	private MemoryMultipliant construitMemoryMultipliant(int valeur, String[] caseG, String[] caseD){
		MemoryMultipliant mm = new MemoryMultipliant(valeur);
		
		for(String prop : caseG){
			Case caseChoix = new Case("", prop, evalueExpression(prop));
			caseChoix.setCssClass(CSS_BOUTON_CASE_LONG);
			caseChoix.setBackgrdStyle(STYLE_BGRD_BLEU);
			caseChoix.setActive(true);
			mm.addCaseG(caseChoix);
		}
		
		for(String prop : caseD){
			Case caseChoix = new Case("", prop, evalueExpression(prop));
			caseChoix.setCssClass(CSS_BOUTON_CASE_LONG);
			caseChoix.setBackgrdStyle(STYLE_BGRD_ROUGE);
			caseChoix.setActive(true);
			mm.addCaseD(caseChoix);
		}
		
		return mm;
	}
	
	public List<MemoryMultipliant> listeMemoryMultipliant(String niveau) {
		
		List<MemoryMultipliant> listeMemoryMultipliant = new ArrayList<MemoryMultipliant>();
		
		switch (niveau) {
		case "s2j4e3":
			listeMemoryMultipliant.add(construitMemoryMultipliant(25, new String[]{"4","5"},new String[]{"5","6"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(12, new String[]{"4","2"},new String[]{"6","3"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(21, new String[]{"7","4","8"},new String[]{"5","6","3"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(15, new String[]{"4","5","3"},new String[]{"5","6","7"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(40, new String[]{"7","3","4","5"},new String[]{"8","6","4","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(18, new String[]{"9","6","7","2"},new String[]{"1","7","2","3"}));
			break;
		case "s4j4e2":
			listeMemoryMultipliant.add(construitMemoryMultipliant(48, new String[]{"2","6","4","5"},new String[]{"7","8","9","10"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(36, new String[]{"6","7","8","9"},new String[]{"4","5","6","7"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(64, new String[]{"7","8","9","10"},new String[]{"6","7","8","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(45, new String[]{"7","8","9","3"},new String[]{"8","6","5","4"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(49, new String[]{"5","6","7","8"},new String[]{"5","6","7","8"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(40, new String[]{"7","8","9","10"},new String[]{"5","6","7","8"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(63, new String[]{"6","7","8","9"},new String[]{"9","8","7","6"}));
			break;
		case "s4j5e3":
			listeMemoryMultipliant.add(construitMemoryMultipliant(42, new String[]{"2","6","4","5"},new String[]{"7","8","9","10"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(81, new String[]{"6","7","8","9"},new String[]{"5","6","7","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(72, new String[]{"7","8","9","3"},new String[]{"6","4","8","2"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(56, new String[]{"3","5","7","9"},new String[]{"8","6","4","3"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(35, new String[]{"5","4","7","6"},new String[]{"7","8","4","3"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(32, new String[]{"1","2","3","4"},new String[]{"6","7","8","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(54, new String[]{"7","8","9","10"},new String[]{"4","5","6","7"}));
			break;
		case "s5j3e2":
			listeMemoryMultipliant.add(construitMemoryMultipliant(81, new String[]{"6","7","8","9"},new String[]{"5","6","7","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(36, new String[]{"6","5","7","9"},new String[]{"8","6","4","3"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(42, new String[]{"2","6","4","5"},new String[]{"7","8","9","10"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(30, new String[]{"5","4","7","6"},new String[]{"7","8","4","5"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(63, new String[]{"7","8","9","6"},new String[]{"6","7","8","9"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(72, new String[]{"7","8","9","3"},new String[]{"6","4","8","2"}));
			listeMemoryMultipliant.add(construitMemoryMultipliant(64, new String[]{"7","8","9","10"},new String[]{"8","5","6","7"}));
			break;
		}
		return listeMemoryMultipliant;
	}
}
