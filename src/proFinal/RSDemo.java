package proFinal;

import java.sql.*;

public class RSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from username");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " "+ rs.getString(2));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
