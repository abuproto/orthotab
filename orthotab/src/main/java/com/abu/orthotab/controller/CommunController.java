package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Couleur;
import com.abu.orthotab.service.CommunService;

@Controller
public class CommunController {
	private CommunService communService;
    
    @Autowired
    public CommunController(CommunService communService) {
        this.communService = communService;
    }
 
    @RequestMapping("couleurs")
    @ResponseBody
    public List<Couleur> getListCouleurs() {
        return communService.getListeCouleurs();
    }
}
