package com.sales.message.parser;

import org.apache.log4j.Logger;

public class MessageParser {

	private final static Logger logger = Logger.getLogger(MessageParser.class);
	private ParsedMessage messageParsed = null;

	public MessageParser(){

	}

	public ParsedMessage parseMessage(String message){
		logger.info("Enter parseMessage with messge " + message);
		messageParsed = new ParsedMessage();

		if (message == null || message.isEmpty()) {
			logger.error("ParseMessage input message is empty");
			return null;
		}
		String[] messageArray = message.trim().split("\\s+");

		String startsWith = messageArray[0];
		if (startsWith.matches("Add|Subtract|Multiply")) {
			parseMessageType3(message);
		} else if (startsWith.matches("^\\d+")) {
			parseMessageType2(message);
		} else if (messageArray.length == 3 && messageArray[1].contains("at")) {
			parseMessageType1(message);
		} else {
			logger.info("Wrong input sales message");
		}
		return messageParsed;
	}

	private boolean parseMessageType1(String message) {
		
		String[] messageArray = message.trim().split("\\s+");
		if(messageArray.length > 3 || messageArray.length < 3) return false;
		messageParsed.setProdType(parseFruitType(messageArray[0]));
		messageParsed.setPrdPrice(parsePrice(messageArray[2]));
		messageParsed.setPrdQuantity(1);
		return true;
	}

	private boolean parseMessageType2(String message) {
		
		String[] messageArray = message.trim().split("\\s+");
		if(messageArray.length > 7 || messageArray.length < 7) return false;
		messageParsed.setProdType(parseFruitType(messageArray[3]));
		messageParsed.setPrdPrice(parsePrice(messageArray[5]));
		messageParsed.setPrdQuantity(Integer.parseInt(messageArray[0]));
		return true;
	}

	private boolean parseMessageType3(String message) {
		
		String[] messageArray = message.trim().split("\\s+");
		if(messageArray.length > 3 || messageArray.length < 3) return false;
		messageParsed.setAdjustmentOperator(messageArray[0]);
		messageParsed.setProdType(parseFruitType(messageArray[2]));
		messageParsed.setPrdQuantity(0); 
		messageParsed.setPrdPrice(parsePrice(messageArray[1]));
		return true;
	}

        String parseFruitType(String rawType) {
		String parsedType = "";
		String typeWithoutLastChar = rawType.substring(0, rawType.length() - 1);

		if (rawType.endsWith("o")) {
			parsedType = String.format("%soes", typeWithoutLastChar);
		} else if (rawType.endsWith("y")) {
			parsedType = String.format("%sies", typeWithoutLastChar);
		} else if (rawType.endsWith("h")) {
			parsedType = String.format("%shes", typeWithoutLastChar);
		} else if (!rawType.endsWith("s")) {
			parsedType = String.format("%ss", rawType);
		} else {
			parsedType = String.format("%s", rawType);
		}
		return parsedType.toLowerCase();
	}

	private double parsePrice(String rawPrice) {
		double price = Double.parseDouble(rawPrice.replaceAll("p", ""));
		if (!rawPrice.contains(".")) {
			price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
		}
		return price;
	}
}
