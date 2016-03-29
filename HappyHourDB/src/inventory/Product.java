package inventory;

/**
 * Represents a single product in our SQLite inventory database.
 * 
 * @author Reid Parker
 * @version 1.0 on 2/25/2016
 */

public class Product {
	private int id;
	private String city;
	private String barName;
	private String drinkName;
	private double price;

	public Product() {
	}

	public Product(int id, String city, String barName, String drinkName, double price) {
		super();
		this.id = id;
		this.city = city;
		this.barName = barName;
		this.drinkName = drinkName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getBarName() {
		return barName;
	}

	public void setBarName(String barName) {
		this.barName = barName;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%4d %-15s %-20s %-20s %8.2f", id, city, barName, drinkName, price);
	}
}
