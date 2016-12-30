package formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Categoria;
import model.Responsavel;
import model.Transacao;

public class GenerateObject {

	public static Transacao GetTransacao (HttpServletRequest request) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Categoria categoria = new Categoria();
		categoria.setNome(request.getParameter("categoria"));		
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(request.getParameter("responsavel"));
		
		Transacao transacao = new Transacao(); 
		transacao.setCategoria(categoria);
		transacao.setData((Date)df.parse(request.getParameter("data")));
		transacao.setDescricao(request.getParameter("descricao"));
		transacao.setResponsavel(responsavel);
		transacao.setValor(Currency.getInstance(request.getParameter("valor")));
		transacao.setStatus(request.getParameter("status"));
		
		return transacao;
	
	}
	
}