package model;

import java.util.Currency;
import java.util.Date;

public class Transacao {

	private int id;
	private Date data;
	private String descricao;
	private Responsavel responsavel;
	private Categoria categoria;
	private String status;
	private Currency valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Currency getValor() {
		return valor;
	}
	public void setValor(Currency valor) {
		this.valor = valor;
	}
		
}
