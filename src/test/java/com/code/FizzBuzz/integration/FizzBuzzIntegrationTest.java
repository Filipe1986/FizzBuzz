package com.code.FizzBuzz.integration;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.code.FizzBuzz.constants.Constants.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void wrongTypeEntry() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get(Url.FIZZBUZZ_PATH).param(Url.FIZZBUZZ_ENTRIES, "1a"))
    	.andExpect(status().isBadRequest())
    	.andExpect(MockMvcResultMatchers.jsonPath("$.description").exists());
    }
    

}
