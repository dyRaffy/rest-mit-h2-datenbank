package com.therealdanvega.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.therealdanvega.domain.Adresse;
import com.therealdanvega.excepion.AdressNotFoundException;
import com.therealdanvega.service.AdressService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/adressen")
public class AdressController {

	private AdressService adressService;
	
	@Autowired
	public AdressController(AdressService postService){
		this.adressService = postService;
	}	
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Iterable<Adresse> list(){
		return adressService.list();
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Adresse create(@RequestBody Adresse post){	// Die Klasse 'HttpMessageConverter' konvetiert den '@RequestBody' zu einem JSON-Objekt
		return adressService.create(post);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Adresse read(@PathVariable(value="id") long id) throws AdressNotFoundException{
		
		 Adresse adresse = adressService.read(id);
		
		 if(adresse == null) {
			 throw new AdressNotFoundException("Adresse mit der ID = " + id +  " wurde nicht gefunden");
		 }
		return adresse;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Adresse update(@PathVariable(value="id") long id, @RequestBody Adresse post){
		return adressService.update(id,post);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		adressService.delete(id);
	}	
	
	@ExceptionHandler(AdressNotFoundException.class)
	public void handleAdressNnotFoundException(AdressNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError( org.springframework.http.HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
	
	
}
