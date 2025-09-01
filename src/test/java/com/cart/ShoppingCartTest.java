package com.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	private ShoppingCart cart;
	private Item item1;
	private Item item2;

	@BeforeEach
	void setUp() {
		cart = new ShoppingCart();
		item1 = new Item(1, "Book", 200.0);
		item2 = new Item(2, "Pen", 20.0);
	}

	@Test
	void testAddItem() {
		cart.addItem(item1);
		cart.addItem(item2);
		assertEquals(220.0, cart.calculateTotalAmount());
	}

	@Test
	void testRemoveItem() {
		cart.addItem(item1);
		cart.addItem(item2);
		cart.removeItem(1);
		assertEquals(20.0, cart.calculateTotalAmount());
	}

	@Test
	void testRemoveItemNotFound() {
		try {
			cart.removeItem(3);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Item not found!!!", e.getMessage());
		}
	}

	@Test
	void testCalculateTotalAmount() {
		assertEquals(0.0, cart.calculateTotalAmount());
	}
	
	@Test
	void testViewCart() {
	    cart.addItem(item1);
	    cart.addItem(item2);
	    assertEquals(2, cart.viewCart().size());
	    assertTrue(cart.viewCart().contains(item1));
	    assertTrue(cart.viewCart().contains(item2));
	}
}
