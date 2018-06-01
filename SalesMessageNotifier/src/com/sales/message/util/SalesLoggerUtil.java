package com.sales.message.util;

import java.util.Map;

import com.sales.message.entity.Product;
import com.sales.message.logger.SalesMessageLogger;

public enum SalesLoggerUtil {

	INSTANCE;

	ReportGenerator reportGenerator;

	public void setReportGenerator(ReportGenerator reportGenerator) {
		INSTANCE.reportGenerator = reportGenerator;
	}

	public void generateReport(Map<String,Product> entries,SalesMessageLogger logger){
		reportGenerator.generateReport(entries,logger);
	}
}
