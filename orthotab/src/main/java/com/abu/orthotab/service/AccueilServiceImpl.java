package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ParametreDao;
import com.abu.orthotab.dao.UserDao;
import com.abu.orthotab.domain.Etape;
import com.abu.orthotab.domain.InfosAccueil;
import com.abu.orthotab.domain.Parametre;
import com.abu.orthotab.domain.User;

@Service
public class AccueilServiceImpl implements AccueilService {

	private final static Logger LOGGER = Logger.getLogger(AccueilServiceImpl.class);
	
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ParametreDao parametreDao;
	
	private final static String CSS_CLASS_AVANT = "avant";
	private final static String CSS_CLASS_ACTIF = "actif";
	private final static String CSS_CLASS_APRES = "apres";
	
	private final static String PARAM_EX_INTERVALLE = "EX_INTERVALLE";
	
	private final static String NOM_OBJET_1 = "chapeau";
	private final static String NOM_OBJET_2 = "papillon";
	private final static String NOM_OBJET_3 = "masque";
	private final static String NOM_OBJET_4 = "bouteille";
	private final static String NOM_OBJET_5 = "confettis";
    
    @Transactional
	public List<Etape> getListeEtapes(String token) {
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
		int dn = 0;
		
		User userConnecte = userDao.findUserByToken(token);
		if(userConnecte!=null){
			nivcourant = (userConnecte.getNivcourant()==null?0:userConnecte.getNivcourant().intValue());
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
					dn = cy;
				}else if(i%5==0){
					exppash = "0";
					exppasv = String.valueOf(pasvertical-r);
					dm = cx;
					dn = cy+r;
				}else if((i>5 && i<10) || (i>15 && i<20)){
					exppash = String.valueOf(-pashorizontal);
					exppasv = "0";
					dm = cx-r;
					dn = cy;
				}
				
				d="M" + dm + "," + dn + " l" + exppash + "," + exppasv;
				
				etape.setR(r);
				etape.setCx(cx);
				etape.setCy(cy);
				etape.setD(d);
								
				etapes.add(etape);
			}
			LOGGER.info("nivcourant : "+ nivcourant + " pour userConnecte " + userConnecte.getLogin());
		}else{
			LOGGER.error("userConnecte null pour token " + token);
		}
		return etapes;
	}
    
    @Transactional
	public InfosAccueil getInfosAccueil(String token) {
    	InfosAccueil infosAccueil = new InfosAccueil();
    	
    	User userConnecte = userDao.findUserByToken(token);
		if(userConnecte!=null){
		
			Date dateLastActivite = userConnecte.getDatechgtniv();
			if(dateLastActivite!=null){
				Parametre parametre = parametreDao.findParametreByCleIdUser(PARAM_EX_INTERVALLE, userConnecte.getId());
				if(parametre!=null){
					String strinter = parametre.getValeur();
					int intermin = Integer.valueOf(strinter);
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(dateLastActivite);
					cal.add(Calendar.MINUTE, intermin);
					infosAccueil.setNbMillisNextJour(cal.getTimeInMillis());
				}
			}else{
				infosAccueil.setNbMillisNextJour(0);
			}
	    	infosAccueil.setNbcac(userConnecte.getNbtotcac()==null?0:userConnecte.getNbtotcac().intValue());
	    	
	    	Long nivcourant = userConnecte.getNivcourant();
	    	
	    	// Ajout objets
	    	int niv = nivcourant.intValue();
	    	infosAccueil.setNivcourant(niv);
	    	infosAccueil.setListeNomObjet(contruitListeObjet(niv));
		}else{
			LOGGER.error("userConnecte null pour token " + token);
		}    	
    	return infosAccueil;
    }

    private List<String> contruitListeObjet(int niv){
    	List<String> listeNomObjet = new ArrayList<String>();
    	
    	String objet1 = "";
    	String objet2 = "";
    	String objet3 = "";
    	String objet4 = "";
    	String objet5 = "";

    	switch(niv){
    	case 1:
	    	objet1 = NOM_OBJET_1 + 0;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 2:
	    	objet1 = NOM_OBJET_1 + 1;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 3:
	    	objet1 = NOM_OBJET_1 + 2;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 4:
	    	objet1 = NOM_OBJET_1 + 3;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 5:
	    	objet1 = NOM_OBJET_1 + 4;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 6:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 0;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 7:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 1;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 8:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 2;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 9:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 3;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 10:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 4;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 11:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 0;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 12:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 1;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 13:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 2;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 14:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 3;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 15:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 4;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 16:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 0;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 17:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 1;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 18:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 2;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 19:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 3;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 20:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 4;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 21:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 0;
    		break;
    	case 22:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 1;
    		break;
    	case 23:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 2;
    		break;
    	case 24:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 3;
    		break;
    	case 25:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 4;
    		break;
    	case 26:
	    	objet1 = NOM_OBJET_1 + 5;
	    	objet2 = NOM_OBJET_2 + 5;
	    	objet3 = NOM_OBJET_3 + 5;
	    	objet4 = NOM_OBJET_4 + 5;
	    	objet5 = NOM_OBJET_5 + 5;
    		break;
    	}
    	
    	listeNomObjet.add(objet1);
    	listeNomObjet.add(objet2);
    	listeNomObjet.add(objet3);
    	listeNomObjet.add(objet4);
    	listeNomObjet.add(objet5);
    	
    	return listeNomObjet;
    }
    
}
