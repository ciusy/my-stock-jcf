package com.stock.accessFile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Date;

import com.stock.trendline.DateUtil;

/**
 * 1、按字节读取文件内容 2、按字符读取文件内容 3、按行读取文件内容 4、随机读取文件内容
 */

public class ReadFromFile {

	
	public static void renameFile(String fileName){
		File newFile = new File(
				fileName.substring(0,fileName.indexOf("."))
				+DateUtil.dateToStringWithTime2(new Date())
				+fileName.substring(fileName.indexOf("."))
				);
        File oldFile = new File(fileName);
        oldFile.renameTo(newFile); 
	}
	
	/**
	 * 写ZXG.blk
	 * @param fileName
	 * @param stockId
	 */
	public static void writeZXGblk(String fileName, String stockId) {
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream(fileName,true),true); //false 不追加
			System.out.println("[write ZXG]:"+stockId);
			pw.println(stockId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}    
        
	}

	/**
	 * 写line.dat文件
	 * 
	 * @param fileName
	 * @param market
	 * @param period
	 * @param stockId
	 * @param dateOne
	 * @param priceOne
	 * @param dateTwo
	 * @param priceTwo
	 */
	public static void writeLinedat(String fileName, int market, int period,
			String stockId, int dateOne, float priceOne, int dateTwo,
			float priceTwo) {

		// int market = 1 ;
		// int period = 4 ;
		// String stockId = "600416";
		String indicatortype = "STANDK";
		// int dateOne = 20110720;
		// float priceOne = 13.73f;
		// int dateTwo = 20110729;
		// float priceTwo = 12.64f;
		int linestyle = 4130;

		FileOutputStream out;
		DataOutputStream dos;

		System.out.println("[write line]:"+stockId);
		
		try {
			out = new FileOutputStream(fileName, true);// false不追加
			dos = new DataOutputStream(out);

			byte[] bytesInOneRecord = new byte[298];

			bytesInOneRecord[0] = Int2Byte(market)[0];

			for (int i = 1; i < 1 + 6; i++) {
				bytesInOneRecord[i] = hex2byte(toHexString(stockId))[i - 1];
			}

			for (int i = 9; i < 9 + 6; i++) {
				bytesInOneRecord[i] = hex2byte(toHexString(indicatortype))[i - 9];
			}

			bytesInOneRecord[19] = Int2Byte(period)[0];

			for (int i = 21; i < 21 + 2; i++) {
				bytesInOneRecord[i] = Int2Byte(linestyle)[i - 21];
			}

			for (int i = 25; i < 25 + 4; i++) {
				bytesInOneRecord[i] = Int2Byte(dateOne)[i - 25];
			}

			for (int i = 29; i < 29 + 4; i++) {
				bytesInOneRecord[i] = Int2Byte(Float.floatToIntBits(priceOne))[i - 29];
			}

			for (int i = 37; i < 37 + 4; i++) {
				bytesInOneRecord[i] = Int2Byte(dateTwo)[i - 37];
			}

			for (int i = 41; i < 41 + 4; i++) {
				bytesInOneRecord[i] = Int2Byte(Float.floatToIntBits(priceTwo))[i - 41];
			}

			dos.write(bytesInOneRecord);
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取通达信line.bat文件 文件格式： 一个记录的长度是298个字节 1、第一个字节是00，表示深圳；01表示上海
	 * 2、下面6个字节，股票代码。 3、ascii码下面2个字节，占位符 4、下面6个字节standk,标准k线或其他技术指标（猜的）
	 * 5、下面4个字节占位符 6、下面一个字节，周期类型， 298个字节
	 * 7、对于价格通道来讲，第25字节到第28字节，日期；第37字节到第40字节，日期；第45字节到第48字节，日期；
	 * 第29字节到第32字节，价格；第41字节到第44字节，价格；第85字节到第88字节，价格；
	 * 8、第21个字节一般为41，不知道什么意思，22字节为line的类型(直线07、线段06、射线30、平行线25)，没有这两个字节显示不出来
	 * 
	 * @param fileName
	 */
	public static void readFileByBytes_linedat(String fileName) {

		InputStream in = null;
		byte[] bytesInOneRecord = new byte[298];
		byte[] dateBytesOne = new byte[4];
		byte[] dateBytesTwo = new byte[4];
		byte[] PriceBytesOne = new byte[4];
		byte[] PriceBytesTwo = new byte[4];

		byte[] marketName = new byte[1];
		byte[] stockIdBytes = new byte[6];
		byte[] indicatortype = new byte[6];
		byte[] periodName = new byte[1];

		byte[] other1 = new byte[2]; //划线类型
		
		byte[] other2 = new byte[2];//平行线信息
		byte[] other3 = new byte[2];//平行线信息
		byte[] other4 = new byte[3];//平行线信息

		try {
			in = new FileInputStream(fileName);

			int count = 0;

			int bytesRead = 0;
			int totalBytesRead = 0;

			while ((bytesRead = in.read(bytesInOneRecord)) != -1) {
				++count;
				totalBytesRead += bytesRead;

				System.arraycopy(bytesInOneRecord, 0, marketName, 0, 1);
				System.arraycopy(bytesInOneRecord, 1, stockIdBytes, 0, 6);
				System.arraycopy(bytesInOneRecord, 9, indicatortype, 0, 6);
				System.arraycopy(bytesInOneRecord, 19, periodName, 0, 1);

				// other1
				System.arraycopy(bytesInOneRecord, 21, other1, 0, 2);

				System.arraycopy(bytesInOneRecord, 25, dateBytesOne, 0, 4);
				System.arraycopy(bytesInOneRecord, 29, PriceBytesOne, 0, 4);
				System.arraycopy(bytesInOneRecord, 37, dateBytesTwo, 0, 4);
				System.arraycopy(bytesInOneRecord, 41, PriceBytesTwo, 0, 4);
				
				//other2
				System.arraycopy(bytesInOneRecord, 84, other2, 0, 2);
				System.arraycopy(bytesInOneRecord, 84, other4, 0, 3);
				System.arraycopy(bytesInOneRecord, 86, other3, 0, 2);
				
				String marketNameStr = "";
				int marketInt = bytesToInt(marketName);
				if (marketInt == 0) {
					marketNameStr = "深圳市场";
				} else {
					marketNameStr = "上海市场";
				}
				System.out.print("所在交易所 \t " + marketNameStr + "\t");
				String stockIdStr = (new String(stockIdBytes)).trim();
				System.out.print("股票代码 \t " + stockIdStr + "\t");

				String indicatortypeStr = (new String(indicatortype)).trim();
				System.out.print("主图名称 \t " + indicatortypeStr + "\t");
				int periodInt = bytesToInt(periodName);
				int[] intTwo = new int[2];
				if (periodInt < 4) {
					intTwo = BytesOf4To2Int(dateBytesOne);
					System.out.print("月份\t" + (intTwo[0] / 100) + "日期\t"
							+ (intTwo[0] % 100) + "\t" + (intTwo[1] / 60)
							+ "时\t" + (intTwo[1] % 60) + "分钟 \t ");
					System.out.print("日期\t" + intTwo[0] + "\t" + "时间\t"
							+ intTwo[1] + "\t");
					intTwo = BytesOf4To2Int(dateBytesTwo);
					System.out.print("月份\t" + (intTwo[0] / 100) + "日期\t"
							+ (intTwo[0] % 100) + "\t" + (intTwo[1] / 60)
							+ "时\t" + (intTwo[1] % 60) + "分钟 \t ");

				}
				System.out.print("周期名称 \t " + periodInt + "\t");
				System.out.print("日期之一\t" + bytesToInt(dateBytesOne) + "\t");
				System.out
						.print("价格之一\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(PriceBytesOne)) * 100))
								/ 100 + "\t");
				System.out.print("日期之二\t" + bytesToInt(dateBytesTwo) + "\t");
				System.out
						.println("价格之二\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(PriceBytesTwo)) * 100))
								/ 100);

				System.out.println("other1......" + bytesToInt(other1));
				System.out.println("other2......" + bytesToInt(other2)+" "+ bytesToInt(dateBytesOne));
				System.out.println("other3......" + bytesToInt(other3)+" "+ bytesToInt(dateBytesOne));
				System.out.println("other4......" + bytesToInt(other4)+" "+ bytesToInt(dateBytesOne));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void readFileByBytes_lc5(String fileName) {

		InputStream in = null;
		byte[] bytesInOneRecord = new byte[32];
		byte[] dateBytes = new byte[2];
		byte[] timeBytes = new byte[2];
		byte[] openPriceBytes = new byte[4];
		byte[] highPriceBytes = new byte[4];
		byte[] lowPriceBytes = new byte[4];
		byte[] closePriceBytes = new byte[4];
		byte[] moneyBytes = new byte[4];
		byte[] volBytes = new byte[4];
		byte[] unknownBytes = new byte[4];
		try {
			in = new FileInputStream(fileName);

			int count = 0;

			int bytesRead = 0;
			int totalBytesRead = 0;

			while ((bytesRead = in.read(bytesInOneRecord)) != -1) {
				++count;
				totalBytesRead += bytesRead;

				System.arraycopy(bytesInOneRecord, 0, dateBytes, 0, 2);
				System.arraycopy(bytesInOneRecord, 2, timeBytes, 0, 2);
				System.arraycopy(bytesInOneRecord, 4, openPriceBytes, 0, 4);
				System.arraycopy(bytesInOneRecord, 8, highPriceBytes, 0, 4);
				System.arraycopy(bytesInOneRecord, 12, lowPriceBytes, 0, 4);
				System.arraycopy(bytesInOneRecord, 16, closePriceBytes, 0, 4);
				System.arraycopy(bytesInOneRecord, 20, moneyBytes, 0, 4);
				System.arraycopy(bytesInOneRecord, 24, volBytes, 0, 4);

				System.arraycopy(bytesInOneRecord, 28, unknownBytes, 0, 4);

				int intDate = bytesToInt(dateBytes);
				int intTime = bytesToInt(timeBytes);
				System.out
						.println("月份\t"
								+ (intDate / 100)
								+ "日期\t"
								+ (intDate % 100)
								+ "\t"
								+ (intTime / 60)
								+ "时\t"
								+ (intTime % 60)
								+ "分钟 \t "
								+ "开盘价\t "
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(openPriceBytes)) * 100))
								/ 100
								+ "最高价\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(highPriceBytes)) * 100))
								/ 100
								+ "最低价\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(lowPriceBytes)) * 100))
								/ 100
								+ "收盘价\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(closePriceBytes)) * 100))
								/ 100
								+ "金额\t"
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(moneyBytes)) * 100))
								/ 100 + "成交量\t" + bytesToInt(volBytes));

				if (intDate > 1300)
					break;
			}
			// }
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {

				try {
					in.close();
					in = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	/*
	 * 唯一确定的是一条记录是26个字节，2/4/4/4 有内容 4/4/4应该为空
	 * 一个字节表示某个地址索引的数据是不是有效，紧跟的两字节就是地址，标志现在假设是"1"
	 * 方法就是打开一个文件，用随机读取的方法，取得连续26个字节，看这26个字节是不是一条记录如果是看下面的26个字节是不是。。。
	 * 如果不是，字节偏移1.先用这个比较笨的方法做
	 */
	public static void readFileByBytes_Trying_tfz(String fileName) {

		byte[] timeBytes = new byte[2];
		byte[] currentPriceBytes = new byte[4];
		byte[] averagePriceBytes = new byte[4];
		byte[] volBytes = new byte[4];
		byte[] unknown1Bytes = new byte[4];
		byte[] unknown2Bytes = new byte[4];
		byte[] unknown3Bytes = new byte[4];

		RandomAccessFile randomFile = null;
		int intTime;
		int u1;
		int u2;
		int u3;
		int v;
		float fc;
		float fa;
		try {
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] tempBytes = new byte[26];
			int bytesRead = 0;

			// 一次读26个字节，如果文件内容不足26个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((bytesRead = randomFile.read(tempBytes)) != -1) {
				System.arraycopy(tempBytes, 0, timeBytes, 0, 2);
				System.arraycopy(tempBytes, 2, currentPriceBytes, 0, 4);
				System.arraycopy(tempBytes, 6, averagePriceBytes, 0, 4);
				System.arraycopy(tempBytes, 10, volBytes, 0, 4);
				System.arraycopy(tempBytes, 14, unknown1Bytes, 0, 4);
				System.arraycopy(tempBytes, 18, unknown2Bytes, 0, 4);
				System.arraycopy(tempBytes, 22, unknown3Bytes, 0, 4);

				intTime = bytesToInt(timeBytes);
				u1 = bytesToInt(unknown1Bytes);
				u2 = bytesToInt(unknown2Bytes);
				u3 = bytesToInt(unknown3Bytes);
				fc = (float) (Math.round(Float
						.intBitsToFloat(bytesToInt(currentPriceBytes)) * 100)) / 100;
				fa = (float) (Math.round(Float
						.intBitsToFloat(bytesToInt(averagePriceBytes)) * 100)) / 100;
				v = bytesToInt(volBytes);
				// System.out.println("是不是有效  " + bytesToInt(trybytesSkip1) +
				// "  索引地址  "
				// + bytesToInt(trybytesSkip3));

				if (!((u1 == 0) && (u2 == 0) && (u3 == 0) && (fc != 0)
						&& (fc < 300.00) && (fa != 0) && (fa < 300.00)
						&& (intTime < 1500) && (intTime > 559))) {
					beginIndex += 1;
					randomFile.seek(beginIndex);
					continue;
				}

				System.out.println("  Time  " + (intTime / 60) + "  点     "
						+ (intTime % 60) + "  分钟  " + "  现价  " + fc

						+ "  均价  " + fa + "  Vol  " + v + "  Unknown1  " + u1
						+ "  Unknown2  " + u2 + "  Unknown3 " + u3 + "索引位置：  "
						+ beginIndex);
				beginIndex += 26;

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void readFileByBytes_origional_tfz(String fileName) {

		InputStream in = null;
		// int trybytes = 18254+12+4;
		int trybytes = 18896 - 2 - 6240 - 2;

		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempBytes = new byte[26];
			byte[] byPassBytesTime = new byte[2];
			byte[] byPassBytesCurrentPrice = new byte[4];
			byte[] byPassBytesAveragePrice = new byte[4];
			byte[] byPassBytesVol = new byte[4];
			byte[] byPassBytesUnknown1 = new byte[4];
			byte[] byPassBytesUnknown2 = new byte[4];
			byte[] byPassBytesUnknown3 = new byte[4];
			byte[] trybytesSkip1 = new byte[1];
			byte[] trybytesSkip2 = new byte[trybytes];
			byte[] trybytesSkip3 = new byte[2];

			in = new FileInputStream(fileName);
			ReadFromFile.showAvailableBytes(in);
			// 读入多个字节到字节数组中，bytesRead为一次读入的字节数
			// bytesRead=in.read(byPassBytes);
			// System.out.println(bytesRead);
			// 跳过前面的8个字节
			int totalBytesRead = 0;
			int bytesRead = 0;

			int count = 0;
			in.read(trybytesSkip1);
			in.read(trybytesSkip3);
			in.read(trybytesSkip2);

			totalBytesRead += 1 * trybytes + 1 + 2;
			System.out.println("是不是有效  " + bytesToInt(trybytesSkip1)
					+ "  索引地址  " + bytesToInt(trybytesSkip3)
					+ "       累计字节数    " + totalBytesRead);

			while ((bytesRead = in.read(tempBytes)) != -1) {
				// System.out.println("       累计字节数    " + totalBytesRead);
				++count;
				totalBytesRead += bytesRead;
				System.arraycopy(tempBytes, 0, byPassBytesTime, 0, 2);
				System.arraycopy(tempBytes, 2, byPassBytesCurrentPrice, 0, 4);
				System.arraycopy(tempBytes, 6, byPassBytesAveragePrice, 0, 4);
				System.arraycopy(tempBytes, 10, byPassBytesVol, 0, 4);
				System.arraycopy(tempBytes, 14, byPassBytesUnknown1, 0, 4);
				System.arraycopy(tempBytes, 18, byPassBytesUnknown2, 0, 4);
				System.arraycopy(tempBytes, 22, byPassBytesUnknown3, 0, 4);

				// System.out.println("first 4 byte  "+bytesToInteger(tempBytes));
				int intTime = bytesToInt(byPassBytesTime);

				// if (count % 100 == 0)
				System.out
						.println("       累计字节数    "
								+ totalBytesRead
								+ "  Time  "
								+ (intTime / 60)
								+ "  点     "
								+ (intTime % 60)
								+ "  分钟  "
								+ "  现价  "
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(byPassBytesCurrentPrice)) * 100))
								/ 100
								// +
								// Float.intBitsToFloat(bytesToInt(byPassBytesCurrentPrice))
								+ "  均价  "
								+ (float) (Math
										.round(Float
												.intBitsToFloat(bytesToInt(byPassBytesAveragePrice)) * 100))
								/ 100 + "  Vol  " + bytesToInt(byPassBytesVol)
								+ "  Unknown1  "
								+ bytesToInt(byPassBytesUnknown1)
								+ "  Unknown2  "
								+ bytesToInt(byPassBytesUnknown2)
								+ "  Unknown3 "
								+ bytesToInt(byPassBytesUnknown3));
				if (totalBytesRead > (19000 + 6240))
					break;

			}
			// break;
			// }
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	// **********************************************************************************************************
	// 读取ZST文件,刚刚开始要有8个字节不知什么意思！！！！！！！！！！！现在清楚了，前面4个字节日期，后面4个字节为昨日收盘价。
	/**
	 * \jcb_zxjt\T0002\zst_cache\ sz399005.zst 说明：只有在浏览历史分时图时才生成相应文件。
	 * 
	 * \jcb_zxjt\T0002\hq_cache\sh.tfz \jcb_zxjt\T0002\hq_cache\sz.tfz
	 * 说明：通达信当日分时数据, 包括所有浏览过的股票 注意： 1）、每6508个字节为一天的数据。（6508 – 8 ）/ 26 = 250
	 * 2）、每26个字节为一个分钟的记录。
	 * 
	 * 
	 * 股票代码文件格式是前面14个字节是ip地址，按照ASIIC字符方式存放，每个一个字节
	 * 前面42到46字节是日期，47到50是时间，20101104的格式存放 第50字节就开始放股票代码信息，250字节为一个记录
	 */

	public static void readFileByBytes_zst(String fileName) {

		InputStream in = null;

		int headBytes = 8;
		byte[] bytesInOneRecord = new byte[26];
		byte[] timeBytes = new byte[2];
		byte[] currentPriceBytes = new byte[4];
		byte[] averagePriceBytes = new byte[4];
		byte[] volBytes = new byte[4];

		byte[] dateBytes = new byte[4];
		byte[] lastCloseBytes = new byte[4];
		byte[] unknownBytes = new byte[12];
		try {

			in = new FileInputStream(fileName);

			// 读入多个字节到字节数组中，bytesRead为一次读入的字节数
			// bytesRead=in.read(byPassBytes);
			// System.out.println(bytesRead);
			// 跳过前面的8个字节
			int totalBytesRead = 0;
			int bytesRead = 0;
			for (int i = 0; i < 9; i++) {

				int count = 0;
				in.read(dateBytes);
				in.read(lastCloseBytes);

				System.out.println("日期  " + bytesToInt(dateBytes) + "  昨天收盘价  "
						+ Float.intBitsToFloat(bytesToInt(lastCloseBytes))
						+ "  元" + "       累计字节数    " + totalBytesRead);
				totalBytesRead += headBytes;
				while ((bytesRead = in.read(bytesInOneRecord)) != -1) {
					++count;
					totalBytesRead += bytesRead;
					System.arraycopy(bytesInOneRecord, 0, timeBytes, 0, 2);
					System.arraycopy(bytesInOneRecord, 2, currentPriceBytes, 0,
							4);
					System.arraycopy(bytesInOneRecord, 6, averagePriceBytes, 0,
							4);
					System.arraycopy(bytesInOneRecord, 10, volBytes, 0, 4);

					System.arraycopy(bytesInOneRecord, 14, unknownBytes, 0, 12);

					int intTime = bytesToInt(timeBytes);
					System.out
							.println("时间"
									+ (intTime / 60)
									+ "点"
									+ (intTime % 60)
									+ "  分钟  "
									+ "  现价  "
									+ (float) (Math
											.round(Float
													.intBitsToFloat(bytesToInt(currentPriceBytes)) * 100))
									/ 100

									+ "  均价  "
									+ (float) (Math
											.round(Float
													.intBitsToFloat(bytesToInt(averagePriceBytes)) * 100))
									/ 100 + "  Vol  " + bytesToInt(volBytes));

					if (count == 250)
						break;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {

				try {
					in.close();
					in = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	// **********************************************************************************************************
	// 读取ZST文件,刚刚开始要有8个字节不知什么意思！！！！！！！！！！！现在清楚了，前面4个字节日期，后面4个字节为昨日收盘价。
	/**
	 * 
	 * \jcb_zxjt\T0002\hq_cache\sh.tfz \jcb_zxjt\T0002\hq_cache\sz.tfz
	 * 说明：通达信当日分时数据, 包括所有浏览过的股票 注意： 1）、每6508个字节为一天的数据。（6508 – 8 ）/ 26 = 250
	 * 2）、每26个字节为一个分钟的记录。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 2、当日分时数据格式（1）、索引数据格式 数据含义 数据类型 备注 存储标记 Byte 表示在指定地址是否有数据 起始地址 Integer
	 * 股票分时数据块起始地址 注意： ）、索引个数与“\jcb_zxjt\T0002\hq_cache\
	 * shex.tnf”或“\jcb_zxjt\T0002\hq_cache\ szex.tnf”中的股票个数相同。 现在_tfz 代码段不能工作
	 */

	public static void readFileByBytes_tnf(String fileName) {

		InputStream in = null;
		int ipAddress = 14;
		int directoryOfInit = 26;
		int unknown2 = 2;

		int dateInt = 4;
		int timeInt = 4;
		int stockId = 9;
		int unknown15 = 15;
		int stockName = 18;
		int unknown4 = 4;
		int unknown186 = 186;
		int lastClose = 4;
		int unknown5 = 5;
		int stockAbbr = 9;
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			// byte[] tempBytes = new byte[26];
			// byte[] lastCloseBytes = new byte[lastClose];
			byte[] bytesInOneRecord = new byte[250];
			byte[] ipAddressBytes = new byte[ipAddress];
			byte[] directoryOfInitBytes = new byte[directoryOfInit];

			byte[] unknown2Bytes = new byte[unknown2];

			byte[] dateIntBytes = new byte[dateInt];
			byte[] timeIntBytes = new byte[timeInt];
			byte[] stockIdBytes = new byte[stockId];

			byte[] unknown15Bytes = new byte[unknown15];
			byte[] stockNameBytes = new byte[stockName];
			byte[] unknown4Bytes = new byte[unknown4];
			byte[] unknown186Bytes = new byte[unknown186];
			byte[] lastCloseBytes = new byte[lastClose];
			byte[] unknown5Bytes = new byte[unknown5];
			byte[] stockAbbrBytes = new byte[stockAbbr];

			in = new FileInputStream(fileName);

			int totalBytesRead = 0;
			int bytesRead = 0;
			int count = 0;

			in.read(ipAddressBytes);
			totalBytesRead += ipAddress;
			String ipAddressStr = (new String(ipAddressBytes)).trim();

			in.read(directoryOfInitBytes);
			totalBytesRead += directoryOfInit;
			String directoryOfInitStr = (new String(directoryOfInitBytes))
					.trim();

			System.out.println("ip地址  " + ipAddressStr + "  目录  "
					+ directoryOfInitStr + "       累计字节数    " + totalBytesRead);

			in.read(unknown2Bytes);
			totalBytesRead += unknown2;
			System.out.println("未知双字节      " + bytesToInt(unknown2Bytes)
					+ "       累计字节数    " + totalBytesRead);
			in.read(dateIntBytes);
			totalBytesRead += dateInt;
			System.out.println("日期      " + bytesToInt(dateIntBytes)
					+ "       累计字节数    " + totalBytesRead);
			in.read(timeIntBytes);
			totalBytesRead += timeInt;
			System.out.println("时间      " + bytesToInt(timeIntBytes)
					+ "       累计字节数    " + totalBytesRead);

			System.out
					.println("===========================================================================");

			while ((bytesRead = in.read(bytesInOneRecord)) != -1) {
				++count;
				totalBytesRead += bytesRead;
				System.arraycopy(bytesInOneRecord, 0, stockIdBytes, 0, stockId);
				System.arraycopy(bytesInOneRecord, stockId, unknown15Bytes, 0,
						unknown15);
				System.arraycopy(bytesInOneRecord, stockId + unknown15,
						stockNameBytes, 0, stockName);
				System.arraycopy(bytesInOneRecord, stockId + unknown15
						+ stockName, unknown4Bytes, 0, unknown4);
				System.arraycopy(bytesInOneRecord, stockId + unknown15
						+ stockName + unknown4, unknown186Bytes, 0, unknown186);
				System.arraycopy(bytesInOneRecord, stockId + unknown15
						+ stockName + unknown4 + unknown186, lastCloseBytes, 0,
						lastClose);
				System.arraycopy(bytesInOneRecord, stockId + unknown15
						+ stockName + unknown4 + unknown186 + lastClose,
						unknown5Bytes, 0, unknown5);
				System.arraycopy(bytesInOneRecord, stockId + unknown15
						+ stockName + unknown4 + unknown186 + lastClose
						+ unknown5, stockAbbrBytes, 0, stockAbbr);

				String stockIdStr = (new String(stockIdBytes)).trim();
				System.out.println("代码  " + stockIdStr);

				String stockNameBytesStr = (new String(stockNameBytes)).trim();
				System.out.println("名称  " + stockNameBytesStr);

				System.out.println("昨日收盘价  "
						+ Float.intBitsToFloat(bytesToInt(lastCloseBytes)));

				String stockAbbrBytesStr = (new String(stockAbbrBytes)).trim();
				System.out.println("简写  " + stockAbbrBytesStr);

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	// **********************************************************************************************************
	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				if (((char) tempchar) != '\r') {
					System.out.print((char) tempchar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("以字符为单位读取文件内容，一次读多个字节：");
			// 一次读多个字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while ((charread = reader.read(tempchars)) != -1) {
				// 同样屏蔽掉\r不显示
				if ((charread == tempchars.length)
						&& (tempchars[tempchars.length - 1] != '\r')) {
					System.out.print(tempchars);
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == '\r') {
							continue;
						} else {
							System.out.print(tempchars[i]);
						}
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 随机读取文件内容
	 */
	public static void readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		try {
			System.out.println("随机读取一段文件内容：");
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static int bytesToInt(byte[] intByte) {
		int fromByte = 0;
		for (int i = 0; i < intByte.length; i++) // 原来是2，改为intByte.length
		{
			int n = (intByte[i] < 0 ? (int) intByte[i] + 256 : (int) intByte[i]) << (8 * i);
			// System.out.println(n);
			fromByte += n;
		}
		return fromByte;
	}

	/**
	 * 显示输入流中还剩的字节数
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ************************************************************************************************
	public static String bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			// String hex = Integer.toHexString(b[ i ] & 0xFF);
			String hex = Integer.toHexString((b[i] & 0x000000FF) | 0xFFFFFF00)
					.substring(6);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	// 字节码转换成16进制字符串
	public static String byte2hex(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i) {
			retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF))
					.substring(1).toUpperCase());
		}
		return retString.toString();
	}

	public static int[] BytesOf4To2Int(byte bytes[]) {

		int[] int2 = new int[2];
		byte[] byteDate = new byte[2];
		byte[] byteTime = new byte[2];
		System.arraycopy(bytes, 0, byteDate, 0, 2);
		System.arraycopy(bytes, 2, byteTime, 0, 2);
		int2[0] = bytesToInt(byteDate);
		int2[1] = bytesToInt(byteTime);
		return int2;
	}

	// 将16进制字符串转换成字节码
	public static byte[] hex2byte(String hex) {
		byte[] bts = new byte[hex.length() / 2];
		for (int i = 0; i < bts.length; i++) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
					16);
		}
		return bts;
	}

	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 将int类型的数据转换为byte数组 原理：将int数据中的四个byte取出，分别存储
	 * 
	 * @param n
	 *            int数据
	 * @return 生成的byte数组
	 */
	public static byte[] intToBytes2(int n) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (n >> (24 - i * 8));
		}
		return b;
	}

	// float转byte[]
	public static byte[] floatToByte(float v) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		byte[] ret = new byte[4];
		FloatBuffer fb = bb.asFloatBuffer();
		fb.put(v);
		bb.get(ret);
		return ret;
	}

	public static byte[] Int2Byte(int send) throws IOException {
		byte[] bTemp = new byte[4];
		// System.out.println( "send:   "+send+ "     Hex: " +
		// Integer.toHexString(send));
		for (int i = 0; i < 4; i++) {
			bTemp[i] = (byte) ((send >> (i * 8)) & 0xff);
			// System.out.println( "send   byte " +((send > > (i*16))&0xff));
		}

		return bTemp;
	}

	// ************************************************************************************************

	public static void main(String[] args) {
		// String fileName = "C:\\stock\\sz000709.day";

		// String fileName = "C:\\stock\\sh600050.zst";
		// ReadFromFile.readFileByBytes_zst(fileName);
		// String fileName = "C:\\stock\\shex.tnf";
		// ReadFromFile.readFileByBytes_tnf(fileName);
		// String fileName = "C:\\stock\\sz.tfz";
		// String fileName = "C:\\stock\\sh.tfz";
		// String fileName = "C:\\stock\\sh600050.lc5";
		// String fileName = "C:\\stock\\sh600015.lc5";

		// ReadFromFile.readFileByBytes_lc5(fileName);
		String fileName = "C:\\stock\\line.dat";
		ReadFromFile.readFileByBytes_linedat(fileName);
		// ReadFromFile.readFileByBytes_origional_tfz(fileName);
		// ReadFromFile.readFileByBytes_Trying_tfz(fileName);
		// ReadFromFile.readFileByChars(fileName);
		// ReadFromFile.readFileByLines(fileName);
		// ReadFromFile.readFileByRandomAccess(fileName);
	}
}

// 5、将内容追加到文件尾部
// public class AppendToFile {
// /**
// * A方法追加文件：使用RandomAccessFile
// */
// public static void appendMethodA(String fileName, String content) {
// try {
// // 打开一个随机访问文件流，按读写方式
// RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
// // 文件长度，字节数
// long fileLength = randomFile.length();
// //将写文件指针移到文件尾。
// randomFile.seek(fileLength);
// randomFile.writeBytes(content);
// randomFile.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// /**
// * B方法追加文件：使用FileWriter
// */
// public static void appendMethodB(String fileName, String content) {
// try {
// //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
// FileWriter writer = new FileWriter(fileName, true);
// writer.write(content);
// writer.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// public static void main(String[] args) {
// String fileName = "C:/temp/newTemp.txt";
// String content = "new append!";
// //按方法A追加文件
// AppendToFile.appendMethodA(fileName, content);
// AppendToFile.appendMethodA(fileName, "append end. \n");
// //显示文件内容
// ReadFromFile.readFileByLines(fileName);
// //按方法B追加文件
// AppendToFile.appendMethodB(fileName, content);
// AppendToFile.appendMethodB(fileName, "append end. \n");
// //显示文件内容
// ReadFromFile.readFileByLines(fileName);
// }
// }
