package com.sales.message.reader;

import java.io.File;
import java.util.Objects;

import org.apache.log4j.Logger;

public class SalesMessageExecutor {

	final static Logger logger = Logger.getLogger(SalesMessageExecutor.class);

	public static void main(String[] args) {

		File inputFile = resolveInputFile();
		if(Objects.nonNull(inputFile))
		  FileRouter.callSpecificReader(resolveInputFile());
		else
			logger.error("File is not found, no valid input");
	}

	static File resolveInputFile(){

		logger.info("Reading file from Repository folder of the project");

		File srcFolder = new File("Repository");
		File fileToRead = null;

		if(Objects.nonNull(srcFolder) && srcFolder.exists() && srcFolder.isDirectory()){
			if(Objects.nonNull(srcFolder.listFiles()) && srcFolder.listFiles().length != 0){

				File[] fileArray = srcFolder.listFiles();
				if(Objects.nonNull(fileArray) && fileArray.length > 1){
					logger.debug( "Multiple sales data sheets present, Hence exiting !");
					System.exit(1);
				}
				else if(Objects.nonNull(fileArray)){
					for(File file:fileArray){
						fileToRead = file;
					}
				}
				
			}
			else{
				logger.debug("Repository folder is empty, it does not contain any sales data sheet !");
			}
		}
		else{
			logger.error("Repository folder does not exists!");
		}
		return fileToRead;
	}

}
