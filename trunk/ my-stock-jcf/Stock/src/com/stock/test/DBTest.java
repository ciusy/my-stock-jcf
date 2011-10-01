package com.stock.test;

import org.junit.Test;

import com.stock.dataImport.DataImport;
import com.stock.db.StockDBTemplate;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class DBTest {

	@Test
	public void testGetDate(){
		StockDBTemplate sdb = new StockDBTemplate();
		PivotalCandleStick[] pcsarray = sdb.getStock("600416", "date between ? and ?", 
				new Object[]{new java.sql.Date(DateUtil.stringToDateTime("2011-01-01 00:00:00").getTime()),
				new java.sql.Date(DateUtil.stringToDateTime("2011-05-01 00:00:00").getTime())});
	
		for(int i =0;i<pcsarray.length;i++){
			System.out.println(pcsarray[i]);
		}
		
	}
	
	@Test
	public void testImport(){
		DataImport di = new DataImport();
		//C:\\jcb_zxjt\\T0002\\export
		//H:\\shouji\\1
		di.importPivotalCandleStick("c:\\1\\");
	}
	
	@Test
	public void test(){
		StockDBTemplate sdb = new StockDBTemplate();
		PivotalCandleStick[] pcsarray = sdb.getStock("sh601318", "date = ?", 
				new Object[]{new java.sql.Date(DateUtil.stringToDateTime("2007-05-11 00:00:00").getTime())});
	
		for(int i =0;i<pcsarray.length;i++){
			System.out.println(pcsarray[i]);
		}
		
	}
	
}
