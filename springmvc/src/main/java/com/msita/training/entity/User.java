package com.msita.training.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name="user", schema="cafedb")
public class User implements Serializable{
	@Id
	@Column(name="iduser")
	private String idUser;
	
	@Column(name="idrole")
	private String idRole;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idRole", nullable=false, insertable=false, updatable=false)
	private Role role;	
	
//	@JsonIgnoreProperties("user")
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.EAGER)
//	private List<Order> lstorder;

	
	
	
	
			/*	 GETTER - SETTER	*/
	
//	public List<Order> getLstorder() {
//		return lstorder;
//	}
//	public void setLstorder(List<Order> lstorder) {
//		this.lstorder = lstorder;
//	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
