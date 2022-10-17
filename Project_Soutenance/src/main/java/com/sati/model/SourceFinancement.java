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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SourceFinancement generated by hbm2java
 */
@Entity
@Table(name = "source_financement", catalog = "bd_gestoinpatrimoine")
public class SourceFinancement implements java.io.Serializable {

	private Integer idDon;
	private String donateur;
	private Date dateDon;
	private Set<EntrerMateriel> entrerMateriels = new HashSet<EntrerMateriel>(0);

	public SourceFinancement() {
	}

	public SourceFinancement(String donateur) {
		this.donateur = donateur;
	}

	public SourceFinancement(String donateur, Date dateDon, Set<EntrerMateriel> entrerMateriels) {
		this.donateur = donateur;
		this.dateDon = dateDon;
		this.entrerMateriels = entrerMateriels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_DON", unique = true, nullable = false)
	public Integer getIdDon() {
		return this.idDon;
	}

	public void setIdDon(Integer idDon) {
		this.idDon = idDon;
	}

	@Column(name = "DONATEUR", nullable = false, length = 30)
	public String getDonateur() {
		return this.donateur;
	}

	public void setDonateur(String donateur) {
		this.donateur = donateur;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_DON", length = 19)
	public Date getDateDon() {
		return this.dateDon;
	}

	public void setDateDon(Date dateDon) {
		this.dateDon = dateDon;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "provenir2", catalog = "bd_gestoinpatrimoine", joinColumns = {
			@JoinColumn(name = "ID_DON", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_ENTRER", nullable = false, updatable = false) })
	public Set<EntrerMateriel> getEntrerMateriels() {
		return this.entrerMateriels;
	}

	public void setEntrerMateriels(Set<EntrerMateriel> entrerMateriels) {
		this.entrerMateriels = entrerMateriels;
	}

}
