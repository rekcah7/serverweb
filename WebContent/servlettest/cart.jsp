<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/serverweb/cart.do">
		�׸���<br /> <select name="item">
			<option value="�����">�����
			<option value="��Ź��">��Ź��
			<option value="TV">TV
			<option value="��ġ�����">��ġ�����
			<option value="���ڷ�����">���ڷ�����
		</select> <input type="submit" value="��ٱ���" />
	</form>
	<hr />
	<%
	/* String item = (String)session.getAttribute("item");
	Integer value = (Integer)session.getAttribute("value"); */
	Enumeration<String> attrNames =  session.getAttributeNames();
	
	while(attrNames.hasMoreElements()){
		String attrName = attrNames.nextElement();
		int attrVal = (Integer)session.getAttribute(attrName);
		%>
		<h3><%=attrName%>:<%=attrVal%></h3>
		<!-- System.out.println(attrName+":"+attrVal); -->
	<%}%>

	<%-- <%if(item.equals("�����"))%>
	<h2>�����:<%=value %>	</h2>
	<%if(item.equals("��Ź��"))%>
	<h2>��Ź��:<%=value %></h2>
	<%if(item.equals("TV"))%>
	<h2>TV:<%=value %></h2>
	<%if(item.equals("��ġ�����"))%>
	<h2>��ġ�����:<%=value %></h2>
	<%if(item.equals("���ڷ���"))%>
	<h2>���ڷ���:<%=value %></h2> --%>

</body>
</html>
