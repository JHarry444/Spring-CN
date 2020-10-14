package com.qa.wood.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.wood.persistence.domain.Wood;

// JPA -> Java Persistence API

@Repository
public interface WoodRepo extends JpaRepository<Wood, Long> {

}
