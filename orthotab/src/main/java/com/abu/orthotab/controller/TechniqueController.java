package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.service.TechniqueService;

@Controller
public class TechniqueController {
	TechniqueService techniqueService;
    
    @Autowired
    public TechniqueController(TechniqueService techniqueService) {
        this.techniqueService = techniqueService;
    }
 
    @RequestMapping("technique01/{nbCombi}")
    @ResponseBody
    public List<Case> getTechnique01(@PathVariable("nbCombi") int nbCombi) {
        return techniqueService.getTechnique01(nbCombi);
    }
}
