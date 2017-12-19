package com.msita.training.vo;

import java.util.List;

public class Order {
	private Table table;
	private User user;
	private String orderId;
	private double sum;
	private Status statusOrder;
	private List<OrderItem> lstOrderItem;
	
	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}
	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Status getStatusOrder() {
		return statusOrder;
	}
	public void setStatusOrder(Status statusOrder) {
		this.statusOrder = statusOrder;
	}
	
}
