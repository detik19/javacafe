package net.ruangtedy.ua.controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.ruangtedy.ua.model.OConnection;
import net.ruangtedy.ua.view.InputEdit;

public class ActionUI 
{
	IdData iddata=new IdData();
	ODBConnectionmySQL odbmysql=new ODBConnectionmySQL();
	private String fresh;
	private String nrp;
	private String riset;
	private String date;
	private int id;
	private String bulan;
	private String tahun;
	private String site;
	
	public boolean DisplayPressed(String bulan, String tahun, String site) throws SQLException
	{
				
		id = iddata.getID(bulan, tahun, site);
		this.bulan=bulan;
		this.tahun=tahun;
		this.site=site;
		
		System.out.println("Trying ot Connecting into DB Local");
		OConnection conn= odbmysql.createConnection();
		System.out.println("Connection Success ");
		
		Connection con=conn.getConnection();
		
		Statement stmt = con.createStatement();
		String query = "Select * FROM datapemakaian WHERE (id = "+id+")";

		ResultSet rs = stmt.executeQuery(query);
		if (!(rs.next()))
		{
			return false;
		}
		else 
		{
			
				fresh = rs.getString(4);
				nrp=rs.getString(5);
				riset=rs.getString(6);
					
			
		
		}
		
		con.close();
		return true;
		
	}
	
	public String getFresh()
	{
		return fresh;
	}
	public String getNrp()
	{
		return nrp;
	}
	public String getRiset()
	{
		return riset;
	}

	
	
	public void inputPressed() throws SQLException
	{
		
		date = iddata.getDate(bulan, tahun);
		System.out.println(date);
		//return id;
		System.out.println("Trying ot Connecting into DB Local");
		OConnection conn= odbmysql.createConnection();
		System.out.println("Connection Success ");
		
		Connection con=conn.getConnection();
		
		Statement stmt = con.createStatement();
	}
}
