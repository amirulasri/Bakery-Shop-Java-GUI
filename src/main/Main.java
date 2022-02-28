package main;

import java.util.ArrayList;

public class Main {
	static ArrayList<Customerclass> customers = new ArrayList<Customerclass>();
	static ArrayList<Itemsclass> listitems = new ArrayList<Itemsclass>();

	public static ArrayList<Customerclass> getcustomer() {
		return customers;
	}

	public static ArrayList<Itemsclass> getitems() {
		return listitems;
	}

	// CREATE ORDER
	public void setnewcustomer(String orderid, String name, String phoneno, String email, boolean regularcustomer) {
		customers.add(new Customerclass(orderid, name, phoneno, email, regularcustomer));
	}

	public static void main(String[] args) {
		Welcomeframe welcomeframe;
		Cashierframe cashier;

		try {
			welcomeframe = new Welcomeframe();
			cashier = new Cashierframe();

			welcomeframe.setVisible(true);
			// Thread.sleep(2000);
			welcomeframe.progressBar.setVisible(true);
			try {
				for (int i = 0; i <= 100; i += 4) {
					Thread.sleep(10);
					welcomeframe.progressBar.setValue(i);
					welcomeframe.lblNewLabel_3.setText("Welcome! Starting up " + i + "%");
				}
				// Thread.sleep(1000);
				welcomeframe.setVisible(false);
				cashier.setVisible(true);
			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}