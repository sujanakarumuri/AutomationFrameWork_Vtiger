package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseFileUtility {
	
	Driver driverRef1;
	Connection con=null;
	/**
	 * THis method will establish a connection
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef1=new Driver();
		DriverManager.registerDriver(driverRef1);
		con=DriverManager.getConnection(ConstantUtility.DBUrl, ConstantUtility.DBUsername, ConstantUtility.DBPassword);
	}
	/**
	 * This method will handle to close the Database
	 * @throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	public String executeQueryandVerifyTheData(String query, int colIndex, String expData) throws SQLException
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colIndex);
			if(actData.equals(expData))
			{
				flag=true; // flag raising event
				break;
			}
		}
		if(flag)
		{
			System.out.println("data present"+expData);
			return expData;
		}
		else
			System.out.println("Data not present");
		return " ";
	}

}
