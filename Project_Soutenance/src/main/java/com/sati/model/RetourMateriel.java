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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RetourMateriel generated by hbm2java
 */
@Entity
@Table(name = "retour_materiel", catalog = "bd_gestoinpatrimoine")
public class RetourMateriel implements java.io.Serializable {

	private Integer idRetourmateriel;
	private SortirMateriel sortirMateriel;
	private Set<SortirMateriel> sortirMateriels = new HashSet<SortirMateriel>(0);

	public RetourMateriel() {
	}

	public RetourMateriel(SortirMateriel sortirMateriel) {
		this.sortirMateriel = sortirMateriel;
	}

	public RetourMateriel(SortirMateriel sortirMateriel, Set<SortirMateriel> sortirMateriels) {
		this.sortirMateriel = sortirMateriel;
		this.sortirMateriels = sortirMateriels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_RETOURMATERIEL", unique = true, nullable = false)
	public Integer getIdRetourmateriel() {
		return this.idRetourmateriel;
	}

	public void setIdRetourmateriel(Integer idRetourmateriel) {
		this.idRetourmateriel = idRetourmateriel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SORTIR", nullable = false)
	public SortirMateriel getSortirMateriel() {
		return this.sortirMateriel;
	}

	public void setSortirMateriel(SortirMateriel sortirMateriel) {
		this.sortirMateriel = sortirMateriel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "retourMateriel")
	public Set<SortirMateriel> getSortirMateriels() {
		return this.sortirMateriels;
	}

	public void setSortirMateriels(Set<SortirMateriel> sortirMateriels) {
		this.sortirMateriels = sortirMateriels;
	}

}
