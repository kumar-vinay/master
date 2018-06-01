package com.sales.message.controller.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sales.message.controller.SalesMessageController;
import com.sales.message.entity.Product;
import com.sales.message.parser.ParsedMessage;

import org.junit.Assert;



public class ControllerTest {
	
	static SalesMessageController objSMController = null;
	
	@BeforeClass
	public static void instantiateClass(){
		objSMController = new SalesMessageController();	
	}

	@Test
	public void processMessagesForNotification_withNoSaleMessage() {
		
		ParsedMessage obj = new ParsedMessage();
		Assert.assertEquals(false,objSMController.processMessagesForNotification(obj, null));
	
	}
	@Test
	public void TestsetProductTotalPrice() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		Product prd = new Product("apple");
		prd.setPrdQty(12);
		prd.setPrdPrice(10);
		objSMController.setProduct(prd);
		 
	        Method method1 = SalesMessageController.class.getDeclaredMethod("setProductTotalPrice");
	        method1.setAccessible(true);
	        method1.invoke(objSMController);
	        Assert.assertEquals(120.0,prd.getTotalPrice(),2);
		
	}

}
