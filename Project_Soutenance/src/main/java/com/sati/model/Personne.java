package com.sati.model;
// Generated 7 nov. 2022 ? 12:20:01 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Personne generated by hbm2java
 */
@Entity
@Table(name = "personne", catalog = "bd_gestoinpatrimoine")
public class Personne implements java.io.Serializable {

	private int id;
	private Entite entite;
	private Users users;
	private String nom;
	private String fonction;
	private String prenoms;
	private String adresse;
	private long numTel;
	private String email;
	private Set<EntrerMateriel> entrerMateriels = new HashSet<EntrerMateriel>(0);
	private Set<EtatDemande> etatDemandes = new HashSet<EtatDemande>(0);

	public Personne() {
	}

	public Personne(Entite entite, Users users, String nom, String fonction, String prenoms, String adresse,
			long numTel, String email) {
		this.entite = entite;
		this.users = users;
		this.nom = nom;
		this.fonction = fonction;
		this.prenoms = prenoms;
		this.adresse = adresse;
		this.numTel = numTel;
		this.email = email;
	}

	public Personne(Entite entite, Users users, String nom, String fonction, String prenoms, String adresse,
			long numTel, String email, Set<EntrerMateriel> entrerMateriels, Set<EtatDemande> etatDemandes) {
		this.entite = entite;
		this.users = users;
		this.nom = nom;
		this.fonction = fonction;
		this.prenoms = prenoms;
		this.adresse = adresse;
		this.numTel = numTel;
		this.email = email;
		this.entrerMateriels = entrerMateriels;
		this.etatDemandes = etatDemandes;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USERS", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "NOM", nullable = false, length = 65535)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "FONCTION", nullable = false, length = 65535)
	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	@Column(name = "PRENOMS", nullable = false, length = 65535)
	public String getPrenoms() {
		return this.prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	@Column(name = "ADRESSE", nullable = false, length = 65535)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "NUM_TEL", nullable = false)
	public long getNumTel() {
		return this.numTel;
	}

	public void setNumTel(long numTel) {
		this.numTel = numTel;
	}

	@Column(name = "EMAIL", nullable = false, length = 65535)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<EntrerMateriel> getEntrerMateriels() {
		return this.entrerMateriels;
	}

	public void setEntrerMateriels(Set<EntrerMateriel> entrerMateriels) {
		this.entrerMateriels = entrerMateriels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<EtatDemande> getEtatDemandes() {
		return this.etatDemandes;
	}

	public void setEtatDemandes(Set<EtatDemande> etatDemandes) {
		this.etatDemandes = etatDemandes;
	}

}
