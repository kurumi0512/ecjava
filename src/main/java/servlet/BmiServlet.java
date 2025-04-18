package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Util.Util;

@WebServlet("/bmi")
public class BmiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//1.設定編碼
				resp.setCharacterEncoding("UTF-8");//告訴servlet所有字段都會用UTF8
				resp.setContentType("text/html;charset=UTF-8");//告訴瀏覽器
				
				//2.接收參數
		        String height = req.getParameter("h");
				String weight =req.getParameter("w");
				
				//3.驗證參數
				if(!(Util.isDouble(height)&&(Util.isDouble(weight)))) {
					resp.getWriter().print("身高體重輸入錯誤");
					return;
				}
				
				//4.計算bmi
				double h = Double.parseDouble(height);
				double w = Double.parseDouble(weight);
				double bmiValue = getBMIvalue(h, w);
				String result = getBMIResult(bmiValue);
				
				//5.印出資訊
				//resp.getWriter().print("BMI值 = " +bmiValue + " (" +result + ")");
				resp.getWriter().print(String.format("BMI 值 = %.2f (%s)",bmiValue,result));
			}
			//計算bmi值
			private double getBMIvalue(double h ,double w) {
				return w /Math.pow(h/100, 2);
			}
			//BMI判讀
			private String getBMIResult(double bmiValue) {
				return bmiValue <=18 ?"過輕" :(bmiValue >23) ?"過重" :"正常";
			}		
}
