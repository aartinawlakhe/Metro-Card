package com.example.geektrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Station class represents a station with its name, charges and discount.
 * It also keeps track of the collection amount and discount amount for each station.
 */

class Station {
		// a static map to keep track of the collection and discount amount for each station
		private static Map<String, ArrayList<Integer>> collection = new HashMap<>();
		
		// instance variables
		private final int ZERO_INDEX = 0;
		private final int ONE_INDEX = 1;
		
		// Constructor to create a new Station object with the given station name, charges and discount.
		Station(String station, int charges, int discount) {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			// If the station already exists in the collection map, the charges and discount amount will be added to the existing values.
			if(collection.containsKey(station)) {
				collection.get(station).set(ZERO_INDEX,collection.get(station).get(ZERO_INDEX)+charges);
				collection.get(station).set(ONE_INDEX,(collection.get(station).get(ONE_INDEX))+discount);			
			}
			// If the station doesn't exist in the collection map, a new entry will be created with the given charges and discount values.
			else {
				list.add(charges);
				list.add(discount);
				collection.put(station, list);
			}
		}

		// Getter method for collection map
		static Map<String, ArrayList<Integer>> getCollection() {
			return collection;
		}
}
