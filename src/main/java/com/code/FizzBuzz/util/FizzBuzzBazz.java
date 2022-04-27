package com.code.FizzBuzz.util;


import org.springframework.stereotype.Component;

import com.code.FizzBuzz.constants.Constants;


@Component
public class FizzBuzzBazz implements FizzBuzz {
	
	/**
	 * Method with a implementation of FizzBuzz
	 * where rules of multiples of 3, 5 and 7 are implemented
	 */
	@Override
	public String fizzbuzzProcess(Integer entry) {

		if(entry % 3 == 0 && entry % 5 == 0 && entry % 7 == 0) {
			return Constants.ReturnMessage.FIZZBUZZBAZZ;
		}
		if(entry % 5 == 0 && entry % 7 == 0) {
			return Constants.ReturnMessage.BUZZBAZZ;
		}
		if(entry % 3 == 0 && entry % 7 == 0) {
			return Constants.ReturnMessage.FIZZBAZZ;
		}
		if(entry % 3 == 0 && entry % 5 == 0) {
			return Constants.ReturnMessage.FIZZBUZZ;
		}
		if(entry % 7 == 0) {
			return Constants.ReturnMessage.BAZZ;
		}
		if(entry % 5 == 0) {
			return Constants.ReturnMessage.BUZZ;
		}
		if(entry % 3 == 0) {
			return Constants.ReturnMessage.FIZZ;
		}

		return String.valueOf(entry);
	}



}