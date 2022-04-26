package com.code.FizzBuzz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {
	
	@GetMapping()
	public ResponseEntity fizzbuzz(@RequestParam(required = false) Integer entry) {
		return ResponseEntity.ok("FizzBuzz " + entry);
	}

}
