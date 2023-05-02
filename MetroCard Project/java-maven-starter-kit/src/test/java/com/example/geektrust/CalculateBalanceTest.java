package com.example.geektrust;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CalculateBalanceTest {

	@Test
	public void constructorTest() {
		String input[] = new String[] {"","MC1","400"};
		Map<String,Integer> expectedOutput = new HashMap<>();
		expectedOutput.put("MC1",400);
		
		new CalculateBalance(input);
		// Compare the actual output with the expected output
	    assertEquals(expectedOutput, CalculateBalance.getWallet());
	}
	
	@Test
	public void checkBalanceTest() {
		CalculateBalance calculateBalance = new CalculateBalance();
		calculateBalance.checkBalance("MC1", 50, "AIRPORT");
		Map<String,Integer> expectedOutput = new HashMap<>();
		expectedOutput.put("MC1",400);
		assertEquals(expectedOutput, CalculateBalance.getWallet());
	}

}
