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
		System.out.println("CalcServlet 서블릿 성공");
		//처리를 위한 기본 작업 - 한글설정, 응답객체로 부터 스트림을 얻기, 응답에 대한 타입을 설정
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = res.getWriter();
		int num1 = Integer.parseInt(req.getParameter("num1"));
		/*String num1 = req.getParameter("num1");*/
		String method = req.getParameter("method");
		int num2 = Integer.parseInt(req.getParameter("num2"));
		/*String num2 = req.getParameter("num2");*/
		
		//비지니스로직 호출
		Calc obj = new Calc();
		/*int result = obj.calc(Integer.parseInt(num1),Integer.parseInt(num2),method);*/
		int result = obj.calc(num1, num2, method);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr/>");
		out.println("결과화면"+"<br/>");
		out.println("<hr/>");
		out.println("num1의 " + num1 +"과"+"num2의"+num2+"을"+"<br/>");
		out.println("연산한 결과는 " + result +"입니다."+"<br/>");
		out.println("</body>");
		out.println("</html>");
		
	}
}