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
		

		assertEquals(Constants.ReturnMessage.FIZZBUZZ, simpleFizzBuzz.fizzbuzzProcess(0));
		int num = (int) ((Math.random() * (-100 - 100)) + 100);
		
		assertEquals(Constants.ReturnMessage.FIZZBUZZ, simpleFizzBuzz.fizzbuzzProcess(num * 5 * 3));
		
		assertEquals(Constants.ReturnMessage.FIZZ, simpleFizzBuzz.fizzbuzzProcess(3));
		assertEquals(Constants.ReturnMessage.FIZZ, simpleFizzBuzz.fizzbuzzProcess(6));
		
		
		assertEquals(Constants.ReturnMessage.BUZZ, simpleFizzBuzz.fizzbuzzProcess(5));
		assertEquals(Constants.ReturnMessage.BUZZ, simpleFizzBuzz.fizzbuzzProcess(10));
		
		assertEquals("7", simpleFizzBuzz.fizzbuzzProcess(7));
		assertEquals("14", simpleFizzBuzz.fizzbuzzProcess(14));
	}
	
	@Test
	public void itShouldThrowNullPointerExceptionWhenParameterIsNull() {
	    assertThrows(NullPointerException.class, ()-> simpleFizzBuzz.fizzbuzzProcess(null));
	    
	    assertThrows(NullPointerException.class, ()-> simpleFizzBuzz.fizzbuzzProcess(null));
	}
	
	@Test
	void FizzBuzzBazzTest() {
		
		assertEquals(Constants.ReturnMessage.FIZZBUZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(0));
		
		int num = (int) ((Math.random() * (-100 -100)) + 100);
		assertEquals(Constants.ReturnMessage.FIZZBUZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(num * 5 * 3 * 7));
		
		
		assertEquals(Constants.ReturnMessage.BUZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(35));
		assertEquals(Constants.ReturnMessage.BUZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(70));
		
		assertEquals(Constants.ReturnMessage.FIZZ, fizzBuzzBazz.fizzbuzzProcess(3));
		assertEquals(Constants.ReturnMessage.FIZZ, fizzBuzzBazz.fizzbuzzProcess(6));
		
		assertEquals(Constants.ReturnMessage.BAZZ, fizzBuzzBazz.fizzbuzzProcess(7));
		assertEquals(Constants.ReturnMessage.BAZZ, fizzBuzzBazz.fizzbuzzProcess(14));
		
		assertEquals(Constants.ReturnMessage.FIZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(21));
		assertEquals(Constants.ReturnMessage.FIZZBAZZ, fizzBuzzBazz.fizzbuzzProcess(42));
		
		
		
		assertEquals(Constants.ReturnMessage.BUZZ, fizzBuzzBazz.fizzbuzzProcess(5));
		assertEquals(Constants.ReturnMessage.BUZZ, fizzBuzzBazz.fizzbuzzProcess(10));
		
		assertEquals("8", fizzBuzzBazz.fizzbuzzProcess(8));
		assertEquals("16", fizzBuzzBazz.fizzbuzzProcess(16));
	}
	
	

}
