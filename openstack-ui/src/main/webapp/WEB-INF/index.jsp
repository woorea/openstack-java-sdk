<%@ page isELIgnored='false'%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/custom.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="POST">
		<div class="modal" id="myModal">

			<div class="modal-header">
				<h3>Login</h3>
			</div>
			<div class="modal-body">

				<div class="control-group">
					<label class="control-label" for="authURL">Auth URL</label>
					<div class="controls">
						<input class="input-xlarge" id="identityURL" name="identityURL"
							value="http://192.168.1.52:5000/v2.0" />
						<p class="help-block">Identity server URL (all your deployment should be accessible over Internet)</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="username">Username</label>
					<div class="controls">
						<input class="input-xlarge" id="username" name="username"
							value="demo" />
						<p class="help-block">xxx</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<input type="password" class="input-xlarge" name="password"
							value="secret0" />
						<p class="help-block">xxx</p>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="login">Login</button>
			</div>
		</div>
	</form>
</body>
</html>

