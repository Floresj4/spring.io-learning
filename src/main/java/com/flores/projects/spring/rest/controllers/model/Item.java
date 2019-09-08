package com.flores.projects.spring.rest.controllers.model;

public class Item {
	
	private String name;
	private String color;
	
	public Item(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
