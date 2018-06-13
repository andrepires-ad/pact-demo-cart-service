package com.appdirect.pactdemo.carts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Item {

	private String productId;
	private String productName;
	private Integer quantity;

}
