package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 서블릿

// HttpServlet 클래스를 상속받아서 만든다
// service() 메소드를 오버라이드 한다
// 어떤 경로 요청이 왔을 때 동작할지 @WebServlet 어노테이션 경로를 설정한다

// 클라이언트가 /fortune 요청을 해오면 Tomcat 서버가 FortuneServlet 클래스로 객체를 생성해서 service() 메소드 호출
// 요청에 관련된 HttpServletRequest, 응답에 관련된 HttpServletResponse

@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		// 응답 content type 설정
		resp.setContentType("text/html; charset=utf-8");
		// 요청을 한 클라이언트에게 문자열을 출력할 수 있는 객체의 참조값 얻어내기
		PrintWriter pw = resp.getWriter();

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>오늘의 운세</title>");
		pw.println("</head>");
		pw.println("<body>");

		String[] fortune = { "ㅁㅁㅁ", "ㄴㄴㄴ", "ㅇㅇㅇ", "ㄹㄹㄹ", "ㅎㅎㅎ" };
		pw.println("<h1>오늘의 운세</h1>");
		pw.println("<strong>" + fortune[new Random().nextInt(0, fortune.length)] + "</strong>");

		pw.println("</body>");
		pw.println("</html>");

		pw.flush();
		pw.close();
	}
}