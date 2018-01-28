package com.therealdanvega.service;

import com.therealdanvega.domain.Adresse;

public interface AdressService {
	
	Iterable<Adresse> list();
	
	Adresse create(Adresse post);
	
	Adresse read(long id);
	
	Adresse update(long id, Adresse post);
	
	void delete(long id);
}
