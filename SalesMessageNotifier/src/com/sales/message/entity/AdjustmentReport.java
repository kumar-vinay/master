package com.sales.message.entity;

public class AdjustmentReport {
	
	private String prdType;
	private double totalPrice;
	private double prdPrice;
	private double adjustedPrice;
	private int totalQty;
	
	
	 AdjustmentReport(String prdType, double totalPrice, double prdPrice, double adjustedPrice, int totalQty) {
		super();
		this.prdType = prdType;
		this.totalPrice = totalPrice;
		this.prdPrice = prdPrice;
		this.adjustedPrice = adjustedPrice;
		this.totalQty = totalQty;
	}


	@Override
	public String toString() {
		return "[prdType=" + prdType + ", totalPrice=" + String.format("%.2fp", totalPrice) + ", prdPrice=" + String.format("%.2fp", prdPrice)
				+ ", adjustedPrice=" +  String.format("%.2fp", adjustedPrice) + ", totalQty=" + totalQty + "]";
	}

}
