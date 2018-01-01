package com.msita.training.entity;

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

@Entity
@Table(name = "item", schema = "cafedb")
public class Item {
	@Id
	@Column(name="iditem")
	private String idItem;
	
	@Column(name="name")
	private String name;
	
	@Column(name="money")
	private double money;
	
	@JsonIgnoreProperties(value="item")
	@OneToMany(mappedBy="item")
	private List<OrderItem> lstOrderItem;

	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}

	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
