package shop;

import java.util.Date;

public class Appliance {
	private String name;
	private String brand;
	private double price;
	private String Model;
	private Date date;
	private double weight;
	private int quantity;

	@Override
	public String toString() {
		return "Appliance [name=" + name + ", brand=" + brand + ", price=" + price + ", Model=" + Model + ", date="
				+ date + ", weight=" + weight + ", quantity=" + quantity + "]";
	}

	public Appliance(String name, String brand, double price, String model, Date date, double weight, int quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		Model = model;
		this.date = date;
		this.weight = weight;
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

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
