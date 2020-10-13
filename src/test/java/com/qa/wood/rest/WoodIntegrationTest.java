package com.qa.wood.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.wood.persistence.domain.Wood;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WoodIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Wood newWood = new Wood(true, "blue", "mahogany", 35, 3453, true, true);
		String requestBody = this.mapper.writeValueAsString(newWood);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Wood savedWood = new Wood(true, "blue", "mahogany", 35, 3453, true, true);
		savedWood.setId(2L); // id = 2 because 1 value is inserted using data.sql

		String resultBody = this.mapper.writeValueAsString(savedWood);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

		String reqBody = result.getResponse().getContentAsString();

		Wood woodResult = this.mapper.readValue(reqBody, Wood.class);
	}

}
