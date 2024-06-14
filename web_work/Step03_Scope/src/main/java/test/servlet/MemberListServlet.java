package test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.member.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberDto> members = new ArrayList<MemberDto>();
		members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
		members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
		members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
		
		req.setAttribute("members", members);
		
		RequestDispatcher rd = req.getRequestDispatcher("/member/list.jsp");
		rd.forward(req, resp);
	}
}