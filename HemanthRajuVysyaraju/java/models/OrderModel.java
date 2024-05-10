package com.pennant.shoppingcart.models;

public class OrderModel {
	private Double orderTotal;
	private Double gst;
	private Double shipping_charges;
	private double gstforshipping;
	private double totalInclAllTax;

	public double getTotalInclAllTax() {
		return totalInclAllTax;
	}

	public void setTotalInclAllTax(double totalInclAllTax) {
		this.totalInclAllTax = totalInclAllTax;
	}

	public Double getShipping_charges() {
		return shipping_charges;
	}

	public void setShipping_charges(Double shipping_charges) {
		this.shipping_charges = shipping_charges;
	}

	public double getGstforshipping() {
		return gstforshipping;
	}

	public void setGstforshipping(double gstforshipping) {
		this.gstforshipping = gstforshipping;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

}
