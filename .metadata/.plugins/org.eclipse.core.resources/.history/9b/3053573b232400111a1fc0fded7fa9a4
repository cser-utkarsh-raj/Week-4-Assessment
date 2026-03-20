package com.capgemini.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "foodorder")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String customerName;
    private String foodItem;
    private Integer quantity;

    private String status;

    public Order() {}

	public Order(Integer orderId, String customerName, String foodItem, Integer quantity, String status) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.foodItem = foodItem;
		this.quantity = quantity;
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", foodItem=" + foodItem + ", quantity="
				+ quantity + ", status=" + status + "]";
	}

    
}