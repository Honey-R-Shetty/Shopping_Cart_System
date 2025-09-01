package com.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	Item item;

	@Test
	void testValidItem() {
		item = new Item(1, "Book", 200.0);
		assertEquals(1, item.getId());
		assertEquals("Book", item.getName());
		assertEquals(200.0, item.getPrice());
	}

	@Test
	void testInvalidItem() {
		try {
			item = new Item(0, null, 200.0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid input!!", e.getMessage());
		}
	}

	@Test
	void testDisplayDetails() {
		item = new Item(2, "Pen", 20.0);
		String expected = "Item [id=2, name=Pen, price=20.0]";
		assertEquals(expected, item.displayItem());
	}
}
