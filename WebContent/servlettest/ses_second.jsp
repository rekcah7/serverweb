<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%//request�� ����� �����͸� ������ ��� 
	/* String mydata = (String)request.getAttribute("mydata"); */
	String mydata = (String)session.getAttribute("mydata");
	%>
	<h2>���� ������(second����):<%= mydata %></h2>
	<hr/>
	<h3><a href="#">�����Ͱ� �����ɱ��?</a></h3>
</body>
</html>