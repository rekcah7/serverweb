package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
								throws ServletException, IOException{
		System.out.println("PostFormServlet ���� ��û ����");
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		//��û��������
		PrintWriter out = res.getWriter();
		String id = req.getParameter("userId");
		String name = req.getParameter("userName");
		String password = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		
		out.println("<html>");
		out.println("<body>");
		out.println("Customer");
		out.println("<HR/>");
		out.println("���̵�:"+id+"<br/>");
		out.println("�̸�:"+name+"<br/>");
		out.println("��ȣ:"+password+"<br/>");
		out.println("����:"+gender+"<br/>");
		out.println("����:"+job+"<br/>");
		out.print("�����ϴ°�:");
		for(int i=0;i<item.length;i++){
		out.print(item[i]+", ");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
