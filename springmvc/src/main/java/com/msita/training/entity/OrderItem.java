package com.msita.training.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="order_item", schema="cafedb")
public class OrderItem implements Serializable{

	@EmbeddedId
	private OrderItemKey key;
	
	@Column(name="time")
	private Timestamp time;
	
	@Column(name="idStatus")
	private String idStatus;
	
	@JsonIgnoreProperties("lstOrderItem")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idItem", nullable=false, insertable=false, updatable=false)
	private Item item;
//	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idstatus",referencedColumnName="idstatus", nullable=false, insertable=false, updatable=false)
	private Status status;
//	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idOrder", nullable=false, insertable=false, updatable=false)
	private Order order;


			/*	 GETTER - SETTER	*/
	
	
	public Timestamp getTime() {
		return time;
	}
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public OrderItemKey getKey() {
		return key;
	}
	public void setKey(OrderItemKey key) {
		this.key = key;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}