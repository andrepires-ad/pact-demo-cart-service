package com.appdirect.pactdemo.carts.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cart {

	private String id;

	private List<Item> items;
}
