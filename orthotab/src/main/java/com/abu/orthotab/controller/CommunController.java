package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Couleur;
import com.abu.orthotab.domain.PathInfo;
import com.abu.orthotab.service.CommunService;

@Controller
public class CommunController {
	private CommunService communService;
    
    @Autowired
    public CommunController(CommunService communService) {
        this.communService = communService;
    }
 
    @RequestMapping("couleurs/{nbCouleurs}")
    @ResponseBody
    public List<Couleur> getListCouleurs(@PathVariable("nbCouleurs") int nbCouleurs) {
        return communService.getListeCouleurs(nbCouleurs);
    }
    
    @RequestMapping("couleursExercice/{niveau}")
    @ResponseBody
    public List<Couleur> getListCouleurs(@PathVariable("niveau") String niveau) {
    	int nbCouleurs = 0;
       	switch(niveau){
    	case "s1j1e1":
    		nbCouleurs=5;
    		break;
    	case "s1j2e1":
    	case "s1j4e1":
    		nbCouleurs=10;
    		break;
    	}
        return communService.getListeCouleurs(nbCouleurs);
    }
    
    @RequestMapping("pathinfos/{nb}")
    @ResponseBody
    public List<PathInfo> getListPathInfos(@PathVariable("nb") int nb) {
        return communService.getListPathInfos(nb);
    }
}
