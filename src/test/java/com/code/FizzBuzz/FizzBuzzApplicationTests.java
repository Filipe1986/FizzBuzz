package com.code.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.code.FizzBuzz.constants.Constants;
import com.code.FizzBuzz.util.FizzBuzzBazz;
import com.code.FizzBuzz.util.SimpleFizzBuzz;

@SpringBootTest
class FizzBuzzApplicationTests {

	@Autowired
	private SimpleFizzBuzz simpleFizzBuzz;
	
	@Autowired
	private FizzBuzzBazz fizzBuzzBazz;
	
	
	@Test
	void SimpleFizzBuzzTest() {
		

		assertEquals(Constants.ReturnMessage.FIZZBUZZ, simpleFizzBuzz.fizzbuzzResponse(0));
		int num = (int) ((Math.random() * (-100 - 100)) + 100);
		
		assertEquals(Constants.ReturnMessage.FIZZBUZZ, simpleFizzBuzz.fizzbuzzResponse(num * 5 * 3));
		
		assertEquals(Constants.ReturnMessage.FIZZ, simpleFizzBuzz.fizzbuzzResponse(3));
		assertEquals(Constants.ReturnMessage.FIZZ, simpleFizzBuzz.fizzbuzzResponse(6));
		
		
		assertEquals(Constants.ReturnMessage.BUZZ, simpleFizzBuzz.fizzbuzzResponse(5));
		assertEquals(Constants.ReturnMessage.BUZZ, simpleFizzBuzz.fizzbuzzResponse(10));
		
		assertEquals("7", simpleFizzBuzz.fizzbuzzResponse(7));
		assertEquals("14", simpleFizzBuzz.fizzbuzzResponse(14));
	}
	
	@Test
	public void itShouldThrowNullPointerExceptionWhenParameterIsNull() {
	    assertThrows(NullPointerException.class, ()-> simpleFizzBuzz.fizzbuzzResponse(null));
	    
	    assertThrows(NullPointerException.class, ()-> simpleFizzBuzz.fizzbuzzResponse(null));
	}
	
	@Test
	void FizzBuzzBazzTest() {
		
		assertEquals(Constants.ReturnMessage.FIZZBUZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(0));
		
		int num = (int) ((Math.random() * (-100 -100)) + 100);
		assertEquals(Constants.ReturnMessage.FIZZBUZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(num * 5 * 3 * 7));
		
		
		assertEquals(Constants.ReturnMessage.BUZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(35));
		assertEquals(Constants.ReturnMessage.BUZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(70));
		
		assertEquals(Constants.ReturnMessage.FIZZ, fizzBuzzBazz.fizzbuzzResponse(3));
		assertEquals(Constants.ReturnMessage.FIZZ, fizzBuzzBazz.fizzbuzzResponse(6));
		
		assertEquals(Constants.ReturnMessage.BAZZ, fizzBuzzBazz.fizzbuzzResponse(7));
		assertEquals(Constants.ReturnMessage.BAZZ, fizzBuzzBazz.fizzbuzzResponse(14));
		
		assertEquals(Constants.ReturnMessage.FIZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(21));
		assertEquals(Constants.ReturnMessage.FIZZBAZZ, fizzBuzzBazz.fizzbuzzResponse(42));
		
		
		
		assertEquals(Constants.ReturnMessage.BUZZ, fizzBuzzBazz.fizzbuzzResponse(5));
		assertEquals(Constants.ReturnMessage.BUZZ, fizzBuzzBazz.fizzbuzzResponse(10));
		
		assertEquals("8", fizzBuzzBazz.fizzbuzzResponse(8));
		assertEquals("16", fizzBuzzBazz.fizzbuzzResponse(16));
	}
	
	

}
