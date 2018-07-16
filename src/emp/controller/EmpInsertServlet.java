package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpInsertServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("EmpInsertServlet ���� ����");
		
		req.setCharacterEncoding("euc-kr");
		/*res.setContentType("text/html;charset=euc-kr");
		
		//1. Ŭ���̾�Ʈ�� ��û���� ����
		PrintWriter out = res.getWriter();*/
		
		System.out.println("EmpInsertServlet���� - forward ������");
		String deptno = req.getParameter("deptno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String addr = req.getParameter("addr");
		int point = Integer.parseInt(req.getParameter("point"));
		String grade = req.getParameter("grade");
		
		//2. �����Ͻ� �޼ҵ� ȣ��
		EmpDTO user = 
				new EmpDTO(id, pass, name, addr, grade, point, deptno);
		EmpService service = new EmpServiceImpl();
		int result = service.insert(user);
		

		String msg = "";
		if(result >= 1){
			msg = result+"�� �� ���� ����";
		}else{
			msg = "���Խ���";
		}
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp");
		rd.forward(req, res);

		//3. ����ȭ���� ���� - sendRedirect
		/*res.sendRedirect("/serverweb/basic/insertResult.html");*/
		
		/*if(result<=0){
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>���Խ���</h1>");
			out.println("<h1>���Խ���</h1>");
			out.println("</body>");
			out.println("</html>");
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>���Լ���</h1>");
			out.println("<h1>"+result+"���� �� ���� ����</h1>");
			out.println("</body>");
			out.println("</html>");
		}*/
		/*System.out.println(deptno);
		System.out.println(name);
		System.out.println(id);
		System.out.println(pass);
		System.out.println(addr);
		System.out.println(point);
		System.out.println(grade);*/
	}

}
