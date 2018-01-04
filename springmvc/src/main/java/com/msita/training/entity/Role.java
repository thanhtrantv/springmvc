package com.msita.training.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="role", schema="cafedb")
public class Role implements Serializable{
	@Id
	@Column(name="idRole")
	private String idRole;
	
	@Column(name="namerole")
	private String namerole;
	
	@JsonIgnoreProperties("role")	/* role la ten bien (Role role) trong bang User */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="role", fetch=FetchType.EAGER)
	private List<User> lstUser;

	
	
	
			/*	 GETTER - SETTER	*/
	
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getNamerole() {
		return namerole;
	}
	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}
	public List<User> getLstUser() {
		return lstUser;
	}
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}
}

