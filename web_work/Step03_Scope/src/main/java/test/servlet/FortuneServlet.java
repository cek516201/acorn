package test.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 비즈니스 로직은 servlet에서
		String fortune = "ㅁㅁㅁ";
		
		// 오늘의 운세를 request 영역에 담기(HttpServletRequest)
		req.setAttribute("fortuneToday", fortune);
		
		// 클라이언트에게 응답은 jsp페이지에 위임(forward 이동)
		RequestDispatcher rd = req.getRequestDispatcher("/test/fortune.jsp");
		rd.forward(req, resp);
	}
}
