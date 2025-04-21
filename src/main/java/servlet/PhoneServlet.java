package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PhonePlan;

@WebServlet("/phone")
public class PhoneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/phone_form.jsp");
		// 沒有要帶參數,不用setAttribute
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收表單資料
		// 1.請求編碼,因為不知道使用者會輸入什麼
		req.setCharacterEncoding("UTF-8");

		// 2.接收使用者輸入的參數,input的內容
		String minAmount = req.getParameter("min"); //
		String gbAmount = req.getParameter("gb");

		// 3.將參數資料注入到model中(Coffeeshop.java)
		PhonePlan phoneplan = new PhonePlan(minAmount, gbAmount);

		// 4.分派到/WEB-INF/user_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/phone_result.jsp");
		req.setAttribute("phoneplan", phoneplan); // 將user資料物件傳給jsp "字串"(傳給jsp的),變數
		rd.forward(req, resp);
	}

}
