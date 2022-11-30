package com.sati.model;
// Generated 7 nov. 2022 � 12:20:01 by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fournisseur generated by hbm2java
 */
@Entity
@Table(name = "fournisseur", catalog = "bd_gestoinpatrimoine")
public class Fournisseur implements java.io.Serializable {

	private Integer idFournisseur;
	private String nomFournisseur;
	private Date dateFounissions;
	private Set<EntrerMateriel> entrerMateriels = new HashSet<EntrerMateriel>(0);

	public Fournisseur() {
	}

	public Fournisseur(String nomFournisseur, Date dateFounissions) {
		this.nomFournisseur = nomFournisseur;
		this.dateFounissions = dateFounissions;
	}

	public Fournisseur(String nomFournisseur, Date dateFounissions, Set<EntrerMateriel> entrerMateriels) {
		this.nomFournisseur = nomFournisseur;
		this.dateFounissions = dateFounissions;
		this.entrerMateriels = entrerMateriels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_FOURNISSEUR", unique = true, nullable = false)
	public Integer getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	@Column(name = "NOM_FOURNISSEUR", nullable = false, length = 65535)
	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FOUNISSIONS", nullable = false, length = 19)
	public Date getDateFounissions() {
		return this.dateFounissions;
	}

	public void setDateFounissions(Date dateFounissions) {
		this.dateFounissions = dateFounissions;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "provenir", catalog = "bd_gestoinpatrimoine", joinColumns = {
			@JoinColumn(name = "ID_FOURNISSEUR", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_ENTRER", nullable = false, updatable = false) })
	public Set<EntrerMateriel> getEntrerMateriels() {
		return this.entrerMateriels;
	}

	public void setEntrerMateriels(Set<EntrerMateriel> entrerMateriels) {
		this.entrerMateriels = entrerMateriels;
	}

}
