package DAO;

import jakarta.servlet.ServletContext;

public class DAOContext {
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;

	public static void init(ServletContext Context) {
		
		try {
			Class.forName(Context.getInitParameter("JDBC_DRIVER"));
			dbURL = Context.getInitParameter("JDBC_URL");
			dbLogin = Context.getInitParameter("JDBC_LOGIN");
			dbPassword = Context.getInitParameter("JDBC_PASSWORD");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
