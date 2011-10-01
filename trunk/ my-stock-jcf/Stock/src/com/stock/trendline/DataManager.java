package com.stock.trendline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.stock.db.StockDBTemplate;

public class DataManager {

	File file = new File("c:\\stock\\600416.csv");

	// 从cvs数据文件中获取数据，需要Formulas类的支持
	public String[][] convertToArray() {

		List<String[]> arrayList = new ArrayList<String[]>();
		boolean bTag = false;// 用于筛选掉错误数据或者是数据<=0 的时候的数据

		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while (!bTag && (line = reader.readLine()) != null) {
				StringTokenizer z = new StringTokenizer(line, ",");
				while (z.hasMoreTokens()) {

					String[] temp = new String[6];
					for (int c = 0; c < 6; c++) {
						String value = z.nextToken();
						if (c > 0 && c < 5 && new Double(value) <= 0) {
							bTag = true;
						}
						temp[c] = value;
					}
					arrayList.add(temp);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String[][] items = new String[arrayList.size()][6];

		for (int i = 0; i < arrayList.size(); i++) {
			items[i] = arrayList.get(i);
		}

		return items;

	}

	// 直接从数据库中获得数据
	public PivotalCandleStick[] getPivotalCandleStick(String stockId,
			String whereSql, Object[] params) {
		StockDBTemplate template = new StockDBTemplate();
		return template.getLimitStock(stockId, whereSql, params);
	}
	
	public PivotalCandleStick[] getExpPivotalCandleStick(String stockId,
			String whereSql, Object[] params) {
		StockDBTemplate template = new StockDBTemplate();
		return toExpArray(template.getLimitStock(stockId, whereSql, params));

	}

	//转换为对数
	public PivotalCandleStick[] toExpArray(PivotalCandleStick[] pcsArray) {
		for (int i = 0; i < pcsArray.length; i++) {
			pcsArray[i].setOpen(java.lang.Math.log(pcsArray[i].getOpen()));
			pcsArray[i].setHigh(java.lang.Math.log(pcsArray[i].getHigh()));
			pcsArray[i].setLow(java.lang.Math.log(pcsArray[i].getLow()));
			pcsArray[i].setClose(java.lang.Math.log(pcsArray[i].getClose()));
		}
		return pcsArray;
	}

	// print out item of array
	public void printArray() {
		String[][] items = convertToArray();
		for (int x = 0; x < items.length; x++) {
			System.out.printf("%s - ", x);
			for (int y = 0; y < items[x].length; y++) {
				System.out.printf("%s ", items[x][y]);
			}
			System.out.println();
		}
	}

	// return array items
	public String[][] getArray() {
		return convertToArray();
	}
}