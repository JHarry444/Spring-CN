package com.qa.wood.persistence.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JPA -> Java Persistence API

@Repository
public interface WoodRepo extends JpaRepository<Wood, Long> {

}
