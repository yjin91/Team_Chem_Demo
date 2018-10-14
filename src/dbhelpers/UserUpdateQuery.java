package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserUpdateQuery {
	
	private Connection connection;

	/**
	 * @author Yi Jin, Sarah Green
	 */
	public UserUpdateQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
;		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addUser(User user) {
		
		String query = "insert into chemDB.users (email, username, firstname, lastname, password) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getPassword());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public User validateUser(String username, String password) {
	    	
	       	String query = "select * from dbfinal.users where username = ? and password = ?";
	    	
	      	User user = null;
	    	
	    	try {
				PreparedStatement ps = this.connection.prepareStatement(query);
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet results = ps.executeQuery();
				
				results.next();
				
				user = new User(
						results.getString("username"),
						results.getString("password")
					);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	return user;
	    }
	

}
