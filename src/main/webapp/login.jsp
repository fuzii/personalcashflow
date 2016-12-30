<%@ include file="./views/master/master.jsp" %>
<body>
	<style type="text/css">
		.form-login
		{
			width: 100%;
			max-width: 440px;
			text-align: center;
			margin: auto;
		}
	</style>
	<div class="container">
			<div class="panel form-login">
				<div class="panel-heading">
					<h1>Login</h1>
				</div>
				<div class="panel-body">
					<form method="post" action="login" class="form">
						<div class="form-group">
							<input type="text" class="form-control form-group" id="email" placeholder="email" />
							<input type="password" class="form-control form-group" id="pwd" placeholder="senha" />
							<input type="submit" class="btn btn-success" value="Entrar" style="width: 150px" />
						</div>
						<div class="form-group col-sm-6 checkbox">
							<label for="remember_me">
								<input type="checkbox" id="remember_me" title="Manter-me conectado" />
							Manter-me conectado</label>
						</div>
						<div class="form-group col-sm-6" style="margin-top: 10px">
							<a href="forgotpwd.jsp">Esqueci minha senha</a>
						</div>
					</form>
				</div>
				<div class="panel-footer">
					<form action="signup.jsp">
						<div class="form-group">
							<p>Não possui cadastro?</p>
							<input type="submit" class="btn btn-default" value="Cadastrar" style="width: 150px;" />
						</div>
					</form>
				</div>
			</div>
	</div>
</body>