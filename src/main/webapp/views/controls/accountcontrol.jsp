<form method="post" action="addAccount" class="form-horizontal panel panel-primary">
	<div class="panel-heading">
		<h2 class="panel-title">Cadasro de usuário</h2>
	</div>
	<div class="panel-body">
		<div class="form-group">
			<div class="col-sm-2">
				<label for="name" class="control-label">Nome: </label>
			</div>
			<div class="col-sm-10">
				<input id="name" name="name" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="phone" class="control-label">Telefone: </label>
			</div>
			<div class="col-sm-10">
				<input id="phone" name="phone" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="email" class="control-label">Email: </label>
			</div>
			<div class="col-sm-10">
				<input id="email" name="email" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="password" class="control-label">Senha:</label>
			</div>
			<div class="col-sm-10">
				<input type="password" name="password" class="form-control" id="password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="confirm_password" name="confirm-password" class="control-label">Confirme Senha:</label>
			</div>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="confirm_password" />
			</div>
		</div>				
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
			</div>
		</div>
	</div>
</form>