package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.domain.InfosAccueil;
import com.abu.orthotab.service.AccueilService;

@Controller
public class AccueilController {
	
	@Autowired
	private AccueilService accueilService;

    @RequestMapping("accueiletapes/{token}")
    @ResponseBody
    public List<Etape> getListEtapes(@PathVariable("token") String token) {
        return accueilService.getListeEtapes(token);
    }
    
    
    @RequestMapping("accueilinfos/{token}")
    @ResponseBody
    public InfosAccueil getInfosAccueil(@PathVariable("token") String token) {
        return accueilService.getInfosAccueil(token);
    }
}
