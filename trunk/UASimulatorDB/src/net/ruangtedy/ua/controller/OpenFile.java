package net.ruangtedy.ua.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File document = new File("D:\\jawa.txt");
		try {
			open(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void open(File document) throws IOException
	{
	    Desktop dt = Desktop.getDesktop();
	    dt.open(document);
	}
}
