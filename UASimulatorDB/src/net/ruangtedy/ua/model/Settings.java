package net.ruangtedy.ua.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Settings 
{
	public static String set_path = "";
	private static Properties settings= new Properties();
	private static boolean loaded= false;

	public Settings()
	{
		super();
	
	}
	
	private static void readSettings()
	{
		File file= null;
		try
		{
			file= new File(set_path + "settings.uasdb");						//file setting at settings.vsn
			
			settings.load(new FileInputStream(file));						//if setting.vsn is exist, load the file
		}
		catch (Exception e)
		{
		}
	}
	
	private static String get(String key, String defaultValue)
	{
		if (!loaded)											// if loaded = false
		{
			loaded= true;										//set loaded = true
			readSettings();										//read setting from setting.vsn	
		}
		return settings.getProperty(key, defaultValue);			//return the value
	}
	
	public static String getHstJDBCDriver()
	{
		return get("hst_sys_driver", "com.mysql.jdbc.Driver");
	}
	
	public static String getHstJDBCUrl()
	{
		return get("hst_sys_url", "jdbc:mysql://localhost/ua_simulator");
	}
	public static String getHstSystemName()
	{
		return get("hst_sys_name", "localhost");
	}
	public static String getHstSystemUser()
	{
		return get("hst_sys_user", "root");
	}
	public static String getHstSystemPassword()
	{
		return get("hst_sys_password", "");
	}

}
