package com.abu.orthotab.service;

import java.util.List;

import com.abu.orthotab.domain.InfosExercice;

public interface InfosExerciceService {
	List<InfosExercice> getListInfosExercice(String groupe, String token);
}
