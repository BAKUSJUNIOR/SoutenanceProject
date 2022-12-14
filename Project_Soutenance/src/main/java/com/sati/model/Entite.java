package com.sati.model;
// Generated 7 nov. 2022 ? 12:20:01 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entite generated by hbm2java
 */
@Entity
@Table(name = "entite", catalog = "bd_gestoinpatrimoine")
public class Entite implements java.io.Serializable {

	private Integer id;
	private String nom;
	private Personne personne;
	private Service service;
	private Set<Demande> demandes = new HashSet<Demande>(0);

	public Entite() {
	}

	public Entite(String nom) {
		this.nom = nom;
	}

	public Entite(String nom, Personne personne, Service service, Set<Demande> demandes) {
		this.nom = nom;
		this.personne = personne;
		this.service = service;
		this.demandes = demandes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NOM", nullable = false, length = 65535)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "entite")
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "entite")
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entite")
	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

}
