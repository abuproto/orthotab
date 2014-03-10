package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;

@Service
public class TechniqueServiceImpl extends UtilServiceImpl implements TechniqueService {

	
	public List<Case> getTechnique01(int nbCombi, int nbIntrus) {
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

	@Override
	public List<Case> getTechnique02(int nbCombi, String pos) {
		List<Case> cases = new ArrayList<Case>();
		for(int i=1;i<=nbCombi;i++){
			
			String libelle = "";
			if("G".equals(pos)){
				libelle = i + " + " + i;
			}else if("D".equals(pos)){
				libelle = String.valueOf(i+i);
			}
			Case caseRes = new Case(Case.Type.RES.name(),libelle,i+i);
			caseRes.setActive(true);
			caseRes.setPos(pos);
			caseRes.setCssClass("boutonCase-small");
			caseRes.setBackgrdStyle("#B5B276");
			cases.add(caseRes);
		}
		
		return completeLoc(melange(cases),pos);
	}

	@Override
	public List<Caseflash> getTechnique03(String niveau) {
		
		List<Caseflash> listCaseflash = new ArrayList<Caseflash>();
		
    	switch(niveau){
    	case "s2j1e1":
    		Caseflash c1 = new Caseflash("1+1",2);
    		String[] tab1 = {"2","1"};
    		listCaseflash.add(completeCaseflash(c1, tab1));
    		
      		Caseflash c2 = new Caseflash("5+5",10);
    		String[] tab2 = {"15","10"};
    		listCaseflash.add(completeCaseflash(c2, tab2));
    		
    		break;
 
    	}
		
		return listCaseflash;
	}

}
