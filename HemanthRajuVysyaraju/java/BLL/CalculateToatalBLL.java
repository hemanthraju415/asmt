package com.pennant.shoppingcart.BLL;

import com.pennant.shoppingcart.DAL.OrderDALImpl;
import com.pennant.shoppingcart.models.OrderModel;
import com.pennant.shoppingcart.models.ProductListModel;

public class CalculateToatalBLL {
	private static Double prods_TotalFare = 0.0;
	private static Double prods_Totalgst = 0.0;

	public static OrderModel doProcess(ProductListModel products) {
		OrderModel order = new OrderModel();
		products.forEach(product -> {
			OrderDALImpl ord = new OrderDALImpl();
			Double gst = ord.getGst(product.getProd_Id());
			prods_Totalgst += gst;
			Double total = (((gst / 100) * product.getProd_Price()) + product.getProd_Price()) * product.getProd_Qty();
			product.setProd_TotalFare(total);
			prods_TotalFare += product.getProd_TotalFare();
		});
		order.setOrderTotal(prods_TotalFare);
		order.setGst(prods_Totalgst);
		order.setShipping_charges(new OrderDALImpl().getShippingCharge(prods_TotalFare + prods_Totalgst));
		System.out.println((order.getShipping_charges() * 0.12) + order.getShipping_charges());
		order.setGstforshipping(order.getShipping_charges() * 0.12);
		order.setTotalInclAllTax(
				order.getGstforshipping() + order.getOrderTotal() + order.getGst() + order.getShipping_charges());
		return order;
	}
}
