package main;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Welcomeframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cashierframe frame2 = new Cashierframe();

	/**
	 * Create the application.
	 */
	JProgressBar progressBar = new JProgressBar();
	public Welcomeframe() {

		setUndecorated(true);
		setResizable(false);
		setTitle("Cashier");
		setBounds(100, 100, 765, 387);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		progressBar.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 51, 102));
		panel.setBounds(0, 306, 766, 81);
		getContentPane().add(panel);

		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(31)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(38, Short.MAX_VALUE)));
		progressBar.setForeground(new Color(51, 0, 153));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel
						.createSequentialGroup().addContainerGap(35, Short.MAX_VALUE).addComponent(progressBar,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(32)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(33, 33, 33));
		panel_1.setBounds(0, 0, 766, 307);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Welcomeframe.class.getResource("/main/logo/logo.png")));

		JLabel lblNewLabel_2 = new JLabel("Bakery Shop");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 58));

		JLabel lblNewLabel = new JLabel("By: Amirul Asri, Harris Irfan, Sholihin Ilias, Aliff Redzuan, Mifzal Dini");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_panel_1.createSequentialGroup().addContainerGap(140, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1).addGap(18)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 509,
										GroupLayout.PREFERRED_SIZE)
								.addGap(19))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(247, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(98)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE).addComponent(
										lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)));
		panel_1.setLayout(gl_panel_1);
	}
}
