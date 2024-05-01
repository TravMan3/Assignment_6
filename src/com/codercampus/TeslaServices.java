package com.codercampus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TeslaServices {

	public List<Tesla> readCSV(String file,String carType) throws IOException{
		List<Tesla> car = new ArrayList<>();
		
		try(FileInputStream fileInput = new FileInputStream(file)){
			InputStreamReader read = new InputStreamReader(fileInput);
			BufferedReader fileRead = new BufferedReader(read);
			
			String model = (carType);
			fileRead.readLine();
			
			String line;
			while((line = fileRead.readLine()) != null) {
				String[] value = line.split(",");
				String date = value[0];
				Date parsedDate = null;
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yy");
				try {
					parsedDate = dateFormat.parse(date);
					
				}catch (ParseException e) {
					e.printStackTrace();
				}
				Integer sales = Integer.parseInt(value[1]);
				
				car.add(new Tesla(model, parsedDate, sales));
			}return car;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
			
		
	}
	
	public Map<Integer, Integer> sortList(List<Tesla> list) {
		Map<Integer, Integer> salesByYear = list.stream()
				.sorted(Comparator.comparing(Tesla::getDate))
				.collect(Collectors.groupingBy(
						tesla -> tesla.getDate().getYear() + 1900,
						Collectors.summingInt(Tesla::getSales)));
return salesByYear;
	}
	public void printResults (Map<Integer, Integer> list, String model) {
		System.out.println(model);
        System.out.println("---------------------------");

        for (Entry<Integer, Integer> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " -> " + (entry.getValue()));
    	}
        System.out.println(" ");
	}
	
	public Map<Integer,Map<String, Integer>> sortByYearAndMonth (List<Tesla> list){
		Map<Integer, Map<String, Integer>> saleByMonth = 
				list.stream()
					.sorted(Comparator.comparing(Tesla::getDate))
					.collect(Collectors.groupingBy(
						tesla -> tesla.getDate().getYear() + 1900, 
					    Collectors.groupingBy(
							    tesla -> Month.of(tesla.getDate().getMonth() + 1).toString(), 
								Collectors.summingInt(Tesla::getSales))));

		return saleByMonth;
	}
	public String bestMonthAndWorst (Map<Integer, Map<String, Integer>> sortedByMonth) {
		
		return "";
	}
}
