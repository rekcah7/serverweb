package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;
@WebServlet(name="login", urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LoginServlet ���� ����");

		req.setCharacterEncoding("euc-kr");
		
		//1.��û���� ����
		System.out.println("LoginServlet���� - Login ������");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		System.out.println("id : "+id+" pass : "+pass);

		// 2. �����Ͻ� �޼ҵ� ȣ��
		EmpDTO loginUser = new EmpDTO();
		EmpService service = new EmpServiceImpl();
		loginUser = service.login(id, pass);
		/*System.out.println(loginUser.getId());*/
		
		//�α��� �����ϸ� ��Ű�� ����
		//-> ���̵� ������ üũ�� ���·� �α��� ��ư�� �������� �α����� �����ϸ�
		//���̵� ��Ű�� ����
		if(check != null){
			if(check.equals("T") & loginUser != null){
				Cookie cookie = new Cookie("id", loginUser.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		
		
		//3. ������ ����
		req.setAttribute("login", loginUser);
		
		//4. ��û ������ - forward
		String url="";
		if(loginUser != null){//�α��� ����
			url = "/emp/list.do";
		}else{
			url = "/emp/login.jsp";//�α��� ����
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, res);
		
		
		
		/*RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);*/
		/*String msg = "";
		if (result >= 1) {
			msg = result + "�� �� ���� ����";
		} else {
			msg = "���Խ���";
		}*/

		/*req.setAttribute("msg", msg);*/
		/*RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp");
		rd.forward(req, res);*/
	}
}