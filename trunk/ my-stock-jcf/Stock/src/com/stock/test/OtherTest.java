package com.stock.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import com.stock.trendline.DataManager;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;
import com.stock.trendline.PivotalCandleStickManager;
import com.stock.trendline.TrendSegment;
import com.stock.trendline.TrendStyle;

public class OtherTest {
	
	public static int[][] map = {
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 148, 149, 150, 0, 0, 0, 0, 0, 87, 0, 0, 0 },
	    { 151, 152, 153, 0, 0, 0, 0, 0, 90, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	  };

	@Test
	  public void test11()
	  {
	    try
	    {
	      FileOutputStream fos = new FileOutputStream("c:\\map_back_4.dat");
	      DataOutputStream dos = new DataOutputStream(fos);

	      dos.writeInt(10);//row
	      dos.writeInt(12);//col
//	      for (int i = 0; i < 10; ++i)
//	        for (int j = 0; j < 12; ++j)
//	        {
//	          dos.writeInt(map[i][j]);
//	        }
	    }
	    catch (Exception e)
	    {
	    }
	  }
	  
	private enum TendStyle{
		
		Rise(1),Fall(0);
		
		private final int value;
		
		TendStyle(int value){
			this.value = value;
		}
		
		public int getValue() {
            return value;
        }
	}
	
	
	
	@Test public void test() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(DateUtil.daysBetween(new Date(df.parse("2007-01-23").getTime()), new Date(df.parse("2007-02-02").getTime())));
		
	}
	
	@Test
	public void test1(){
		String path = "F:\\java\\amchart\\amstock\\examples\\candlestick_test\\trend_lines.xml";
		String target = path.substring(0, path.lastIndexOf("\\"));
		System.out.println(path);
		System.out.println(target);
	}
	
	@Test
	public void test2() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = null;
			newDate = df.parse("2011-05-08 12:12:12");
//		System.out.println(DateUtil.dateToStringWithTime(sqlDate));
		System.out.println(newDate);
	}
	
	@Test
	public void test3(){
		String [][] a = new DataManager().convertToArray();
		for(int i = 0;i<a.length;i++ ){
			for(int j=0;j<a[i].length;j++){
				System.out.println(a[i][j]+"  ");
			}
		}
		
	}
	
	@Test
	public void test4(){
		
//		Calendar c=Calendar.getInstance();
//		int month = c.get(Calendar.MONTH)+1;
//		month = 4;
//		int quarter = month%3 == 0 ? month/3 : month/3+1;
//		System.out.println(c.get(Calendar.MINUTE));
		
		Date begin = DateUtil.stringToDateTime("2011-09-23 12:12:12");
		Date end = DateUtil.stringToDateTime("2011-09-23 12:17:12");
		System.out.println(DateUtil.getBetweenMinute(begin, end));
		
		begin = end;
		System.out.println(DateUtil.dateToStringWithTime(begin));
		
		end = DateUtil.stringToDateTime("2011-12-29 12:12:12");
		
		
		System.out.println(DateUtil.dateToStringWithTime(begin));
	}
	
	@Test
	public void test5(){
		File file = new File("c:\\stock\\601628.csv");
		boolean bTag = false;//用于筛选掉错误数据或者是数据<=0 的时候的数据
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while (!bTag && (line = reader.readLine()) != null) {
				System.out.println(line);
				for(int i =0;i<line.split(",").length;i++){
					System.out.println(line.split(",")[i]);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test public void test6(){
		List<TrendSegment> tslist = new ArrayList<TrendSegment>();
		
		TrendSegment ts1 = new TrendSegment(-4,3,TrendStyle.Direct.Rise);
		TrendSegment ts2 = new TrendSegment(4,9,TrendStyle.Direct.Fall);
		TrendSegment ts3 = new TrendSegment(13,15,TrendStyle.Direct.Rise);
		TrendSegment ts4 = new TrendSegment(18,20,TrendStyle.Direct.Fall);
		TrendSegment ts5 = new TrendSegment(21,21,TrendStyle.Direct.Rise);
		
		tslist.add(ts1);
		tslist.add(ts2);
		tslist.add(ts3);
		tslist.add(ts4);
		tslist.add(ts5);
		
		PivotalCandleStickManager pcsm = new PivotalCandleStickManager();
		List<TrendSegment> lst = pcsm.trendSegmentListFilter(tslist);
		
		for(TrendSegment ts : lst){
			System.out.println(ts);
		}
		
	}
	
	
	@Test
	public void test111(){
//		System.out.println(DateUtil.dateToString(new Date(), "yyyyMMdd"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(DateUtil.stringToDate("2000-10-2"));
		
		System.out.println(cal.get(Calendar.YEAR)+" "+cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println(cal1.get(Calendar.YEAR)+" "+cal1.get(Calendar.WEEK_OF_YEAR));
	}
	
	@Test public void test7(){
		System.out.println(Math.log(30)-Math.log(20));
		double a = 3;
		double b = 2;
		double i = a;
		System.out.println(i+" "+Math.log((i)));
		System.out.println(Math.tan(Math.toRadians(15)));
	}
	
	@Test public void test8(){
		String str = "      日期	    开盘	    最高	    最低	    收盘	    成交量	    成交额";
		for(int i=0;i<str.split("\t").length;i++){
			System.out.println(str.split("\t")[i]);
		}
	}
	
	@Test
	public void test9(){
//		Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
//	    System.out.println(pattern.matcher("1a212121.000").matches());
	    Pattern pattern = Pattern.compile("^\\d{1,2}(\\-|\\/|\\.)\\d{1,2}\\1\\d{4}$"); 
	    System.out.println(pattern.matcher("12.12.2011").matches());
//	    System.out.println("SH00012121.txt".substring(0,"SH00012121.txt".lastIndexOf(".")));
//	    
//	    System.out.println(DateUtil.stringToString("02/02/2011", "MM/dd/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test10() throws IOException{
		float f1 = 11.05f;
		float f2 ;
		byte[] priceBytesOne = new byte[4];
		
//		priceBytesOne = floatToByte(f1);
//		priceBytesOne = intToBytes2(Float.floatToIntBits(f1));
		priceBytesOne = Int2Byte(Float.floatToIntBits(f1));
//		priceBytesOne = Float.toString(f1).getBytes();
		f2 = (float) (Math.round(Float
				.intBitsToFloat(bytesToInt(priceBytesOne)) * 100));
		System.out.println(f2);
		System.out.println(Float.floatToIntBits(f1));
	}
	
	@Test
	public void test13(){
		PivotalCandleStick pcs = new PivotalCandleStick();
		pcs.setCi(0);
		pcs.setDate(new Date());
		pcs.setClose(12.30);
		pcs.setHigh(11.0);
		pcs.setLow(4.09);
		pcs.setOpen(55.6);
		pcs.setVolumn(124324);
		
		PivotalCandleStick pcs2 = new PivotalCandleStick();
		pcs2.setCi(1);
		pcs2.setDate(new Date());
		pcs2.setClose(2.63);
		
		PivotalCandleStick pcs3 = new PivotalCandleStick();
		pcs3.setCi(0);
		pcs3.setDate(new Date());
		pcs3.setClose(12.30);
		pcs3.setHigh(11.0);
		pcs3.setLow(4.09);
		pcs3.setOpen(55.6);
		pcs3.setVolumn(124324);
		
		List<PivotalCandleStick> pvslist = new ArrayList<PivotalCandleStick>();
		pvslist.add(pcs);
		pvslist.add(pcs2);
		
		pvslist.get(0).setCi(100);
		
//		System.out.println(pvslist.get(0));
		System.out.println("sh600416".substring(0,2));
	}
	
	@Test
	public void test14(){
		for(int i =0;i<10;i++){
			if(i%2 == 0) continue;
			System.out.println(i);
		}
	}
	
	public static int bytesToInt(byte[] intByte) {
		int fromByte = 0;
		for (int i = 0; i < intByte.length; i++)
		{
			int n = (intByte[i] < 0 ? (int) intByte[i] + 256 : (int) intByte[i]) << (8 * i);
			// System.out.println(n);
			fromByte += n;
		}
		return fromByte;
	}
	
	//float转byte[]
	public static byte[] floatToByte(float v) {
	        ByteBuffer bb = ByteBuffer.allocate(4);
	        byte[] ret = new byte [4];
	        FloatBuffer fb = bb.asFloatBuffer();
	        fb.put(v);
	        bb.get(ret);
	        return ret;
	}
	
	public static byte[] intToBytes2(int n){
		 byte[] b = new byte[4];
		 for(int i = 0;i < 4;i++){
		  b[i] = (byte)(n >> (24 - i * 8)); 
		 }
		 return b;
		}
	
	public static byte[]  Int2Byte(int   send) throws IOException{
		  byte   []   bTemp   =   new   byte[4];
		  //System.out.println( "send:   "+send+   "     Hex: "   +   Integer.toHexString(send));
		  for(int   i=0;i <4;i++){
			  bTemp[i]   =   (byte)((send   >> (i*8))&   0xff);
		  //System.out.println( "send   byte "   +((send   > > (i*16))&0xff));  
		  }
		 
		  return   bTemp;
		  }
	
}
