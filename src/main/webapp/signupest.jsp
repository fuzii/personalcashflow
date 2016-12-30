<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<form method="post" action="/addEstablishment" class="form-horizontal panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">Cadastro do estabelecimento</h1>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Dados da conta</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="email" name="email" type="text" placeholder="email de login" class="form-control" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="password" name="password" type="password" placeholder="senha" class="form-control" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="confirm_password" type="password" placeholder="confirme sua senha" class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Contato do representante legal</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="responsibleName" name="responsible_name" placeholder="Nome completo do representante" class="form-control" type="text" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="responsibleEmail" name="responsible_email" placeholder="Email do representante" class="form-control" type="text" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="responsiblePhone" name="responsible_phone" placeholder="Telefone de contato" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Dados do estabelecimento</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="est_name" name="alias" placeholder="Nome" class="form-control" type="text" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="cnpj" name="register_number" placeholder="CNPJ" class="form-control" type="text" />
								</div>
								<div class="form-group col-lg-offset-1 col-lg-11">
									<input id="contact_phone" name="phone" placeholder="Telefone de contato" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Endereço do estabelecimento</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-lg-4">
									<input id="zipCode" name="zipCode" type="text" class="form-control" placeholder="CEP" maxlength="9" />
									<input id="country" name="country" class="hidden" value="Brasil" />
									<input id="radius" name="radius" class="hidden" value="0" />
									<input id="latitude" name="latitude" class="hidden" />
									<input id="longitude" name="longitude" class="hidden" />
								</div>
								<div class="form-group">
									<div class="col-lg-11">
										<input type="text" class="form-control" id="state" name="state" placeholder="UF" disabled style="width:25%; display:inline"/>
										<input type="text" class="form-control" id="city" name="city" placeholder="Cidade" disabled style="width:74%; display:inline" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-11">
										<input type="text" class="form-control" id="street" name="street" placeholder="Rua, Avenida, etc" disabled style="width:74%; display:inline" />
										<input type="text" class="form-control" id="number" name="number" placeholder="Nº" style="width:25%; display:inline" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 panel">
						<div class="form-group panel-body">
							<input id="btnSave" type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function searchZipCode(ctl){
			$.getJSON('https://api.postmon.com.br/v1/cep/' + $(ctl).val(), function (data) {
				$('#state').val(data.estado);
				$('#city').val(data.cidade);
				$('#street').val(data.logradouro);
			});
		}
		
		$(function () {
			$('#zipCode').focusout(function (){
				searchZipCode(this);
			});
			
			$('#number').focusout(function () {
				geocoder = new google.maps.Geocoder();
				geocoder.geocode({ 'address': $('#street').val() + ' ' + $('#number').val() + ' ' + $('#city').val()}, function (results, status) {
					if (status === google.maps.GeocoderStatus.OK) {
	                    //set lat and lng
	                    $('#latitude').val(results[0].geometry.location.lat());
	                    $('#longitude').val(results[0].geometry.location.lng());
					}
					else
						alert('Geocode error: ' + status);
				});
			});
		});
	</script>
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNr74pDGCK8gERm_i_o0TsVtiZIrtjj7Y"></script>
</body>