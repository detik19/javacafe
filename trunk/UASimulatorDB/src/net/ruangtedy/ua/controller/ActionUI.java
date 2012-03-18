package net.ruangtedy.ua.controller;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import net.ruangtedy.ua.model.OConnection;
import net.ruangtedy.ua.model.Settings;
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
	private String attachfile=null;
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
		String query = "Select * FROM "+ Settings.getTableName()+" WHERE (id = "+id+")";

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
				attachfile=rs.getString(7);
					
			
		
		}
		
		con.close();
		return true;
		
	}
	public String getFile()
	{
		return attachfile;
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

	
	public int UpdatePressed(String fresh, String nrp, String riset, String filepath)
	{
		String filedb=attachfile;
		if (!filepath.equals(""))
		{
			File fromFile = new File(filepath);
			if (fromFile.exists())
			{
				Filename attachment = new Filename(filepath, '/', '.');
				System.out.println("Extension = " + attachment.extension());
				String tofile=Settings.getPathFile()+id+"."+attachment.extension();
				filedb=id+"."+attachment.extension();
				
				File oldfile =new File(Settings.getPathFile()+attachfile);
				if(oldfile.exists())
				{
					oldfile.delete();
					System.out.println("Old file successfully deleted");
				}
				try 
				{
				    copy(filepath,tofile);
				    System.out.println("Success copy file");
				} 
				catch (IOException e) 
				{
				      System.err.println(e.getMessage());
				}
			}
		}
				
		
		
		
		
		ConnectIntoDBLocal();
		int val = 0;
		String sql = "UPDATE "+ Settings.getTableName()+" SET Fresh ="+fresh+"," +
															"NRP ="+nrp+","+
															"Riset ="+riset+","+
															"File ='"+filedb+"'"+
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
	
	public int inputPressed(String fresh, String nrp, String riset, String filepath) throws SQLException
	{
		
		date = iddata.getDate(bulan, tahun);
		//System.out.println("data="+date);
		String filedb="";
		if (!filepath.equals(""))
		{
			File fromfile = new File(filepath);
			if (fromfile.exists())
			{
				Filename attachment = new Filename(filepath, '/', '.');
				System.out.println("Extension = " + attachment.extension());
				String tofile=Settings.getPathFile()+id+"."+attachment.extension();
		
				try 
				{
					copy(filepath,tofile );
					System.out.println("Success copy file:"+tofile);
				} 
				catch (IOException e) 
				{
					System.err.println(e.getMessage());
				}
		  
				filedb=id+"."+attachment.extension();
			}
			else
			{
			}
		}
		ConnectIntoDBLocal();
		String update="INSERT into "+ Settings.getTableName() +" Values ("+id+",'"+date+"','"+site+"',"+fresh+","+nrp+","+riset+",'"+filedb+"')";
		Statement stmt = con.createStatement();
		int val = stmt.executeUpdate(update);
		con.close();

		return val;
	}
	
	public int deletePressed()
	{
		int val=0;
		ConnectIntoDBLocal();
		String sql="DELETE FROM "+ Settings.getTableName() +" WHERE (id ="+id+" )";
		Statement stmt;
		try {
			stmt = con.createStatement();
			val = stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File filedeleted=new File (Settings.getPathFile()+getFile());
		if (filedeleted.exists())
		{
			filedeleted.delete();
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
	
	
	public void open(File document) throws IOException
	{
	    Desktop dt = Desktop.getDesktop();
	    dt.open(document);
	}
	
	 public static void copy(String fromFileName, String toFileName)
		      throws IOException 
	 {
		 File fromFile = new File(fromFileName);
		 File toFile = new File(toFileName);

		 if (!fromFile.exists())
		      throw new IOException("FileCopy: " + "no such source file: "
		          + fromFileName);
		 if (!fromFile.isFile())
		      throw new IOException("FileCopy: " + "can't copy directory: "
		          + fromFileName);
		 if (!fromFile.canRead())
		      throw new IOException("FileCopy: " + "source file is unreadable: "
		          + fromFileName);

		 if (toFile.isDirectory())
		      toFile = new File(toFile, fromFile.getName());

		 if (toFile.exists()) 
		 {
		      if (!toFile.canWrite())
		        throw new IOException("FileCopy: "
		            + "destination file is unwriteable: " + toFileName);
		      System.out.print("Overwrite existing file " + toFile.getName()
		          + "? (Y/N): ");
		      System.out.flush();
		      BufferedReader in = new BufferedReader(new InputStreamReader(
		          System.in));
		      //String response = in.readLine();
		      String response ="y";
		      
		      if (!response.equals("Y") && !response.equals("y"))
		        throw new IOException("FileCopy: "
		            + "existing file was not overwritten.");
		  } 
		  else 
		  {
		      String parent = toFile.getParent();
		      if (parent == null)
		        parent = System.getProperty("user.dir");
		      File dir = new File(parent);
		      if (!dir.exists())
		        throw new IOException("FileCopy: "
		            + "destination directory doesn't exist: " + parent);
		      if (dir.isFile())
		        throw new IOException("FileCopy: "
		            + "destination is not a directory: " + parent);
		      if (!dir.canWrite())
		        throw new IOException("FileCopy: "
		            + "destination directory is unwriteable: " + parent);
		    }
		 
		 FileInputStream from = null;
		 FileOutputStream to = null;
		 try 
		 {
		     from = new FileInputStream(fromFile);
		     to = new FileOutputStream(toFile);
		     
		     byte[] buffer = new byte[4096];
		     int bytesRead;

		     while ((bytesRead = from.read(buffer)) != -1)
		        to.write(buffer, 0, bytesRead); // write
		    } 
		  finally 
		  {
		     if (from != null)
		        try {
		          from.close();
		        } catch (IOException e) {
		          ;
		        }
		      if (to != null)
		        try {
		          to.close();
		        } catch (IOException e) {
		          ;
		        }
		    }
	 }
	 
		
}

class Filename 
{
	  private String fullPath;
	  private char pathSeparator, extensionSeparator;

	  public Filename(String str, char sep, char ext) 
	  {
	    fullPath = str;
	    pathSeparator = sep;
	    extensionSeparator = ext;
	  }

	  public String extension() 
	  {
	    int dot = fullPath.lastIndexOf(extensionSeparator);
	    return fullPath.substring(dot + 1);
	  }

	  public String filename() 
	  { // gets filename without extension
	    int dot = fullPath.lastIndexOf(extensionSeparator);
	    int sep = fullPath.lastIndexOf(pathSeparator);
	    return fullPath.substring(sep + 1, dot);
	  }

	  public String path() 
	  {
	    int sep = fullPath.lastIndexOf(pathSeparator);
	    return fullPath.substring(0, sep);
	  }
	}
