package com.msita.training.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_item", schema = "cafedb")
public class OrderItem {
	@EmbeddedId
	private OrderItemKey key;
	
	@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="iditem",referencedColumnName="iditem",
				nullable = false, insertable = false, updatable = false)
	private Item item;
	
	@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idorder",referencedColumnName="idorder",
				nullable = false, insertable = false, updatable = false)
	private Order order;

	@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idstatus",referencedColumnName="idstatus",
				nullable = false, insertable = false, updatable = false)
	private Status status;
	
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public OrderItemKey getKey() {
		return key;
	}

	public void setKey(OrderItemKey key) {
		this.key = key;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
