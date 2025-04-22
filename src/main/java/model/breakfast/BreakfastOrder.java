package model.breakfast;

public class BreakfastOrder {
	private MainDish mainDish; // 主餐
	private Drink drink; // 飲料
	private Topping topping; // 配料
	private int totalPrice; // 總價

	// 原先mainDishName是String要把他轉成MainDish的物件
	public BreakfastOrder(String mainDishName, String drinkName, String[] toppingArray) {
		this(new MainDish(mainDishName), new Drink(drinkName), new Topping(toppingArray));
	}

	public BreakfastOrder(MainDish mainDish, Drink drink, Topping topping) {
		this.mainDish = mainDish;
		this.drink = drink;
		this.topping = topping;
		this.totalPrice = mainDish.getPrice() + drink.getPrice() + topping.getPrice();
	}

	public MainDish getMainDish() {
		return mainDish;
	}

	public Drink getDrink() {
		return drink;
	}

	public Topping getTopping() {
		return topping;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

}