package com.msita.training.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user", schema = "cafedb")
public class User implements Serializable{
	@Id
	@Column(name = "iduser")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="idrole")
	private String idrole;
	
	@Column(name="name")
	private String fullName;
	
//	@JsonIgnoreProperties(value="user")
//	//@JsonBackReference
//	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
//	private List<Order> lstOrder;
//
//	public List<Order> getLstOrder() {
//		return lstOrder;
//	}
//
//	public void setLstOrder(List<Order> lstOrder) {
//		this.lstOrder = lstOrder;
//	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdrole() {
		return idrole;
	}

	public void setIdrole(String idrole) {
		this.idrole = idrole;
	}
	
	
}
