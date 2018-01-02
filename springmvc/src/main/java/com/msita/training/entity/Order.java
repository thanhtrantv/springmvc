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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order", schema = "cafedb")
public class Order {
	@Id
	@Column(name="idorder")
	private String orderId;
	
//	///@JsonManagedReference
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="iduser", nullable = false, insertable = false, updatable = false)
//	private User user;
	
//	@JsonManagedReference
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="idstatus", nullable = false, insertable = false, updatable = false)
//	private Status status;
//
////	@JsonBackReference
//	@OneToMany(mappedBy="order")
//	private List<OrderItem> lstOrderItem;
	
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idtable",referencedColumnName = "idtable",nullable = false, insertable = false, updatable = false)
	private com.msita.training.entity.Table table;
	
	@Column(name="sum")
	private Double sum;

	public com.msita.training.entity.Table getTable() {
		return table;
	}

	public void setTable(com.msita.training.entity.Table table) {
		this.table = table;
	}

//	public List<OrderItem> getLstOrderItem() {
//		return lstOrderItem;
//	}
//
//	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
//		this.lstOrderItem = lstOrderItem;
//	}
//
//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//
//	public String getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
}
