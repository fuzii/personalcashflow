package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory { 
	
	public Connection getConnection(){

		try{			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			postgres://xogedsiotnpich:Ww-Myo8dazR2Wjms8p416jPHUZ@ec2-23-21-102-155.compute-1.amazonaws.com:5432/de1jpt0aitj0hr
			URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
			
		    //String username = dbUri.getUserInfo().split(":")[0];
		    //String password = dbUri.getUserInfo().split(":")[1];
		    
		    String dbUrl = "jdbc:" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		    //jdbc:mysql://localhost:3306/seuDataBase
		    //jdbc:mysql://us-cdbr-iron-east-04.cleardb.net:3306/heroku_d7b17a780904d50
		    //mysql://b7c8b8960a327a:02615190@us-cdbr-iron-east-04.cleardb.net/heroku_d7b17a780904d50?reconnect=true
		    	
		    return DriverManager.getConnection(dbUrl);//, username, password);
			
		} catch(SQLException e){
			throw new RuntimeException(e);
			
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}
