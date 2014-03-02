package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.service.DidactService;

@Controller
public class DidactController {
	DidactService didactService;
    
    @Autowired
    public DidactController(DidactService didactService) {
        this.didactService = didactService;
    }
 
    @RequestMapping("didact01/{nbCombi}")
    @ResponseBody
    public List<Case> getDidact01(@PathVariable("nbCombi") int nbCombi) {
        return didactService.getDidact01(nbCombi);
    }
    
    @RequestMapping("didact02/{nbCombi}/{pos}")
    @ResponseBody
    public List<Case> getDidact02(@PathVariable("nbCombi") int nbCombi, @PathVariable("pos") String pos) {
        return didactService.getDidact02(nbCombi, pos);
    }
    
    @RequestMapping("didact04/{nbCombi}")
    @ResponseBody
    public List<Case> getDidact04(@PathVariable("nbCombi") int nbCombi) {
        return didactService.getDidact04(nbCombi);
    }
}
