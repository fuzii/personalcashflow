package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Address;
import model.Lead;
 
public class LeadDao {

	public static Lead Insert(Lead lead) {	
		
		try {
			
			// insert address  
			Address address = AddressDao.Insert(lead.getAddress());
			
			// insert account
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO lead(name,email,phone,status,address_id) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,lead.getName());
			stmt.setString(2,lead.getEmail());
			stmt.setString(3,lead.getPhone());
			stmt.setString(4,"New");
			stmt.setLong(5,address.getId());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    lead.setId(rs.getLong(1));
	
				
			rs.close();
			stmt.close();
			connection.close();
			
			return lead;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
