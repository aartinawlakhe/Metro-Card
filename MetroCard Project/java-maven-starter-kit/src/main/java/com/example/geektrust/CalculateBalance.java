package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

/**
 * Defining the CalculateBalance class
 */

class CalculateBalance {
	
		// Creating a Map to store the wallet details of each commuter
		private static Map<String,Integer> wallet = new HashMap<>();
		private static final double twentyPercentDiscount = 0.02;
		private static final double fiftyPercentDiscount = 0.5;
		private static final int ZERO_INDEX = 0;
		private static final int ONE_INDEX = 1;
		private static final int TWO_INDEX = 2;
		
		// Declaring variables to hold the metro card number and balance
		private String cardNumber = "";
		private int balance = 0;
		
		// Constructor to initialize the metro card number and balance variables
		CalculateBalance(String[] temp) {
			this.cardNumber = temp[ONE_INDEX];
			this.balance = Integer.parseInt(temp[TWO_INDEX]);
			
			//Adding the metro card number and balance to the wallet Map
			wallet.put(cardNumber,balance);
		}

		// Default constructor
		CalculateBalance() {}
		
		void checkBalance(String cardNumber, int amount, String station) {
			if(hasSufficientBalance(cardNumber,amount))
				topUpBalance(cardNumber,amount, station);
		}
		
		//Checking if the card has sufficient balance for a journey
		boolean hasSufficientBalance(String cardNumber, int amount) {
			// Retrieving the balance for the given card number from the wallet Map
			// and comparing it with the amount to be deducted for the journey
			return wallet.get(cardNumber) < amount;
		}
		
		// Method to top up balance the balance of a metro card
		void topUpBalance(String cardNumber,int amount, String fromStation) {
			// Calculating the amount to be recharged based on the difference
			// between the recharge amount and the current balance
			int recharge = amount-wallet.get(cardNumber);
			wallet.put(cardNumber, wallet.get(cardNumber)+recharge);
			
			// Calculating the processing fees for the recharge, which is 2% of the recharge amount
			int rechargeProcessingFees = (int)((double)recharge * twentyPercentDiscount);
			
			// Adding the processing fees to the collection at the from station
			Station.getCollection().get(fromStation).set(ZERO_INDEX, Station.getCollection().get(fromStation).get(ZERO_INDEX)+rechargeProcessingFees);
		}
		
		// Method to deduct the fare from the metro card balance
		void deductFare(String cardNumber, int amount) {
			// Subtracting the fare amount from the metro card balance
			wallet.put(cardNumber, wallet.get(cardNumber)-amount);
		}
		
		// Method to apply discount on the fare amount
		void applyDiscount(String cardNumber,int amount) {
			// Applying a 50% discount on the fare amount and deducting it from the metro card balance
			int discount = (int) ((double) amount * fiftyPercentDiscount);
			wallet.put(cardNumber, wallet.get(cardNumber)-discount);
		}

		public static Map<String, Integer> getWallet() {
			return wallet;
		}
		
}
