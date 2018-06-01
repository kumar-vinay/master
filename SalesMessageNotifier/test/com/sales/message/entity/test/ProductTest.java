package com.sales.message.entity.test;

import org.junit.Test;
import com.sales.message.entity.Product;
import org.junit.Assert;

public class ProductTest {

	@Test
	public void setTotalQuantity_withNoInitialQuantity() {
		Product obj = new Product("apple");
		obj.setTotalQuantity(12);
		Assert.assertEquals(12, obj.getTotalQty());
	}
	
	@Test
	public void setTotalQuantity_withSomeInitialQuantity() {
		Product obj = new Product("apple");
		obj.setTotalQuantity(5);
		obj.setTotalQuantity(12);
		Assert.assertEquals(17, obj.getTotalQty());
	}

	@Test
	public void setTotalQuantity_deductionQuantity() {
		Product obj = new Product("apple");
		obj.setTotalQuantity(5);
		obj.setTotalQuantity(-2);
		Assert.assertEquals(3, obj.getTotalQty());
	}
}
