<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String bookTitle = (String)request.getAttribute("bookTitle");
	String bookPage = (String)request.getAttribute("bookPage");
	%>
	
	
	<h2>
		�ֱٿ� ���� å�� ������ <%= URLDecoder.decode(bookTitle, "euc-kr") %>�̸� <%=bookPage %>���� �о����ϴ�.
	</h2>
</body>
</html>