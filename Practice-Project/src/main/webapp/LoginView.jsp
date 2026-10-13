<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login View</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<form action="LoginCtl" method="post">
		<div align="center">

			<h1>Login View</h1>

			<table>

				<tr>

					<th>Login:*</th>
					<td><input type="text" name="loginId" value=""
						placeholder="Enter your emailId"></td>

				</tr>

				<tr>

					<th>Password:*</th>
					<td><input type="text" name=password value=""
						placeholder="Enter your password"></td>

				</tr>

			</table>

			<input type="submit" name="operation" value="SignIn">

		</div>
	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>