package com.sales.message.reader;

import java.io.File;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.sales.message.util.SalesConstants;

 class FileRouter {

	private final static Logger logger = Logger.getLogger(FileRouter.class);
	private static IFileReader fileReader = null;

	static void callSpecificReader(File inputFile){

		logger.info("Enter method callSpecificReader with input file " + inputFile.getName());
		if(Objects.nonNull(inputFile)){
			String fileNameParts[] = inputFile.getName().split("\\.");
			String extension = fileNameParts[fileNameParts.length-1];
			logger.debug("CallSpecificReader with input file");
			
			if( SalesConstants.CSV_FILE.equalsIgnoreCase(extension))
				fileReader = new CSVFileReader();
			else if( SalesConstants.TXT_FILE.equalsIgnoreCase(extension))
				fileReader = new TextFileReader();

			fileReader.processFileContent(inputFile);
		}
		else{
			logger.error("File error while reading input sales data ");
		}
	}
}
