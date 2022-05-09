package com.code.FizzBuzz.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.FizzBuzz.dto.FizzBuzzResponseDTO;
import com.code.FizzBuzz.util.FizzBuzz;

@Service
public class FizzBuzzService {
	// Depends on abstraction
	private FizzBuzz fizzBuzzBazz;

	Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);

	public FizzBuzzService(FizzBuzz fizzBuzzBazz) {
		this.fizzBuzzBazz = fizzBuzzBazz;
	}
	
	/**
	 * method that build FizzBuzz client response
	 * @param List<Integer> entries
	 * @return FizzBuzzResponseDTO
	 */
	public FizzBuzzResponseDTO process(List<Integer> entries) {
        if (entries == null || entries.isEmpty()) {
            entries = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        }
        logger.info(entries.toString());
	    FizzBuzzResponseDTO response = new FizzBuzzResponseDTO();
        
        entries.forEach(i -> response.addOutput(String.valueOf(i), fizzBuzzBazz.fizzbuzzProcess(i)));
        
		return response;
	}
	
	
	
	

}
