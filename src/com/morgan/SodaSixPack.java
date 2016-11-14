package com.morgan;

public class SodaSixPack implements Grocery {
	private int deposit;
	private int quantity;
	private int price;
	private boolean taxable;

	public SodaSixPack() {
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#getQuantity()
	 */
	@Override
	public int getQuantity() {
		return quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.deposit = quantity * 6 * 5;
		this.quantity = quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.morgan.Grocery#getPrice()
	 */
	@Override
	public int getPrice() {
		if ((this.quantity / 4) >= 1) {
			this.price = 1200 + (this.quantity - 4) * 350;
		} else {
			this.price = quantity * 350;
		}
//		this.price = quantity * 350;
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
