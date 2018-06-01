package com.sales.message.entity;

public class Product {
	
	private String prdType;
	private int prdQty;
	private double prdPrice;
	private String adjustOperator;
	private int totalQty;
	private double totalPrice;
	
	public Product(String prdType) {
		this.prdType = prdType;
		this.prdQty = 0;
		this.prdPrice = 0.0;
		this.totalPrice = 0.0;
		this.adjustOperator = "";
	}
	
    public void appendTotalPrice(double productPrice) {
        this.totalPrice += productPrice;
    }

    public void setTotalQuantity(int quantity){
        this.totalQty += quantity;
    }
    
    public double calculatePrice(int productQuantity, double productPrice){
        return productQuantity * productPrice;
    }

	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}

	public int getPrdQty() {
		return prdQty;
	}

	public void setPrdQty(int prdQty) {
		this.prdQty = prdQty;
	}

	public double getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(double prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getAdjustOperator() {
		return adjustOperator;
	}

	public void setAdjustOperator(String adjustOperator) {
		this.adjustOperator = adjustOperator;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
