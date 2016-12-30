package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import model.Product;

public class ProductDao {

	public static Product Insert(Product product) {	
		
		try { 
			
			// product
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO product (name,description) values (?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,product.getName());
			stmt.setString(2,product.getDescription());
			stmt.execute();
			
			// get generated product id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				product.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return product;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Product GetProductById(Long id) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from product where id=?");
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;
			
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
										
			// created on
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created"));
			product.setCreated(data);
			
			rs.close();
			stmt.close();
			connection.close();
			
			return product;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
