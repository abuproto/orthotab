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
import com.abu.orthotab.service.TechniqueService;

@Controller
public class ExerciceController {
	TechniqueService techniqueService;
    
    @Autowired
    public ExerciceController(TechniqueService techniqueService) {
        this.techniqueService = techniqueService;
    }
 
    @RequestMapping("technique01/{niveau}")
    @ResponseBody
    public List<Case> getTechnique01(@PathVariable("niveau") String niveau) {
    	int debut = 1;
    	int fin = 1;
    	int pas = 1;
    	int nbInRow = 5;
    	switch(niveau){
    	case "s1j1e1":
    		debut=1;
    		fin=5;
    		break;
    	case "s1j2e1":
       	case "s1j4e1":
       		debut=1;
    		fin=10;
    		nbInRow = 10;
    		break;
       	case "s3j1e1":
    		debut=10;
    		pas = 10;
    		fin=90;
    		nbInRow = 10;
    		break;
     	case "s4j3e1":
    		debut=5;
      		fin=95;
      		pas=10;
      		nbInRow = 10;
    		break;
    	}
        return techniqueService.getTechnique01(niveau, nbInRow, debut, fin, pas);
    }
    
    @RequestMapping("technique02/{niveau}/{pos}")
    @ResponseBody
    public List<Case> getTechnique02(@PathVariable("niveau") String niveau, @PathVariable("pos") String pos) {
       	int debut = 1;
    	int fin = 1;
    	int pas = 1;
    	switch(niveau){
    	case "s1j1e2":
    		fin=5;
    		break;
    	case "s1j3e1":
    	case "s1j5e1":
    		fin=10;
    		break;
      	case "s3j3e1":
      	case "s3j4e1":
    		debut=10;
      		fin=90;
      		pas=10;
    		break;
      	case "s4j1e1":
    		debut=5;
      		fin=95;
      		pas=10;
    		break;
    	}
        return techniqueService.getTechnique02(debut, fin, pas, pos, niveau);
    }
    
    @RequestMapping("technique03/{niveau}")
    @ResponseBody
    public List<Caseflash> getTechnique03(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique03(niveau);
    }
    
    @RequestMapping("technique04/{niveau}")
    @ResponseBody
    public List<Case> getTechnique04(@PathVariable("niveau") String niveau) {
    	int debut = 1;
    	int fin = 1;
    	int pas = 1;
    	int nbInRow = 5;
    	switch(niveau){
    	case "s2j2e1":
    	case "s2j5e1":
    		debut=5;
    		fin=15;
    		nbInRow = 6;
    		break;
     	case "s5j2e1":
    		debut=3;
    		fin=15;
    		pas = 2;
    		nbInRow = 10;
    		break;
    	}
        return techniqueService.getTechnique04(niveau, nbInRow, debut, fin, pas);
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
    
    @RequestMapping("technique08/{niveau}")
    @ResponseBody
    public List<CalculATrou> getTechnique08(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique08(niveau);
    }
}
