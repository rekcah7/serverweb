<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="emp.dto.EmpDTO"%>
<%@page import="emp.service.EmpService"%>
<%@page import="emp.service.EmpServiceImpl"%>

<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	System.out.println("insert.jsp jsp 성공");

	request.setCharacterEncoding("euc-kr");
	response.setContentType("text/html;charset=euc-kr");
	
	String deptno = request.getParameter("deptno");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String addr = request.getParameter("addr");
	int point = Integer.parseInt(request.getParameter("point"));
	String grade = request.getParameter("grade");
	
	EmpDTO user = 
			new EmpDTO(id, pass, name, addr, grade, point, deptno);
	EmpService service = new EmpServiceImpl();
	int result = service.insert(user);
%>
<%
String msg = "";
if(result >= 1){
%>
	<h3> <%=msg=result+"개 형 삽입 성공"%> ;</h3>
<% }else{%>
	<h3> <%=msg %> = "삽입실패";</h3>
<% }%>

<%-- <% response.sendRedirect("/serverweb/basic/insertResult.html");%> --%>
</body>
</html>