package com.qa.wood.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.wood.persistence.domain.Wood;

// ctrl + space  /// ctrl + shift + o

@RestController
public class WoodController {

	private List<Wood> woodDB = new ArrayList<>();

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, World!";
	}

	@PostMapping("/create")
	public void createWood(@RequestBody Wood wood) {
		System.out.println(wood);
		this.woodDB.add(wood);
	}

	@GetMapping("/get")
	public List<Wood> getWood() {
		return this.woodDB;
	}

	@PutMapping("/update")
	public void updateWood(@RequestBody Wood wood, @PathParam("id") int id) {
		this.woodDB.remove(id);
		this.woodDB.add(id, wood);
	}

	@DeleteMapping("/remove/{id}")
	public void deleteWood(@PathVariable int id) {
		this.woodDB.remove(id);
	}
}
