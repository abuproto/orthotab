package com.abu.orthotab.service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

public abstract class TechniqueDataUtil {

	private final static Logger LOGGER = Logger
			.getLogger(TechniqueDataUtil.class);
	
	protected <T> List<T> melange(List<T> listeItem) {
		long seed = System.nanoTime();
		Collections.shuffle(listeItem, new Random(seed));
		return listeItem;
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
