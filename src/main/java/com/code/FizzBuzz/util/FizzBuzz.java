package com.code.FizzBuzz.util;

import org.springframework.stereotype.Component;

@Component
public interface FizzBuzz {
	
	public boolean isEmpty(Integer entry);
	
	public String fizzbuzzProcess(Integer entry);

}