package com.sales.message.parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MessageParserTest {
	
	static MessageParser objMarsher = null;
	
	@BeforeClass
    public static void beforeClass() {
		objMarsher = new MessageParser();
    }
	@Test
	public void test_parseMessage_forNoInput(){
		Assert.assertNull(objMarsher.parseMessage(null));
	}
	
	@Test
	public void test_parseMessage_forMessageType1(){
		String message = "apple at 10p";
		Assert.assertNotNull(objMarsher.parseMessage(message));
	}
	
	@Test
	public void test_parseFruitType(){
		String fruitType = "apples";
		Assert.assertEquals(fruitType, objMarsher.parseFruitType(fruitType));
	}
	@Test
	public void test_parseMessage_forMessageType2(){
		String message = "20 sales of apples at 10p each";
		Assert.assertNotNull(objMarsher.parseMessage(message));
	}
	
	@Test
	public void test_parseMessage_forMessageType3(){
		String message = "Add 20 apples";
		Assert.assertNotNull(objMarsher.parseMessage(message));
	}
	
	@Ignore
	public void test_parseMessageType1_invalidLength() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		MessageParser objMarsher1 = new MessageParser();
		String input = "apple at ";
        Method method = MessageParser.class.getDeclaredMethod("parseMessageType1",String.class);
        method.setAccessible(true);
        Assert.assertEquals(false, (boolean) method.invoke(objMarsher1, input));
        
	}
	
	@Test
	public void test_parseMessageType2_invalidLength() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		MessageParser objMarsher1 = new MessageParser();
		String input = "add 20p to  ";
        Method method = MessageParser.class.getDeclaredMethod("parseMessageType2",String.class);
        method.setAccessible(true);
        Assert.assertEquals(false, (boolean) method.invoke(objMarsher1, input));
        
	}
	
	@Test
	public void test_parseMessageType3_invalidLength() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		MessageParser objMarsher1 = new MessageParser();
		String input = "add 20 ";
        Method method = MessageParser.class.getDeclaredMethod("parseMessageType3",String.class);
        method.setAccessible(true);
        Assert.assertEquals(false, (boolean) method.invoke(objMarsher1, input));
        
	}
}
