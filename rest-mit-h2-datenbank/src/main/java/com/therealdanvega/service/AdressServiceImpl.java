package com.therealdanvega.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.Adresse;
import com.therealdanvega.repository.AuthorRepository;
import com.therealdanvega.repository.AdressRepository;

@Service
public class AdressServiceImpl implements AdressService {

	private AdressRepository adressRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public AdressServiceImpl(AdressRepository postRepository, AuthorRepository authorRepository){
		this.adressRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public Iterable<Adresse> list() {
		return adressRepository.findAll();
	}

	@Override
	public Adresse read(long id) {
		return adressRepository.findOne(id);
	}

	@Override
	@Transactional
	public Adresse create(Adresse adresse) {
		// save the new author
		authorRepository.save(adresse.getAuthor());
		return adressRepository.save(adresse);
	}

	@Override
	public void delete(long id) {
		adressRepository.delete(id);
	}

	@Override
	public Adresse update(long id,Adresse adresse) {
		Adresse neueAdresse = adressRepository.findOne(id);
		if( adresse.getBeschreibung() != null ) {
			neueAdresse.setBeschreibung(adresse.getBeschreibung());
		}
		return adressRepository.save(neueAdresse);
	}

}
