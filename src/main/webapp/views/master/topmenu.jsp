<style type="text/css">
	div#userAddress
	{
		text-align: center;
		float: left;
		margin: auto;
	}
    ul#menu
    {
        /*border-bottom: 1px #5C87B2 solid;
        padding: 0 0 2px;
        position: relative;
        margin: 0;*/
        float: right;
    }

    ul#menu li
    {
        display: inline;
    }
    .page
    {
        width: 100%;
        margin-left: auto;
        margin-right: auto;
    }
    #menucontainer
    {
        margin-top:20px;
        padding-right: 30px;
    }
</style>
<section class="clearfix">
<div id="header">
    <div id="menucontainer">
    	<div id="userAddress" style="display: none;">
    		<p style="display: inline-block;"></p>
    		<a href="home.jsp?toHome=1">Alterar endereço</a>
    	</div>
        <ul id="menu">
            <li id="signup"><a href="../signup.jsp" class="btn btn-info"><span class="glyphicon glyphicon-user"></span>
            	<span class="hidden-xs hidden-sm"> Cadastrar</span></a></li>
            <li><a href="../login.jsp" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span>
            <span id="userName" class="hidden-xs hidden-sm"> Entrar</span></a></li>
        </ul>
    </div>
</div>
</section>
<script type="text/javascript">
	Storage.prototype.setObject = function(key, value) {
    	this.setItem(key, JSON.stringify(value));
	}
	
	Storage.prototype.getObject = function(key) {
	    var value = this.getItem(key);
	    return value && JSON.parse(value);
	}
	
	function showAddress() {
		if(localStorage.getItem('userInfo') != null) {
			var userInfo = localStorage.getObject('userInfo');
			$('#userName').html('Olá ' + userInfo.name + '!');
			$('#userAddress').show();
			$('#userAddress').find('p').html('<span class="glyphicon glyphicon-map-marker"></span> ' + userInfo.street + ', ' + userInfo.number + ' - ' + userInfo.city);
			if($('#searchAddress') != null) {
				$('#searchAddress').hide();
			}
		}
	}
	
	function getUrlVars()
	{
	    var vars = [], hash;
	    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	    for(var i = 0; i < hashes.length; i++)
	    {
	        hash = hashes[i].split('=');
	        vars.push(hash[0]);
	        vars[hash[0]] = hash[1];
	    }
	    return vars;
	}
	
	$(function () {
		if(getUrlVars()['toHome'] == 1) {
			localStorage.removeItem('userInfo');
		}
		else {
			showAddress();
		}
	});
</script>