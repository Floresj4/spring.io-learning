package com.flores.projects.spring.rest.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.projects.spring.rest.controllers.model.Item;

@RestController
@RequestMapping("/private")
public class PrivateController {

	@RequestMapping("/item")
	public Item getItem() {
		return new Item("Apple", "red");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/privilege/item")
	public Item getPrivilegedItem() {
		return new Item("Orange", "orange");
	}
}
