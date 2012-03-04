package net.ruangtedy.ua.controller;

import java.io.*;
import java.sql.*;

import net.ruangtedy.ua.model.Settings;

public class Dummy 
{
	public static void main(String args[])
	{
		String dbtime;
		String query = "Select * FROM datapemakaian";

		try 
		{

			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName(Settings.getHstJDBCDriver());
			Connection con = DriverManager.getConnection (Settings.getHstJDBCUrl(),"root","");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) 
			{
				dbtime = rs.getString(1);
				System.out.println(dbtime);
			} //end while

			con.close();
		} //end try

		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		catch(SQLException e) 
		{
			e.printStackTrace();
		}

		}  //end main
}
