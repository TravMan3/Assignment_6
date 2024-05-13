package com.codercampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public static List<Tesla> totalForEachYear (List<Tesla> carSales, int startYear, int endYear) {
		List<Tesla> totalSalesForEachYear = new ArrayList<>();
		int year = startYear;
		while( year <= endYear) {
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
	
	public Optional<Tesla> bestMonth (List<Tesla> carSales){
		Optional<Tesla> bestMonth = carSales.stream()
										.max(Comparator.comparingInt(tesla -> tesla.getSales()));
		return bestMonth;
	}
	public Optional<Tesla> worstMonth (List<Tesla> carSales){
		Optional<Tesla> worstMonth = carSales.stream()
											 .min(Comparator.comparingInt(tesla -> tesla.getSales()));
		return worstMonth;
	}
	public void printReports (String model, String fileName) throws IOException {
		System.out.println(" ");
		System.out.println(model + " Yearly Sales Report");
		System.out.println("------------------------");
		List<Tesla> readCSV = readCSV(fileName);
		int firstYear = year(readCSV, 0);
		int lastYear = year(readCSV, readCSV.size()-1);
		List<Tesla> totalSales = totalForEachYear(readCSV,firstYear,lastYear);
		int i = 0;
		while(totalSales != null && i < totalSales.size()) {
			System.out.println("20" + totalSales.get(i).getDate() + 
					" -> " + totalSales.get(i).getSales());
			i++;
		}
		System.out.println(" ");
		Optional<Tesla> best = bestMonth(readCSV);
		bestAndWorstPrint(model, best, "best");
		
		Optional<Tesla> worst = worstMonth(readCSV);
		bestAndWorstPrint(model, worst, "worst");
		System.out.println(" ");
	}

	private int year(List<Tesla> readCSV, int index) {
		String yearString = readCSV.get(index).getDate();
		String[] part = yearString.split("-");
		String string = part[1];
		int year = Integer.parseInt(string);
		return year;
	}

	private void bestAndWorstPrint(String model, Optional<Tesla> best, String is) {
		String year = best.get().getDate().substring(4,6);
		String month = best.get().getDate().substring(0, 3);
		System.out.println("The " + is + " month for " + model + " was: " 
		+ "20" + year + "-" + month );
	}
}