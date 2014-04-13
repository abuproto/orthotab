package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

import com.abu.orthotab.domain.Case;

public class TechniqueDataUtil {

	protected final static String CSS_ROND_PLEIN = "rond trou-plein";
	protected final static String CSS_ROND_SF_PLEIN = "rond-sf trou-plein";
	protected final static String CSS_CARRE_PLEIN = "carre trou-plein";
	protected final static String CSS_CARRE_SF_PLEIN = "carre-sf trou-plein";
	protected final static String CSS_CASE_NOMBRE = "case-nombre";
	protected final static String STYLE_BGRD_GRIS = "#B5B276";
	protected final static String STYLE_BGRD_JAUNE = "yellow";
	protected final static String STYLE_BGRD_ROUGE = "red";
	protected final static String STYLE_BGRD_BLEU = "blue";
	protected final static String STYLE_BGRD_BLANC = "white";
	protected final static String CSS_BOUTON_CASE = "boutonCase";
	protected final static String CSS_BOUTON_CASE_SMALL = "boutonCase-small";
	protected final static String CSS_BOUTON_CASE_LONG = "boutonCase-long";
	protected final static String CSS_BOUTON_CASE_XLONG = "boutonCase-xlong";
	
	protected TechniqueDataUtil() {
	};

	private final static TechniqueDataUtil instance = new TechniqueDataUtil();

	public static TechniqueDataUtil getInstance() {
		return instance;
	}
	
	private final static Logger LOGGER = Logger
			.getLogger(TechniqueDataUtil.class);
	
	protected <T> List<T> melange(List<T> listeItem) {
		long seed = System.nanoTime();
		Collections.shuffle(listeItem, new Random(seed));
		return listeItem;
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
	
	protected int evalueExpression(String expression) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int result = 0;
		try {
			float f = Float.parseFloat(String.valueOf(engine.eval(normaliseExpression(expression))));
			result = Math.round(f);
		} catch (NumberFormatException | ScriptException e) {
			LOGGER.error("Erreur dans evalueExpression avec : " + expression, e);
		}
		return result;
	}
	
	protected String normaliseExpression(String expression){
		if(expression.indexOf("x")>0){
			return expression.replace('x','*');
		}else{
			return expression;
		}
			
	}
}
