package servlet;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random = new Random();
		Set<Integer>numbers = new LinkedHashSet<>();
		while(numbers.size()<5) {
			int number =random.nextInt(39)+1;
			numbers.add(number);
		}
		resp.getWriter().print(numbers);
		
	}

	

}
