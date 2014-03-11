package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.domain.Caseflash;
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
    	int nbCombi = 0;
    	int nbInRow = 5;
    	switch(niveau){
    	case "s1j1e1":
    		nbCombi=5;
    		break;
    	case "s1j2e1":
       	case "s1j4e1":
    		nbCombi=10;
    		nbInRow = 10;
    		break;
    	}
        return techniqueService.getTechnique01(nbCombi, niveau, nbInRow);
    }
    
    @RequestMapping("technique02/{niveau}/{pos}")
    @ResponseBody
    public List<Case> getTechnique02(@PathVariable("niveau") String niveau, @PathVariable("pos") String pos) {
    	int nbCombi = 0;
    	switch(niveau){
    	case "s1j1e2":
    		nbCombi=5;
    		break;
    	case "s1j3e1":
    		nbCombi=10;
    		break;
    	}
        return techniqueService.getTechnique02(nbCombi, pos);
    }
    
    @RequestMapping("technique03/{niveau}")
    @ResponseBody
    public List<Caseflash> getTechnique03(@PathVariable("niveau") String niveau) {
        return techniqueService.getTechnique03(niveau);
    }
}
