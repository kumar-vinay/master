package com.sales.message.priceadjust.test;

import org.junit.Assert;
import org.junit.Test;

import com.sales.message.entity.PriceAdjust;
import com.sales.message.entity.Product;

public class PriceAdjustTest {
    
	@Test
	public void testAdd_getPriceAdjusted() {
		
		Product prd = new Product("apples");
		prd.setAdjustOperator("Add");
		prd.setTotalPrice(10.0);
		prd.setTotalQuantity(5);
		prd.setPrdPrice(2.0);
		PriceAdjust priceAdjust = new PriceAdjust(prd);
		Assert.assertEquals(20, priceAdjust.getPriceAdjusted(),2);
	    
	}
	
	@Test
	public void testSub_getPriceAdjusted() {
		
		Product prd = new Product("apples");
		prd.setAdjustOperator("Subtract");
		prd.setTotalPrice(10.0);
		prd.setTotalQuantity(5);
		prd.setPrdPrice(2.0);
		PriceAdjust priceAdjust = new PriceAdjust(prd);
		Assert.assertEquals(0, priceAdjust.getPriceAdjusted(),2);
	    
	}
	
	@Test
	public void testMult_getPriceAdjusted() {
		
		Product prd = new Product("apples");
		prd.setAdjustOperator("Multiply");
		prd.setTotalPrice(10.0);
		prd.setTotalQuantity(5);
		prd.setPrdPrice(2.0);
		PriceAdjust priceAdjust = new PriceAdjust(prd);
		Assert.assertEquals(40, priceAdjust.getPriceAdjusted(),2);
	    
	}
	@Test
	public void testInvalidOperatior_getPriceAdjusted() {
		
		Product prd = new Product("apples");
		prd.setAdjustOperator("jouy");
		prd.setTotalPrice(10.0);
		prd.setTotalQuantity(5);
		prd.setPrdPrice(2.0);
		PriceAdjust priceAdjust = new PriceAdjust(prd);
		Assert.assertEquals(0, priceAdjust.getPriceAdjusted(),2);
	    
	}

}
