package shop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Cashier {
	
	private int state= 0;
	public double fdiscount(Cart cart) {
		Food food = cart.getFood();
		Beverage beverage = cart.getBeverage();
		Calendar calendar = Calendar.getInstance();
		LocalDate date = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate date2 = food.getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		double price = 0.0;
		double sumoOfDiscount = 0.0;
		// System.out.print(date.getDayOfMonth() - date2.getDayOfMonth());
		if (date.equals(date2)) {
			price = food.getPrice();
			food.setPrice(price * 0.50);
			sumoOfDiscount = price - food.getPrice();
			state=1;
		} else if (date2.isBefore(date) && date.getDayOfMonth() - date2.getDayOfMonth() <= 5
				&& date2.getMonthValue() == date.getMonthValue() && date2.getYear() == date.getYear()) {
			price = food.getPrice();
			food.setPrice(price * 0.90);
			sumoOfDiscount = price - food.getPrice();
			state=2;
		}
		state=0;
		return sumoOfDiscount;
	}

	public boolean clothesSize(Cart cart) {
		Clothes clothes = cart.getClothes();

		if (!clothes.getColor().isEmpty() && clothes.getSize().matches("S") || clothes.getSize().matches("M")
				|| clothes.getSize().matches("XS") || clothes.getSize().matches("L")
				|| clothes.getSize().matches("XL")) {
			return true;
		} else {
			return false;

		}
	}

	public double clothesDiscount(Cart cart) {
		Clothes clothes = cart.getClothes();

		double price = 0.0;
		double sumOfDiscount = 0.0;
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			price = clothes.getPrice();
			clothes.setPrice(price * 0.9);
			sumOfDiscount = price - clothes.getPrice();
			state = 1;
			return sumOfDiscount;
		} else {
			state = 0;
			return sumOfDiscount;
		}
	}

	public double appliancesDiscount(Cart cart) {
		Appliance appliance = cart.getAppliance();
		double price = 0.0;
		double sumOfDiscount = 0.0;
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && appliance.getPrice() > 999.0) {
			price = appliance.getPrice();
			appliance.setPrice(price * 0.95);
			sumOfDiscount = price - appliance.getPrice();
			state = 1;
			return sumOfDiscount;

		} else {
			state = 0;
			return sumOfDiscount;
			
		}
	}
	
	public void showReceipt(Cart card) {
		Calendar calendar = Calendar.getInstance();
		LocalDate date = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		//Cashier cashier = new Cashier();
		double rawPrice=0.0;
		double discountPrice=0.0;
		double totalDiscount=0.0;
		double subtotal=0.0;
		double total=0.0;
		
		System.out.println("Date: "+date.toString());
		System.lineSeparator();
		System.out.println("--Products--");
		System.lineSeparator();
		if(card.getFood()!=null) {
		System.out.println(card.getFood().getName()+" - "+card.getFood().getBrand());
		rawPrice=card.getFood().getQuantity()*card.getFood().getPrice();
		System.out.println(card.getFood().getQuantity()+" x "+card.getFood().getPrice()+" = "+rawPrice);
		subtotal+=rawPrice;
		discountPrice=this.fdiscount(card);
		totalDiscount+=discountPrice;
		if(state==1) {
			System.out.println("#discount 50% $"+discountPrice);
		}
		else if(state==2) {
			System.out.println("#discount 10% $"+discountPrice);
		}
		
		}
		
		if(card.getBeverage()!=null) {
			System.out.println(card.getBeverage().getName()+" - "+card.getBeverage().getBrand());
			rawPrice=card.getBeverage().getQuantity()*card.getBeverage().getPrice();
			System.out.println(card.getBeverage().getQuantity()+" x "+card.getBeverage().getPrice()+" = "+rawPrice);
			discountPrice=this.fdiscount(card);
			totalDiscount+=discountPrice;
			subtotal+=rawPrice;
			if(state==1) {
				System.out.println("#discount 50% $"+discountPrice);
			}
			else if(state==2) {
				System.out.println("#discount 10% $"+discountPrice);
			}
		}
		
		if(card.getClothes()!=null || this.clothesSize(card) ){
			System.out.println(card.getClothes().getName()+" - "+card.getClothes().getBrand());
			rawPrice=card.getClothes().getQuantity()*card.getClothes().getPrice();
			System.out.println(card.getClothes().getQuantity()+" x "+card.getClothes().getPrice()+" = "+rawPrice);
			discountPrice=this.clothesDiscount(card);
			totalDiscount+=discountPrice;
			subtotal+=rawPrice;
			if (state==1) {
				System.out.println("#discount 10% $"+discountPrice);
			}
		}
		if(card.getAppliance()!=null) {
			System.out.println(card.getAppliance().getName()+" - "+card.getAppliance().getBrand());
			rawPrice=card.getAppliance().getQuantity()*card.getAppliance().getPrice();
			System.out.println(card.getAppliance().getQuantity()+" x "+card.getAppliance().getPrice()+" = "+rawPrice);
			discountPrice=this.appliancesDiscount(card);
			totalDiscount+=discountPrice;
			subtotal+=rawPrice;
			if (state==1) {
				System.out.println("#discount 5% $"+discountPrice);
			}
		}
		
		System.out.println(" SUBTOTAL: "+subtotal);
		System.out.println(" DISCOUNT: "+totalDiscount);
		System.out.println(" SUBTOTAL: "+(subtotal-totalDiscount));
		
		
		
		
	}

	public static void main(String[] args) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = simpleDateFormat.parse("2021-06-30");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Food food = new Food("apple", "Brand-A", 1.50, date, 2.45);
		Beverage beverage = new Beverage("milk", "BrandM", 1, date, 3);
		Appliance appliance = new Appliance("laptop", "BrandT", 2345, "Modell", date, 2.5, 1);
		Clothes clothes = new Clothes("T-shirt", "BrandT", 15.99, "M", "violet", 2);

		
		Cashier cashier = new Cashier();
		Cart cart = new Cart(food, beverage, clothes, appliance);
		cashier.showReceipt(cart);
		/*
		double discount = cashier.fdiscount(cart);

		if (!cashier.clothesSize(cart)) {
			System.out.println("No");
		} else
			System.out.println("Yes");
		double discount2 = cashier.clothesDiscount(cart);
		System.out.println(discount2);
		double discount3 = cashier.appliancesDiscount(cart);
		System.out.println(discount3);
		
		 * System.out.println("namalenieto e " + discount);
		 * System.out.println(date.toString()); System.out.println(food.toString());
		 * System.out.println(beverage.toString()); System.out.println(cart.toString());
		 */
	}

}
