package formatter;

import org.json.JSONException;
import org.json.JSONObject;
import model.Transacao;

public class GenerateJSON {
	
	public static JSONObject GetTransacaoJSON (Transacao transacao){
		
		
		JSONObject jsonTransacao = null;
				
		try {

			jsonTransacao = new JSONObject();			
			jsonTransacao.put("id",transacao.getId());
			jsonTransacao.put("data",transacao.getData());
			jsonTransacao.put("descricao",transacao.getDescricao());
			jsonTransacao.put("responsavel",transacao.getResponsavel().getNome());
			jsonTransacao.put("categoria",transacao.getCategoria().getNome());
			jsonTransacao.put("status",transacao.getStatus());
			jsonTransacao.put("valor",transacao.getValor());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonTransacao;
	
	}
	
}