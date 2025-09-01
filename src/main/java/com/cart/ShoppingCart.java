package com.cart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
	List<Item> list = new LinkedList<Item>();

	public void addItem(Item item) {
		list.add(item);
	}

	public void removeItem(int id) {
		boolean isFound = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			throw new IllegalArgumentException("Item not found!!!");
		}
	}

	public List<Item> viewCart() {
		return new ArrayList<>(list);
	}

	public double calculateTotalAmount() {
		double totalAmount = 0;
		for (Item item : list) {
			totalAmount += item.getPrice();
		}
		list.clear();
		return totalAmount;
	}
}
