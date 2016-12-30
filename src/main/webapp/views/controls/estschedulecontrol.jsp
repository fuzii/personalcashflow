<div class="panel-heading">
	<h3>Horário de funcionamento</h3>
</div>
<div class="panel-body">
	<form method="post">
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="time_start">Segunda - Sexta: </label>
			</div>
			<div class="col-lg-10">
				<input id="time_start" type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input id= "time_finish" type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input type="checkbox" title="fechado" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="">Sábado: </label>
			</div>
			<div class="col-lg-10">
				<input type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input title="fechado" type="checkbox" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="">Domingo: </label>
			</div>
			<div class="col-lg-10">
				<input type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input type="checkbox" title="fechado" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function () {
		$('input[type=checkbox]').click(function () {
			if($(this).is(':checked')) {
				$(this).parent().parent().siblings().each(function (i, ctl){
					$(ctl).val('');
					$(ctl).attr('disabled','');
				});
			}
			else {
				$(this).parent().parent().siblings().each(function (i, ctl){
					$(ctl).val('');
					$(ctl).removeAttr('disabled');
				});
			}
		});
	});
</script>