package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
					throws ServletException, IOException{
		System.out.println("CalcServlet ���� ����");
		//ó���� ���� �⺻ �۾� - �ѱۼ���, ���䰴ü�� ���� ��Ʈ���� ���, ���信 ���� Ÿ���� ����
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = res.getWriter();
		int num1 = Integer.parseInt(req.getParameter("num1"));
		/*String num1 = req.getParameter("num1");*/
		String method = req.getParameter("method");
		int num2 = Integer.parseInt(req.getParameter("num2"));
		/*String num2 = req.getParameter("num2");*/
		
		//�����Ͻ����� ȣ��
		Calc obj = new Calc();
		/*int result = obj.calc(Integer.parseInt(num1),Integer.parseInt(num2),method);*/
		int result = obj.calc(num1, num2, method);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr/>");
		out.println("���ȭ��"+"<br/>");
		out.println("<hr/>");
		out.println("num1�� " + num1 +"��"+"num2��"+num2+"��"+"<br/>");
		out.println("������ ����� " + result +"�Դϴ�."+"<br/>");
		out.println("</body>");
		out.println("</html>");
		
	}
}