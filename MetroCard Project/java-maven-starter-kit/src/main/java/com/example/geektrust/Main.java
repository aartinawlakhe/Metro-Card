package com.example.geektrust;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Sample code to read from file passed as command line argument
        try {
        
        	// Creating a FileInputStream object to read the file
            FileInputStream fis = new FileInputStream(args[0]);
      
            // file to be scanned
            Scanner sc = new Scanner(fis); 
            
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
            	String input = sc.nextLine();
            	new ProceedToMetroCard(input);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
       
    }
}
