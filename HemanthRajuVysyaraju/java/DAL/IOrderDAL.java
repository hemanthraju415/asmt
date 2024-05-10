package com.pennant.shoppingcart.DAL;

public interface IOrderDAL {
	public Double getGst(Integer id);

	public Double getShippingCharge(Double total);

}
