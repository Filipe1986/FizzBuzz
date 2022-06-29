package com.code.fizzbuzz.dto;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzzResponseDTO {

	private Map<String, String> outputs;
	
	public Map<String, String> getOutputs() {
		return this.outputs;
	}
	
	public void addOutput(String entry, String output) {
		if(this.outputs == null) {
			this.outputs = new HashMap<>();
		}
		outputs.put(entry, output);
	}
	
}
