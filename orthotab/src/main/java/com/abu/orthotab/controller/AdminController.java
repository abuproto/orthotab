package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.InfosActivity;
import com.abu.orthotab.domain.InfosUtilisateur;
import com.abu.orthotab.domain.Parametre;
import com.abu.orthotab.service.InfosActivityService;
import com.abu.orthotab.service.InfosUtilisateurService;
import com.abu.orthotab.service.ParametreService;

@Controller
public class AdminController {

	@Autowired
	InfosUtilisateurService infosUtilisateurService;
	
	@Autowired
	InfosActivityService infosActivityService;
	
	@Autowired
	ParametreService parametreService;
	
    @RequestMapping("infosactivity")
    @ResponseBody
    public List<InfosActivity> getListInfosActivity() {
        return infosActivityService.getListInfosActivity();
    }
    
    @RequestMapping("infosutilisateur")
    @ResponseBody
    public List<InfosUtilisateur> getListInfosUtilisateur() {
        return infosUtilisateurService.getListInfosUtilisateur();
    }
    
	@RequestMapping(value = "majparametre", method = RequestMethod.POST)
    @ResponseBody
	public void majparametre(@RequestBody Parametre parametre){
		parametreService.miseAJourParametreIntervalle(parametre);
	}
}
