package com.qa.wood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.wood.persistence.domain.Wood;

//@Component
@Service
public class WoodService {

	private List<Wood> woodDB = new ArrayList<>();

	public void createWood(Wood wood) {
		System.out.println(wood);
		this.woodDB.add(wood);
	}

	public List<Wood> getWood() {
		return this.woodDB;
	}

	public void updateWood(Wood wood, int id) {
		this.woodDB.remove(id);
		this.woodDB.add(id, wood);
	}

	public void deleteWood(int id) {
		this.woodDB.remove(id);
	}
}
