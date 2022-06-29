package com.code.fizzbuzz.controller;

import com.code.fizzbuzz.constants.Constants;
import com.code.fizzbuzz.dto.FizzBuzzResponseDTO;
import com.code.fizzbuzz.service.FizzBuzzService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(Constants.Url.FIZZBUZZ_PATH)
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
