package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.Couleur;
import com.abu.orthotab.domain.PathInfo;

public interface CommunService {
	List<Couleur> getListeCouleurs(int nbCouleurs);
	
	List<PathInfo> getListPathInfos(int nb);
}
