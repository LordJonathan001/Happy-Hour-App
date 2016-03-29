package inventory;

import java.util.List;
import java.util.Scanner;

import mucis.util.Validator;

/**
 * Inventory database application implemented using Java 7 and SQLite.
 * 
 * @author Reid Parker
 * @version 1.0.1 on 2/25/2016 
 */
public class InventoryApp {

	Scanner sc = new Scanner(System.in);
	ProductDAO prodDB;

	public InventoryApp() {
		prodDB = new DAOSQLiteProduct();
		menu();
	}

	public void menu() {
		final String MY_MENU = "\n***** Happy Hour Menu *****\n" + "0 = quit\n"
				+ "1 = List all bars by id\n" + "2 = List all bars by city\n"
				+ "3 = List all bars by bar name\n" + "4 = List all bars by drink name\n"
				+ "5 = List all by price\n"
				+ "11 = find by id\n" + "71 = Add record\n"
				+ "81 = update record\n" + "82 = update product name\n"
				+ "83 = update quantity\n"
				+ "91 = delete record\n" + "101 = create new table\n"
				+ "102 = populate table\n" + "Enter number of choice: ";
		int choice = 0;
		while (true) {
			choice = Validator.getInt(sc, MY_MENU);
			System.out.println();
			if (choice == 0)
				break;
			else if (choice == 1)
				displayAll("id");
			else if (choice == 2)
				displayAll("city");
			else if (choice == 3)
				displayAll("barName");
			else if (choice == 4)
				displayAll("drinkName");
			else if (choice == 5)
				displayAll("price");
			else if (choice == 11)
				find();
			else if (choice == 71)
				addRecord();
			else if (choice == 81)
				updateRecord();
			else if (choice == 83)
				updateProductQuantity();
			else if (choice == 91)
				deleteRecord();
			else if (choice == 101)
				deleteTable();
			else if (choice == 102)
				prodDB.populateTable();
			else
				System.out.println("Invalid number. Please try again.");
		}
	}

	private void updateProductQuantity() {
		int id = Validator.getInt(sc, "Enter id of record to update: ");
		Product p = prodDB.findRecordById(id);
		if (p != null) {
			System.out.println("Updating: " + p);
			int qty = Validator.getInt(sc, "Enter quantity in stock: ");
			p = new Product(id, p.getCity(), p.getBarName(), p.getDrinkName(), p.getPrice());
			String choice = Validator.getLine(sc, "Update product (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				prodDB.updateRecord(p);
				System.out.println("The following product has been updated: ");
				System.out.println(prodDB.findRecordById(id) + "\n");
			} else {
				System.out.println("The product was not updated.");
			}
		} else {
			System.out.println("The record was not found for id " + id);
		}
	}

	public void addRecord() {
		String city = Validator.getLine(sc, "Enter city name: ");
		String barName = Validator.getLine(sc, "Enter bar name: ");
		String drinkName = Validator.getLine(sc, "Enter name of drink: ");
		double price = Validator.getDouble(sc, "Enter price: ");
		Product p = new Product(0, city, barName, drinkName, price);
		String choice = Validator.getLine(sc, "Add this product (y/n): ");
		if (choice.equalsIgnoreCase("y")) {
			int id = prodDB.insertRecord(p);
			if (id > 0) {
				System.out.println("The following product has been added: ");
				System.out.println(prodDB.findRecordById(id) + "\n");
			} else {
				System.out.println("****Error: the product was not added.");
			}
		}
	}

	public void updateRecord() {
		int id = Validator.getInt(sc, "Enter id of record to update: ");
		Product p = prodDB.findRecordById(id);
		if (p != null) {
			System.out.println("Updating: " + p);
			String city = Validator.getLine(sc, "Enter city name: ");
			String barName = Validator.getLine(sc, "Enter name of bar: ");
			String drinkName = Validator.getLine(sc, "Enter name of drink: ");
			double price = Validator.getDouble(sc, "Enter price: ");
			p = new Product(id, city, barName, drinkName, price);
			String choice = Validator.getLine(sc, "Update product (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				prodDB.updateRecord(p);
				System.out.println("The following product has been updated: ");
				System.out.println(prodDB.findRecordById(id) + "\n");
			} else {
				System.out.println("The product was not updated.");
			}
		} else {
			System.out.println("The record was not found for id " + id);
		}
	}

	public void deleteRecord() {
		int id = Validator.getInt(sc, "Enter id of record to delete: ");
		Product p = prodDB.findRecordById(id);
		if (p != null) {
			System.out.println("Record found: " + p);
			String choice = Validator.getLine(sc, "Delete (y/n): ");
			if (choice.equalsIgnoreCase("y")) {
				prodDB.deleteRecord(id);
				System.out.println("Deleted record id " + id);
			} else {
				System.out.println("The record was not deleted.");
			}
		} else {
			System.out.println("The record was not found for id " + id);
		}
	}

	public void find() {
		int id = Validator.getInt(sc, "Enter record id: ");
		Product p = prodDB.findRecordById(id);
		if (p != null)
			System.out.println(p);
		else
			System.out.println("Record not found for id " + id);
		Validator.getLine(sc, "\npress Enter to continue...");
	}

	public void displayAll(String columnName) {
		List<Product> list = prodDB.retrieveAllRecords(columnName);
		System.out.println("  ID City            BarName              DrinkName               Price");
		for (Product p : list) {
			System.out.println(p);
		}
		Validator.getLine(sc, "\npress Enter to continue...");
	}

	public void deleteTable() {
		String choice = Validator.getLine(sc,
				"Delete entire product table (y/n)? ");
		if (choice.equalsIgnoreCase("y")) {
			choice = Validator.getLine(sc, "Administrator password: ");
			if (choice.equals("")) {
				prodDB.deleteTable();
				prodDB.createTable();
			} else {
				System.out.println("Incorrect Password.");
			}
		}
	}

	public static void main(String[] args) {
		new InventoryApp();
		System.out.println("Goodbye.");
	}
}
