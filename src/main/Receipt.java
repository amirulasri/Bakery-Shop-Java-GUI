package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Receipt extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Customerclass searchcustobject(String orderid) {
		for (int i = 0; i < Main.getcustomer().size(); i++) {
			if (String.valueOf(Main.getitems().get(i).getorderid()).equals(orderid)) {
				
			}

		}
	}

	public Receipt(String orderid) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receipt.class.getResource("/main/logo/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 717);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 184, 156));
		setContentPane(contentPane);
		setTitle(Main.getappname());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(140, 47, 57));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(99, 71, 77));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 842, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(56, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(374, Short.MAX_VALUE)));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(152, 82, 119));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(688, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(panel_2,
				GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE));

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Phone Number:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));

		JLabel lblNewLabel_2_1 = new JLabel("Regular Customer:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_3).addGap(78)
						.addComponent(lblNewLabel_2_1).addContainerGap(33, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("Receipt");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Receipt.class.getResource("/main/logo/receiptframe.png")));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(20).addComponent(lblNewLabel).addContainerGap(692, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
				.createSequentialGroup().addContainerGap(23, Short.MAX_VALUE).addComponent(lblNewLabel).addGap(21)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
