package com.codercampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeslaServices {

	public List<Tesla> readCSV(String file) throws IOException {
		BufferedReader fileReader = null;
		List<Tesla> car = new ArrayList<>();
		String line;
		fileReader = new BufferedReader(new FileReader(file));
		
		fileReader.readLine();
		while((line = fileReader.readLine()) != null){
			String[] data = line.split(",");
			Tesla tesla = new Tesla();
			tesla.setDate(data[0]);
			tesla.setSales(Integer.parseInt(data[1]));
			car.add(tesla);
		}
		fileReader.close();
		return car;
	}
	
	public static List<Integer> totalForEachYear (List<Tesla> carSales) {
		List<Integer> totalSalesForEachYear = new ArrayList<>();
		int year = 16;
		while( year <= 19) {
			String yearString = String.valueOf(year);
			List<Tesla> totalSalesForYear = carSales.stream()
											 		.filter(tesla -> tesla.getDate().contains(yearString))
											 		.collect(Collectors.toList());
			
			if(!totalSalesForYear.isEmpty()) {
				Integer totalSales = totalSalesForYear.stream()
													  .mapToInt(tesla -> tesla.getSales())
													  .sum();
			totalSalesForEachYear.add(new Tesla(yearString, totalSales));
			}
			year++;
		}
		return totalSalesForEachYear;
	}
	
	public void printReports (String model, String fileName) {
		System.out.println(model + "Yearly Sales Report");
	}
}