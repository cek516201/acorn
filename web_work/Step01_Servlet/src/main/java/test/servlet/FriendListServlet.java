package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/friend/list")
public class FriendListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		// 응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		
		// DB에 있는 친구목록이라 가정
		List<String> names = new ArrayList<String>();
		names.add("ㅁㅁㅁ");
		names.add("ㄴㄴㄴ");
		names.add("ㅇㅇㅇ");
		
		// 요청을 한 클라이언트에게 문자열을 출력할수 있는 객체의 참조값 얻어내기
		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>친구 목록 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
			pw.println("<h3>친구 목록</h3>");
			pw.println("<ul>");
				for (int i = 0; i < names.size(); i++) {
					pw.println("<li>" + names.get(i) + "</li>");
				}
			pw.println("</ul>");
	
			pw.println("<ul>");
				for (var elem : names) {
					pw.println("<li>" + elem + "</li>");
				}
			pw.println("</ul>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}