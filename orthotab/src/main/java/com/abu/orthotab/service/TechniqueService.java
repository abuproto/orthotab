package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;

public interface TechniqueService {
	List<Case> getTechnique01(String niveau, int nbInRow, int debut, int fin, int pas);
	
	List<Case> getTechnique02(int debut, int fin, int pas, String pos, String niveau);
	
	List<Caseflash> getTechnique03(String niveau);
	
	List<Case> getTechnique04(String niveau, int nbInRow, int debut, int fin, int pas);
}
