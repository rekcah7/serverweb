package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpInsertServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("EmpInsertServlet 서블릿 성공");
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		//1. 클라이언트의 요청정보 추출
		PrintWriter out = res.getWriter();
		String deptno = req.getParameter("deptno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String addr = req.getParameter("addr");
		int point = Integer.parseInt(req.getParameter("point"));
		String grade = req.getParameter("grade");
		
		//2. 비지니스 메소드 호출
		EmpDTO user = 
				new EmpDTO(id, pass, name, addr, grade, point, deptno);
		EmpService service = new EmpServiceImpl();
		int result = service.insert(user);
		
		//3. 응답화면을 생성
		String msg = "";
		if(result >= 1){
			msg = result+"개 형 삽입 성공";
		}else{
			msg = "삽입실패";
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>"+msg+"</h1>");
		out.println("<h3 href='/serverweb/emp/list.do'>회원목록 보기</h3>");
		out.println("</body>");
		out.println("</html>");
		
		
		/*if(result<=0){
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>삽입실패</h1>");
			out.println("<h1>삽입실패</h1>");
			out.println("</body>");
			out.println("</html>");
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>삽입성공</h1>");
			out.println("<h1>"+result+"개의 행 삽입 성공</h1>");
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
