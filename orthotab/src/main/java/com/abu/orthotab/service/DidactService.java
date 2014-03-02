package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.Case;

public interface DidactService {
	List<Case> getDidact01(int nbCombi);
	List<Case> getDidact02(int nbCombi, String pos);
	List<Case> getDidact04(int nbCombi);
}
