package com.therealdanvega.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.therealdanvega.domain.Adresse;

@Repository
public interface AdressRepository extends CrudRepository<Adresse, Long> {

	Adresse findFirstByOrderByPostedOnDesc();

	List<Adresse> findAllByOrderByPostedOnDesc();

	Adresse findBySlug(String slug);

}
