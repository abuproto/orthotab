package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.BoiteAOeuf;
import com.abu.orthotab.domain.CalculATrou;
import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;
import com.abu.orthotab.domain.Domino;
import com.abu.orthotab.domain.InfosExercice;
import com.abu.orthotab.domain.MemoryMultipliant;
import com.abu.orthotab.domain.RemettreOrdre;
import com.abu.orthotab.service.InfosExerciceService;
import com.abu.orthotab.service.Technique01Data;
import com.abu.orthotab.service.TechniqueService;

@Controller
public class ExerciceController {
	
	@Autowired
	TechniqueService techniqueService;
    
    @Autowired
    InfosExerciceService infosExerciceService;

 
    @RequestMapping("technique01/{niveau}")
    @ResponseBody
    public List<Case> getTechnique01(@PathVariable("niveau") String niveau) {
    	int debut = 1;
    	int fin = 1;
    	int pas = 1;
    	int nbInRow = 5;
    	List<Case> listeCase = null;
    	
    	switch(niveau){
    	case "s1j1e1":
    		debut=1;
    		fin=5;
    		listeCase = techniqueService.getTechnique01(niveau, nbInRow, debut, fin, pas);
    		break;
    	case "s1j2e1":
       	case "s1j4e1":
       		debut=1;
    		fin=10;
    		nbInRow = 10;
    		listeCase = techniqueService.getTechnique01(niveau, nbInRow, debut, fin, pas);
    		break;
       	case "s3j1e1":
    		debut=10;
    		pas = 10;
    		fin=90;
    		nbInRow = 10;
    		listeCase = techniqueService.getTechnique01(niveau, nbInRow, debut, fin, pas);
    		break;
     	case "s4j3e1":
    		debut=5;
      		fin=95;
      		pas=10;
      		nbInRow = 10;
      		listeCase = techniqueService.getTechnique01(niveau, nbInRow, debut, fin, pas);
    		break;
     	case "s1j3e2":
     		nbInRow = 6;
     		listeCase = Technique01Data.getInstance().listeCase(niveau, nbInRow);
     		break;
     	case "s2j2e3":
     		nbInRow=8;
     		listeCase = Technique01Data.getInstance().listeCase(niveau, nbInRow);
     		break;
      	case "s3j2e2":
    		nbInRow=11;
    		listeCase = Technique01Data.getInstance().listeCase(niveau, nbInRow);
    		break;
      	case "s4j2e2":
      		nbInRow=10;
      		listeCase = Technique01Data.getInstance().listeCase(niveau, nbInRow);
      		break;
    	}
        return listeCase;
    }
    
    @RequestMapping("technique02/{niveau}/{pos}")
    @ResponseBody
    public List<Case> getTechnique02(@PathVariable("niveau") String niveau, @PathVariable("pos") String pos) {
       	int debut = 1;
    	int fin = 1;
    	int pas = 1;
    	List<Case> listeCase = null;
    	
    	switch(niveau){
    	case "s1j1e2":
    		fin=5;
    		listeCase = techniqueService.getTechnique02(debut, fin, pas, pos, niveau);
    		break;
    	case "s1j3e1":
    	case "s1j5e1":
    		fin=10;
    		listeCase = techniqueService.getTechnique02(debut, fin, pas, pos, niveau);
    		break;
      	case "s3j3e1":
    		debut=10;
      		fin=90;
      		pas=10;
      		listeCase = techniqueService.getTechnique02(debut, fin, pas, pos, niveau);
    		break;
      	case "s3j4e1":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s4j1e1":
    		debut=5;
      		fin=95;
      		pas=10;
      		listeCase = techniqueService.getTechnique02(debut, fin, pas, pos, niveau);
    		break;
      	case "s1j2e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s1j4e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s1j5e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s2j2e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s2j5e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s5j4e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s2j3e3":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
      	case "s5j1e2":
      		listeCase = techniqueService.getTechnique02Variante(pos, niveau);
      		break;
    	}
        return listeCase;
    }
    
    @RequestMapping("technique03/{niveau}")
    @ResponseBody
    public List<Caseflash> getTechnique03(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique03(niveau);
    }
    
    @RequestMapping("technique04/{niveau}")
    @ResponseBody
    public List<Case> getTechnique04(@PathVariable("niveau") String niveau) {
    	int nbInRow = 5;
    	List<Case> listeCase = null;
    	switch(niveau){
    	case "s2j2e1":
     		nbInRow = 7;
     		listeCase = techniqueService.getTechnique04Variante(nbInRow, niveau);
     		break;
    	case "s2j5e1":
    		nbInRow = 6;
    		listeCase = techniqueService.getTechnique04Variante(nbInRow, niveau);
    		break;
     	case "s5j2e1":
    		nbInRow = 7;
    		listeCase = techniqueService.getTechnique04Variante(nbInRow, niveau);
    		break;
     	case "s2j1e2":
     		nbInRow = 5;
     		listeCase = techniqueService.getTechnique04Variante(nbInRow, niveau);
     		break;
     	case "s4j1e2":
     		nbInRow = 6;
     		listeCase = techniqueService.getTechnique04Variante(nbInRow, niveau);
     		break;
    	}
        return listeCase;
    }
    
    @RequestMapping("technique05choix/{niveau}")
    @ResponseBody
    public List<Domino> getTechnique05Choix(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique05Choix(niveau);
    }
    
    @RequestMapping("technique05cible/{niveau}")
    @ResponseBody
    public List<Domino> getTechnique05Cible(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique05Cible(niveau);
    }
     
    @RequestMapping("technique06/{niveau}")
    @ResponseBody
    public List<BoiteAOeuf> getTechnique06(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique06(niveau);
    }
    
    @RequestMapping("technique07/{niveau}")
    @ResponseBody
    public List<MemoryMultipliant> getTechnique07(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique07(niveau);
    }
    
    @RequestMapping("technique08/{niveau}")
    @ResponseBody
    public List<CalculATrou> getTechnique08(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique08(niveau);
    }
    
    @RequestMapping("technique09/{niveau}")
    @ResponseBody
    public List<RemettreOrdre> getTechnique09(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique09(niveau);
    }
    
    @RequestMapping("infosexercice/{token}/{groupe}")
    @ResponseBody
    public List<InfosExercice> getInfosExercice(@PathVariable("token") String token, @PathVariable("groupe") String groupe) {
    	return infosExerciceService.getListInfosExercice(groupe, token);
    }
}
