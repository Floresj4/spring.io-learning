package com.flores.projects.spring.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.projects.spring.rest.controllers.model.Item;

@RestController
@RequestMapping("/private")
public class ItemController {

	@RequestMapping("/randomitem")
	public Item getRandomItem() {
		return new Item("Apple", "red");
	}
	
}
