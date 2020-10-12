package com.qa.wood.persistence.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA -> Java Persistence API

public interface WoodRepo extends JpaRepository<Wood, Long> {

}
