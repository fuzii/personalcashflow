<style type="text/css">
	.borderless td, .borderless th {
		border: none !important;
	}
</style>
<table id="tbl_orders" class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>Pedido</th>
			<th>Data</th>
			<th>Valor (R$)</th>
			<th>Status</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>00001</td>
			<td>02/12/2016</td>
			<td>5,00</td>
			<td>Entregue</td>
		</tr>
		<tr>
			<td>00002</td>
			<td>03/12/2016</td>
			<td>10,00</td>
			<td>Entregue</td>
		</tr>
		<tr>
			<td>00003</td>
			<td>04/12/2016</td>
			<td>5,00</td>
			<td>Entregue</td>
		</tr>
		<tr>
			<td>00004</td>
			<td>05/12/2016</td>
			<td>5,00</td>
			<td>Pendente</td>
		</tr>
		<tr>
			<td>00005</td>
			<td>06/12/2016</td>
			<td>15,00</td>
			<td>Provisionado</td>
		</tr>
	</tbody>
</table>
<div id="order_details" class="panel panel-default" style="display: none;">
	<div class="panel-body">
		<div class="row">
			<div class="col-md-10">
				<h2>Pedido: 00001</h2>
			</div>
			<div class="col-md-2">
				<p>Status: <strong>Entregue</strong></p>
				<p>Data: <strong>02/12/2016</strong>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table borderless">
					<thead>
						<tr>
							<th>Produto</th>
							<th>Valor</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>10 Pão frânces</td>
							<td>20,00</td>
						</tr>
						<tr>
							<td>5 Pão frânces integral</td>
							<td>15,00</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td>Total</td>	
							<td>35,00</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function () {
		$('#tbl_orders > tbody > tr').click(
			function () {
				$(this).siblings().removeAttr('class');
				$(this).attr('class','active');
				$('#order_details').hide();
				$('#order_details').fadeIn('slow');
			}
		);
	});
</script>