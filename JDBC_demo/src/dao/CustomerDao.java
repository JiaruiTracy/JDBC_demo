package dao;

import model.Customer;
import db.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import java.sql.PreparedStatement;

public class CustomerDao {

	public void addCustomer(Customer c) throws SQLException {
		Connection connect = DBUtil.getConnection();
		String sql = "INSERT INTO Customers" + "(customer_id,customer_name,customer_zip,customer_phone,customer_city)"
				+ "VALUES (" + "?,?,?,?,?)";
		PreparedStatement ptmt = connect.prepareStatement(sql);
		ptmt.setInt(1, c.getCustomer_id());
		ptmt.setString(2, c.getCustomer_name());
		ptmt.setString(3, c.getCustomer_zip());
		ptmt.setString(4, c.getCustomer_phone());
		ptmt.setString(5, c.getCustomer_city());
		ptmt.execute();
	}

	// public void updateCustomer(Customer c) throws SQLException {
	public void updateCustomer(int id) throws SQLException {
		Connection connect = DBUtil.getConnection();
		String sql = "UPDATE Customers" + " SET customer_city = ? where customer_id = ?";
		PreparedStatement ptmt = connect.prepareStatement(sql);
		ptmt.setString(1, "New York");
		ptmt.setInt(2, id);
		ptmt.execute();
	}

	public void deleteCustomer(int id) throws SQLException {
		Connection connect = DBUtil.getConnection();
		String sql = "DELETE FROM Customers WHERE customer_id = ?";
		PreparedStatement ptmt = connect.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public List<Customer> queryCustomer() throws SQLException {
		Connection connect = DBUtil.getConnection();
		Statement state = connect.createStatement();
		ResultSet resultSet = state.executeQuery("SELECT * FROM Customers");

		List<Customer> customerList = new ArrayList<>();
		Customer tempC = null;
		while (resultSet.next()) {
			tempC = new Customer();
			tempC.setCustomer_id(resultSet.getInt("customer_id"));
			tempC.setCustomer_name(resultSet.getString("customer_name"));
			tempC.setCustomer_zip(resultSet.getString("customer_zip"));
			tempC.setCustomer_phone(resultSet.getString("customer_phone"));
			tempC.setCustomer_city(resultSet.getString("customer_city"));
			customerList.add(tempC);

		}
		return customerList;
	}

	public Customer get() {
		// System.out.println(resultSet.getInt("order_id") + "," +
		// resultSet.getBigDecimal("order_totalprice"));
		return null;
	}

}
