package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Responsavel;

public class ResponsavelDao { 

	public static Responsavel Insert(Responsavel responsavel) {	
		
		try {
			
			// insert responsavel
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO responsavel (nome,password) VALUES (?,MD5(?))",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,responsavel.getNome());
			stmt.setString(2,responsavel.getPassword().toString());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    responsavel.setId(rs.getInt(1));
					
			rs.close();
			stmt.close();
			connection.close();
			
			return responsavel;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static boolean Login(Responsavel responsavel) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM responsavel WHERE nome=? AND password = MD5(?)");
			stmt.setString(1,responsavel.getNome());
			stmt.setString(2,new String(responsavel.getPassword()));

			ResultSet rs = stmt.executeQuery();
			boolean login = rs.next();
					
			rs.close();
			stmt.close();
			connection.close();
			
			return login;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
