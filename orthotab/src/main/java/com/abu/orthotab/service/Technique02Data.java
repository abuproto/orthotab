package com.abu.orthotab.service;

import java.util.ArrayList;
import java.util.List;

import com.abu.orthotab.domain.Case;

public class Technique02Data extends TechniqueDataUtil {

	private Technique02Data() {
	};

	private final static Technique02Data instance = new Technique02Data();

	public static Technique02Data getInstance() {
		return instance;
	}

	private Case construitCase(String exp, String pos) {
		Case caseRes = new Case(Case.Type.RES.name(), exp,
				evalueExpression(exp));
		caseRes.setActive(true);
		caseRes.setPos(pos);
		caseRes.setCssClass(CSS_BOUTON_CASE_SMALL);
		caseRes.setBackgrdStyle(STYLE_BGRD_GRIS);
		return caseRes;
	}

	public List<Case> listeBrutCase(String niveau, String pos) {
		List<Case> casesBrut = new ArrayList<Case>();

		switch (niveau + pos) {
		case "s1j2e2G":
			casesBrut.add(construitCase("5+9", pos));
			casesBrut.add(construitCase("3+9", pos));
			casesBrut.add(construitCase("4+9", pos));
			//casesBrut.add(construitCase("6+9", pos));
			//casesBrut.add(construitCase("8+9", pos));
			break;
		case "s1j2e2D":
			casesBrut.add(construitCase("(5+10)-1", pos));
			casesBrut.add(construitCase("(3+10)-1", pos));
			casesBrut.add(construitCase("(4+10)-1", pos));
			//casesBrut.add(construitCase("(6+10)-1", pos));
			//casesBrut.add(construitCase("(8+10)-1", pos));
			break;
		case "s1j4e2G":
			casesBrut.add(construitCase("5+9", pos));
			casesBrut.add(construitCase("3+9", pos));
			casesBrut.add(construitCase("4+9", pos));
			casesBrut.add(construitCase("6+9", pos));
			casesBrut.add(construitCase("8+9", pos));
			casesBrut.add(construitCase("7+9", pos));
			casesBrut.add(construitCase("4+8", pos));
			casesBrut.add(construitCase("5+8", pos));
			casesBrut.add(construitCase("6+8", pos));
			break;
		case "s1j4e2D":
			casesBrut.add(construitCase("(5+10)-1", pos));
			casesBrut.add(construitCase("(3+10)-1", pos));
			casesBrut.add(construitCase("(4+10)-1", pos));
			casesBrut.add(construitCase("(6+10)-1", pos));
			casesBrut.add(construitCase("(8+10)-1", pos));
			casesBrut.add(construitCase("(7+10)-1", pos));
			casesBrut.add(construitCase("(4+10)-2", pos));
			casesBrut.add(construitCase("(5+10)-2", pos));
			casesBrut.add(construitCase("(6+10)-2", pos));
			break;
		case "s1j5e2G":
			casesBrut.add(construitCase("(5+10)-1", pos));
			casesBrut.add(construitCase("(3+10)-1", pos));
			casesBrut.add(construitCase("(4+10)-1", pos));
			casesBrut.add(construitCase("(6+10)-1", pos));
			casesBrut.add(construitCase("(8+10)-1", pos));
			casesBrut.add(construitCase("(7+10)-1", pos));
			casesBrut.add(construitCase("(4+10)-2", pos));
			casesBrut.add(construitCase("(5+10)-2", pos));
			casesBrut.add(construitCase("(6+10)-2", pos));
			break;
		case "s1j5e2D":
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("15", pos));
			casesBrut.add(construitCase("16", pos));
			casesBrut.add(construitCase("17", pos));
			break;
		case "s2j2e2G":
			casesBrut.add(construitCase("(2+10)-1", pos));
			casesBrut.add(construitCase("(3+10)-1", pos));
			casesBrut.add(construitCase("4+9", pos));
			casesBrut.add(construitCase("(5+10)-1", pos));
			casesBrut.add(construitCase("6+9", pos));
			casesBrut.add(construitCase("(7+10)-1", pos));
			casesBrut.add(construitCase("(8+10)-1", pos));
			casesBrut.add(construitCase("(13+10)-1", pos));
			casesBrut.add(construitCase("14+9", pos));
			casesBrut.add(construitCase("(15+10)-1", pos));
			break;
		case "s2j2e2D":
			casesBrut.add(construitCase("11", pos));
			casesBrut.add(construitCase("3+9", pos));
			casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("15", pos));
			casesBrut.add(construitCase("7+9", pos));
			casesBrut.add(construitCase("17", pos));
			casesBrut.add(construitCase("13+9", pos));
			casesBrut.add(construitCase("23", pos));
			casesBrut.add(construitCase("15+9", pos));
			break;
		case "s2j5e2G":
			casesBrut.add(construitCase("(2+10)-1", pos));
			//casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("(5+10)-1", pos));
			//casesBrut.add(construitCase("8+10-1", pos));
			casesBrut.add(construitCase("13+9", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("6+9", pos));
			//casesBrut.add(construitCase("4+10-2", pos));
			casesBrut.add(construitCase("24", pos));
			//casesBrut.add(construitCase("6+8", pos));
			break;
		case "s2j5e2D":
			//casesBrut.add(construitCase("8+9", pos));
			casesBrut.add(construitCase("(13+10)-1", pos));
			casesBrut.add(construitCase("2+9", pos));
			casesBrut.add(construitCase("(3+10)-1", pos));
			//casesBrut.add(construitCase("4+9", pos));
			casesBrut.add(construitCase("(15+10)-1", pos));
			casesBrut.add(construitCase("(6+10)-1", pos));
			//casesBrut.add(construitCase("4+8", pos));
			//casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("14", pos));
			break;
		case "s5j4e2G":
			casesBrut.add(construitCase("8+9", pos));
			casesBrut.add(construitCase("5+9", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("22", pos));
			casesBrut.add(construitCase("21", pos));
			casesBrut.add(construitCase("5+8", pos));
			casesBrut.add(construitCase("23", pos));
			casesBrut.add(construitCase("3+9", pos));
			casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("15+9", pos));
			break;
		case "s5j4e2D":
			casesBrut.add(construitCase("13+9", pos));
			casesBrut.add(construitCase("24", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("4+9", pos));
			casesBrut.add(construitCase("14+9", pos));
			casesBrut.add(construitCase("13", pos));
			casesBrut.add(construitCase("17", pos));
			casesBrut.add(construitCase("12+9", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("6+8", pos));
			break;
		case "s2j3e3G":
			casesBrut.add(construitCase("2x3", pos));
			casesBrut.add(construitCase("2x4", pos));
			casesBrut.add(construitCase("2x5", pos));
			casesBrut.add(construitCase("2x6", pos));
			casesBrut.add(construitCase("2x7", pos));
			casesBrut.add(construitCase("2x8", pos));
			casesBrut.add(construitCase("2x9", pos));
			casesBrut.add(construitCase("3x2", pos));
			casesBrut.add(construitCase("3x3", pos));
			casesBrut.add(construitCase("3x4", pos));
			casesBrut.add(construitCase("3x5", pos));
			casesBrut.add(construitCase("3x10", pos));
			break;
		case "s2j3e3D":
			casesBrut.add(construitCase("6", pos));
			casesBrut.add(construitCase("8", pos));
			casesBrut.add(construitCase("10", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("14", pos));
			casesBrut.add(construitCase("16", pos));
			casesBrut.add(construitCase("18", pos));
			casesBrut.add(construitCase("6", pos));
			casesBrut.add(construitCase("9", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("15", pos));
			casesBrut.add(construitCase("30", pos));
			break;
		case "s5j1e2G":
			casesBrut.add(construitCase("3x3", pos));
			casesBrut.add(construitCase("3x4", pos));
			casesBrut.add(construitCase("5x5", pos));
			casesBrut.add(construitCase("5x4", pos));
			casesBrut.add(construitCase("4x6", pos));
			casesBrut.add(construitCase("6x3", pos));
			casesBrut.add(construitCase("7x3", pos));
			casesBrut.add(construitCase("7x7", pos));
			casesBrut.add(construitCase("8x7", pos));
			casesBrut.add(construitCase("8x5", pos));
			casesBrut.add(construitCase("3x8", pos));
			casesBrut.add(construitCase("9x5", pos));
			casesBrut.add(construitCase("3x9", pos));
			break;
		case "s5j1e2D":
			casesBrut.add(construitCase("9", pos));
			casesBrut.add(construitCase("12", pos));
			casesBrut.add(construitCase("25", pos));
			casesBrut.add(construitCase("20", pos));
			casesBrut.add(construitCase("24", pos));
			casesBrut.add(construitCase("18", pos));
			casesBrut.add(construitCase("21", pos));
			casesBrut.add(construitCase("49", pos));
			casesBrut.add(construitCase("56", pos));
			casesBrut.add(construitCase("40", pos));
			casesBrut.add(construitCase("24", pos));
			casesBrut.add(construitCase("45", pos));
			casesBrut.add(construitCase("27", pos));
			break;
		case "s3j4e1G":
			casesBrut.add(construitCase("12+12", pos));
			casesBrut.add(construitCase("14+14", pos));
			casesBrut.add(construitCase("20+20", pos));
			casesBrut.add(construitCase("30+30", pos));
			casesBrut.add(construitCase("40+40", pos));
			casesBrut.add(construitCase("60+60", pos));
			casesBrut.add(construitCase("80+80", pos));
			casesBrut.add(construitCase("90+90", pos));
			break;
		case "s3j4e1D":
			casesBrut.add(construitCase("24", pos));
			casesBrut.add(construitCase("28", pos));
			casesBrut.add(construitCase("40", pos));
			casesBrut.add(construitCase("60", pos));
			casesBrut.add(construitCase("80", pos));
			casesBrut.add(construitCase("120", pos));
			casesBrut.add(construitCase("160", pos));
			casesBrut.add(construitCase("180", pos));
			break;
		}


		
		return casesBrut;
	}

}
