package com.igate.dto;

import java.util.Date;

public class Order {
int orderId;
String productName;
int quantity;
Date orderDate;
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", productName=" + productName
			+ ", quantity=" + quantity + ", orderDate=" + orderDate + "]";
}
public Order(int orderId, String productName, int quantity, Date orderDate) {
	super();
	this.orderId = orderId;
	this.productName = productName;
	this.quantity = quantity;
	this.orderDate = orderDate;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
}
