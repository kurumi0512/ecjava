package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/*
 * 可擴充:add(...)
 * 邏輯可分離:條件與邏輯分開
 * 容易測試
 * 可以利用 lambda 開發與理解上較為直觀
 */

public class PhonePlan {
	private Integer min; // 通話分鐘
	private Integer gb; // 流量

	// 建立一個內部類來代表一種手機類型的判斷規則,phonerule是屬於手機才可以使用
	static class PlanRule {
		// 類型名稱
		private String type;
		// 描述
		private Integer price;
		// 條件的判斷邏輯
		private BiPredicate<Integer, Integer> condition;

		public PlanRule(String type, Integer price, BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;
		}

		// 符合比對
		public boolean matches(Integer min, Integer gb) {
			return condition.test(min, gb); // BiPredicate的test方法
		}

		public String getResult() {
			return type + ": $" + price;
		}

	}

	// 可以儲存所有手機規則的清單
	private static final List<PlanRule> rules = new ArrayList<>();

	// 類別資料初始化區段
	static {
		// 初始化規則->下面的東西都會帶入這些東西
		rules.add(new PlanRule("商務型", 1499, (min, gb) -> min > 1000 || gb > 50));
		rules.add(new PlanRule("一般用戶型", 660, (min, gb) -> min > 500 || gb > 10));
		rules.add(new PlanRule("長輩節省型", 200, (min, gb) -> gb < 1 && min < 20));
	}

	// Phone 建構子
	public PhonePlan(Integer min, Integer gb) {
		this.min = min;
		this.gb = gb;
	}

	// 為了不讓servlet還要轉字串,所以這邊寫兩個建構子
	public PhonePlan(String min, String gb) {
		this(Integer.parseInt(min), Integer.parseInt(gb));
	}

	// 判斷咖啡類型
	public String getPhoneType() {
		return rules.stream().filter(rule -> rule.matches(min, gb)) // 找出符合條件的規則
				.findFirst() // 取得第一筆匹配的
				// .map(PlanRule::getResult)
				.map(rule -> rule.getResult()) // 轉換成字串
				.orElse("無適合方案");
	}

	// Getter
	public Integer getmin() {
		return min;
	}

	public Integer getGb() {
		return gb;
	}

	public static void main(String[] args) {
		rules.add(new PlanRule("商務型", 1499, (min, gb) -> min > 1000 || gb > 50));
	}

}
