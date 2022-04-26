package com.code.FizzBuzz.integration;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {
	
    private static final String URL_PATH = "/fizzbuzz";
   
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void wrongTypeEntry() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH).param("entry", "1a"))
    	.andExpect(status().isBadRequest())
    	.andExpect(MockMvcResultMatchers.jsonPath("$.description").exists());
    }
    

}
