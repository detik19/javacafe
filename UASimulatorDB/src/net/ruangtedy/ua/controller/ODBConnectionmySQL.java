package net.ruangtedy.ua.controller;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import net.ruangtedy.ua.model.OConnection;
import net.ruangtedy.ua.model.Settings;

public class ODBConnectionmySQL 
{

	public ODBConnectionmySQL()
	{
		
	}
	
	/**
	 *Create Connection
	 * @return
	 */
	public OConnection createConnection()
	{
		OConnection conn= null;
		try
		{
			Class.forName(Settings.getHstJDBCDriver());
			conn= new OConnection();
			conn.setConnection(DriverManager.getConnection(Settings.getHstJDBCUrl(),"root",""));
			
		}
		catch (Exception e)
		{
		}
		return conn;
	}
	
	/**
	 * Returns a flag wheter the login user is vali
	 * 
	 * @return boolean user and password ok
	 */
	public boolean authenticateUser(String user, String password) throws Exception
	{
		return password.equals(user);
	}

	
	public static void main(String args[]) throws SQLException
	{
		String dbtime;
		String query = "Select * FROM datapemakaian";
		
		ODBConnectionmySQL odbmysql=new ODBConnectionmySQL();
		System.out.println("Trying ot Connecting into DB Local");
		OConnection conn= odbmysql.createConnection();
		System.out.println("Connection Success ");
		
		Connection con=conn.getConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) 
		{
			dbtime = rs.getString(1);
			System.out.println(dbtime);
		} //end while
		con.close();

	}
}
