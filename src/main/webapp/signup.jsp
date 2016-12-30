<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<div class="panel-heading" style="text-align: center;">
			<h1 style="display:none;">Cadastro de usuário</h1>
		</div>
		<%@ include file="./views/controls/accountcontrol.jsp" %>
	</div>
	<script>
		$(function () {
			if(localStorage.getItem('userInfo') != null){
				var userInfo = JSON.parse(localStorage.getItem('userInfo'));
				$('#name').val(userInfo.name);
				$('#email').val(userInfo.email);
			}
		});
	</script>
</body>