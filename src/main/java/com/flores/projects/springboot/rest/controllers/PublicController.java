package com.flores.projects.springboot.rest.controllers;

import static java.lang.String.valueOf;

import java.time.OffsetDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@RequestMapping("/gettime")
	public String getTime() {
		return valueOf(OffsetDateTime.now());
	}
}
