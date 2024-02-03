package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
		String db = "bibliotheque_db";
	    String user = "root";
	    String pwd = "";
	    String url = "jdbc:mysql://localhost:3306/" + db;
	    
public static Connection connection=null;
public  SingleConnection(){
	        try {
				connection = DriverManager.getConnection(url, user, pwd);
				System.out.println("instance crée");
	        } catch (SQLException e) {
				e.printStackTrace();
			}
}

public static Connection getConnection(){
        	if(connection==null)
        	    new SingleConnection();
        	return connection;
      
}

}
