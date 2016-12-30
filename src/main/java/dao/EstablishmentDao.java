package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Establishment;
import model.User;
import util.Geolocation;
import util.Util;
import model.Address;

public class EstablishmentDao { 
	
	@SuppressWarnings("unchecked")
	public static Establishment Insert(Establishment establishment) {	
		
		try { 
			
			// insert user
			User user = UserDao.Insert(establishment);

			// insert establishment
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO establishment (name,alias,register_num,email,radius,responsible_name,responsible_email,responsible_phone,rate,phone,user_id) values (?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,establishment.getName());
			stmt.setString(2,establishment.getAlias());
			stmt.setLong(3,establishment.getRegisterNumber());
			stmt.setString(4,establishment.getEmail());
			stmt.setInt(5,establishment.getRadius());
			stmt.setString(6,establishment.getResponsibleName());
			stmt.setString(7,establishment.getResponsibleEmail());
			stmt.setString(8,establishment.getResponsiblePhone());
			stmt.setInt(9,establishment.getRate());
			stmt.setString(10,establishment.getResponsiblePhone());
			stmt.setLong(11,user.getUserId());
			stmt.execute();

			// get generated establishment id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    establishment.setId(rs.getLong(1));

			// insert address
			for(Address address: (List<Address>)Util.IsEmptyList(establishment.getAddress())){
				address.setEstablishmentId(establishment.getId());
				address = AddressDao.InsertByEstablishment(address);
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			return establishment;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void Update(Establishment establishment) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE establishment SET name=?,alias=?,register_num=? where id=?");
			
			stmt.setString(1,establishment.getName());
			stmt.setString(2,establishment.getAlias());
			stmt.setLong(3,establishment.getRegisterNumber());
			stmt.setLong(4,establishment.getId());
			stmt.execute();
			
			for(Address address: establishment.getAddress()){
				AddressDao.Update(address);
			}
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static List<Establishment> GetEstablishments() {
	     
		try {
			
			List<Establishment> establishments = new ArrayList<Establishment>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from establishment");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Establishment establishment = new Establishment();
				establishment.setId(rs.getLong("id"));
				establishment.setName(rs.getString("name"));
				establishment.setAlias(rs.getString("alias"));
				establishment.setRegisterNumber(rs.getLong("register_num"));
				establishment.setAddress(GetEstablishmentAddresses(establishment));
												
				// created on
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created"));
				establishment.setCreated(data);

				establishments.add(establishment);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return establishments;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Establishment GetEstablishmentsById(Long id) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from establishment where id=?");
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;
			
			Establishment establishment = new Establishment();
			establishment.setId(rs.getLong("id"));
			establishment.setName(rs.getString("name"));
			establishment.setAlias(rs.getString("alias"));
			establishment.setRegisterNumber(rs.getLong("register_num"));
			establishment.setEmail(rs.getString("email"));
			establishment.setRadius(rs.getInt("radius"));
			establishment.setResponsibleName(rs.getString("responsible_name"));
			establishment.setResponsibleEmail(rs.getString("responsible_email"));
			establishment.setResponsiblePhone(rs.getString("responsible_phone"));
			establishment.setRate(rs.getInt("rate"));
			establishment.setPhone(rs.getString("phone"));
										
			// created on
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created"));
			establishment.setCreated(data);
			
			rs.close();
			stmt.close();
			connection.close();
			return establishment;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static List<Address> GetEstablishmentsAddressesByLocation(Address address) {
	     
		try {
			
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from address where establishment_id IS NOT NULL");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				int radius = rs.getInt("radius");
				int distance = Geolocation.Distance(address.getLatitude(), address.getLongitude(), rs.getDouble("latitude"), rs.getDouble("longitude"));
				
				if(radius >= distance){
					
					// Add address
					Address a = new Address();
					a.setId(rs.getLong("id"));
					a.setAccountId(rs.getLong("account_id"));
					a.setZipCode(rs.getString("zipCode"));
					a.setStreet(rs.getString("street"));
					a.setCity(rs.getString("city"));
					a.setState(rs.getString("state"));
					a.setNumber(rs.getInt("number"));
					a.setPremise(rs.getString("premise"));
					a.setCountry(rs.getString("country"));
					a.setLatitude(rs.getDouble("latitude"));
					a.setLongitude(rs.getDouble("longitude"));
					a.setEstablishmentId(rs.getLong("establishment_id"));
									
					// created on
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("created"));
					a.setCreated(data);

					addresses.add(a);
					
				}
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return addresses;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static List<Address> GetEstablishmentAddresses(Establishment establishment) {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from address where establishment_id=?");
	    	stmt.setLong(1,establishment.getId());
	    	
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Address address = new Address();
				address.setId(rs.getLong("id"));
				address.setEstablishmentId(rs.getLong("establishment_id"));
				address.setZipCode(rs.getString("zipCode"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setNumber(rs.getInt("number"));
				address.setPremise(rs.getString("premise"));
				address.setCountry(rs.getString("country"));
				address.setLatitude(rs.getDouble("latitude"));
				address.setLongitude(rs.getDouble("longitude"));
								
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

	public static void InsertEstablishmentAddress(Establishment establishment, Address address){
		
		address.setEstablishmentId(establishment.getId());
		AddressDao.Insert(address);
		
	}
	
}
