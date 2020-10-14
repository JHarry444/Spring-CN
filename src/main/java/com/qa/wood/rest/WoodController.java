package com.qa.wood.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin // disables CORS shenanigans
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
	public ResponseEntity<Wood> createWood(@RequestBody Wood wood) {
		return new ResponseEntity<Wood>(this.service.createWood(wood), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Wood>> getWood() {
		return ResponseEntity.ok(this.service.getWood());
	}

	@PutMapping("/update")
	public ResponseEntity<Wood> updateWood(@RequestBody Wood wood, @PathParam("id") Long id) {
		return new ResponseEntity<Wood>(this.service.updateWood(wood, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteWood(@PathVariable Long id) {
		if (this.service.deleteWood(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
