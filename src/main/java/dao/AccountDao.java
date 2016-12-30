package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Account;
import model.Address;
import model.User;
import util.Geolocation;
import util.Util;

public class AccountDao { 

	@SuppressWarnings("unchecked")
	public static Account Insert(Account account) {	
		
		try {
			
			// insert user
			User user = UserDao.Insert(account);
			
			// insert account
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO account(name,email,phone,user_id) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,account.getName());
			stmt.setString(2,account.getEmail());
			stmt.setString(3,account.getPhone());
			stmt.setLong(4,user.getUserId());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    account.setId(rs.getLong(1));
	
			// insert address
			for(Address address: (List<Address>)Util.IsEmptyList(account.getAddress())){
				address.setAccountId(account.getId());
				address = AddressDao.InsertByAccount(address);
			}
				
			rs.close();
			stmt.close();
			connection.close();
			
			return account;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
/*	public static void Update(Account account) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE account SET name=?,email=? where id=?");

			stmt.setString(1,account.getName());
			stmt.setString(2,account.getEmail());
			stmt.setLong(3,account.getId());
			stmt.execute();
			
			for(Address address: account.getAddress()){
				AddressDao.Update(address);
			}
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
*/	
	public static List<Account> GetAccounts() {
	     
		try {
			
			List<Account> accounts = new ArrayList<Account>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from account");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Account account = new Account();
				account.setId(rs.getLong("id"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setAddress(GetAccountAddresses(account));
												
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created"));
				account.setCreated(data);

				accounts.add(account);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return accounts;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Account GetAccountsById(Long id) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from account where id=?");
	    	stmt.setLong(1,id);
	    	ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;

			Account account = new Account();
			account.setId(rs.getLong("id"));
			account.setName(rs.getString("name"));
			account.setEmail(rs.getString("email"));
			account.setAddress(GetAccountAddresses(account));
											
			// montando a data através do Calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created"));
			account.setCreated(data);
			
			rs.close();
			stmt.close();
			connection.close();
			return account;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static List<Address> GetAccountAddresses(Account account) {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from address where account_id=?");
	    	stmt.setLong(1,account.getId());
	    	
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
								
				// montando a data através do Calendar
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

	public static List<Address> GetAccountsAddressesByLocation(Address address) {
	     
		try {
			
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from address where account_id IS NOT NULL");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				int radius = 1000; //address.getRadius();
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
									
					// created
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
	
}
