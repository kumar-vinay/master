package com.sales.message.parser;

public class ParsedMessage {
	
	    //identifies and stores each component of the message in its properties
		private String prodType;
		private String adjustmentOperator;
		private double prdPrice;
		private int prdQuantity;
		
		public ParsedMessage(){
			super();
			this.prodType = "";
			this.adjustmentOperator = "";
			this.prdPrice = 0;
			this.prdQuantity = 0;
			
		}
		public String getProdType() {
			return prodType;
		}

		public String getAdjustmentOperator() {
			return adjustmentOperator;
		}

		public double getPrdPrice() {
			return prdPrice;
		}

		public int getPrdQuantity() {
			return prdQuantity;
		}

		public void setProdType(String prodType) {
			this.prodType = prodType;
		}

		public void setAdjustmentOperator(String adjustmentOperator) {
			this.adjustmentOperator = adjustmentOperator;
		}

		public void setPrdPrice(double prdPrice) {
			this.prdPrice = prdPrice;
		}

		public void setPrdQuantity(int prdQuantity) {
			this.prdQuantity = prdQuantity;
		}
		@Override
		public String toString() {
			return "ParsedMessage [prodType=" + prodType + ", adjustmentOperator=" + adjustmentOperator + ", prdPrice="
					+ prdPrice + ", prdQuantity=" + prdQuantity + "]";
		}
}
