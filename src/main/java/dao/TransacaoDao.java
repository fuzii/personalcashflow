package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Transacao;

public class TransacaoDao { 

	public static Transacao Insert(Transacao transacao) {	
		
		try {
			
			// insert transacao
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO transacao (data, descricao, responsavel_id, categoria_id, status, valor) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1,Date.valueOf(transacao.getData().toString())); //Ex.: 2016-12-30
			stmt.setString(2,transacao.getDescricao());
			stmt.setInt(3,transacao.getResponsavel().getId());
			stmt.setInt(4,transacao.getCategoria().getId());
			stmt.setString(5,transacao.getStatus());
			stmt.setDouble(6,Double.parseDouble(transacao.getValor().toString()));
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

}