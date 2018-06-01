package com.sales.message.entity;

import org.apache.log4j.Logger;

import com.sales.message.util.SalesConstants;

public class PriceAdjust {

	private final static Logger logger = Logger.getLogger(PriceAdjust.class);
	
    private double adjustedPrice;
    private Product product;

    public PriceAdjust(Product product) {
        this.product = product;
        this.adjustedPrice = 0.0;
    }

    
    public double getPriceAdjusted() {
    	 
        String adjustmentMethod = product.getAdjustOperator().toLowerCase();
        logger.info("GetPriceAdjusted with adjustmentMethod " + adjustmentMethod);
        
        if(SalesConstants.ADD_OPERATOR.equalsIgnoreCase(adjustmentMethod))
        	addToPrice();
        else if(SalesConstants.SUB_OPERATOR.equalsIgnoreCase(adjustmentMethod))
        	subtractFromPrice();
        else if(SalesConstants.MULT_OPERATOR.equalsIgnoreCase(adjustmentMethod))
        	multiplyToPrice();
        else
        	System.out.println("Wrong Adjustment method");
        
        return adjustedPrice;
    }

    private double addToPrice() {
       return this.adjustedPrice = this.product.getTotalPrice() + ( this.product.getTotalQty() * this.product.getPrdPrice() );
    }

    private double subtractFromPrice() {
        return this.adjustedPrice = this.product.getTotalPrice() - (this.product.getTotalQty() * this.product.getPrdPrice());
    }

    private double multiplyToPrice() {
       return this.adjustedPrice = this.product.getTotalPrice() +
                (this.product.getTotalPrice() * this.product.getPrdPrice()) +
                (this.product.getTotalQty() * this.product.getPrdPrice());
    }

    public AdjustmentReport adjustmentReport(){
    	AdjustmentReport objAdjustmentReport = null;
        objAdjustmentReport = new AdjustmentReport(this.product.getPrdType(), this.product.getTotalPrice(), this.product.getPrdPrice(), this.adjustedPrice, this.product.getTotalQty());
        return objAdjustmentReport;
    }



}
