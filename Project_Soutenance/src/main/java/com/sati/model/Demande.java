package com.sati.model;
// Generated 17 oct. 2022 � 19:09:55 by Hibernate Tools 4.3.6.Final

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Demande generated by hbm2java
 */
@Entity
@Table(name = "demande", catalog = "bd_gestoinpatrimoine")
public class Demande implements java.io.Serializable {

	private Integer idDemande;
	private Entite entite;
	private EtatDemande etatDemande;
	private Materiels materiels;
	private SortirMateriel sortirMateriel;
	private String motif;
	private String designation;
	private Date date;
	private Set<SortirMateriel> sortirMateriels = new HashSet<SortirMateriel>(0);

	public Demande() {
	}

	public Demande(Entite entite, EtatDemande etatDemande, Materiels materiels, String motif, String designation) {
		this.entite = entite;
		this.etatDemande = etatDemande;
		this.materiels = materiels;
		this.motif = motif;
		this.designation = designation;
	}

	public Demande(Entite entite, EtatDemande etatDemande, Materiels materiels, SortirMateriel sortirMateriel,
			String motif, String designation, Date date, Set<SortirMateriel> sortirMateriels) {
		this.entite = entite;
		this.etatDemande = etatDemande;
		this.materiels = materiels;
		this.sortirMateriel = sortirMateriel;
		this.motif = motif;
		this.designation = designation;
		this.date = date;
		this.sortirMateriels = sortirMateriels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_DEMANDE", unique = true, nullable = false)
	public Integer getIdDemande() {
		return this.idDemande;
	}

	public void setIdDemande(Integer idDemande) {
		this.idDemande = idDemande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID", nullable = false)
	public Entite getEntite() {
		return this.entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "E", nullable = false)
	public EtatDemande getEtatDemande() {
		return this.etatDemande;
	}

	public void setEtatDemande(EtatDemande etatDemande) {
		this.etatDemande = etatDemande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATERIEL", nullable = false)
	public Materiels getMateriels() {
		return this.materiels;
	}

	public void setMateriels(Materiels materiels) {
		this.materiels = materiels;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SORTIR")
	public SortirMateriel getSortirMateriel() {
		return this.sortirMateriel;
	}

	public void setSortirMateriel(SortirMateriel sortirMateriel) {
		this.sortirMateriel = sortirMateriel;
	}

	@Column(name = "MOTIF", nullable = false, length = 65535)
	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	@Column(name = "DESIGNATION", nullable = false, length = 65535)
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "demande")
	public Set<SortirMateriel> getSortirMateriels() {
		return this.sortirMateriels;
	}

	public void setSortirMateriels(Set<SortirMateriel> sortirMateriels) {
		this.sortirMateriels = sortirMateriels;
	}

}