package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Case;

@Service
public class NiveauServiceImpl implements NiveauService {

	public List<Case> getNiveau01(int nbCombi) {
				
		// cases
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			Case caseOp = new Case(Case.Type.OP.name(),i + " + " + i,i+i);
			caseOp.setActive(true);
			caseOp.setCssClass("boutonCase");
			caseOp.setBackgrdStyle("#B5B276");
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(),String.valueOf(i+i),i+i);
			caseRes.setActive(true);
			caseRes.setCssClass("boutonCase");
			caseRes.setBackgrdStyle("#B5B276");
			cases.add(caseRes);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(cases,new Random(seed));
		return cases;
	}

}
