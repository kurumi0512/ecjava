package model.breakfast;

import java.util.Map;

// 主餐
public class Drink {

	private String name; // 飲料名稱
	private int price; // 價格
	// 價格表
	private static final Map<String, Integer> PRICE_MAP = Map.of("豆漿", 15, "紅茶", 20, "牛奶", 25);

	public Drink(String name) {
		this.name = name;
		this.price = PRICE_MAP.get(name);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
