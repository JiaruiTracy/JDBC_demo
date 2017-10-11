package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static final String URL = "jdbc:mysql://localhost:3306/coffee_shop";
	public static final String NAME = "root";
	public static final String PASSWORD = "root";

	private static Connection connect;
	
	static {
		// 1.加载驱动程序。反射
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库连接
			connect = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		return connect;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Statement state = connect.createStatement();
		ResultSet resultSet = state.executeQuery(
				"SELECT o.order_id, o.order_totalprice FROM Orders o, Customers c, Ordered_products op WHERE c.customer_name = 'Dante' AND YEAR(o.order_date) = '2017' AND o.Customers_customer_id = ( SELECT c.customer_id FROM Customers c WHERE c.customer_name = 'Dante') GROUP BY o.order_id");

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("order_id") + "," + resultSet.getBigDecimal("order_totalprice"));
		}

	}

}
