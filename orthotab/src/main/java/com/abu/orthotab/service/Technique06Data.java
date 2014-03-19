package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.BoiteAOeuf;
import com.abu.orthotab.domain.Case;

public class Technique06Data extends TechniqueDataUtil{
	private Technique06Data() {
	};

	private final static Technique06Data instance = new Technique06Data();

	public static Technique06Data getInstance() {
		return instance;
	}
	
	private BoiteAOeuf construitBoiteAOeuf(int valmax, int valacquis, String[] tabprop, int idxproppref){
		BoiteAOeuf bao = new BoiteAOeuf(valmax,valacquis);
		
		int idx = 0;
		String type = "INTRUS";
		for(String prop : tabprop){
			if(idx==idxproppref){
				type = "RES";
			}else{
				type = "INTRUS";
			}
			Case caseChoix = new Case(type, prop, evalueExpression(prop));
			caseChoix.setCssClass(CSS_BOUTON_CASE_LONG);
			caseChoix.setBackgrdStyle(STYLE_BGRD_GRIS);
			bao.addCaseChoix(caseChoix);
			idx++;
		}
		return bao;
	}
	
	public List<BoiteAOeuf> listeBoiteAOeuf(String niveau) {
		
		List<BoiteAOeuf> listeBoiteAOeuf = new ArrayList<BoiteAOeuf>();
		
		switch (niveau) {
		case "s5j5e3":
			listeBoiteAOeuf.add(construitBoiteAOeuf(347, 220, new String[]{"80+47","63+44+20","40+87"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(415, 275, new String[]{"45+80+15","30+100+10","40+80+20"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(289, 194, new String[]{"10+80+5","45+50","25+46"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(512, 342, new String[]{"60+100+10","35+65+42+28","70+90+10"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(358, 283, new String[]{"35+40","20+55","10+45"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(474, 281, new String[]{"92+101","20+100+73","83+100"},1));
			break;
		}
		return listeBoiteAOeuf;
	}
}
