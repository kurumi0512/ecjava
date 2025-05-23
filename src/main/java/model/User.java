package model;

public class User {
	private String userName; 	//from表單欄位
	private String gender; 		//from表單欄位
	private Integer age; 		//from表單欄位
	private Double height; 		//from表單欄位
	private Double weight;		//from表單欄位
	private Double bmiValue;	//自建欄位
	private String result;      //自建欄位
	//建構子封裝
	public User(String username, String gender, String age, String height, String weight) {
		this.userName = username;
		this.gender = gender;
		this.age = Integer.parseInt(age);
		this.height = Double.parseDouble(height);
		this.weight = Double.parseDouble(weight);
		//計算bmi值
		this.bmiValue = this.weight / Math.pow(this.height/100, 2);
		//診斷
		setResult();
	}
	//診斷的邏輯
	private void setResult() {
		double min = 0, max =0;
		switch (gender) {
			case "male" : 
				min =17.4;
				max = 23.3;
				break;
			case "female":
				min =17.1;
				max = 22.7;
				break;
		}
		String result =bmiValue < min ? "過瘦" :bmiValue > max ? "過胖" : "正常";
		this.result =result;
	}
	//方法封裝-getter,給jsp調用
	public String getResult(){
		return result;
	}
	
	
	//方法封裝-getter,自動生成
	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getBmiValue() {
		return bmiValue;
	}
	
	@Override //自動生成
	public String toString() {
		return "User [userName=" + userName + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", bmiValue=" + bmiValue + "]";
	}	
}
