package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.domain.User;

@Service
public class AccueilServiceImpl implements AccueilService {

	private final static Logger LOGGER = Logger.getLogger(AccueilServiceImpl.class);
	
    @Autowired
    private UserDao userDao;
	
	private final static String CSS_CLASS_AVANT = "avant";
	private final static String CSS_CLASS_ACTIF = "actif";
	private final static String CSS_CLASS_APRES = "apres";
    
    @Transactional
	public List<Etape> getListeEtapes(int userid) {
		List<Etape> etapes = new ArrayList<Etape>();
		
		int cxinit = 40;
		int cyinit = 20;
		int r = 20;
		int pashorizontal = 80;
		int pasvertical = 80;
		
		
		int nivcourant = 0;
		int nbNiveau = 25;
		
		int cx = cxinit;
		int cy = cyinit;
		String d = "";
		
		String exppash = "";
		String exppasv = "";
		int dm = 0;
		
		User userConnecte = userDao.finduserById(userid);
		if(userConnecte!=null){
			nivcourant = userConnecte.getNivcourant();
			// commence a 1
			for(int i=1;i<=nbNiveau;i++){
				Etape etape = new Etape();
				if(i<nivcourant){
					etape.setCircleCssClass(CSS_CLASS_AVANT);
					etape.setPathCssClass(CSS_CLASS_AVANT);
				}else if(i==nivcourant){
					etape.setCircleCssClass(CSS_CLASS_ACTIF);
					etape.setPathCssClass(CSS_CLASS_APRES);
				}else{
					etape.setCircleCssClass(CSS_CLASS_APRES);
					etape.setPathCssClass(CSS_CLASS_APRES);
				}
				
				// cx et cy
				if(i<=5){
					cx = cxinit + (i-1)*pashorizontal;
					cy = cyinit;
				}else if(i>5 && i<=10){
					cx = cxinit + (10-i)*pashorizontal;
					cy =  cyinit + pasvertical;
				}else if(i>10 && i<=15){
					cx = cxinit + (i-11)*pashorizontal;
					cy =  cyinit + pasvertical*2;
				}else if(i>15 && i<=20){
					cx = cxinit + (20 -i)*pashorizontal;
					cy =  cyinit + pasvertical*3;
				}else if(i>20 && i<=25){
					cx = cxinit + (i-21)*pashorizontal;
					cy =  cyinit + pasvertical*4;
				}
				
				//d
				if(i<5 || (i>10 && i<15) || (i>20 && i<25)){
					exppash = String.valueOf(pashorizontal);
					exppasv = "0";
					dm = cx+r;
				}else if(i%5==0){
					exppash = "0";
					exppasv = String.valueOf(pasvertical);
					dm = cx;
				}else if((i>5 && i<10) || (i>15 && i<20)){
					exppash = String.valueOf(-pashorizontal);
					exppasv = "0";
					dm = cx+r;
				}
				
				d="M" + dm + "," + cy + " l" + exppash + "," + exppasv;
				
				etape.setR(r);
				etape.setCx(cx);
				etape.setCy(cy);
				etape.setD(d);
								
				etapes.add(etape);
			}
			LOGGER.info("nivcourant : "+ nivcourant + " pour userConnecte " + userConnecte.getLogin());
		}else{
			LOGGER.error("userConnecte null pour userid " + userid);
		}
		return etapes;
	}

}
