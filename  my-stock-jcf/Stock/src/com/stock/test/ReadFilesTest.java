package com.stock.test;

import org.junit.Test;

import com.stock.accessFile.ReadFromFile;
import com.stock.trendline.DataManager;

public class ReadFilesTest {
	
	@Test public void testConvertArray(){
		DataManager rf = new DataManager();
		rf.convertToArray();
		rf.printArray();
	}
	
	@Test
	public void testReadLineBat(){
		ReadFromFile.readFileByBytes_linedat("c:\\line.dat");
	}
	
	@Test
	public void testWriteLineBat(){
//		ReadFromFile.writeLinedat("c:\\line_test.dat");
		ReadFromFile.readFileByBytes_linedat("c:\\line_test.dat");
		
	}
	
	
	@Test
	public void testLC5(){
		ReadFromFile.readFileByBytes_lc5("c:\\sh000005.5");
	}
}
