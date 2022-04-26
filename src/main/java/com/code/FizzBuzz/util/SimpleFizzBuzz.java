package com.code.FizzBuzz.util;


import org.springframework.stereotype.Component;

import com.code.FizzBuzz.constants.Constants;


@Component
public class SimpleFizzBuzz implements FizzBuzz {
	
	@Override
	public boolean isEmpty(Integer entry) {
		if(entry == null) {
			return false;
		}
		return true;
	}

	@Override
	public String fizzbuzzResponse(Integer entry) {

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