package com.qa.wood.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.wood.persistence.domain.Wood;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:wood-schema.sql",
		"classpath:wood-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
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

		// In case you need to access the actual result as an object:
		String reqBody = result.getResponse().getContentAsString();

		Wood woodResult = this.mapper.readValue(reqBody, Wood.class);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/remove/1");

		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);

//		ResultMatcher checkStatus2 = status().is(500);
//
//		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testRead() throws Exception {
		Wood wood = new Wood(false, "blue", "fir", 47, 435, true, true);
		wood.setId(1L); // wood object to match the one in wood-data.sql
		List<Wood> woods = new ArrayList<>();
		woods.add(wood);
		String responseBody = this.mapper.writeValueAsString(woods);

		this.mockMVC.perform(get("/get")).andExpect(status().isOk()).andExpect(content().json(responseBody));
	}

}
