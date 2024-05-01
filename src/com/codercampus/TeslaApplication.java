package com.codercampus;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class TeslaApplication {

	public static void main(String[] args) throws IOException, ParseException {
		TeslaServices teslaServices = new TeslaServices();
		List<Tesla> listOfTesla0 = teslaServices.readCSV("model3.csv", "Model 3");

		Map<Integer, Integer> streamedList = teslaServices.sortList(listOfTesla0);
		teslaServices.printResults(streamedList, "Model 3 Yearly Sales Report");
		Map<Integer,Map <String, Integer>> sortedByMonth = 
				teslaServices.sortByYearAndMonth(listOfTesla0);
		System.out.println(sortedByMonth);
	    sortedByMonth.forEach((year, salesByMonth) -> {
            System.out.println("Year " + year + ":");
            salesByMonth.forEach((month, sales) -> {
                System.out.println("  " + month + ": " + sales);
            });
        });
		String bestWorst = teslaServices.bestMonthAndWorst(sortedByMonth);
		
		List<Tesla> listOfTesla1 = teslaServices.readCSV("modelS.csv", "Model S");

		Map<Integer, Integer> streamedList1 = teslaServices.sortList(listOfTesla1);
		teslaServices.printResults(streamedList1, "Model S Yearly Sales Report");
		
		
		List<Tesla> listOfTesla2 = teslaServices.readCSV("modelX.csv", "Model X");

		Map<Integer, Integer> streamedList2 = teslaServices.sortList(listOfTesla2);
		teslaServices.printResults(streamedList2, "Model X Yearly Sales Report");
		

}
}