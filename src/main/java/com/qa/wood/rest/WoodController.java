package com.qa.wood.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// ctrl + space  /// ctrl + shift + o

@RestController
public class WoodController {

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, World!";
	}

}
