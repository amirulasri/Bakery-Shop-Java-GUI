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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	
	DecimalFormat priceformatter = new DecimalFormat("#0.00");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField deletenumberfield;
	DefaultTableModel listitemmodel;
	private String orderid;
	JLabel totalpricedisplay;
	

	/**
	 * Create the frame.
	 */

	public ItemSelector(final String orderid) throws IOException {
		this.orderid = orderid;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/main/logo/logo.png")));
		setTitle(Main.getappname());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 225, 168));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(114, 61, 70));

		JScrollPane scrollPane = new JScrollPane();

		// READ ITEM FROM FILE
		BufferedReader itemlistinput = null;
		List<String> itemlist = new ArrayList<String>();
		List<String> itemlistname = new ArrayList<String>();
		List<Double> priceperitem = new ArrayList<Double>();
		
		try {
			itemlistinput = new BufferedReader(new FileReader("items.txt"));
			String itemline = null;
			itemlist.add("Select Item");
			while ((itemline = itemlistinput.readLine()) != null) {
				String[] listitemcomma = itemline.split(",");
				itemlist.add(listitemcomma[0] + " RM"+ listitemcomma[1]);
				itemlistname.add(listitemcomma[0]);
				priceperitem.add(Double.parseDouble(listitemcomma[1]));
			}
		}
		catch (FileNotFoundException e) {
			// DISABLE WHEN IN WINDOWBUILDER EDITING
			// JOptionPane.showMessageDialog(null, "Error: File bakery.txt not found. Go to
			// jar file location and create bakery.txt");
			System.err.println("Error, file didn't exist.");
			// System.exit(0);
		} finally {
			itemlistinput.close();
		}

		String[] itemlistArray = itemlist.toArray(new String[] {});
		String[] itemlistnameArray = itemlistname.toArray(new String[] {});
		Double[] priceperitemArray = priceperitem.toArray(new Double[] {});
		
		JComboBox itemcombobox = new JComboBox(itemlistArray);

		JSpinner quantity = new JSpinner();
		quantity.setModel(new SpinnerNumberModel(1, 1, null, 1));
		

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			int lastitemnumber = 1;
			@Override
			public void mouseClicked(MouseEvent e) {
				//ADD ITEMS TO LIST ORDERS FOR CUSTOMER
				int selecteditem = 0;
				int quantityno;
				double totalitemsprice = 0;
				
				selecteditem = itemcombobox.getSelectedIndex();
				
				try {
					if(selecteditem != 0) {
						if(table.getRowCount() > 0) {				
							lastitemnumber = (int) table.getModel().getValueAt(table.getRowCount() - 1, 0) + 1;
						}else {
							lastitemnumber = 1;
						}
						
						//CALCULATE PRICE FOR SELECTED ITEM AND QUANTITY
						quantityno = (Integer) quantity.getValue();
						totalitemsprice = priceperitemArray[selecteditem - 1] * quantityno;
						Main.getitems().add(new Itemsclass(orderid, lastitemnumber, String.valueOf(itemlistnameArray[selecteditem - 1]), (Integer)quantity.getValue(), totalitemsprice));
						quantity.setValue(1);
						showdata();
					}else {
						JOptionPane.showMessageDialog(null, "Please select item", "No item selected", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception error) {
					System.out.println("Error: " + error);
				}
				calctotalprice();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		deletenumberfield = new JTextField();
		deletenumberfield.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//DELETE ITEMS HERE
				int deletenumber;
				try {
					deletenumber = Integer.parseInt(deletenumberfield.getText());
					Predicate<Itemsclass> condition2 = p->p.getitemnumber()==deletenumber && p.orderid == orderid;
					Main.getitems().removeIf(condition2);
					calctotalprice();
					showdata();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter a valid item number", "Invalid Item Number", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		totalpricedisplay = new JLabel("Total Price: RM 0");
		totalpricedisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(quantity)
						.addComponent(itemcombobox, 0, 196, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deletenumberfield, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addComponent(totalpricedisplay))
					.addGap(90))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(629, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(itemcombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(deletenumberfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(totalpricedisplay)))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addGap(6))
		);

		table = new JTable();
		listitemmodel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Item Number", "Item Name", "Quantity", "Price"
				}
			){
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
			};
		
		table.setModel(listitemmodel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(62);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("Items for order ID: " + orderid);

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
		
		showdata();
	}
	
	private void calctotalprice() {
		double listpricecust = 0;
		for(int i = 0; i < Main.getitems().size(); i++) {
			if(String.valueOf(Main.getitems().get(i).getorderid()).equals(orderid)) {				
				listpricecust = listpricecust + Main.getitems().get(i).gettotalitems();
			}
		}
		totalpricedisplay.setText("Total Price: RM " + priceformatter.format(listpricecust));
		NewOrder.calctotalprice(listpricecust);
	}
	
	private void showdata() {
		//ADD DATA HERE
		listitemmodel.setRowCount(0);
		for(int i = 0; i < Main.getitems().size(); i++) {
			if(String.valueOf(Main.getitems().get(i).getorderid()).equals(orderid)) {				
				listitemmodel.addRow(new Object[]{Main.getitems().get(i).getitemnumber(), Main.getitems().get(i).getitemname(), Main.getitems().get(i).getquantity(), "RM " + priceformatter.format(Main.getitems().get(i).gettotalitems())});
			}
		}
	}
}
