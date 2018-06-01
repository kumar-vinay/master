package com.sales.message.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.sales.message.controller.SalesMessageController;
import com.sales.message.parser.MessageParser;
import com.sales.message.parser.ParsedMessage;

class TextFileReader implements IFileReader {

	private final static Logger logger = Logger.getLogger(TextFileReader.class);
	@Override
	public void processFileContent(File file) {

		String singleLine;
		MessageParser messageParser ;
		ParsedMessage parsedMessage;
		logger.info("ProcessFileContent with input file " + file.getName());
		
		SalesMessageController objSalesController = new SalesMessageController();
		logger.info("SalesMessageController instance created ");
		
		try( BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			messageParser = new MessageParser();
			
			while((singleLine = bufferedReader.readLine()) != null) {
				parsedMessage = messageParser.parseMessage(singleLine);
				objSalesController.processMessagesForNotification(parsedMessage,singleLine);
			}
		}
		catch(IOException ex){
			logger.error("IOException in processFileContent " + ex.getMessage());
		}
		
	}
}
