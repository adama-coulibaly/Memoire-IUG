package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.catalina.User;

public class UserDAO extends DAOContext{
	
	public static User isValidLogin(String login, String password) {
		
		
	
		try(Connection connection = DriverManager.getConnection(dbURL, dbLogin, password))
		{
			String strsql = "SELECT * FROM ETUDIANT WHERE email = ? AND passe = ?";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				

		
		
		
		
		return null;
		
		
	}

}
