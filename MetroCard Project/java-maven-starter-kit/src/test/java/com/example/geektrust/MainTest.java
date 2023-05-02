package com.example.geektrust;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Scanner;

import org.junit.Test;

public class MainTest {
	@Test
	public void fileTest() throws IOException {
		
		String inputText = "BALANCE MC1 400\n"
				+ "BALANCE MC2 100\n"
				+ "BALANCE MC3 50\n"
				+ "BALANCE MC4 50\n"
				+ "CHECK_IN MC1 SENIOR_CITIZEN AIRPORT\n"
				+ "CHECK_IN MC2 KID AIRPORT\n"
				+ "CHECK_IN MC3 ADULT CENTRAL\n"
				+ "CHECK_IN MC1 SENIOR_CITIZEN CENTRAL\n"
				+ "CHECK_IN MC3 ADULT AIRPORT\n"
				+ "CHECK_IN MC3 ADULT CENTRAL\n"
				+ "PRINT_SUMMARY";
		String outputText = "TOTAL_COLLECTION CENTRAL 457 50\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 2\n"
				+ "SENIOR_CITIZEN 1\n"
				+ "TOTAL_COLLECTION AIRPORT 252 100\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "KID 1\n"
				+ "SENIOR_CITIZEN 1";
		String actualOutput = "";
		
		    // file to be scanned
		    Scanner sc = new Scanner(inputText); 
		    
		    // returns true if there is another line to read
		    while (sc.hasNextLine()) {
		    	String input = sc.nextLine();
		    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
			    PrintStream originalOut = System.out;
			    System.setOut(new PrintStream(outContent));

			    new ProceedToMetroCard(input);
			    
			    System.setOut(originalOut);
			    
			    actualOutput = outContent.toString();
		    }
		    sc.close(); // closes the scanner

		// Compare the actual output with the expected output
		assertEquals(outputText.trim(), actualOutput.trim());
		    
	}	
}

/*String inputText = "C:\\Users\\Aarti Nawlakhe\\OneDrive\\Documents\\GeekTrust Project\\MetroCard Project\\java-maven-starter-kit\\sample_input\\input5.txt";
String outputText = "C:\\Users\\Aarti Nawlakhe\\OneDrive\\Documents\\GeekTrust Project\\MetroCard Project\\java-maven-starter-kit\\sample_input\\output5.txt";
String actualOutput = "";
try {
	// Path of the file to be opened for reading
	FileInputStream fis = new FileInputStream(inputText);

    // file to be scanned
    Scanner sc = new Scanner(fis); 
    
    // returns true if there is another line to read
    while (sc.hasNextLine()) {
    	String input = sc.nextLine();
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    PrintStream originalOut = System.out;
	    System.setOut(new PrintStream(outContent));

	    new MetroCardEntryPoint(input);
	    
	    System.setOut(originalOut);
	    
	    actualOutput = outContent.toString().trim();
    }
    sc.close(); // closes the scanner
} catch (IOException e) {
}


// Read the expected output from the output file
BufferedReader outputReader = new BufferedReader(new FileReader(outputText));
StringBuilder sb = new StringBuilder();
String line = outputReader.readLine();
while (line != null) {
    sb.append(line);
    sb.append(System.lineSeparator());
    line = outputReader.readLine();
}
String expectedOutput = sb.toString().trim();
outputReader.close();

// Compare the actual output with the expected output
assertEquals(expectedOutput, actualOutput);*/

/*String inputText = "C:\\Users\\Aarti Nawlakhe\\OneDrive\\Documents\\GeekTrust Project\\MetroCard Project\\java-maven-starter-kit\\sample_input\\input5.txt";
String outputText = "C:\\Users\\Aarti Nawlakhe\\OneDrive\\Documents\\GeekTrust Project\\MetroCard Project\\java-maven-starter-kit\\sample_input\\output5.txt";

ByteArrayOutputStream outContent = new ByteArrayOutputStream();
PrintStream originalOut = System.out;
System.setOut(new PrintStream(outContent));

Main.main(new String[] {inputText});
   
System.setOut(originalOut);
    
String actualOutput = outContent.toString().trim();
System.out.println("Redirecting output...");
System.out.println("Actual output: " + outContent.toString());

// Read the expected output from the output file
BufferedReader reader = new BufferedReader(new FileReader(outputText));
StringBuilder sb = new StringBuilder();
String line = reader.readLine();
while (line != null) {
    sb.append(line);
    sb.append(System.lineSeparator());
    line = reader.readLine();
}
String expectedOutput = sb.toString().trim();
reader.close();

// Compare the actual output with the expected output
assertEquals(expectedOutput, actualOutput);*/