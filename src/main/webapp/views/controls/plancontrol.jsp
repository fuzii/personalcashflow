<link href="./css/card-details.css" type="text/css" rel="Stylesheet" />
<div class="col-sm-9">
    <div class="card-details">
        <div class="card-details-image">
            <img src="../../images/images.jpg" />
        </div>
        <div class="card-details-content">
            <h3>TESTE</h3>
        </div>
        <div class="card-details-action">
            <a href="#">LINK</a>
            <a href="#">LINK</a>
        </div>
    </div>
    <div id="planContainer" class="card-details">
        <h3 style="padding-left: 10px">Configure seu plano</h3>
        <input type="hidden" id="monSelected" value="1" />
        <input type="hidden" id="tueSelected" value="1" />
        <input type="hidden" id="wedSelected" value="1" />
        <input type="hidden" id="thuSelected" value="1" />
        <input type="hidden" id="friSelected" value="1" />
        <input type="hidden" id="satSelected" value="1" />
        <input type="hidden" id="sunSelected" value="1" />
        <!-- xs sm md lg
        <div class="card-day-container hidden-xs hidden-sm">
        	<div class="row">
        		<div class="card-day">
                 <label class="checkbox-inline"><input id="chx_mon" type="checkbox" value="" onclick="selected(this);" />Segunda</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button id="Horario_Segunda" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>09:00</li>
                     </ul>
                 </div>
             </div>
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_tue" type="checkbox" value="" onclick="selected(this);" />Terça</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_wed" type="checkbox" value="" onclick="selected(this);" />Quarta</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_thu" type="checkbox" value="" onclick="selected(this);" />Quinta</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
        	</div>
            <div class="row">
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_fri" type="checkbox" value="" onclick="selected(this);" />Sexta</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_sat" type="checkbox" value="" onclick="selected(this);" />Sábado</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
             <div class="card-day">
                 <label class="checkbox-inline"><input id="chx_sun" type="checkbox" value="" onclick="selected(this);" />Domingo</label>
                 <input type="text" class="form-control" placeholder="Quantidade" disabled />
                 <div class="btn-group" style="width:100%">
                     <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
                     <ul class="dropdown-menu">
                         <li>08:00</li>
                         <li>08:00</li>
                     </ul>
                 </div>
             </div>
            </div>
        </div> -->
        <!-- xs sm -->
        <!-- <div class="hidden-md hidden-lg" style="margin: 10px"> -->
        	<div class="card-day-list-group">
        		<div class="card-day-list-item">
	        		<div class="card-day-list-content">
	        			<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%"  />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
	        		</div>
	        		<div class="card-day-list-btn">
	        			<button id="btn_mon" onclick="btnSelectedList(this);">Segunda</button>
        			</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_tue" onclick="btnSelectedList(this);">Terça</button>
        			</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_wed" onclick="btnSelectedList(this);">Quarta</button>
        			</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_thu" onclick="btnSelectedList(this);">Quinta</button>
       				</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_fri" onclick="btnSelectedList(this);">Sexta</button>
        			</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_sat" onclick="btnSelectedList(this);">Sábado</button>
        			</div>
        		</div>
        		<div class="card-day-list-item">
        			<div class="card-day-list-content">
        				<input type="text" class="form-control" placeholder="Quantidade" style=" display: inline; width: 48%" />
	        			<div class="btn-group" style="width: 50%; display: inline; float: right">
	        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
	        				<ul class="dropdown-menu">
	        					<li>8:00</li>
	        					<li>9:00</li>
	        				</ul>
	        			</div>
        			</div>
        			<div class="card-day-list-btn">
        				<button id="btn_sun" onclick="btnSelectedList(this);">Domingo</button>
        			</div>
        		</div>
        	</div>
    	</div>
   	<!-- </div> -->        
</div>
<div class="col-xs-3 hidden-xs">
    	<div class="panel panel-default" data-spy="affix" data-offset-top="300">
    		<div class="panel-heading">
    			<h3 class="panel-title"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</h3>
    		</div>
    		<div class="panel-body">
    			<ul class="list-unstyled">
    				<li><span>1</span><span>Pão françês</span><span>R$ 50,00</span></li>
    			</ul>
    		</div>
    		<div class="panel-footer">
    			<span>SubTotal</span>
    			<span><strong>R$ 50,00</strong></span>
    		</div>
    	</div>
    </div>
<script type="text/javascript">
    //function selected(ctl) {
    //	var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
    //    if ($(ctl).is(':checked')) {
    //        $(ctl).parent().parent().attr('class', 'card-day-selected');
    //        $(ctl).parent().parent().find(':input').removeAttr('disabled');
    //        $('#planContainer').find('#' + selectedID).val('1');
    //    }
    //    else {
    //        $(ctl).parent().parent().attr('class', 'card-day');
    //        $(ctl).parent().parent().find(':input').attr('disabled', '');
    //        $(ctl).removeAttr('disabled');
    //        $('#planContainer').find('#' + selectedID).val('0');
    //    }
    //}
    function btnSelectedList(ctl) {
    	var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
    	if($('#planContainer').find('#' + selectedID).val() == '0') {
    		$(ctl).attr('style','color: #fff; background-color: #5cb85c');
    		$(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #5cb85c');
    		$(ctl).parent().parent().find(':input').removeAttr('disabled');
    		$('#planContainer').find('#' + selectedID).val('1');
   		}
    	else{
    		$(ctl).attr('style','color: #000; background-color: rgba(230,230,230,0.5);');
    		$(ctl).parent().attr('style','background-color: rgba(230,230,230,0.5);');
    		$(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #fff;');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input').attr('disabled','');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input[type=text]').val('');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input[type=button]').html('Horário<span class="caret"></span>');
    		$('#planContainer').find('#' + selectedID).val('0');
    	}
    		
    }
    $(function() {
    	$('input[type=hidden]').each(function (i, ctl) {
    		var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
        	if($('#planContainer').find(selectedID).val() == '1') {
        		$(ctl).attr('style','background-color: green');
       		}
        	else{
        		$(ctl).attr('style','background-color: white');
        	}	
    	});
        $(".dropdown-menu").on('click', 'li', function(){
          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
          $($(this).parent().siblings()[0]).val($(this).text());
          //$(".btn:first-child").html($(this).text() + '<span class="caret"></span>');
          //$(".btn:first-child").val($(this).text());
       });

    });
</script>