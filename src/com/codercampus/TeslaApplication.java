package com.codercampus;

import java.io.IOException;

public class TeslaApplication {

	public static void main(String[] args) throws IOException{
		TeslaServices teslaServices = new TeslaServices();
		
		teslaServices.printReports("Model 3", "model3.csv");
		teslaServices.printReports("Model S", "modelS.csv");
		teslaServices.printReports("Model X", "modelX.csv");
	}
}