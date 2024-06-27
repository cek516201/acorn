package test.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. Filter 인터페이스 구현
// 2. 추상메소드 오벼라이딩
// 3. @WebFilter() 어노테이션을 이용해서 필터 맵핑

@WebFilter({"/user/private/*", "/file/private/*", "/shop/*", "/cafe/private/*"})
public class LoginFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getSession().getAttribute("id") == null) {
			/*
			 *  로그인 페이지로 강제 리다일렉트 됬다면 
			 *  로그인 성공후에 원래 가려던 목적지로 다시 보내야 하고
			 *  GET 방식 전송 파라미터가 있다면 파라미터 정보도 같이 가지고 갈수 있도록 해야한다.
			 */
			// 원래 가려던 url 정보 읽어오기
			String url = req.getRequestURI();
			// GET 방식 전송 파라미터를 query 문자열로 읽어오기 ( a=xxx&b=xxx&c=xxx )
			String query = req.getQueryString();
			// 특수 문자는 인코딩을 해야한다.
			String encodedUrl = null;
			if(query == null) { //전송 파라미터가 없다면 
				encodedUrl = URLEncoder.encode(url);
			} else {
				// 원래 목적지가 /test/xxx.jsp 라고 가정하면 아래와 같은 형식의 문자열을 만든다.
				// "/test/xxx.jsp?a=xxx&b=xxx ..."
				encodedUrl = URLEncoder.encode(url + "?" + query);
			}
			
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + "/user/loginform.jsp?url=" + encodedUrl);
		} else { // 로그인을 한 사용자라면
			// 관여하지 않고 요청의 흐름을 이어간다
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}