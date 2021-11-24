package com.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Table_or")

public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int orderid;
	
	private String customerName;
	
	private String customerAddress;
	
	private String orderStatus;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private int pro_id;
	private int quantity;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order(int orderid, String customerName, String customerAddress, String orderStatus, Date orderDate,
			int pro_id, int quantity) {
		super();
		this.orderid = orderid;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.pro_id = pro_id;
		this.quantity = quantity;
	}

	public String toString() {
		return "Order [customerName=" + customerName + ", customerAddress=" + customerAddress + ", orderStatus="
				+ orderStatus + ", orderDate=" + orderDate + ", pro_id=" + pro_id + ", quantity=" + quantity + "]";
	}
	
	
	public Order() {}
	public void setCreationDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
