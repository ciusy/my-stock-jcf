package com.stock.test;

import org.junit.Test;

import com.stock.dataImport.DataImport;
import com.stock.db.StockDBTemplate;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class DBTest {

	
	/**数据导入测试用例,主要用于附加新的数据到数据库中,可以控制导入的数据的正确性0.16 **/
	@Test
	public void testImport(){
		DataImport di = new DataImport();
		di.importPivotalCandleStick("C:\\");//传入*.TXT文件所在路径
	}
	
	/**数据导入测试用例,主要用于比较更新数据到数据库中,可以用于修正错误数据0.16 **/
	@Test
	public void testUpdateImport(){
		DataImport di = new DataImport();
		di.importPivotalCandleStickFullCheck("c:\\",true,true);//传入*.TXT文件所在路径
	}
	
	/**删除数据库中的错误数据0.16,用于数据库中有错误数据而现实中又没有正确的数据而又想删除数据库中错误数据**/
	@Test
	public void testDeleteErrorData(){
		String stockId= "sh600416"; //深证加sz 上证sh
		DataImport di = new DataImport();
		di.deleteErrorData(stockId);
	}
	
	
	@Test
	public void testGetDate(){
		StockDBTemplate sdb = new StockDBTemplate();
		PivotalCandleStick[] pcsarray = sdb.getLimitStock("sh600416",null,null,50);
	
		for(int i =0;i<pcsarray.length;i++){
			System.out.println(i+":"+pcsarray[i]);
		}
		
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
