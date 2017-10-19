package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.util.*;

@Entity
public class Actualite {
	@Id
	@GeneratedValue
	private Long id;
	private String titre;
	private Date dateCreation;
	private String photo;
	private String auteur;
	@Lob
	private String Contenue;
	public Actualite() {
		
	}
	
	public Actualite(String titre, Date dateCreation, String photo, String auteur, String contenue) {
		super();
		this.titre = titre;
		this.dateCreation = dateCreation;
		this.photo = photo;
		this.auteur = auteur;
		Contenue = contenue;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getContenue() {
		return Contenue;
	}
	public void setContenue(String contenue) {
		Contenue = contenue;
	}
	
}
