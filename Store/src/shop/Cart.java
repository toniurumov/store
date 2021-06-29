package shop;

public class Cart {
private Food food ;
private Beverage beverage;
private Clothes clothes;
private Appliance appliance;
public Cart(Food food, Beverage beverage, Clothes clothes, Appliance appliance) {
	super();
	this.food = food;
	this.beverage = beverage;
	this.clothes = clothes;
	this.appliance = appliance;
	
}


@Override
public String toString() {
	return "Cart [food=" + food + ", beverage=" + beverage + ", clothes=" + clothes + ", appliance=" + appliance + "]";
}


public Food getFood() {
	return food;
}
public void setFood(Food food) {
	this.food = food;
}
public Beverage getBeverage() {
	return beverage;
}
public void setBeverage(Beverage beverage) {
	this.beverage = beverage;
}
public Clothes getClothes() {
	return clothes;
}
public void setClothes(Clothes clothes) {
	this.clothes = clothes;
}
public Appliance getAppliance() {
	return appliance;
}
public void setAppliance(Appliance appliance) {
	this.appliance = appliance;
}

}
