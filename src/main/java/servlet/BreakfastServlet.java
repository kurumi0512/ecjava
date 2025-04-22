package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.breakfast.BreakfastOrder;
import model.ice.IceOrder;

// 冰果店
@WebServlet("/breakfast")
public class BreakfastServlet extends HttpServlet {

	private static List<BreakfastOrder> breakfastOrders = new CopyOnWriteArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/breakfast_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 接收表單參數
		String mainDishName = req.getParameter("mainDish");
		String drinkName = req.getParameter("drink");
		String[] toppingArray = req.getParameterValues("toppings");

		// 建立訂單物件
		BreakfastOrder breakfastOrder = new BreakfastOrder(mainDishName, drinkName, toppingArray);

		// ✅ 加進 List 中
		breakfastOrders.add(breakfastOrder);

		// ✅ 傳到 JSP
		req.setAttribute("breakfastOrders", breakfastOrders);

		// 轉交給 JSP 顯示
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/breakfast_result.jsp");
		rd.forward(req, resp);
	}

}