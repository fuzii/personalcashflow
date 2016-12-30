<%@ include file="./views/master/master.jsp" %>
<body>
	<link href="./css/site.css" type="text/css" rel="Stylesheet" />
	<%@ include file="./views/master/topmenu.jsp" %>
	<div class="container">
		<div class="panel panel-default panel-fade">
			<div class="panel-heading" style="padding-bottom: 0px;">
				<ul class="panel-title nav nav-tabs nav-justified">
					<li class="active"><a data-toggle="tab" href="#plan" style="border-bottom-style: none;">Plano</a></li>
					<li><a data-toggle="tab" href="#signup" style="border-bottom-style: none;">Cadastro</a></li>
					<li><a data-toggle="tab" href="#orders" style="border-bottom-style: none;">Pedidos</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div id="plan" class="tab-pane fade in active">
						<%@ include file="./views/controls/plancontrol.jsp" %>
					</div>
					<div id="signup" class="tab-pane fade" style="margin-top: 20px">
						<%@ include file="./views/controls/accountcontrol.jsp" %>
						<%@ include file="./views/controls/accountaddresscontrol.jsp" %>
					</div>
					<div id="orders" class="tab-pane fade" style="margin-top: 20px">
						<%@ include file="./views/controls/orderscontrol.jsp" %>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>