package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//設定編碼,可以做也可以不做,jsp中有做了
				resp.setCharacterEncoding("UTF-8");//告訴servlet所有字段都會用UTF8
				resp.setContentType("text/html;charset=UTF-8");//告訴瀏覽器
				
				//建立分派器
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_form.jsp");
				//沒有要帶參數,不用setAttribute
				rd.forward(req, resp);
	}
	
	@Override
	//處理使用者
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收表單資料
		//1.請求編碼,因為不知道使用者會輸入什麼
		req.setCharacterEncoding("UTF-8");
		
		//2.接收使用者輸入的參數,input的內容
		String userName = req.getParameter("userName"); //
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		//3.將參數資料注入到model中(User.java)
		User user = new User(userName, gender, age, height, weight);
		
		//4.分派到/WEB-INF/user_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_result.jsp");
		req.setAttribute("user", user); //將user資料物件傳給jsp
		rd.forward(req, resp);
		
		
		//resp.getWriter().print(user);
		//resp.getWriter().print("doPost()..."); 送出表單後就會連接到dopost這個方法,會出現doPost()...
	}

}
