package com.code.fizzbuzz.util;


import org.springframework.stereotype.Component;

import com.code.fizzbuzz.constants.Constants;


@Component
public class SimpleFizzBuzz implements FizzBuzz {
	
	/**
	 * Method with a simple implementation of fizzbuzz
	 * where only rules of multiples of 3 and 5 are implemented
	 */
	@Override
	public String fizzbuzzProcess(Integer entry) {

		if(entry % 5 == 0 && entry % 3 == 0) {
			return Constants.ReturnMessage.FIZZBUZZ;
		}
		if(entry % 3 == 0) {
			return Constants.ReturnMessage.FIZZ;
		}
		if(entry % 5 == 0) {
			return Constants.ReturnMessage.BUZZ;
		}
		return String.valueOf(entry);
	}



}