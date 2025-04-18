package servlet;

import java.io.IOException;

import Util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CoffeeOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.設定編碼
		resp.setCharacterEncoding("UTF-8");//告訴servlet所有字段都會用UTF8
		resp.setContentType("text/html;charset=UTF-8");//告訴瀏覽器
		
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String suger = req.getParameter("suger");
		
		//3.驗證參數
		if(!(Util.isNumber(type)&&(Util.isNumber(size)&&(Util.isNumber(suger))))) {
			resp.getWriter().print("輸入錯誤");
			return;
		}
		
	}				
}
	


