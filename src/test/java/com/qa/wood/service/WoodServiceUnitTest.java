package com.qa.wood.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.wood.persistence.domain.Wood;
import com.qa.wood.persistence.repos.WoodRepo;

@SpringBootTest
public class WoodServiceUnitTest {

	@Autowired
	private WoodService service;

	@MockBean
	private WoodRepo repo;

	// GIVEN - WHEN - THEN
	@Test
	void testCreate() {
		// GIVEN
		Long id = 1L;
		Wood newWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		Wood savedWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		savedWood.setId(id);

		// WHEN
		Mockito.when(this.repo.save(newWood)).thenReturn(savedWood);

		// THEN
		assertThat(this.service.createWood(newWood)).isEqualTo(savedWood);
	}

	@Test
	void testUpdate() {
		// GIVEN

		Long id = 1L;

		// will be passed in
		Wood newWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		// will be found by findById()
		Wood oldWood = new Wood(false, "red", "birch", 34235, 6464, false, true);
		oldWood.setId(id);
		// will be saved back to db and returned by method
		Wood updatedWood = new Wood(true, "blue", "mahogany", 324, 2234, true, false);
		updatedWood.setId(id);

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldWood));
		Mockito.when(this.repo.save(updatedWood)).thenReturn(updatedWood);

		// THEN
		assertThat(this.service.updateWood(newWood, id)).isEqualTo(updatedWood);
	}

}
