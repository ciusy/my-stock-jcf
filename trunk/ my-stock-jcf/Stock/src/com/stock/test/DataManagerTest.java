package com.stock.test;

import org.junit.Test;

import com.stock.trendline.DataManager;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class DataManagerTest {

	@Test
	public void testGetData(){
		DataManager dm = new DataManager();
		PivotalCandleStick[] pcsArray =dm.getExpPivotalCandleStick("600416", "", null);
//		System.out.println(DateUtil.dateToString(DateUtil.dateIncreaseByDay(pcsArray[0].getDate(),1)));
		System.out.println(pcsArray[0].getOpen());
	}
}
