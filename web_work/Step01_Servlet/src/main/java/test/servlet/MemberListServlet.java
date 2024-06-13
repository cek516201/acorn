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
import test.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		// 응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");

		List<MemberDto> members = new ArrayList<MemberDto>();
		members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
		members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
		members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));

		// 요청을 한 클라이언트에게 문자열을 출력할수 있는 객체의 참조값 얻어내기
		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>회원 목록 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
			pw.println("<h3>회원 목록</h3>");
			pw.println("<table>");
				pw.println("<tr>");
					pw.println("<th>번호</th>");
					pw.println("<th>이름</th>");
					pw.println("<th>주소</th>");
				pw.println("</tr>");
			for (var member : members) {
				pw.println("<tr>");
					pw.println("<td>"+ member.getNum() +"</td>");
					pw.println("<td>"+ member.getName() +"</td>");
					pw.println("<td>"+ member.getAddr() +"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}