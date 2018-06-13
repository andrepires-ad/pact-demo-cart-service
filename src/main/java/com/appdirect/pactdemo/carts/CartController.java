package com.appdirect.pactdemo.carts;

import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.demo.cart.api.CartsApi;
import com.appdirect.demo.cart.model.ItemWsDTO;
import com.appdirect.pactdemo.carts.model.Cart;
import com.appdirect.pactdemo.carts.service.CartService;
import com.appdirect.demo.cart.model.CartWsDTO;

@RestController
public class CartController implements CartsApi {

	@Autowired
	private CartService cartService;

	@Override
	public ResponseEntity<CartWsDTO> getCartById(String cartId) {
		Cart cart = getCartService().getCart(cartId);
		return new ResponseEntity<>(convert(cart), HttpStatus.CREATED);
	}

	private CartWsDTO convert(Cart cart) {
		return new CartWsDTO()
				.id(cart.getId())
				.items(cart.getItems()
						.stream()
						.map(item ->new ItemWsDTO().productId(item.getProductId()).productName(item.getProductName()).quantity(item.getQuantity()))
						.collect(toList()));
	}

	public CartService getCartService() {
		return cartService;
	}
}
