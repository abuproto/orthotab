package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Case;
import com.abu.orthotab.service.NiveauService;

@Controller
//@RequestMapping("api")
public class NiveauController {

	NiveauService niveauService;
    
    @Autowired
    public NiveauController(NiveauService niveauService) {
        this.niveauService = niveauService;
    }
 
    @RequestMapping("niveau01")
    @ResponseBody
    //public Niveau getNiveau01() {
    public List<Case> getNiveau01() {
        return niveauService.getNiveau01();
    }
	
}
