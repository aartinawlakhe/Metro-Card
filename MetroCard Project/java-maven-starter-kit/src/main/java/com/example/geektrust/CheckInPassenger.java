package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

/**
 * CheckIn class represents the start of a journey for a passenger.
 * It stores the card number, journey type, and station from where the journey started.
 */

class CheckInPassenger {
	private String cardNumber = "";
	private String journeyType = "";
	private String fromStation = "";
	
	private static Map<String, Integer> journeyTypeWithValues = new HashMap<String, Integer>();
	static{
		journeyTypeWithValues.put("ADULT", 200);
		journeyTypeWithValues.put("SENIOR_CITIZEN", 100);
		journeyTypeWithValues.put("KID", 50);
	}
	
	// instance variables
	private final double FIFTY_PERCENT_DISCOUNT = 0.5;
	private final int RETURN_JOURNEY = 2;
	private final int ZERO_COUNT = 0;
	private final int ONE_INDEX = 1;
	private final int TWO_INDEX = 2;
	private final int THREE_INDEX = 3;
	
	
	// Create objects of Balance and JourneyType classes
	CalculateBalance calculateBalance = new CalculateBalance();
	
	//Constructor for CheckIn class that takes an array of strings as input.
	CheckInPassenger(String[] temp) {
		this.cardNumber = temp[ONE_INDEX];
		this.journeyType = temp[TWO_INDEX];
		this.fromStation = temp[THREE_INDEX];
		
		//ProceedToTravel method performs the journey for the passenger.
		ProceedToCheckIn(calculateBalance);
	}
	
	void ProceedToCheckIn(CalculateBalance calculateBalance) {
		
		//creates a new Passengers object and adds the passenger to the passengers map.
		new AddPassengers(cardNumber, journeyType, fromStation);
		
		if(isReturnTrip())
			returnTrip();
		else
			singleTrip();
	}

	// Default constructor
	CheckInPassenger() {}
	
	//checks if the passenger is eligible for a discount based on the number of trips made so far.
	//If the passenger has made 2 trips, a discount of 50% is applied to the station charges.
	boolean isReturnTrip() {
		return AddPassengers.getPassengers().get(cardNumber) == RETURN_JOURNEY;
	}
	
	void returnTrip() {
		int stationCharges = journeyTypeWithValues.get(journeyType);
		int discount = (int) ((double) stationCharges * FIFTY_PERCENT_DISCOUNT);
		
		//creates a new Station object.
		new Station(fromStation, journeyTypeWithValues.get(journeyType)-discount, discount);
		
		//Making balance if the balance is not sufficient.
		calculateBalance.checkBalance(cardNumber, discount, fromStation);
		
		//deducts the charges from the balance with discount
		calculateBalance.applyDiscount(cardNumber, journeyTypeWithValues.get(journeyType));
		
		//updates the discount and trips made for the passenger in the passengers map.
		AddPassengers.getPassengers().put(cardNumber, ZERO_COUNT);		
	}
	
	void singleTrip() {
		//creates a new Station object.
		new Station(fromStation, journeyTypeWithValues.get(journeyType), ZERO_COUNT);
		
		//Making balance if the balance is not sufficient.
		calculateBalance.checkBalance(cardNumber, journeyTypeWithValues.get(journeyType), fromStation);
		
		//deducts the charges from the balance withount discount
		calculateBalance.deductFare(cardNumber,journeyTypeWithValues.get(journeyType));
	}

	static Map<String, Integer> getJourneyTypeWithValues() {
		return journeyTypeWithValues;
	}
}
