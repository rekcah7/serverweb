<%@page import="emp.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/emp/search.jsp" />
	<h2>jsp�� �Ҹ��� ����ȭ��</h2>
	<hr />
	<% ArrayList<EmpDTO> userlist = (ArrayList<EmpDTO>) request.getAttribute("userlist");
		EmpDTO loginUser = (EmpDTO) request.getAttribute("loginUser");
	%>

	<%-- <% EmpDTO login = (EmpDTO) request.getAttribute("login"); %> --%>

	<%-- <% ArrayList<EmpDTO> userlist = (ArrayList<EmpDTO>) request.getAttribute("userserch"); %> --%>

	<%if(loginUser==null){
			response.sendRedirect("/serverweb/emp/login.jsp");
			}else{
				<h4><%= loginUser.getName() %></h4>
	<h1>������(jsp�� �и�)</h1>
	<hr />

	<table border='1'>
		<tr bgColor='skyblue'>

			<th>���̵�</th>
			<th>����</th>
			<th>�н�����</th>
			<th>�ּ�</th>
			<th>�Ի�����</th>
			<th>���</th>
			<th>����Ʈ</th>
			<th>�μ���ȣ</th>
			<th>����</th>
		</tr>
		<% 
	int size = userlist.size();
	System.out.println("����"+userlist.size());
	%>
		<% 
				for (int i = 0; i < size; i++) {
					EmpDTO user = userlist.get(i);
				%>
		<tr>
			<td><a
				href='/serverweb/emp/read.do?info=test&id=<%=user.getId()%>&action=READ'><%=user.getId()%></a></td>
			<td><%=user.getName()%></td>
			<td><%=user.getPass()%></td>
			<td><%=user.getAddr()%></td>
			<td><%=user.getHiredate()%></td>
			<td><%=user.getGrade()%></td>
			<td><%=user.getPoint()%></td>
			<td><%=user.getDeptno()%></td>
			<td><a
				href='/serverweb/emp/delete.do?info=test&id=<%=user.getId()%>'>����</a></td>
		</tr>
		<%
				}
				%>
		<%-- <jsp:include page="/emp/search.jsp">
					<jsp:param value="" name=""/>
				</jsp:include> --%>

		}%> }
	</table>
</body>
</html>