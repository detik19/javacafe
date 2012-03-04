package net.ruangtedy.ua.controller;

import net.ruangtedy.ua.model.Constants;

public class IdData 
{
	public String getDate(String bulan, String tahun)
	{
		String codeBulan=getCodeBulan(bulan);
		String codeTahun=getCodeTahun(tahun);
		String date=codeTahun+codeBulan+"01";
		return date;
		
	}
	
	
	public int getID(String bulan, String tahun, String site)
	{
		String codeBulan=getCodeBulan(bulan);
		String codeTahun=getCodeTahun(tahun);
		String codeSite=getCodeSite(site);
		String strid=codeTahun+codeBulan+codeSite;
		System.out.println(strid);
		int id=Integer.parseInt(strid);
		return id;
			
		
	}
	
	private String getCodeBulan(String bulan)
	{
		String codeBulan = null;
		
		if (bulan.equalsIgnoreCase("Januari")) codeBulan=Constants.JANUARI;
		else if (bulan.equalsIgnoreCase("Februari")) codeBulan=Constants.FEBRUARI;
		else if (bulan.equalsIgnoreCase("Maret")) codeBulan=Constants.MARET;
		else if (bulan.equalsIgnoreCase("April")) codeBulan=Constants.APRIL;
		else if (bulan.equalsIgnoreCase("Mei")) codeBulan=Constants.MEI;
		else if (bulan.equalsIgnoreCase("Juni")) codeBulan=Constants.JUNI;
		else if (bulan.equalsIgnoreCase("Juli")) codeBulan=Constants.JULI;
		else if (bulan.equalsIgnoreCase("Agustus")) codeBulan=Constants.AGUSTUS;
		else if (bulan.equalsIgnoreCase("September")) codeBulan=Constants.SEPTEMBER;
		else if (bulan.equalsIgnoreCase("Oktober")) codeBulan=Constants.OKTOBER;
		else if (bulan.equalsIgnoreCase("November")) codeBulan=Constants.NOVEMBER;
		else if (bulan.equalsIgnoreCase("Desember")) codeBulan=Constants.DESEMBER;
		return codeBulan;
		
	}
	
	private String getCodeTahun(String tahun)
	{
		
		return tahun;
		
	}
	
	/*
	 * new String[] { "Adaro S60", "Adaro S219","Kideco S179", "Kideco S211","KPC S079", "BAYA S214", "INDO S313", "TCMM S314", "CILE S142" });
	 */
	private String getCodeSite(String site)
	{
		String codeSite=null;
		if (site.equalsIgnoreCase("Adaro S60")) codeSite=Constants.ADARO_S60;
		else if (site.equalsIgnoreCase("Adaro S219")) codeSite=Constants.ADARO_S219;
		else if (site.equalsIgnoreCase("Kideco S179")) codeSite=Constants.KIDECO_S179;
		else if (site.equalsIgnoreCase("Kideco S211")) codeSite=Constants.KIDECO_S211;
		else if (site.equalsIgnoreCase("KPC S079")) codeSite=Constants.KPC_S079;
		else if (site.equalsIgnoreCase("BAYA S214")) codeSite=Constants.BAYA_S214;
		else if (site.equalsIgnoreCase("INDO S313")) codeSite=Constants.INDO_S313;
		else if (site.equalsIgnoreCase("TCMM S314")) codeSite=Constants.TCMM_S314;
		else if (site.equalsIgnoreCase("CILE S142")) codeSite=Constants.CILE_S142;
		
		return codeSite;
		
	}
	

}
