package com.sati.model;
// Generated 17 oct. 2022 � 19:09:55 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name = "service", catalog = "bd_gestoinpatrimoine")
public class Service implements java.io.Serializable {

	private int id;
	private Entite entite;
	private String nom;
	private String bureau;

	public Service() {
	}

	public Service(Entite entite, String nom) {
		this.entite = entite;
		this.nom = nom;
	}

	public Service(Entite entite, String nom, String bureau) {
		this.entite = entite;
		this.nom = nom;
		this.bureau = bureau;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "entite"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Entite getEntite() {
		return this.entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	@Column(name = "NOM", nullable = false, length = 65535)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "BUREAU", length = 65535)
	public String getBureau() {
		return this.bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

}
