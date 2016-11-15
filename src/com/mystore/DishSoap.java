package com.mystore;

public class DishSoap implements Grocery {
	private int quantity;
	private Integer price;
	private boolean taxable = true;

	public DishSoap() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#getQuantity()
	 */
	@Override
	public Integer getQuantity() {
		return quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#setQuantity(int)
	 */
	@Override
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#getPrice()
	 */
	@Override
	public Integer getPrice() {
		this.price = quantity * 289;
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#isTaxable()
	 */
	@Override
	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

}
