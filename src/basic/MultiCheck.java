package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiCheck extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("multi ���� ��û ����");

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");

		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String[] sw = req.getParameterValues("sw");

		out.println("<html>");
		out.println("<body>");
		out.println("<hr/>");
		out.println("�̸�:" + name + "<br/>");
		out.println("�ּ�:" + addr + "<br/>");
		out.println("������� ����Ʈ����" + "<br/>");
		for (int i = 0; i < sw.length; i++) {
			out.print(sw[i] + "<br/>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
