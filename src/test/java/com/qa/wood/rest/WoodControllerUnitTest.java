package com.qa.wood.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.wood.persistence.domain.Wood;
import com.qa.wood.service.WoodService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class WoodControllerUnitTest {

	@Autowired
	private WoodController controller;

	@MockBean
	private WoodService service;

	// GIVEN - WHEN - THEN
	@Test
	void testCreate() {
		// GIVEN
		Long id = 1L;
		Wood newWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		Wood savedWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		savedWood.setId(id);

		// WHEN
		Mockito.when(this.service.createWood(newWood)).thenReturn(savedWood);

		// THEN
		assertThat(this.controller.createWood(newWood))
				.isEqualTo(new ResponseEntity<Wood>(savedWood, HttpStatus.CREATED));

		Mockito.verify(this.service, Mockito.times(1)).createWood(newWood);
	}

	@Test
	void testUpdate() {
		// GIVEN

		Long id = 1L;

		Wood newWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		Wood updatedWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		updatedWood.setId(id);

		// WHEN
		Mockito.when(this.service.updateWood(newWood, id)).thenReturn(updatedWood);

		// THEN
		assertThat(this.controller.updateWood(newWood, id))
				.isEqualTo(new ResponseEntity<Wood>(updatedWood, HttpStatus.ACCEPTED));

		Mockito.verify(this.service, Mockito.times(1)).updateWood(newWood, id);
	}

	@Test
	void testGet() {
		// GIVEN
		Wood wood = new Wood(false, "blue", "fir", 47, 435, true, true);
		wood.setId(1L); // wood object to match the one in wood-data.sql
		List<Wood> woods = new ArrayList<>();
		woods.add(wood);

		// WHEN
		Mockito.when(this.service.getWood()).thenReturn(woods);

		// THEN
		assertThat(this.controller.getWood()).isEqualTo(ResponseEntity.ok(woods));

		Mockito.verify(this.service, Mockito.times(1)).getWood();
	}

	@Test
	void testDeleteSucceeds() {
		// GIVEN
		Long id = 1L;

		// WHEN
		Mockito.when(this.service.deleteWood(id)).thenReturn(true);

		// THEN
		assertThat(this.controller.deleteWood(id)).isEqualTo(ResponseEntity.ok().build());

		Mockito.verify(this.service, Mockito.times(1)).deleteWood(id);
	}

	@Test
	void testDeleteFails() {
		// GIVEN
		Long id = 1L;

		// WHEN
		Mockito.when(this.service.deleteWood(id)).thenReturn(false);

		// THEN
		assertThat(this.controller.deleteWood(id)).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		Mockito.verify(this.service, Mockito.times(1)).deleteWood(id);
	}
}
