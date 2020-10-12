package com.qa.wood.rest;

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
import com.qa.wood.service.WoodService;

// ctrl + space  /// ctrl + shift + o

@RestController
public class WoodController {

	private WoodService service;

	public WoodController(WoodService service) {
		super();
		this.service = service;
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, World!";
	}

	@PostMapping("/create")
	public void createWood(@RequestBody Wood wood) {
		this.service.createWood(wood);
	}

	@GetMapping("/get")
	public List<Wood> getWood() {
		return this.service.getWood();
	}

	@PutMapping("/update")
	public void updateWood(@RequestBody Wood wood, @PathParam("id") Long id) {
		this.service.updateWood(wood, id);
	}

	@DeleteMapping("/remove/{id}")
	public void deleteWood(@PathVariable Long id) {
		this.service.deleteWood(id);
	}
}
