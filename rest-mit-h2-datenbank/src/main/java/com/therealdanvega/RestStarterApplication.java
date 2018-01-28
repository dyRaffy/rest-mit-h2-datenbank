package com.therealdanvega;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Adresse;
import com.therealdanvega.repository.AuthorRepository;
import com.therealdanvega.repository.AdressRepository;

@SpringBootApplication
public class RestStarterApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(RestStarterApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(AuthorRepository authorRepository, AdressRepository postRepository) {
    	return args -> {
			
	    	Author author = new Author("Mourad","Jarrar","mourad.jarrar@gmail.com");
	    	authorRepository.save( author );
	    	
	    	Adresse privateAdresse = new Adresse("In dieser Adresse wohne ich!");
	    	privateAdresse.setStrasse("Ludwigstrasse");
	    	privateAdresse.setPlz("63499");
	    	privateAdresse.setStadt("Frankfurt");
	    	privateAdresse.setSlug("Wozu wird ein slug gebraucht");
	    	privateAdresse.setPostedOn(new Date());
	    	privateAdresse.setAuthor(author);
	    	postRepository.save(privateAdresse);
	    	
	    	Adresse arbeitsAdresse = new Adresse("In dieser Adresse arbeite ich");
	    	arbeitsAdresse.setStrasse("Raiffeisenplatz");
	    	arbeitsAdresse.setPlz("65489");
	    	arbeitsAdresse.setStadt("Wiesbaden");
	    	arbeitsAdresse.setSlug("Wozu wird ein slug gebraucht");
	    	arbeitsAdresse.setPostedOn(new Date());
	    	arbeitsAdresse.setAuthor(author);
	    	postRepository.save(arbeitsAdresse);
	    	
    	};
    }
    
}
