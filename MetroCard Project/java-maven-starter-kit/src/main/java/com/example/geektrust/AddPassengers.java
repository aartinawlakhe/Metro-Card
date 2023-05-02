package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to keep track of passengers and their journeys
 */

class AddPassengers {
		// Creating a Map to store the number of passengers with each metro card
		private static Map<String, Integer> passengers = new HashMap<String, Integer>();
		// Creating Maps to keep track of the number of passengers for each journey type and station
		private static Map<String, Integer> central = new HashMap<String, Integer>();
		private static Map<String, Integer> airport = new HashMap<String, Integer>();
		
		// instance variables
		private final int ZERO_COUNT = 0;
		private final int ONE_COUNT = 1;
		
		// Constructor to add a new passenger for a journey
		AddPassengers(String cardNumber, String journeyType, String station) {
			
			// Storing the metro card number and incrementing the number of passengers for that card by 1
			passengers.put(cardNumber, passengers.getOrDefault(cardNumber, ZERO_COUNT)+ONE_COUNT);
			
			// Updating the number of passengers for the given journey type and station
			if(station.equals("CENTRAL")) {
				
				central.put(journeyType, central.getOrDefault(journeyType, ZERO_COUNT)+ONE_COUNT);
			}
			else {
				
				airport.put(journeyType, airport.getOrDefault(journeyType, ZERO_COUNT)+ONE_COUNT);
			}
		}

		static Map<String, Integer> getPassengers() {
			return passengers;
		}

		static Map<String, Integer> getCentral() {
			return central;
		}

		static Map<String, Integer> getAirport() {
			return airport;
		}
}
