package shop;

import java.util.Date;

public class Food {
	protected String name;
	protected String brand;
	protected double price;
	protected Date expiration;
	protected double quantity;

	public Food() {
		super();

	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", brand=" + brand + ", price=" + price + ", expiration=" + expiration
				+ ", quantity=" + quantity + "]";
	}

	public Food(String name, String brand, double price, Date expiration, double quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.expiration = expiration;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
