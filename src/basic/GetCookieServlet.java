package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��Ű ��������
@WebServlet(name = "getCookie", urlPatterns = { "/getCookie" })
public class GetCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("getCookie");
		//request��ü���� ��Ű�� ������.
		Cookie[] cookies = request.getCookies();
		
		//��Ű�� ����� value�� ������ ����
		String bookTitle = "";
		String bookPage = "";
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("booktitle")){
				bookTitle = cookies[i].getValue();
			}else if(cookies[i].getName().equals("bookpage")){
				bookPage = cookies[i].getValue();
			}
		}
		//���� ��Ű�� ����
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("bookPage", bookPage);
		
		//��û������
		RequestDispatcher rd = request.getRequestDispatcher("/servlettest/cookieResult.jsp");
		rd.forward(request, response);
		
	}
}
