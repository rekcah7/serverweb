package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;

@WebServlet(name = "include", urlPatterns = { "/include.do" })
public class includeTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = response.getWriter();
		
		System.out.println("include���� - include���� ������");
		out.println("<h1>��û������ ���� - include</h1>");
		
		//1. ������ ���� - db���� ������ ����� �����Ͻ����� ������
		EmpDTO dto = new EmpDTO("jang","","�嵿��","","",0,"11");
		//��û�����ȿ��� "mydata"��� �̸����� dto�� ������ �� �ֵ��� �����۾�
		request.setAttribute("mydata", dto);
		
		//2.��û������ - sendRedirect
		//������ ��û�ǰ� response���� ���� ���·� �ٽ� jsp�� ��û�Ǵ� ���̹Ƿ� ����
		//context�ȿ��� �۾��� �̷������. ���� context���� ��θ� �����Ѵ�.
		/*response.sendRedirect("/serverweb/servlettest/result.jsp");*/
		RequestDispatcher rd = 
				/*request.getRequestDispatcher("/serverweb/servlettest/result.jsp");*/
				request.getRequestDispatcher("/servlettest/result.jsp");
		rd.include(request, response);
		
		out.print("<h1>��û������ ����-include end</h1>");
		
	}
}
