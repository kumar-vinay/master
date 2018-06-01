package com.sales.message.util;

import java.util.Map;

import org.apache.log4j.Logger;

import com.sales.message.entity.Product;
import com.sales.message.logger.SalesMessageLogger;

public class ReportBunches implements ReportGenerator {

	private final static Logger logger = Logger.getLogger(ReportBunches.class);
	@Override
	public void generateReport(Map<String,Product> entries,SalesMessageLogger messageLogger) {
		logger.info("ReportBunches with sale entries size " + entries.size());
		
		System.out.println(SalesConstants.EMPTY_STRING);
        System.out.println(SalesConstants.REPORT_FIRST);
        System.out.println(SalesConstants.FOLLOWING_LINE);
        System.out.println(SalesConstants.REPORT_COLUMNS);
        entries.forEach((k,v) -> messageLogger.formatReports(k,v));
        System.out.println("------------------------------------------------------------------");
        System.out.println(String.format("|%-52s|%-11.2f|","Total Sales",messageLogger.getTotalSaleValue()));
        System.out.println(SalesConstants.FOLLOWING_LINE);
        System.out.println("\n\n");

	}

}
