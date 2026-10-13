<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
	String succMsg = (String) request.getAttribute("succMsg");
	%>

	<form action="UserCtl" method="post">

		<div>

			<h1>Add User</h1>
			<h1 style="color : green"><%= succMsg != null ? succMsg : "" %></h1>

			<table>
				<tr>

					<th>FirstName</th>
					<td><input type="text" name="first Name" value=""
						placeholder="enter you first Name"></td>

				</tr>

				<tr>

					<th>LastName</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter your lastName"></td>

				</tr>

				<tr>
					<th>Email</th>
					<td><input type="email" name="loginId" value=""
						placeholder="enter your emailId"></td>

				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>

				</tr>

				<tr>
					<th>D.O.B</th>
					<td><input type="date" name="dob" value=""
						placeholder="enter your dob"></td>

				</tr>

			</table>

			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="submit"></td>

			</tr>

		</div>

	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>