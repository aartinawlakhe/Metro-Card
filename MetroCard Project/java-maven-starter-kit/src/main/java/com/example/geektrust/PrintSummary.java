package com.example.geektrust;

/**
 * This class prints the summary of the total collection and passenger type summary for Central and Airport stations
 * It is called when the program execution is completed
 */

class PrintSummary {
	PrintSummary() {
		// prints the summary for Central station
		centralSummery();
		
		// prints the summary for Airport station
		airportSummery();
	}
	
	// This method prints the total collection and passenger type summary for Central station
	private void centralSummery() {
		System.out.println("TOTAL_COLLECTION CENTRAL "+Station.getCollection().get("CENTRAL").get(0)+" "+Station.getCollection().get("CENTRAL").get(1));
		System.out.println("PASSENGER_TYPE_SUMMARY");
		if(AddPassengers.getCentral().get("ADULT") != null)
			System.out.println("ADULT "+AddPassengers.getCentral().get("ADULT"));
		if(AddPassengers.getCentral().get("KID") != null)
			System.out.println("KID "+ AddPassengers.getCentral().get("KID"));
		if(AddPassengers.getCentral().get("SENIOR_CITIZEN") != null)
			System.out.println("SENIOR_CITIZEN "+ AddPassengers.getCentral().get("SENIOR_CITIZEN"));
	}
	
	// This method prints the total collection and passenger type summary for Airport station
	private void airportSummery() {
		System.out.println("TOTAL_COLLECTION AIRPORT "+Station.getCollection().get("AIRPORT").get(0)+" "+Station.getCollection().get("AIRPORT").get(1));
		System.out.println("PASSENGER_TYPE_SUMMARY");
		if(AddPassengers.getAirport().get("ADULT") != null)
			System.out.println("ADULT "+AddPassengers.getAirport().get("ADULT"));
		if(AddPassengers.getAirport().get("KID") != null)
			System.out.println("KID "+ AddPassengers.getAirport().get("KID"));
		if(AddPassengers.getAirport().get("SENIOR_CITIZEN") != null)
			System.out.println("SENIOR_CITIZEN "+AddPassengers.getAirport().get("SENIOR_CITIZEN"));
	}
}
