package com.qa.wood;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.wood.persistence.domain.Wood;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class SpringExampleApplicationTests {

	@Test
	void contextLoads() {
		// smoke
	}

	@Test
	void giveCoveragePlz() {
		EqualsVerifier.forClass(Wood.class).usingGetClass().verify();
	}

}
