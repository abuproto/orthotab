package com.abu.orthotab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.service.AccueilService;

@Controller
public class AccueilController {
	private AccueilService accueilService;

	@Autowired
	public AccueilController(AccueilService accueilService) {
		this.accueilService = accueilService;
	}

    @RequestMapping("accueil")
    @ResponseBody
    public List<Etape> getListEtapes() {
        return accueilService.getListeEtapes();
    }
}
