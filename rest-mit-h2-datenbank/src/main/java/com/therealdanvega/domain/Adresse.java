package com.therealdanvega.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;


@Entity
public class Adresse {

	@Id @GeneratedValue
	private Long id;
	
	private String beschreibung;
	
	@Column(columnDefinition = "TEXT")
	private String strasse;
	
	@Column(columnDefinition = "TEXT")
	private String stadt;
	
	@Column(columnDefinition = "TEXT")
	private String plz;
	
	private String slug;
	
	@CreatedDate 
	@Temporal(TemporalType.DATE)
	private Date postedOn;

	@ManyToOne
	//@JsonManagedReference
	private Author author;
	
	@SuppressWarnings("unused")
	private Adresse(){
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adresse(String beschreibung){
		setBeschreibung(beschreibung);
	}

	

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
//		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	@Override
	public String toString() {
		return "Post [title=" + beschreibung + "]";
	}
	
}
