package model.breakfast;

import java.util.Map;

// 主餐
public class MainDish {

	private String name; // 主餐名稱
	private int price; // 價格
	// 價格表
	private static final Map<String, Integer> PRICE_MAP = Map.of("蛋餅", 35, "漢堡", 40, "三明治", 30);

	public MainDish(String name) {
		this.name = name;
		Integer priceObj = PRICE_MAP.get(name);
		if (priceObj == null) {
			throw new IllegalArgumentException("找不到主餐價格：「" + name + "」");
		}
		this.price = priceObj;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
