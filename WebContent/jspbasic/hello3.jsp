<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<style type="text/css">
	#myimg{
		border: solid 3px blue;
	}
	</style>
	<script type="text/javascript">
		function test(){
			alter("환영합니다.");
		}
	</script>
</head>
<body>
	<h1><%="hello3" %></h1>
	<hr/>
	<img src="../images/jang.jpg" id="myimg"/>
</body>
</html>