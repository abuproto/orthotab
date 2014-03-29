package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.domain.InfosAccueil;

public interface AccueilService {
	List<Etape> getListeEtapes(String token);
	
	public InfosAccueil getInfosAccueil(String token);
}
