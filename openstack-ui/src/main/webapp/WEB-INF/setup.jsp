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
	<form action="${pageContext.request.contextPath}/setup" method="POST">
		<div class="modal" id="myModal">

			<div class="modal-header">
				<h3>OpenStack UI Setup</h3>
			</div>
			<div class="modal-body">

				<div class="control-group">
					<label class="control-label" for="identity-public-url">Identity Public URL</label>
					<div class="controls">
						<input class="input-xlarge" id="identity-public-url" name="identity.endpoint.publicURL" value="http://192.168.1.52:5000/v2.0" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="identity-internal-url">Identity Internal URL</label>
					<div class="controls">
						<input class="input-xlarge" id="identity-internal-url" name="identity.endpoint.internalURL" value="http://192.168.1.52:5000/v2.0" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="identity-admin-url">Identity Administration URL</label>
					<div class="controls">
						<input class="input-xlarge" id="identity-admin-url" name="identity.endpoint.adminURL" value="http://192.168.1.52:35357/v2.0" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="identity-admin-token">
						Identity Administration Token 
						<span class="help-block">(ie : 666777888999)</span>
					</label>
					<div class="controls">
						<input class="input-xlarge" id="identity-admin-url" name="identity.admin.token" value="secret0" />
						
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="login">Finish</button>
			</div>
		</div>
	</form>
</body>
</html>