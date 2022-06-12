/* --- DATABSE CREATION, USE, TABLE CREATION --- */
package PASSWORD_OTP; 								// Package statement
import java.sql.*; 									// import statement
public class DATABASE 								// Class declaration
{

	private static final String url = "jdbc:mysql://127.0.0.1:3306";	//copy the JDBC url 
	private static final String user = "root";							//copy the user name of database
	private static final String pas = "";								// give the password of given user
	
	public static void main(String args[])								//main function
	{
		try																//try block
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, pas);
			Statement st = con.createStatement();
			
			try															/*Create Database "account_details"*/
			{
				System.out.println("Create a database account_details");
				st.executeUpdate("create database account_details");
			}
			catch(SQLException s1)
			{
				System.out.println("SQLException : "+s1.getMessage());
			}
			
			try															/*use "account_details" Database*/
			{
				System.out.println("Use account_details");
				st.executeUpdate("use account_details");
			}
			catch(SQLException s2)
			{
				System.out.println("SQLException : "+s2.getMessage());
			}
			
			try														/*create a table to store details of users "users"*/
			{
				String table = "create table users("
								+"Name varchar(50),"
								+"Gmail varchar(50),"
								+"Password varchar(50),"
								+"Image longblob"
								+");";
				
				System.out.println("create users table");
				st.executeUpdate(table);
			}
			catch(SQLException s3)									
			{
				System.out.println("SQLException : "+s3.getMessage());
			}
		}
		catch(Exception E)											//Catch block
		{
			System.out.println("Access Denied");
			E.printStackTrace();
		}
	}
}
