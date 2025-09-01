package com.cart;

public class Item {
	private int id;
	private String name;
	private double price;

	public Item(int id, String name, double price) {
		if (id <= 0 || name.trim() == null || price <= 0) {
			throw new IllegalArgumentException("Invalid input!!");
		}
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String displayItem() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
