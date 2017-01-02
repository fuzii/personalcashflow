package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Categoria;
import model.Responsavel;
import model.Transacao;

public class TransacaoDao { 

	public static Transacao Insert(Transacao transacao) {	
		
		try {
			
			// insert transacao
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO transacao (data, descricao, responsavel_id, categoria_id, status, valor) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1,new Date(transacao.getData().getTime()));
			stmt.setString(2,transacao.getDescricao());
			stmt.setInt(3,transacao.getResponsavel().getId());
			stmt.setInt(4,transacao.getCategoria().getId());
			stmt.setString(5,transacao.getStatus());
			stmt.setDouble(6,transacao.getValor());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    transacao.setId(rs.getInt(1));
					
			rs.close();
			stmt.close();
			connection.close();
			
			return transacao;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public static List<Transacao> ListaMes(java.util.Date data) {	
		
		try {
			
			List<Transacao> transacoes = new ArrayList<Transacao>();
			
			Connection connection = new ConnectionFactory().getConnection();
			String query = "SELECT * FROM transacao WHERE (year(data) = year(?) AND month(data) = month(?))"; 
			
			Calendar current = Calendar.getInstance();
			current.set(3,1); //set do dia para 01
				
			if(!data.before(current.getTime()))
				query += " OR (status='Base')";
				
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setDate(1,new Date(data.getTime()));
			stmt.setDate(2,new Date(data.getTime()));
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("categoria_id"));
				
				Responsavel responsavel = new Responsavel();
				responsavel.setId(rs.getInt("responsavel_id"));
						
				Transacao transacao = new Transacao();
				transacao.setId(rs.getInt("id"));
				transacao.setCategoria(categoria);
				transacao.setResponsavel(responsavel);
				transacao.setDescricao(rs.getString("descricao"));
				transacao.setValor(rs.getDouble("valor"));
				transacao.setStatus(rs.getString("status"));
				transacao.setData(rs.getDate("data"));
										
				transacoes.add(transacao);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			return transacoes;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


}