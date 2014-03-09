package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Case;

@Service
public class TechniqueServiceImpl implements TechniqueService {

	private List<Case> melange(List<Case> listeCase ){
		long seed = System.nanoTime();
		Collections.shuffle(listeCase,new Random(seed));
		return listeCase;
	}
	
	public List<Case> getTechnique01(int nbCombi) {
		int nbInRow = 5;
		int nbCase = 0;
		
		// cases
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			Case caseOp = new Case(Case.Type.OP.name(),i + " + " + i,i+i);
			nbCase++;
			int row = (nbCase<=nbInRow?1:2);
			caseOp.setActive(true);
			caseOp.setCssClass("boutonCase");
			caseOp.setBackgrdStyle("#B5B276");
			caseOp.setRow(String.valueOf(row));
			cases.add(caseOp);
			Case caseRes = new Case(Case.Type.RES.name(),String.valueOf(i+i),i+i);
			nbCase++;
			row = (nbCase<=nbInRow?1:2);
			caseRes.setActive(true);
			caseRes.setCssClass("boutonCase");
			caseRes.setBackgrdStyle("#B5B276");
			caseRes.setRow(String.valueOf(row));
			cases.add(caseRes);
		}
		return melange(cases);
	}

}
