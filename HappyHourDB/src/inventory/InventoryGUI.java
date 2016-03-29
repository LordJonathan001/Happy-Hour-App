package inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

/**
 * GUI Interface to the inventory database application implemented using Java 7
 * and SQLite.
 * 
 * @author Reid Parker
 * @version 1.0 on 2/25/2016
 */
public class InventoryGUI {
	public InventoryGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIPanel();
			}
		});
	}

	public static void main(String[] args) {
		new InventoryGUI();
	}
}

class GUIPanel {
	private ProductDAO prodDB;
	private JFrame frame;
	private JPanel framePanel, dataPanel, statusPanel;
	private JTextArea dataTA, statusTA;
	private JMenuItem newMI, printMI, exitMI;
	private JMenuItem addMI, updateMI, deleteMI;
	private JMenuItem listAllByIdMI, listAllByNameMI;
	private JMenuItem listAllByQuantityMI, listAllByPriceMI;
	private JMenuItem lowStockMI, netWorthMI;
	private JMenuItem aboutMI;

	public GUIPanel() {
		prodDB = new DAOSQLiteProduct();
		framePanel = new JPanel();
		dataPanel = new JPanel();
		statusPanel = new JPanel();

		Font font = new Font("monospaced", Font.PLAIN, 16);
		
		dataTA = new JTextArea(20, 80);
		dataTA.setFont(font);
		dataTA.setBackground(new Color(190, 209, 200));
		dataTA.setLineWrap(false);
		dataTA.setWrapStyleWord(false);
		JScrollPane dataSP = new JScrollPane(dataTA,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		dataPanel.add(dataSP);

		statusTA = new JTextArea("Status Panel", 1, 80);
		statusTA.setFont(font);
		statusTA.setBackground(new Color(255, 255, 150));
		statusTA.setLineWrap(true);
		statusTA.setWrapStyleWord(true);
		statusTA.setEditable(false);
		JScrollPane statusSP = new JScrollPane(statusTA,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		statusPanel.add(statusSP);

		framePanel.setOpaque(true);
		framePanel.setLayout(new BorderLayout());
		framePanel.add(dataPanel, BorderLayout.CENTER);
		framePanel.add(statusPanel, BorderLayout.SOUTH);

		frame = new JFrame("John's Inventory GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(createMenuBar());
		frame.setContentPane(framePanel);
		frame.pack();
		frame.setLocation(50, 50);
		frame.setResizable(false);
		frame.setVisible(true);

	} // end GUIPanel constructor

	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		newMI = new JMenuItem("Create and Populate Database Table");
		newMI.addActionListener(new NewListener());
		newMI.setMnemonic(KeyEvent.VK_N);
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menu.add(newMI);

		printMI = new JMenuItem("Print...");
		printMI.addActionListener(new PrintListener());
		menu.add(printMI);

		exitMI = new JMenuItem("Exit");
		exitMI.addActionListener(new ExitListener());
		menu.add(exitMI);

		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);

		addMI = new JMenuItem("Add new record");
		addMI.addActionListener(new AddListener());
		menu.add(addMI);

		updateMI = new JMenuItem("Update a record");
		updateMI.addActionListener(new UpdateListener());
		menu.add(updateMI);

		deleteMI = new JMenuItem("Delete a record");
		deleteMI.addActionListener(new DeleteListener());
		menu.add(deleteMI);

		menu = new JMenu("Report");
		menu.setMnemonic(KeyEvent.VK_R);
		menuBar.add(menu);

		listAllByIdMI = new JMenuItem("List all by Id");
		listAllByIdMI.setMnemonic(KeyEvent.VK_I);
		listAllByIdMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				ActionEvent.ALT_MASK));
		listAllByIdMI.addActionListener(new ListAllByIdListener());
		menu.add(listAllByIdMI);

		listAllByNameMI = new JMenuItem("List all by name");
		listAllByNameMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.ALT_MASK));
		listAllByNameMI.addActionListener(new ListAllByNameListener());
		menu.add(listAllByNameMI);

		listAllByQuantityMI = new JMenuItem("List all by quantity");
		listAllByQuantityMI.addActionListener(new ListAllByQuantityListener());
		menu.add(listAllByQuantityMI);

		listAllByPriceMI = new JMenuItem("List all by price");
		listAllByPriceMI.addActionListener(new ListAllByPriceListener());
		menu.add(listAllByPriceMI);
		
		lowStockMI = new JMenuItem("Display low stock");
		lowStockMI.addActionListener(new LowStockListener());
		menu.add(lowStockMI);
		
		netWorthMI = new JMenuItem("Total value of inventory");
		netWorthMI.addActionListener(new NetWorthListener());
		menu.add(netWorthMI);

		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);

		aboutMI = new JMenuItem("About");
		aboutMI.addActionListener(new AboutListener());
		menu.add(aboutMI);

		return menuBar;
	} // end createMenuBar
	
	public void displayAllRecords(String sortField) {
		StringBuilder sb = new StringBuilder();
		for (Product p : prodDB.retrieveAllRecords(sortField)) {
			sb.append(p.toString() + "\n");
		}
		dataTA.setText(sb.toString());
	}
	
	public void displayAllRecords(List<Product> list) {
		StringBuilder sb = new StringBuilder();
		for (Product p : list) {
			sb.append(p.toString() + "\n");
		}
		dataTA.setText(sb.toString());
	}

	class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			prodDB.deleteTable();
			prodDB.createTable();
			prodDB.populateTable();
			statusTA.setText("New data table created and populated");
			displayAllRecords("id");
		}
	}

	class PrintListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				dataTA.print();
				statusTA.setText("Print dialog finished");
			} catch (Exception pe) {
				statusTA.setText("Printer error");
			}
		}
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel();
			JTextField nameTF = new JTextField(10);
			JTextField quantityTF = new JTextField(5);
			JTextField priceTF = new JTextField(8);

			panel.add(new JLabel("Name:"));
			panel.add(nameTF);
			panel.add(new JLabel("Quantity:"));
			panel.add(quantityTF);
			panel.add(new JLabel("Price:"));
			panel.add(priceTF);

			int result = JOptionPane.showConfirmDialog(framePanel, panel,
					"Add a new product record", JOptionPane.OK_CANCEL_OPTION);
			
			if(result == JOptionPane.OK_OPTION) {
				String name = nameTF.getText();
				String qty = quantityTF.getText();
				String price = priceTF.getText();
				if(name.length()>0 && qty.length()>0 && price.length()>0) {
					Product p = new Product(0, name, Integer.parseInt(qty), Double.parseDouble(price));

					int id = prodDB.insertRecord(p);
					statusTA.setText("Added: " + prodDB.findRecordById(id));
					displayAllRecords("id");
				} else {	
					statusTA.setText("Check your input");
				}
			} else {
				statusTA.setText("Add record canceled");
			}
		}
	}

	class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			statusTA.setText("Update record");
			displayAllRecords("id");
		}
	}

	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = JOptionPane.showInputDialog(framePanel,
					"Enter record id to delete: ", null);
			if (s != null && s.length() > 0) {
				int id = Integer.parseInt(s);
				prodDB.deleteRecord(id);
				statusTA.setText("Record " + id + " has been deleted.");
				displayAllRecords("id");
			} else {
				statusTA.setText("**** Record not deleted ****");
			}
		}
	}

	class ListAllByIdListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("List all records by id");
			displayAllRecords("id");
		}
	}

	class ListAllByNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("List all records by name");
			displayAllRecords("name");
		}
	}

	class ListAllByQuantityListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("List all records by quantity");
			displayAllRecords("quantity");
		}
	}

	class ListAllByPriceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("List all records by price");
			displayAllRecords("price");
		}
	}

	class LowStockListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("Low stock");
			displayAllRecords(prodDB.retrieveLowStock(5));
		}
	}
	
	class NetWorthListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String netWorth = String.format("%1.2f", prodDB.retrieveNetWorth());
			statusTA.setText("Total value of inventory $" + netWorth);
			displayAllRecords("price");
		}
	}
	
	class AboutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			statusTA.setText("All Systems Go");
			JOptionPane.showMessageDialog(framePanel,
					"InventoryGUI by John Phillips 2014.03.07", "About",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

} // end class GUIPanel
