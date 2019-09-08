package com.flores.projects.springboot.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@RequestMapping("/randomitem")
	public Item getRandomItem() {
		return new Item("Apple", "red");
	}
	
}
