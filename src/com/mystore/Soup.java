package com.mystore;

public class Soup implements Grocery {
	private int quantity;
	private Integer price;
	private boolean taxable;

	public Soup() {
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
		this.price = (this.quantity % 3) * 125;
		this.price += new Double((Math.floor((this.quantity / 3) * 300))).intValue();
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
