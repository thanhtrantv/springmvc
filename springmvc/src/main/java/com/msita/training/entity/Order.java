package com.msita.training.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="order", schema="cafedb")
public class Order implements Serializable {	
	@Id
	@Column(name="idorder")
	private String idOrder;
	
	@Column(name="idstatus")
	private String idStatus;

	@Column(name="sum")
	private double sum;
	
	@Column(name="idtable")
	private int idTable;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idtable",referencedColumnName="idtable", nullable=false, insertable=false, updatable=false)
	private Table table;

	@JsonIgnoreProperties("order")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order", fetch=FetchType.EAGER)
	private List<OrderItem> lstOrderItem;
	
	public int getIdTable() {
		return idTable;
	}
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}
	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}

}
