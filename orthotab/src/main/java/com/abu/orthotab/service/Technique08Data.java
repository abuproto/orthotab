package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.CalculATrou;
import com.abu.orthotab.domain.Case;

public class Technique08Data extends TechniqueDataUtil {
	
	private Technique08Data() {
	};

	private final static Technique08Data instance = new Technique08Data();

	public static Technique08Data getInstance() {
		return instance;
	}

	private CalculATrou construitCalculATrouRapide(int terme1, int terme2, int resultat, int idtrou, String[] tabprop, int idxchoix){
		CalculATrou calculATrou = new CalculATrou();
		calculATrou.setIdtrou(idtrou);
	
		Case caseTerme1 = new Case("",String.valueOf(terme1),terme1);
		caseTerme1.setCssClass(CSS_ROND_SF_PLEIN);
		caseTerme1.setBackgrdStyle(idtrou==0?STYLE_BGRD_JAUNE:STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseTerme1);
		
		Case caseSigne = new Case("","+",0);
		caseSigne.setCssClass(CSS_CARRE_PLEIN);
		caseSigne.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseSigne);
		
		Case caseTerme2 = new Case("",String.valueOf(terme2),terme2);
		caseTerme2.setCssClass(CSS_ROND_SF_PLEIN);
		caseTerme2.setBackgrdStyle(idtrou==1?STYLE_BGRD_JAUNE:STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseTerme2);
		
		Case caseEgal = new Case("","=",0);
		caseEgal.setCssClass(CSS_CARRE_PLEIN);
		caseEgal.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseEgal);
		
		Case caseResultat = new Case("",String.valueOf(resultat),resultat);
		caseResultat.setCssClass(CSS_ROND_SF_PLEIN);
		caseResultat.setBackgrdStyle(idtrou==2?STYLE_BGRD_JAUNE:STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseResultat);
		
		int i=0;
		for(String prop : tabprop){
			String type = "INTRUS";
			if(idxchoix==i){
				type = "RES";
			}
			Case caseChoix = new Case(type, prop, evalueExpression(prop));
			caseChoix.setCssClass(CSS_BOUTON_CASE_XLONG);
			caseChoix.setBackgrdStyle(STYLE_BGRD_GRIS);
			calculATrou.addCaseChoix(caseChoix);
			i++;
		}
		
		return calculATrou;
	}
	
	
	private CalculATrou construitCalculATrou(int terme, String signe, int resultat, int idtrou, int valTrou, String[] tabprop){
		CalculATrou calculATrou = new CalculATrou();
		calculATrou.setIdtrou(idtrou);
		
		Case caseTerme = new Case("",String.valueOf(terme),terme);
		caseTerme.setCssClass(CSS_ROND_PLEIN);
		caseTerme.setBackgrdStyle(STYLE_BGRD_GRIS);
		
		Case caseEgal = new Case("","=",0);
		caseEgal.setCssClass(CSS_CARRE_PLEIN);
		caseEgal.setBackgrdStyle(STYLE_BGRD_GRIS);
		
		Case caseSigne = new Case("",signe,0);
		caseSigne.setCssClass(CSS_CARRE_PLEIN);
		caseSigne.setBackgrdStyle(STYLE_BGRD_GRIS);
		
		Case caseTrou = new Case("","...",valTrou);
		caseTrou.setCssClass(CSS_ROND_PLEIN);
		caseTrou.setBackgrdStyle(STYLE_BGRD_JAUNE);
		
		Case caseResultat = new Case("",String.valueOf(resultat),resultat);
		caseResultat.setCssClass(CSS_ROND_PLEIN);
		caseResultat.setBackgrdStyle(STYLE_BGRD_GRIS);

		
		if(idtrou==0){
			calculATrou.addCaseCible(caseTrou);
		}else if(idtrou==2) {
			calculATrou.addCaseCible(caseTerme);
		}
		calculATrou.addCaseCible(caseSigne);
		if(idtrou==0){
			calculATrou.addCaseCible(caseTerme);
		}else if(idtrou==2) {
			calculATrou.addCaseCible(caseTrou);
		}
		calculATrou.addCaseCible(caseEgal);
		calculATrou.addCaseCible(caseResultat);
		
		for(String prop : tabprop){
			Case caseChoix = new Case("", prop, evalueExpression(prop));
			//caseChoix.setCssClass(CSS_CASE_NOMBRE);
			caseChoix.setCssClass(CSS_ROND_PLEIN);
			caseChoix.setBackgrdStyle(STYLE_BGRD_GRIS);
			calculATrou.addCaseChoix(caseChoix);
		}
		
		return calculATrou;
	}
	
	
	public CalculATrou construitCalculATrouParentheses(int terme1,int terme2, int resultat, int valTrou, String[] tabprop){
		CalculATrou calculATrou = new CalculATrou();
		calculATrou.setIdtrou(1);
		String signe1 = "+";
		String signe2 = "-";
		
		Case caseParentOuv = new Case("","(",0);
		caseParentOuv.setCssClass(CSS_CARRE_PLEIN);
		caseParentOuv.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseParentOuv);
		
		Case caseTrou = new Case("","...",valTrou);
		caseTrou.setCssClass(CSS_ROND_PLEIN);
		caseTrou.setBackgrdStyle(STYLE_BGRD_JAUNE);
		calculATrou.addCaseCible(caseTrou);
		
		Case caseSigne1 = new Case("",signe1,0);
		caseSigne1.setCssClass(CSS_CARRE_PLEIN);
		caseSigne1.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseSigne1);
		
		Case caseTerme1 = new Case("",String.valueOf(terme1),terme1);
		caseTerme1.setCssClass(CSS_ROND_PLEIN);
		caseTerme1.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseTerme1);
		
		Case caseParentFerm = new Case("",")",0);
		caseParentFerm.setCssClass(CSS_CARRE_PLEIN);
		caseParentFerm.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseParentFerm);
		
		Case caseSigne2 = new Case("",signe2,0);
		caseSigne2.setCssClass(CSS_CARRE_PLEIN);
		caseSigne2.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseSigne2);
		
		Case caseTerme2 = new Case("",String.valueOf(terme2),terme2);
		caseTerme2.setCssClass(CSS_ROND_PLEIN);
		caseTerme2.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseTerme2);
		
		Case caseEgal = new Case("","=",0);
		caseEgal.setCssClass(CSS_CARRE_PLEIN);
		caseEgal.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseEgal);
		
		Case caseResultat = new Case("",String.valueOf(resultat),resultat);
		caseResultat.setCssClass(CSS_ROND_PLEIN);
		caseResultat.setBackgrdStyle(STYLE_BGRD_GRIS);
		calculATrou.addCaseCible(caseResultat);
		
		for(String prop : tabprop){
			Case caseChoix = new Case("", prop, evalueExpression(prop));
			caseChoix.setCssClass(CSS_CASE_NOMBRE);
			caseChoix.setBackgrdStyle(STYLE_BGRD_GRIS);
			calculATrou.addCaseChoix(caseChoix);
		}
		
		return calculATrou;
	}
	
	public List<CalculATrou> listeCalculATrou(String niveau) {
		
		List<CalculATrou> listeCalculATrou = new ArrayList<CalculATrou>();
		
		String signe = "";		
		switch (niveau) {
		case "s2j3e1":
			signe="+";
			listeCalculATrou.add(construitCalculATrou(2, signe, 10, 2, 8, new String[]{"9","8"}));
			listeCalculATrou.add(construitCalculATrou(6, signe, 10, 2, 4, new String[]{"4","2","6"}));
			listeCalculATrou.add(construitCalculATrou(3, signe, 10, 0, 7, new String[]{"7","8","9"}));
			listeCalculATrou.add(construitCalculATrou(1, signe, 10, 0, 9, new String[]{"8","9","7"}));
			listeCalculATrou.add(construitCalculATrou(15, signe, 20, 2, 5, new String[]{"5","15"}));
			listeCalculATrou.add(construitCalculATrou(13, signe, 20, 2, 7, new String[]{"7","8"}));
			listeCalculATrou.add(construitCalculATrou(19, signe, 20, 0, 1, new String[]{"1","2","3"}));
			listeCalculATrou.add(construitCalculATrou(17, signe, 20, 2, 3, new String[]{"1","2","3"}));
			listeCalculATrou.add(construitCalculATrou(11, signe, 20, 0, 9, new String[]{"8","9","10"}));
			break;
		case "s2j5e4":
			signe="+";
			listeCalculATrou.add(construitCalculATrou(11, signe, 20, 2, 9, new String[]{"9","19","14"}));
			listeCalculATrou.add(construitCalculATrou(14, signe, 20, 2, 6, new String[]{"7","8","6"}));
			//listeCalculATrou.add(construitCalculATrou(15, signe, 20, 0, 5, new String[]{"5","6","7"}));
			listeCalculATrou.add(construitCalculATrou(12, signe, 20, 2, 8, new String[]{"7","6","8"}));
			listeCalculATrou.add(construitCalculATrou(18, signe, 20, 0, 2, new String[]{"1","2","3","4"}));
			//listeCalculATrou.add(construitCalculATrou(10, signe, 20, 2, 10, new String[]{"5","15","10","20"}));
			listeCalculATrou.add(construitCalculATrou(13, signe, 20, 2, 7, new String[]{"7","8","9","10"}));
			//listeCalculATrou.add(construitCalculATrou(19, signe, 20, 0, 1, new String[]{"1","2","3","4"}));
			//listeCalculATrou.add(construitCalculATrou(16, signe, 20, 2, 4, new String[]{"3","6","4","9"}));
			listeCalculATrou.add(construitCalculATrou(17, signe, 20, 0, 3, new String[]{"4","3","1","2"}));
			break;
		case "s3j3e2":
			signe="+";
			listeCalculATrou.add(construitCalculATrou(29, signe, 30, 2, 1, new String[]{"1","2","3"}));
			listeCalculATrou.add(construitCalculATrou(35, signe, 40, 2, 5, new String[]{"5","6","7"}));
			listeCalculATrou.add(construitCalculATrou(26, signe, 30, 2, 4, new String[]{"4","5","6"}));
			listeCalculATrou.add(construitCalculATrou(43, signe, 50, 2, 7, new String[]{"5","6","7","8"}));
			listeCalculATrou.add(construitCalculATrou(22, signe, 30, 2, 8, new String[]{"6","7","8","9"}));
			listeCalculATrou.add(construitCalculATrou(37, signe, 40, 2, 3, new String[]{"1","2","3","4"}));
			listeCalculATrou.add(construitCalculATrou(41, signe, 50, 2, 9, new String[]{"6","7","8","9"}));
			break;
		case "s3j5e1":
			signe="+";
			listeCalculATrou.add(construitCalculATrou(28, signe, 30, 2, 2, new String[]{"1","2","3"}));
			listeCalculATrou.add(construitCalculATrou(25, signe, 30, 2, 5, new String[]{"5","6","7"}));
			listeCalculATrou.add(construitCalculATrou(34, signe, 40, 2, 6, new String[]{"4","5","6"}));
			listeCalculATrou.add(construitCalculATrou(33, signe, 40, 2, 7, new String[]{"5","6","7","8"}));
			listeCalculATrou.add(construitCalculATrou(21, signe, 30, 2, 9, new String[]{"6","7","8","9"}));
			listeCalculATrou.add(construitCalculATrou(49, signe, 50, 2, 1, new String[]{"1","2","3","4"}));
			listeCalculATrou.add(construitCalculATrou(47, signe, 50, 2, 3, new String[]{"2","3","4","5"}));
			break;
		case "s4j4e1":
			signe="-";
			listeCalculATrou.add(construitCalculATrou(12, signe, 10, 2, 2, new String[]{"1","2","8"}));
			listeCalculATrou.add(construitCalculATrou(17, signe, 10, 2, 7, new String[]{"5","6","7"}));
			listeCalculATrou.add(construitCalculATrou(15, signe, 10, 2, 5, new String[]{"4","5","6"}));
			listeCalculATrou.add(construitCalculATrou(18, signe, 10, 2, 8, new String[]{"6","7","8","9"}));
			listeCalculATrou.add(construitCalculATrou(13, signe, 10, 2, 3, new String[]{"1","2","3","7"}));
			listeCalculATrou.add(construitCalculATrou(14, signe, 10, 2, 4, new String[]{"6","4","3","2"}));
			listeCalculATrou.add(construitCalculATrou(11, signe, 10, 2, 1, new String[]{"1","2","8","9"}));
			break;
		case "s5j1e1":
			signe="-";
			listeCalculATrou.add(construitCalculATrou(43, signe, 40, 2, 3, new String[]{"1","2","3"}));
			listeCalculATrou.add(construitCalculATrou(22, signe, 20, 2, 2, new String[]{"1","2","8"}));
			listeCalculATrou.add(construitCalculATrou(35, signe, 30, 2, 5, new String[]{"4","5","6"}));
			listeCalculATrou.add(construitCalculATrou(21, signe, 20, 2, 1, new String[]{"1","2","8","9"}));
			listeCalculATrou.add(construitCalculATrou(47, signe, 40, 2, 7, new String[]{"6","7","8","9"}));
			listeCalculATrou.add(construitCalculATrou(34, signe, 30, 2, 4, new String[]{"6","7","5","4"}));
			listeCalculATrou.add(construitCalculATrou(38, signe, 30, 2, 8, new String[]{"6","7","8","9"}));
			break;
		case "s5j5e1":
			signe="-";
			listeCalculATrou.add(construitCalculATrou(39, signe, 30, 2, 9, new String[]{"7","8","9","1"}));
			listeCalculATrou.add(construitCalculATrou(26, signe, 20, 2, 6, new String[]{"6","7","8","4"}));
			listeCalculATrou.add(construitCalculATrou(44, signe, 40, 2, 4, new String[]{"4","5","6","3"}));
			listeCalculATrou.add(construitCalculATrou(25, signe, 20, 2, 5, new String[]{"2","3","4","5"}));
			listeCalculATrou.add(construitCalculATrou(43, signe, 40, 2, 3, new String[]{"3","4","5","6","7"}));
			listeCalculATrou.add(construitCalculATrou(37, signe, 30, 2, 7, new String[]{"6","7","8","9","3"}));
			listeCalculATrou.add(construitCalculATrou(41, signe, 40, 2, 1, new String[]{"1","2","7","8","9"}));
			break;
		case "s4j3e2":
			signe="+";
			listeCalculATrou.add(construitCalculATrouParentheses(10,1,14,5, new String[]{"5","7","8"}));
			listeCalculATrou.add(construitCalculATrou(9, signe, 13, 0, 4, new String[]{"4","8","5"}));
			//listeCalculATrou.add(construitCalculATrouParentheses(10,1,17,16, new String[]{"8","5","10"}));
			listeCalculATrou.add(construitCalculATrouParentheses(10,1,26,15, new String[]{"17","19","15"}));
			//listeCalculATrou.add(construitCalculATrou(9, signe, 11, 0, 2, new String[]{"2","3","1","5"}));
			listeCalculATrou.add(construitCalculATrouParentheses(10,1,22,13, new String[]{"16","13","15","12"}));
			//listeCalculATrou.add(construitCalculATrou(8, signe, 14, 0, 6, new String[]{"6","7","8","9"}));
			listeCalculATrou.add(construitCalculATrouParentheses(10,2,17,9, new String[]{"9","11","7","12"}));
			listeCalculATrou.add(construitCalculATrou(8, signe, 13, 0, 5, new String[]{"4","5","6","8"}));
			//listeCalculATrou.add(construitCalculATrouParentheses(10,1,24,15, new String[]{"15","13","14","16"}));
			break;
		case "s3j1e4":
			//listeCalculATrou.add(construitCalculATrouRapide(42, 33, 75, 1, new String[]{"30+3","11+11+11"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(31, 24, 55, 0, new String[]{"30+1","15+15"}, 0));
			//listeCalculATrou.add(construitCalculATrouRapide(22, 61, 83, 0, new String[]{"15+5+2","20+2"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(12, 52, 64, 0, new String[]{"6+4+2","10+2"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(44, 55, 99, 1, new String[]{"26+24+5","50+5","55+1"}, 1));
			break;
		case "s3j2e3":
			listeCalculATrou.add(construitCalculATrouRapide(36, 11, 47, 1, new String[]{"10+1","5+5+1"}, 0));
			//listeCalculATrou.add(construitCalculATrouRapide(25, 31, 56, 0, new String[]{"15+10","20+5"}, 1));
			//listeCalculATrou.add(construitCalculATrouRapide(17, 20, 37, 0, new String[]{"5+5+7","10+7"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(40, 22, 62, 1, new String[]{"20+2","10+10+2"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(31, 28, 59, 0, new String[]{"14+15+2","30+1"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(25, 43, 68, 1, new String[]{"40+3","15+25+3","35+8"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(15, 24, 39, 1, new String[]{"15+9","20+4","25+4"}, 1));
			break;
		case "s3j4e4":
			listeCalculATrou.add(construitCalculATrouRapide(38, 14, 52, 1, new String[]{"2+12","5+9"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(27, 16, 43, 1, new String[]{"8+6+2","3+13"}, 1));
			//listeCalculATrou.add(construitCalculATrouRapide(25, 59, 84, 0, new String[]{"22+4","1+24"}, 1));
			//listeCalculATrou.add(construitCalculATrouRapide(38, 37, 75, 1, new String[]{"2+35","15+15+7"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(19, 17, 36, 1, new String[]{"14+3","1+16"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(45, 16, 61, 1, new String[]{"15+1","15+25+5","14+2"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(57, 35, 92, 1, new String[]{"5+16+14","3+32","34+1"}, 1));
			//listeCalculATrou.add(construitCalculATrouRapide(46, 25, 71, 0, new String[]{"5+41","23+23","43+3"}, 0));
			break;
		case "s5j2e3":
			listeCalculATrou.add(construitCalculATrouRapide(36, 52, 88, 2, new String[]{"36+2+50","23+54+11","36+22+27"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(78, 44, 122, 2, new String[]{"100+11+11","78+2+20+22","78+24+34"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(67, 44, 111, 2, new String[]{"67+3+41","50+25+29+7","67+4+47"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(54, 18, 72, 2, new String[]{"18+48+34","54+8+10","54+20+2"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(57, 78, 135, 2, new String[]{"57+3+50+25","70+30+17+8","57+2+58+20"}, 0));
			break;			
		case "s5j3e3":
			signe="+";
			listeCalculATrou.add(construitCalculATrou(160, signe, 256, 1, 96, new String[]{"92","96","80","16"}));
			listeCalculATrou.add(construitCalculATrou(160, signe, 384, 0, 224, new String[]{"234","64","234","244"}));
			listeCalculATrou.add(construitCalculATrou(310, signe, 520, 1, 210, new String[]{"210","320","200","220"}));
			listeCalculATrou.add(construitCalculATrou(168, signe, 488, 1, 320, new String[]{"330","322","320","220"}));
			listeCalculATrou.add(construitCalculATrou(67, signe, 335, 0, 268, new String[]{"248","268","265","368"}));
			break;
		case "s5j4e3":
			listeCalculATrou.add(construitCalculATrouRapide(72, 43, 115, 2, new String[]{"72+3+30+10","72+40+13","72+23+70+2"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(47, 36, 83, 2, new String[]{"47+16+20","30+17+30+6","47+3+33"}, 2));
			listeCalculATrou.add(construitCalculATrouRapide(34, 57, 91, 2, new String[]{"34+7+50","30+57+4+10","34+37+20"}, 0));
			listeCalculATrou.add(construitCalculATrouRapide(18, 66, 84, 2, new String[]{"18+60+6+10","66+6+10","18+36+30"}, 1));
			listeCalculATrou.add(construitCalculATrouRapide(24, 89, 113, 2, new String[]{"89+4+10+10","89+12+10","24+10+70+9"}, 0));
			//listeCalculATrou.add(construitCalculATrouRapide(355, 216, 571, 2, new String[]{"320+220+21+10","5+50+16+100+100+200+200","300+210+50+5+6"}, 2));
			break;
			


		}
		return listeCalculATrou;
	}
}
