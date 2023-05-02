package com.example.geektrust;

class ProceedToMetroCard {
	// instance variables
	private final int ZERO_INDEX = 0;
	
	ProceedToMetroCard(String input) {
		// Splitting the input into tokens based on space delimiter
        String[] tokens = input.split(" ");
        
        // Checking the first token to determine the type of command
        switch(tokens[ZERO_INDEX]) {
        	case "BALANCE" :
        		// Creating a new instance of the Balance class and passing the input tokens to its constructor
          	   	new CalculateBalance(tokens);
          	   	break;
          	  
        	case "CHECK_IN" :
        		// Creating a new instance of the CheckIn class and passing the input tokens to its constructor
          	   	new CheckInPassenger(tokens);
          	   	break;
          	   
        	case "PRINT_SUMMARY":
        		// Creating a new instance of the PrintSummary class
          	    new PrintSummary();
          	   	break;
        }
	}
	
}
