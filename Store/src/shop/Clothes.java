package shop;

public class Clothes {

	private String name;
	private String brand;
	private double price;
	private String Size;
	private String Color;
	private int quantity;

	@Override
	public String toString() {
		return "Clothes [name=" + name + ", brand=" + brand + ", price=" + price + ", Size=" + Size + ", Color=" + Color
				+ ", quantity=" + quantity + "]";
	}

	public Clothes(String name, String brand, double price, String size, String color, int quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		Size = size;
		Color = color;
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

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
