package com.code.FizzBuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.FizzBuzz.service.FizzBuzzService;


@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {
	
	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	@GetMapping()
	public ResponseEntity fizzbuzz(@RequestParam(required = false) List<Integer> entry) {

		return ResponseEntity.ok(fizzBuzzService.process(entry));
	}

}
