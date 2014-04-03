package com.abu.orthotab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ParametreDao;
import com.abu.orthotab.domain.Parametre;

@Service
public class ParametreServiceImpl implements ParametreService {

    @Autowired
    private ParametreDao parametreDao;
	
	@Override
	@Transactional
	public void miseAJourParametreIntervalle(Parametre parametre) {
		
		Parametre parametreAMaj = parametreDao.findParametreByCleIdUser(Parametre.Cle.EX_INTERVALLE.name(), parametre.getIdUser());
		
		if(parametreAMaj!=null){
			parametreAMaj.setValeur(String.valueOf(parametre.getHeure()*60 + parametre.getMinute()));
		}
	}

}
