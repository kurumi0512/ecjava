package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//設定編碼
		resp.setCharacterEncoding("UTF-8");//告訴servlet
		resp.setContentType("text/html;charset=UTF-8");//告訴瀏覽器
		
		//接收參數
		//例如:http://localhost:8080/JavaWeb/welcome?name=Jack&age=17
		String name = req.getParameter("name");
		String age =req.getParameter("age");
		
		//檢查age是否是數字
		if(isNumber2(age)) {
			String message = Integer.parseInt(age) >=18?"成年" :"未成年";
			resp.getWriter().print(name + "歡迎光臨("+age +"歲" +message +")"); //直接呈現給瀏覽器
		} else {
			resp.getWriter().print(name + "歡迎光臨");
		}
	}	
	
	//判斷是否是數字
	private boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
		    return false;
		}
	}
	
	//判斷是否是數字
		private boolean isNumber2(String data) {
			if(data == null) return false;
			return data.matches("\\d+");
		}
	
	
}
