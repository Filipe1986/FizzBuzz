package com.code.FizzBuzz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.FizzBuzz.constants.Constants.Url;
import com.code.FizzBuzz.dto.FizzBuzzResponseDTO;
import com.code.FizzBuzz.service.FizzBuzzService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(Url.FIZZBUZZ_PATH)
public class FizzBuzzController {
		
	private FizzBuzzService fizzBuzzService;
	
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = fizzBuzzService;
	}


	@GetMapping()
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "BAD RESQUEST")
	})
	public ResponseEntity<FizzBuzzResponseDTO> fizzbuzz(@RequestParam(required = false) List<Integer> entry) {
		return ResponseEntity.ok(fizzBuzzService.process(entry));
	}

}
