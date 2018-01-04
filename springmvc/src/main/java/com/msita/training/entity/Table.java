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

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="table", schema="cafedb")
public class Table implements Serializable {
	@Id
	@Column(name="idtable")
	private int idTable;
	
	@Column(name="type")
	private String type;
	
	@JsonIgnoreProperties("table")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="table", fetch=FetchType.EAGER)
	private List<Order> lstOrder;
	
	@JsonIgnoreProperties("table")
	public Order getOrderNotPay() {
		for(Order order:lstOrder) {
			if(order.getIdStatus().equals("CTT")) {
				return order;
			}
		}
		return null;
	}

	/*	 GETTER - SETTER	*/
	public int getIdTable() {
		return idTable;
	}
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Order> getLstOrder() {
		return lstOrder;
	}
	public void setLstOrder(List<Order> lstOrder) {
		this.lstOrder = lstOrder;
	}
	
}

