package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.CaseRm;
import com.abu.orthotab.domain.RemettreOrdre;

public class Technique09Data extends TechniqueDataUtil{
	private Technique09Data() {
	};

	private final static Technique09Data instance = new Technique09Data();

	public static Technique09Data getInstance() {
		return instance;
	}
	
	private RemettreOrdre construitRemettreOrdre(String[][] elements, Integer[] position){
		RemettreOrdre rm = new RemettreOrdre();
		
		int nbocc = elements.length;
		
		List<CaseRm> listeCaseChoix = new ArrayList<CaseRm>();
		for(String[] crm : elements){
			CaseRm caseRm = new CaseRm(crm[0],crm[1]);
			caseRm.setBackgrdStyle(STYLE_BGRD_GRIS);
			caseRm.setCssClass(calculCssClass(crm[0]));
			listeCaseChoix.add(caseRm);
		}
		rm.setListeCaseChoix(melange(listeCaseChoix));
		
		rm.setListeCaseCible(construitListeCaseCible(nbocc,position));
		return rm;
	}
	
	public List<RemettreOrdre> listeRemettreOrdre(String niveau){
		List<RemettreOrdre> listeRemettreOrdre = new ArrayList<RemettreOrdre>();
		
		switch (niveau) {
		case "s4j5e1":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"14","0"},{"=","3"},{"4","2;4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"16","0"},{"=","3"},{"6","2;4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"19","0"},{"=","3"},{"9","2;4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"12","0"},{"=","3"},{"2","2;4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"15","0"},{"=","3"},{"5","2;4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"11","0"},{"=","3"},{"1","2;4"}},new Integer[]{1,3}));
			break;			
		case "s3j2e1":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1"},{"15","0;2"},{"9","0;2"},{"=","3"},{"24","4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1"},{"7","0;2"},{"9","0;2"},{"=","3"},{"16","4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"-","1"},{"10","2;4"},{"12","0"},{"=","3"},{"2","2;4"}},new Integer[]{1,3}));
			break;
		case "s3j4e2":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"10","0;2;4"},{"5","0;2;4"},{"1","0;2;4"},{"=","5"},{"16","6"}},new Integer[]{1,3,5}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1"},{"9","0;2"},{"12","0;2"},{"=","3"},{"21","4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"10","0;2;4"},{"14","0;2;4"},{"1","0;2;4"},{"=","5"},{"25","6"}},new Integer[]{1,3,5}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1"},{"3","0;2"},{"9","0;2"},{"=","3"},{"12","4"}},new Integer[]{1,3}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"2","0;2;4"},{"10","0;2;4"},{"9","0;2;4"},{"=","5"},{"21","6"}},new Integer[]{1,3,5}));
			break;			
		case "s4j2e3":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"1","0;2;4;6"},{"10","0;2;4;6"},{"89","0;2;4;6"},{"39","0;2;4;6"},{"=","7"},{"139","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"2","0;2;4;6"},{"86","0;2;4;6"},{"4","0;2;4;6"},{"50","0;2;4;6"},{"=","7"},{"142","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"3","0;2;4;6"},{"72","0;2;4;6"},{"30","0;2;4;6"},{"20","0;2;4;6"},{"=","7"},{"125","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"94","0;2;4;6"},{"10","0;2;4;6"},{"4","0;2;4;6"},{"20","0;2;4;6"},{"=","7"},{"128","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"84","0;2;4"},{"20","0;2;4"},{"10","0;2;4"},{"=","5"},{"117","6"}},new Integer[]{1,3,5}));
			break;
		case "s4j4e3":
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"3","0;2;4"},{"97","0;2;4"},{"32","0;2;4"},{"=","5"},{"132","6"}},new Integer[]{1,3,5}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"2","0;2;4"},{"45","0;2;4"},{"98","0;2;4"},{"=","5"},{"145","6"}},new Integer[]{1,3,5}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"20","0;2;4;6"},{"79","0;2;4;6"},{"16","0;2;4;6"},{"1","0;2;4;6"},{"=","7"},{"116","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3;5"},{"+","1;3;5"},{"+","1;3;5"},{"88","0;2;4;6"},{"10","0;2;4;6"},{"2","0;2;4;6"},{"44","0;2;4;6"},{"=","7"},{"144","8"}},new Integer[]{1,3,5,7}));
			listeRemettreOrdre.add(construitRemettreOrdre(new String[][]{{"+","1;3"},{"+","1;3"},{"1","0;2;4"},{"27","0;2;4"},{"99","0;2;4"},{"=","5"},{"127","6"}},new Integer[]{1,3,5}));
			break;
		}
				
		return listeRemettreOrdre;
	}
	
	
	private List<Case> construitListeCaseCible(int nbocc, Integer[] position){
		List<Case> lstCase = new ArrayList<Case>();
		for(int i=0;i<nbocc;i++){
			Case caseCible = new Case("","?",0);
			caseCible.setActive(true);
			caseCible.setBackgrdStyle(STYLE_BGRD_BLANC);
			caseCible.setCssClass(calculCssClass(i, position));
			lstCase.add(caseCible);
		}
		return lstCase;
	}
	
	// didact :
	
	//rond trou-plein
	//carre trou-plein
	
	private String calculCssClass(int i, Integer[] position){
		String cssClass="";
		if(Arrays.asList(position).contains(i)){
			cssClass = CSS_CARRE_SF_PLEIN;
		}else{
			cssClass = CSS_ROND_SF_PLEIN;
		}
		return cssClass;
	}
	
	
	
	
	
	private String calculCssClass(String signe){
		String cssClass="";
		if("+".equals(signe) || "-".equals(signe) || "=".equals(signe)){
			cssClass = CSS_CARRE_SF_PLEIN;
		}else{
			cssClass = CSS_ROND_SF_PLEIN;
		}
		return cssClass;
	}
	
	// actuellement : case-nombre-sf
}
