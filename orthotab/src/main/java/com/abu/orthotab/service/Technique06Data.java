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
			caseChoix.setActive(true);
			bao.addCaseChoix(caseChoix);
			idx++;
		}
		return bao;
	}
	
	public List<BoiteAOeuf> listeBoiteAOeuf(String niveau) {
		
		List<BoiteAOeuf> listeBoiteAOeuf = new ArrayList<BoiteAOeuf>();
		
		switch (niveau) {
		case "s3j1e3":
			listeBoiteAOeuf.add(construitBoiteAOeuf(20, 17, new String[]{"1","2","3","4"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(30, 23, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(50, 45, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(40, 38, new String[]{"1","2","3","4","5"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(30, 21, new String[]{"5","6","7","8","9"},0));			
			break;
		case "s4j2e1":
			listeBoiteAOeuf.add(construitBoiteAOeuf(20, 18, new String[]{"1","2","3","4"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(30, 26, new String[]{"4","5","6","7","8"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(50, 42, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(40, 35, new String[]{"1","2","3","4","5","6"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(30, 24, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(50, 43, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(40, 37, new String[]{"1","2","3","4","5","6"},0));
			break;
		case "s5j3e1":
			listeBoiteAOeuf.add(construitBoiteAOeuf(20, 11, new String[]{"4","5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(40, 36, new String[]{"4","5","6","7","8"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(20, 14, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(50, 49, new String[]{"1","2","3","4","5","6"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(30, 22, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(40, 33, new String[]{"5","6","7","8","9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(50, 47, new String[]{"1","2","3","4","5","6"},0));			
			break;
		case "s3j3e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(64, 41, new String[]{"20+3","15+18"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(57, 40, new String[]{"4+7+6","10+7"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(49, 14, new String[]{"30+5","28+7"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(35, 23, new String[]{"6+4+2","10+2","12+1"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(76, 50, new String[]{"25+1","11+13+2","23+3"},0));			
			break;
		case "s3j5e3":
			//listeBoiteAOeuf.add(construitBoiteAOeuf(51, 36, new String[]{"4+11","8+7"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(62, 48, new String[]{"7+7","2+12"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(93, 77, new String[]{"3+13","5+9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(75, 51, new String[]{"4+20","12+8+4","16+8"},0));
			//listeBoiteAOeuf.add(construitBoiteAOeuf(44, 28, new String[]{"2+14","10+3+3","18+4"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(86, 59, new String[]{"13+8+6","1+26","17+9"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(32, 17, new String[]{"3+12","6+4+5","14+5"},0));			
			break;
		case "s4j1e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(128, 80, new String[]{"20+28","18+15+15","38+18"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(116, 70, new String[]{"12+30+4","30+16","15+31"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(125, 60, new String[]{"40+25","22+33+10","20+55"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(104, 92, new String[]{"10+2","14-3","9+4"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(137, 122, new String[]{"5+20","23+2-10","7+19"},0));			
			break;
		case "s4j3e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(92, 38, new String[]{"2+52","20+31+3","4+50"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(113, 87, new String[]{"15+15+16","3+10+13","40+6"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(121, 19, new String[]{"2+100","2+110","70+34+1"},0));
			//listeBoiteAOeuf.add(construitBoiteAOeuf(135, 87, new String[]{"25+15+8","3+10+35","22+51"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(106, 79, new String[]{"1+20+6","15+5+17","28+10"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(124, 68, new String[]{"25+25+6","2+30+24","32+32"},1));
			break;
		case "s4j5e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(127, 78, new String[]{"2+20+27","15+25+9","32+47"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(122, 86, new String[]{"24+16+6","4+10+22","14+22+10"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(150, 118, new String[]{"2+30","15+10+7","20+32"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(112, 64, new String[]{"16+22+10","6+30+12","66+2"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(134, 75, new String[]{"5+20+34","32+13+14","51+7"},0));
			//listeBoiteAOeuf.add(construitBoiteAOeuf(178, 119, new String[]{"24+12+23","1+58","41+49"},1));
			//listeBoiteAOeuf.add(construitBoiteAOeuf(143, 96, new String[]{"4+43","28+9+10","14+22+31"},0));
			break;
		case "s5j1e3":
			listeBoiteAOeuf.add(construitBoiteAOeuf(127, 73, new String[]{"30+24","17+13+24","34+21"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(140, 76, new String[]{"32+25+7","4+60","54+10"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(78, 44, new String[]{"30+4","55+14","10+46"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(59, 24, new String[]{"19+16","5+30","45+6"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(112, 58, new String[]{"42+12","45+18","68+6"},0));
			break;
		case "s5j5e3":
			listeBoiteAOeuf.add(construitBoiteAOeuf(147, 20, new String[]{"80+47","63+44+20","40+87"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(115, 75, new String[]{"45+15","30+10","40+5+20"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(89, 24, new String[]{"60+5","45+30","25+45"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(112, 42, new String[]{"60+10","35+42+28","70+10"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(138, 83, new String[]{"35+33","5+20+30","10+45+38"},1));
			//listeBoiteAOeuf.add(construitBoiteAOeuf(474, 281, new String[]{"92+101","20+100+73","83+100"},1));
			break;
		}
		return listeBoiteAOeuf;
	}
}
