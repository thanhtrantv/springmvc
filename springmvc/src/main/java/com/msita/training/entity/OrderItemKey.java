package com.msita.training.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class OrderItemKey implements Serializable{
	
	@Column(name="idorder")
	private String idOrder;
	
	@Column(name="iditem")
	private String idItem;
	
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
}
