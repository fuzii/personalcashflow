package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Categoria;

public class CategoriaDao {

	public static Categoria Insert(Categoria categoria) {	
		
		try {
			
			// insert categoria
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO categoria (nome) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1,categoria.getNome());
			stmt.execute();

			// get generated categoria id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    categoria.setId(rs.getInt(1));
					
			rs.close();
			stmt.close();
			connection.close();
			
			return categoria;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
