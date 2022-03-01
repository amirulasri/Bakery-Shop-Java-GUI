package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Cashierframe extends JFrame {
	
	SimpleDateFormat newdateformat = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat newtimeformat = new SimpleDateFormat("hh:mm a");

	private JPanel contentPane;
	private JTable table;
	
	public void displaydata() {
		Iterator itrcustomer = Main.getcustomer().iterator();
		while(itrcustomer.hasNext()) {
			String customerdatalist = (String) itrcustomer.next();
			System.out.println(customerdatalist);
		}
	}
	
	public Cashierframe() throws IOException{
		displaydata();
		setTitle("Bakery Shop");
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 511);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tools");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Settings");
		mntmNewMenuItem.setIcon(new ImageIcon(Cashierframe.class.getResource("/main/logo/gear.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Read manual");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Cashierframe.class.getResource("/main/logo/manual.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Cashierframe.class.getResource("/main/logo/about.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 18, 32));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JLabel lblNewLabel = new JLabel("Orders");
		lblNewLabel.setIcon(new ImageIcon(Cashierframe.class.getResource("/main/logo/ordericon.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("New Order");
		btnNewButton.setIcon(new ImageIcon(Cashierframe.class.getResource("/main/logo/add.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(218, 98, 125));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String orderid = JOptionPane.showInputDialog(null, "To create new order, enter new order ID", "Enter new order ID", JOptionPane.INFORMATION_MESSAGE);
				if(orderid == null || (orderid != null && ("".equals(orderid))))   
				{
				    
				}else {
					NewOrder neworderframe;
					try {
						Date date = new Date();
						
						Main.getorders().add(new Ordersclass(orderid, newdateformat.format(date), newtimeformat.format(date)));
						
						//GET NEW INDEX ORDER AFTER ADD
						int newaddedorderindex = Main.getorders().size() - 1;
						Ordersclass objectname = Main.getorders().get(newaddedorderindex);
						System.out.println(String.valueOf(objectname));
						
						neworderframe = new NewOrder(orderid, newaddedorderindex);
						neworderframe.setVisible(true);						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 646, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addGap(0))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Phone No", "E-mail", "Order No", "Total Price"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(195);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(this.getClass().getResource("/main/logo/logo.png")).getImage());
	}
}
