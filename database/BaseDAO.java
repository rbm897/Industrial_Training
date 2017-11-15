package pizzaordersystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	Connection connection =null;
	public Connection getConnection(){
		
	try{
		 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","Abtdm1234");
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	return connection;
	}
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
