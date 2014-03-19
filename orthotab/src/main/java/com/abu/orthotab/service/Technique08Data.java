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
			break;
		}
		
		
		/*Opération : 2 + … =10		propositions : 9 - 8
				Opération : 6 + … =10		propositions :  4 - 2 - 6
				Opération : … + 3 =10		propositions : 7 - 8 - 9 
				Opération : … +1 =10		propositions : 8 - 9 - 7
				Opération : 15 + … =20	propositions : 5 - 15
				Opération : 13 + … =20	propositions : 7 - 8  
				Opération : … + 19 =20	propositions : 1 - 2 - 3 
				Opération : 17 + … =20	propositions :  1 - 2 - 3 
				Opération : … +11 =20	propositions : 8 - 9 - 10*/

		
		
		return listeCalculATrou;
	}
}
