package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

public class UserDao { 

	public static User Insert(User user) {	
		
		try {
			
			// insert user
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO user_application (login,password) VALUES (?,CRYPT(?,GEN_SALT('md5')))",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,user.getUserLogin());
			stmt.setString(2,user.getUserPassword().toString());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    user.setUserId(rs.getLong(1));
					
			rs.close();
			stmt.close();
			connection.close();
			
			return user;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static boolean Login(User user) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_application WHERE login=? AND password = CRYPT(?,password)");
			stmt.setString(1,user.getUserLogin());
			stmt.setString(2,new String(user.getUserPassword()));

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
