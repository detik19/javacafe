package net.ruangtedy.ua.controller;


import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private String file=null;
	OConnection conn;
	Connection con;
	
	public boolean DisplayPressed(String bulan, String tahun, String site) throws SQLException
	{
				
		id = iddata.getID(bulan, tahun, site);
		this.bulan=bulan;
		this.tahun=tahun;
		this.site=site;
		
		ConnectIntoDBLocal();
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

	
	public int UpdatePressed(String fresh, String nrp, String riset, String file)
	{
		ConnectIntoDBLocal();
		int val = 0;
		String sql = "UPDATE datapemakaian SET Fresh ="+fresh+"," +
											   "NRP ="+nrp+","+
											   "Riset ="+riset+","+
											   "File ='"+file+"'"+
					 "WHERE (id="+id+")";
		try 
		{
			Statement stmt;

			stmt = con.createStatement();
			val = stmt.executeUpdate(sql);
			con.close();									

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
		


	}
	
	public int inputPressed(String fresh, String nrp, String riset, String file) throws SQLException
	{
		
		date = iddata.getDate(bulan, tahun);
		//System.out.println("data="+date);
		
		ConnectIntoDBLocal();
		String update="INSERT into datapemakaian Values ("+id+",'"+date+"','"+site+"',"+fresh+","+nrp+","+riset+",'"+file+"')";
		Statement stmt = con.createStatement();
		int val = stmt.executeUpdate(update);
		con.close();

		return val;
	}
	
	public int deletePressed()
	{
		int val=0;
		ConnectIntoDBLocal();
		String sql="DELETE FROM datapemakaian WHERE (id ="+id+" )";
		Statement stmt;
		try {
			stmt = con.createStatement();
			val = stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return val;		
	}
	private void ConnectIntoDBLocal()
	{
		System.out.println("Trying ot Connecting into DB Local");
		conn= odbmysql.createConnection();
		System.out.println("Connection Success ");
		
		con=conn.getConnection();

	}
}
