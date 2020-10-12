package com.qa.wood.persistence.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JPA -> Java Persistence API

public interface WoodRepo extends JpaRepository<Wood, Long> {

	// SELECT * FROM wood WHERE colour = {colour};
	@Query("SELECT w FROM Wood w WHERE w.colour = ?1")
	List<Wood> findByColour(String colour);

}
