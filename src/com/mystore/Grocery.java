package com.mystore;

public interface Grocery {

	Integer getQuantity();

	void setQuantity(Integer quantity);

	Integer getPrice();

	boolean isTaxable();

}