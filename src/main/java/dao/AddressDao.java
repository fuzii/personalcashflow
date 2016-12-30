package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Address;

public class AddressDao {

	public static Address Insert(Address address) {	
 
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO address(account_id,zipCode,street,city,state,establishment_id,premise,country,latitude,longitude,number) values (?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			if(address.getAccountId()!=null)
				stmt.setLong(1,address.getAccountId());
			else 
				stmt.setNull(1, Types.INTEGER);
				
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());

			if(address.getEstablishmentId()!=null)
				stmt.setLong(6,address.getEstablishmentId());
			else
				stmt.setNull(6, Types.INTEGER);
			
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			
			if(address.getLatitude()!=null)
				stmt.setDouble(9,address.getLatitude());
			else
				stmt.setNull(9, Types.DOUBLE);
			
			if(address.getLongitude()!=null)
				stmt.setDouble(10,address.getLongitude());
			else
				stmt.setNull(10, Types.DOUBLE);
			
			stmt.setInt(11,address.getNumber());
			
			stmt.execute();

			// get generated address id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    address.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return address;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Address InsertByAccount(Address address) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO address(account_id,zipCode,street,city,state,number,premise,country,latitude,longitude) values (?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1,address.getAccountId());
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());
			stmt.setInt(6,address.getNumber());
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			stmt.setDouble(9,address.getLatitude());
			stmt.setDouble(10,address.getLongitude());
			stmt.execute();

			// get generated address id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    address.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return address;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Address InsertByEstablishment(Address address) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO address(establishment_id,zipCode,street,city,state,number,premise,country,latitude,longitude) values (?,?,?,?,?,?,?,?,?,?)");

			stmt.setLong(1,address.getEstablishmentId());
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());
			stmt.setInt(6,address.getNumber());
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			stmt.setDouble(9,address.getLatitude());
			stmt.setDouble(10,address.getLongitude());
			stmt.execute();
			
			// get generated address id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				address.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return address;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void Update(Address address) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE address SET account_id=?,zipCode=?,street=?,city=?,state=?,number=?,premise=?,country=?,latitude=?,longitude=?,establishment_id=? where id=?");

			stmt.setLong(1,address.getAccountId());
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());
			stmt.setInt(6,address.getNumber());
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			stmt.setDouble(9,address.getLatitude());
			stmt.setDouble(10,address.getLongitude());
			stmt.setLong(11, address.getEstablishmentId());
			stmt.setLong(12, address.getId());
			stmt.execute();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void Delete(Address address) {
		
	     try {
	    	 
	    	 Connection connection = new ConnectionFactory().getConnection();
	    	 PreparedStatement stmt = connection.prepareStatement("delete from address where id=?");
	    	 stmt.setLong(1, address.getId());
	    	 stmt.execute();
	    	 stmt.close();
	    	 connection.close();
	    	 
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	public static List<Address> GetAddresses() {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from address");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Address address = new Address();
				address.setId(rs.getLong("id"));
				address.setAccountId(rs.getLong("account_id"));
				address.setZipCode(rs.getString("zipCode"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setNumber(rs.getInt("number"));
				address.setPremise(rs.getString("premise"));
				address.setCountry(rs.getString("country"));
				address.setLatitude(rs.getDouble("latitude"));
				address.setLongitude(rs.getDouble("longitude"));
				address.setEstablishmentId(rs.getLong("establishment_id"));
								
				// created
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created"));
				address.setCreated(data);

				addresses.add(address);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return addresses;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public static Address GetAddressById(Long id) {
	     
		try {
		
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from address where id=?");
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;

			Address address = new Address();
			address.setId(rs.getLong("id"));
			address.setAccountId(rs.getLong("account_id"));
			address.setZipCode(rs.getString("zipCode"));
			address.setStreet(rs.getString("street"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setNumber(rs.getInt("number"));
			address.setPremise(rs.getString("premise"));
			address.setCountry(rs.getString("country"));
			address.setLatitude(rs.getDouble("latitude"));
			address.setLongitude(rs.getDouble("longitude"));
			address.setEstablishmentId(rs.getLong("establishment_id"));
							
			// created
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created"));
			address.setCreated(data);
			
			rs.close();
			stmt.close();
			connection.close();
			return address;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	
}
