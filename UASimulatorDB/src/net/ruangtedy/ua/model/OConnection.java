package net.ruangtedy.ua.model;
import java.sql.Connection;


public class OConnection 
{
	private boolean inUse= false;
	private Connection conn= null;

	/**
	 * Constructor for OConnection.
	 */
	public OConnection()
	{
		super();
	}

	public Connection getConnection()
	{
		return conn;
	}

	/**
	 * Membuat Koneksi Baru 
	 * @param newConn koneksi dengan url
	 */
	public void setConnection(Connection newConn)
	{
		conn= newConn;
	}

	public boolean getInUse()
	{
		return inUse;
	}

	public void setInUse(boolean flag)
	{
		inUse= flag;
	}

	public boolean isConnected()
	{
		try
		{
			return !conn.isClosed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

}
