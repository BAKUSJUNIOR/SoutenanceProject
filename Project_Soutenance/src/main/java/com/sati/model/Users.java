package com.sati.model;
// Generated 17 oct. 2022 � 19:09:55 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "bd_gestoinpatrimoine")
public class Users implements java.io.Serializable {

	private Integer idUsers;
	private String username;
	private String password;
	private String active;
	private Set<Personne> personnes = new HashSet<Personne>(0);
	private Set<Role> roles = new HashSet<Role>(0);

	public Users() {
	}

	public Users(String username, String password, String active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Users(String username, String password, String active, Set<Personne> personnes, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.active = active;
		this.personnes = personnes;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_USERS", unique = true, nullable = false)
	public Integer getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(Integer idUsers) {
		this.idUsers = idUsers;
	}

	@Column(name = "USERNAME", nullable = false, length = 65535)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 65535)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ACTIVE", nullable = false, length = 65535)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userses")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
