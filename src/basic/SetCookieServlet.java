package basic;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��Ű �����ϱ�
@WebServlet(name = "setCookie", urlPatterns = { "/setCookie" })
public class SetCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("setCookie");
		
		
		//��Ű�� �����ϰ� ���� �����͸� �����ؼ� Cookie��ü�� ����
		
		Cookie cookie1 = new Cookie("booktitle", 
				URLEncoder.encode("��Ŭ����", "euc-kr"));
		Cookie cookie2 = new Cookie("bookpage", "128");
		
		//��Ű�� ���� ��ȿ�ð��� ���� - �ʴ���
		cookie1.setMaxAge(60*60*24);
		cookie2.setMaxAge(60*60*24);
		
		
		//response�� ��Ű�� ����
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		response.sendRedirect("/serverweb/servlettest/cookieStart.jsp");
	}
}
