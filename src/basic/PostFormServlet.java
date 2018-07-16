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
		System.out.println("PostFormServlet 서블릿 요청 성공");
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		//요청정보추출
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
		out.println("아이디:"+id+"<br/>");
		out.println("이름:"+name+"<br/>");
		out.println("암호:"+password+"<br/>");
		out.println("성별:"+gender+"<br/>");
		out.println("직업:"+job+"<br/>");
		out.print("종아하는것:");
		for(int i=0;i<item.length;i++){
		out.print(item[i]+", ");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
