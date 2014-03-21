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
		case "s3j1e2":
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
			listeBoiteAOeuf.add(construitBoiteAOeuf(51, 36, new String[]{"4+11","8+7"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(62, 48, new String[]{"7+7","2+12"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(93, 77, new String[]{"3+13","5+9"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(75, 51, new String[]{"4+20","12+8+4","16+8"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(44, 28, new String[]{"2+14","10+3+3","18+4"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(86, 59, new String[]{"13+8+6","1+26","17+9"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(32, 17, new String[]{"3+12","6+4+5","14+5"},0));			
			break;
		case "s4j1e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(128, 80, new String[]{"20+28","18+15+15","38+18"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(146, 70, new String[]{"42+30+4","30+46","15+61"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(135, 60, new String[]{"40+35","22+43+10","20+55"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(154, 92, new String[]{"8+54","14+48","8+64"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(167, 122, new String[]{"5+40","23+12+10","7+38"},0));			
			break;
		case "s4j3e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(151, 98, new String[]{"2+52","20+31+3","4+50"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(173, 127, new String[]{"15+15+16","3+43","40+6"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(161, 126, new String[]{"4+31","14+16+5","34+1"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(135, 87, new String[]{"25+15+8","3+10+35","22+51"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(146, 79, new String[]{"1+20+46","15+35+17","28+39"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(124, 68, new String[]{"25+25+6","2+30+24","32+32"},1));
			break;
		case "s4j5e4":
			listeBoiteAOeuf.add(construitBoiteAOeuf(127, 78, new String[]{"2+20+29","15+25+9","32+47"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(152, 86, new String[]{"44+16+6","4+10+52","14+26+35"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(165, 118, new String[]{"2+45","16+24+7","20+35"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(112, 64, new String[]{"16+22+10","6+30+12","66+2"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(134, 75, new String[]{"5+20+34","32+13+14","66+2"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(178, 119, new String[]{"24+12+23","1+58","41+49"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(143, 96, new String[]{"4+43","28+9+10","14+22+31"},0));
			break;
		case "s5j1e3":
			listeBoiteAOeuf.add(construitBoiteAOeuf(227, 173, new String[]{"30+24","17+13+24","34+21"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(340, 276, new String[]{"32+25+7","4+60","54+10"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(478, 344, new String[]{"100+30+4","55+65+14","10+46+100"},0));
			listeBoiteAOeuf.add(construitBoiteAOeuf(359, 124, new String[]{"184+35+16","200+5+30","100+145"},1));
			listeBoiteAOeuf.add(construitBoiteAOeuf(422, 268, new String[]{"32+100+22","45+61+48","200+68"},0));
			break;
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
