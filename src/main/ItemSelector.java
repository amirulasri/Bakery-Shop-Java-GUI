package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class ItemSelector extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */

	// GET ORDER ID FROM NEWORDER CLASS
	private String getorderid() {
		return NewOrder.getorderid();
	}

	public ItemSelector() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/main/logo/logo.png")));
		setTitle("Bakery Shop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 225, 168));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(114, 61, 70));

		JScrollPane scrollPane = new JScrollPane();

		// READ ITEM FROM FILE
		BufferedReader bakerylistinput = null;
		List<String> bakerylist = new ArrayList<String>();
		try {
			bakerylistinput = new BufferedReader(new FileReader("bakery.txt"));
			String bakeryitemline = null;
			bakerylist.add("Select Cake");
			while ((bakeryitemline = bakerylistinput.readLine()) != null) {
				String[] listitemcomma = bakeryitemline.split(",");
				bakerylist.add(listitemcomma[0] + " RM"+ listitemcomma[1]);
			}
		}

		catch (FileNotFoundException e) {
			// DISABLE WHEN IN WINDOWBUILDER EDITING
			// JOptionPane.showMessageDialog(null, "Error: File bakery.txt not found. Go to
			// jar file location and create bakery.txt");
			System.err.println("Error, file didn't exist.");
			// System.exit(0);
		} finally {
			bakerylistinput.close();
		}

		String[] bakerylistArray = bakerylist.toArray(new String[] {});
		
		JComboBox itemcombobox = new JComboBox(bakerylistArray);

		JSpinner quantity = new JSpinner();
		quantity.setModel(new SpinnerNumberModel( 1, 1, null, 1));
		

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ADD ITEMS TO LIST ORDERS FOR CUSTOMER
				int selecteditem = 0;
				int quantityno;
				try {
					selecteditem = itemcombobox.getSelectedIndex();
					quantityno = (Integer) quantity.getValue();
					
					if(selecteditem != 0) {
						Main.getitems().add(new Itemsclass(NewOrder.getorderid(), String.valueOf(itemcombobox.getSelectedItem()), (Integer)quantity.getValue()));
					}else {
						JOptionPane.showMessageDialog(null, "Please select item", "No item selected", JOptionPane.ERROR_MESSAGE);
					}
					
					System.out.println(quantityno);
					System.out.println(selecteditem);
				}catch(Exception error) {
					System.out.println("Error: " + error);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Save");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Delete");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(quantity)
						.addComponent(itemcombobox, 0, 196, Short.MAX_VALUE))
					.addGap(55)
					.addComponent(btnNewButton)
					.addGap(71)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addGap(34))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(613, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemcombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addGap(6))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Item Name", "Quantity", "Price" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(62);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("Items for order ID: " + getorderid());

		lblNewLabel_2.setIcon(new ImageIcon(ItemSelector.class.getResource("/main/logo/contract.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(18)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
				.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE).addComponent(lblNewLabel_2).addGap(20)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
