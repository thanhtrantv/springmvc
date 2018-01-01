package com.msita.training.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "status", schema = "cafedb")
public class Status {
	@Id
	@Column(name = "idstatus")
	private String idStatus;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnoreProperties(value="status")
	@OneToMany(cascade=CascadeType.ALL,
			mappedBy="status")
	private List<Order> orderStatus;
	
	@JsonIgnoreProperties(value="status")
	@OneToMany(cascade=CascadeType.ALL,
			mappedBy="status")
	private List<OrderItem> lstOrderItem;
	
	public List<Order> getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(List<Order> orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIdStatus() {
		return idStatus;
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
	
	
}
