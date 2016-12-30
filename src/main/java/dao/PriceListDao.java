package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.PriceList;

public class PriceListDao {

	public static PriceList Insert(PriceList priceList) {	
		
		try { 
			
			// price list
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO price_list (establishment_id,product_id,price,unit) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,priceList.getEstablishment().getId());
			stmt.setLong(2,priceList.getProduct().getId());
			stmt.setDouble(3,priceList.getPrice());
			stmt.setString(4,priceList.getUnit());
			stmt.execute();
			
			// get generated price list id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				priceList.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return priceList;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
