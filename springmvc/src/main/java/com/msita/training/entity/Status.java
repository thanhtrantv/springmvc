package com.msita.training.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name="status", schema="cafedb")
public class Status implements Serializable{
	@Id
	@Column(name="idstatus")
	private String idStatus;
	
	@Column(name="name")
	private String name;
	
	
//	@JsonIgnoreProperties("statusOrder")
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="statusOrder", fetch=FetchType.EAGER)
//	private List<Order> lstorder;
//	
	@JsonBackReference
	@JsonIgnoreProperties("status")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="status", fetch=FetchType.EAGER)
	private List<OrderItem> lstOrderItem;
//
//	
	
		/*	 GETTER - SETTER	*/
		
	public String getIdStatus() {
		return idStatus;
	}
	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}
	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<Order> getLstorder() {
//		return lstorder;
//	}
//	public void setLstorder(List<Order> lstorder) {
//		this.lstorder = lstorder;
//	}
//	public List<OrderItem> getLstOrderItem() {
//		return lstOrderItem;
//	}
//	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
//		this.lstOrderItem = lstOrderItem;
//	}
}
