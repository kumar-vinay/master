package com.sales.message.controller;

import org.apache.log4j.Logger;

import com.sales.message.entity.PriceAdjust;
import com.sales.message.entity.Product;
import com.sales.message.logger.SalesMessageLogger;
import com.sales.message.parser.ParsedMessage;

public class SalesMessageController {

	private SalesMessageLogger salesMessageLogger;
	private Product product;
	private PriceAdjust adjustedPrice ;
	
	private final static Logger logger = Logger.getLogger(SalesMessageController.class);

	public SalesMessageController(){

		salesMessageLogger = new SalesMessageLogger();
	}
	public boolean processMessagesForNotification(ParsedMessage parsedMessage, String singleLine){
		
		logger.debug("ProcessMessagesForNotification with input " + singleLine);
		String productType = parsedMessage.getProdType();
		if (productType.isEmpty()) {
			logger.debug("Product type is empty");
			return false;
		}

		this.product = salesMessageLogger.getProduct(productType);
		
		if(!parsedMessage.getAdjustmentOperator().isEmpty()){
			this.adjustedPrice = new PriceAdjust(product);
		}
		
        this.product.setPrdQty(parsedMessage.getPrdQuantity());
        this.product.setTotalQuantity(parsedMessage.getPrdQuantity());
        this.product.setPrdPrice(parsedMessage.getPrdPrice());
        this.product.setAdjustOperator(parsedMessage.getAdjustmentOperator());
        
        setProductTotalPrice();

        salesMessageLogger.setSoldEntries(singleLine);
        salesMessageLogger.updateProduct(product);
        
        salesMessageLogger.logSalesEntries();
        return true;

	}
	
	 private void setProductTotalPrice() {
		 
	        double adjPrice;
	        double productValue;

	        if (!product.getAdjustOperator().isEmpty()) {
	        	adjPrice = adjustedPrice.getPriceAdjusted();
	        	salesMessageLogger.setAdjustementEntries(adjustedPrice.adjustmentReport());
	        	logger.debug("Adjustment price " + adjPrice + "for product " + product.getPrdType());
	            product.setTotalPrice(adjPrice);
	            
	        } else {
	            productValue = product.calculatePrice(product.getPrdQty(), product.getPrdPrice());
	            logger.debug("Total price " + productValue + "for product " + product.getPrdType());
	            product.appendTotalPrice(productValue);
	        }
	 }
	 
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}

