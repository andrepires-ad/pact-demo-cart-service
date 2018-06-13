package com.appdirect.pactdemo.carts.service;

import com.appdirect.pactdemo.carts.model.Cart;

public interface CartService {

	/**
	 * Returns the cart given its id
	 * @param id
	 * @return The cart
	 */
	Cart getCart(String id);
}
