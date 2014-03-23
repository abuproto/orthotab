package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.BoiteAOeuf;
import com.abu.orthotab.domain.CalculATrou;
import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;
import com.abu.orthotab.domain.Domino;
import com.abu.orthotab.domain.MemoryMultipliant;

public interface TechniqueService {
	List<Case> getTechnique01(String niveau, int nbInRow, int debut, int fin, int pas);
	
	List<Case> getTechnique02(int debut, int fin, int pas, String pos, String niveau);
	
	List<Case> getTechnique02Variante(String pos, String niveau);
	
	List<Caseflash> getTechnique03(String niveau);
	
	List<Case> getTechnique04(String niveau, int nbInRow, int debut, int fin, int pas);
	
	List<Case> getTechnique04Variante(int nbInRow,String niveau);
	
	List<Domino> getTechnique05Choix(String niveau);
	
	List<Domino> getTechnique05Cible(String niveau);
	
	List<BoiteAOeuf> getTechnique06(String niveau);
	
	List<MemoryMultipliant> getTechnique07(String niveau);
	
	List<CalculATrou> getTechnique08(String niveau);
}
