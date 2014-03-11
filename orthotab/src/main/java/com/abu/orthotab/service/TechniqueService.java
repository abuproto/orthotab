package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;

public interface TechniqueService {
	List<Case> getTechnique01(int nbCombi, String niveau, int nbInRow);
	
	List<Case> getTechnique02(int nbCombi, String pos);
	
	List<Caseflash> getTechnique03(String niveau);
}
