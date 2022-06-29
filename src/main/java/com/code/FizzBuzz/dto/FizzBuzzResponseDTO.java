package com.code.fizzbuzz.dto;

import java.util.Map;
import java.util.TreeMap;

public class FizzBuzzResponseDTO {

	private Map<String, String> outputs;
	
	public Map<String, String> getOutputs() {
		return this.outputs;
	}
	
	public void addOutput(String entry, String output) {
		if(this.outputs == null) {
			//TreeMap so the maps is always ordered
			this.outputs = new TreeMap<>();
		}
		outputs.put(entry, output);
	}
	
}
