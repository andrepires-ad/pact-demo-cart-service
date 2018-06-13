package com.appdirect.pactdemo.carts.service;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.pactdemo.carts.apiclients.ProductWsDTO;
import com.appdirect.pactdemo.carts.apiclients.ProductsApi;
import com.appdirect.pactdemo.carts.model.Cart;
import com.appdirect.pactdemo.carts.model.Item;

@Service
public class DefaultCartService implements CartService {

	@Autowired
	private ProductsApi productsApi;

	@Override
	public Cart getCart(String cartId) {
		return Cart.builder()
				.id(cartId)
				.items(
						IntStream.range(0, 5).boxed().map(
								id -> {
									ProductWsDTO product = getProductById(id);
									return Item.builder()
											.productId(product.getId())
											.productName(product.getName())
											.quantity(new Random().nextInt(100))
											.build();
								}
						).collect(toList())
				)
				.build();
	}

	protected ProductWsDTO getProductById(Integer id) {
		try {
			return getProductsApi().getProductById(id.toString()).execute().body();
		} catch (IOException e) {
			throw new RuntimeException("Error while fetching product api.", e);
		}
	}
	public ProductsApi getProductsApi() {
		return productsApi;
	}
}
