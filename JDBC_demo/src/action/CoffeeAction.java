package action;

import java.sql.SQLException;
import java.util.*;

import dao.CustomerDao;
import model.Customer;

public class CoffeeAction {

	public static void main(String[] args) throws SQLException {
		CustomerDao c = new CustomerDao();
		List<Customer> cList = c.queryCustomer();

		System.out.println("id\t\tname\t\tphone\t\t\tzip\t\tcity\t\t");
		
		for (Customer cs : cList) {
			System.out.println(cs.getCustomer_id() + "\t\t" + cs.getCustomer_name() + "\t\t" + cs.getCustomer_phone()
					+ "\t\t" + cs.getCustomer_zip() + "\t\t" + cs.getCustomer_city());
		}
		
//		Customer nc = new Customer();
//		nc.setCustomer_id(102);
//		nc.setCustomer_name("Jiarui");
//		nc.setCustomer_phone("(732) 000-7890");
//		nc.setCustomer_zip("07724");
//		nc.setCustomer_city("Eatontown");
//		c.addCustomer(nc);
//		c.updateCustomer(102);
//		c.deleteCustomer(102);
		
	}
}
