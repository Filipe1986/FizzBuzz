package com.code.fizzbuzz.integration;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.code.fizzbuzz.constants.Constants;
import com.code.fizzbuzz.constants.Constants.Url;

@SpringBootTest
@AutoConfigureMockMvc
class FizzBuzzIntegrationTest {

    private MockMvc mockMvc;

	@Autowired
	public FizzBuzzIntegrationTest(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
    void wrongTypeEntry() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, "1a"))
    	.andExpect(status().isBadRequest())
    	.andExpect(jsonPath("$.description").exists());
    }

	@Test
	void commaTypeEntry() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, ","))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.description").exists());
	}
    
    @Test
    void EntryNotFound404Test() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get( "/inexistentUrl"))
    	.andExpect(status().isNotFound())
    	.andExpect(jsonPath("$.description").exists());
    }
    
    @Test
    void oneEntry() throws Exception {
    	String entry = "1";
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, entry))
    	.andExpect(jsonPath("$.outputs", hasEntry(entry, "1")))
    	.andExpect(jsonPath("$.outputs", aMapWithSize(1)));
    }
    
    @Test
    void entry3() throws Exception {
    	String entry = "3";
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, entry))
    	
    	.andExpect(jsonPath("$.outputs", hasEntry(entry, Constants.ReturnMessage.FIZZ)))
    	.andExpect(jsonPath("$.outputs", aMapWithSize(1)));
    }
    
    @Test
    void entryOneAndThree() throws Exception {
    	String entry = "1,3";
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, entry))
    	.andExpect(jsonPath("$.outputs", hasEntry("3", Constants.ReturnMessage.FIZZ)))
    	.andExpect(jsonPath("$.outputs", hasEntry("1", "1")))
    	.andExpect(jsonPath("$.outputs", aMapWithSize(2)));
    }
    
    @Test
    void emptyTypeEntry() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH))
    	.andExpect(status().is2xxSuccessful())
    	.andExpect(jsonPath("$.outputs.0").doesNotExist())
    	.andExpect(jsonPath("$.outputs.1").exists())
    	.andExpect(jsonPath("$.outputs.100").exists())
    	.andExpect(jsonPath("$.outputs", hasEntry("1", "1")))
    	.andExpect(jsonPath("$.outputs", hasEntry("3", Constants.ReturnMessage.FIZZ)))
    	.andExpect(jsonPath("$.outputs", hasEntry("7", Constants.ReturnMessage.BAZZ)))
    	.andExpect(jsonPath("$.outputs", hasEntry("15", Constants.ReturnMessage.FIZZBUZZ)))
    	.andExpect(jsonPath("$.outputs", aMapWithSize(100)));
    }
    

}
