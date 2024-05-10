package com.pennant.shoppingcart.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCUTILITIES.JdbcUtil;

public class OrderDALImpl implements IOrderDAL {
	@Override
	public Double getGst(Integer id) {
		Double gst = null;
		Connection con = JdbcUtil.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(
					"select hsnc_gstc_percentage from i213_HSNCodes where hsnc_hsncode in(select hsnc_hsncode from i213_HSNCodes where hsnc_id in (select prod_hsnc_id from i213_productsdata where prod_id=?))");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				gst = rs.getDouble("hsnc_gstc_percentage");
			}
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
		}
		return gst;
	}

	@Override
	public Double getShippingCharge(Double total) {
		Double charge = null;
		Connection con = JdbcUtil.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(
					"SELECT orvl_shippingamount FROM i213_OrderValueWiseShippingCharges WHERE ? BETWEEN orvl_from AND orvl_to");
			psmt.setDouble(1, total);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				charge = rs.getDouble("orvl_shippingamount");
			}
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
		}
		return charge;
	}

}
