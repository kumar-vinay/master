package com.sales.message.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sales.message.entity.AdjustmentReport;
import com.sales.message.entity.Product;
import com.sales.message.util.ReportBunches;
import com.sales.message.util.ReportGenerator;
import com.sales.message.util.ReportString;
import com.sales.message.util.SalesLoggerUtil;

/**
 * Stores information about all the messages that need to log.
 * Process messages in bunch of 10 and display the information to its users in console.
 * It also maintains the details about the adjustments made in each of the sales.
 * 
 * @author vinakuma
 *
 */
public class SalesMessageLogger {

	private List<String> soldEntries ;
	private List<AdjustmentReport> adjustementEntries;
	private Map<String,Product> productEntries;
	private double totalSaleValue ;

	public SalesMessageLogger(){

		this.soldEntries = new ArrayList<>();
		this.adjustementEntries = new ArrayList<>();
		this.productEntries  = new HashMap<>();
		this.totalSaleValue = 0.0;
	}

	public double getTotalSaleValue() {
		return totalSaleValue;
	}

	public void setTotalSaleValue(double totalSaleValue) {
		this.totalSaleValue = totalSaleValue;
	}


	public List<String> getSoldEntries() {
		return soldEntries;
	}

	public void setSoldEntries(String soldEntry) {
		this.soldEntries.add(soldEntry);
	}

	public List<AdjustmentReport> getAdjustementEntries() {
		return adjustementEntries;
	}

	public void setAdjustementEntries(AdjustmentReport adjustementEntry) {
		this.adjustementEntries.add(adjustementEntry);
	}

	private void appendTotalSalesValue(double productTotalPrice) { totalSaleValue += productTotalPrice;}

	public void setTotalSalesValue(double productTotalPrice) { totalSaleValue = productTotalPrice;}
	
    public Product getProduct(String type) { return productEntries.getOrDefault(type,new Product(type)); }

    public void updateProduct(Product product){productEntries.put(product.getPrdType(), product);}

	public void logSalesEntries(){
       
		ReportGenerator objReportGen = null;
		if((soldEntries.size() % 10) == 0 && soldEntries.size() !=0){

			setTotalSalesValue(0.0);
			objReportGen = new ReportBunches();
			SalesLoggerUtil.INSTANCE.setReportGenerator(objReportGen);
			SalesLoggerUtil.INSTANCE.generateReport(productEntries,this);

		}
		if((soldEntries.size() % 50) == 0 && soldEntries.size() !=0) {
			objReportGen = new ReportString();
			objReportGen.printReport(getAdjustementEntries());
			System.exit(1);
		}
	}

	public void formatReports(String type, Product product) {

		String lineItem = String.format("|%-40s|%-11d|%-11.2f|", product.getPrdType(), product.getTotalQty(), product.getTotalPrice());
		appendTotalSalesValue(product.getTotalPrice());
		System.out.println(lineItem);
	}



}
