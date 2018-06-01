package com.sales.message.util;

import java.util.List;
import java.util.Map;

import com.sales.message.entity.AdjustmentReport;
import com.sales.message.entity.Product;
import com.sales.message.logger.SalesMessageLogger;

public interface ReportGenerator {
	
	public void generateReport(Map<String,Product> entries,SalesMessageLogger logger);
	
	public default void printReport(List<AdjustmentReport> adjustmentEntries){
		
		System.out.println("");
        System.out.println("********************** Adjusted Log Report ***************************************");
        adjustmentEntries.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\n\n");
		 
	}

}
	