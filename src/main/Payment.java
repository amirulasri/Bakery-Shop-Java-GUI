package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Payment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Payment.class.getResource("/main/logo/logo.png")));
		setTitle(Main.getappname());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 88, 95));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(140, 47, 57));
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setIcon(new ImageIcon(Payment.class.getResource("/main/logo/mobile-payment.png")));
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblPayment)
					.addContainerGap(718, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 68, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(lblPayment)
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(372, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
