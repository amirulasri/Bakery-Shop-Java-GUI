package main;

public class Main {
	public static void main(String[] args) {
		try {
			Welcomeframe welcomeframe = new Welcomeframe();
			Cashierframe cashier = new Cashierframe();
			welcomeframe.setVisible(true);
			Thread.sleep(2000);
			welcomeframe.progressBar.setVisible(true);
			try {
				for (int i = 0; i < 100; i+=4) {
					Thread.sleep(40);
					welcomeframe.progressBar.setValue(i);
				}
				Thread.sleep(1000);
				welcomeframe.setVisible(false);
				cashier.setVisible(true);
			} catch (Exception e) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}