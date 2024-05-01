package com.codercampus;

import java.io.IOException;
import java.util.List;

public class TeslaApplication {

	public static void main(String[] args) throws IOException{
		TeslaServices teslaServices = new TeslaServices();
		List<Tesla> test = teslaServices.readCSV("modelS.csv");
		System.out.println(TeslaServices.totalForEachYear(test));
		List<Integer> testing = TeslaServices.totalForEachYear(test);
		System.out.println(testing.get(2));
	}
}