package com.stock.trendline;

import java.util.Date;

public class Formulas {
	
	DataManager r = new DataManager();
	int totalRec = r.convertToArray().length;
	double[][] dataArray = new double[totalRec][7];
	double[][] dataExpArray = new double[totalRec][7];
	double[] openArray = new double[totalRec];
	double[] highArray = new double[totalRec];
	double[] lowArray = new double[totalRec];
	double[] closeArray = new double[totalRec];
	Date[] dateArray = new Date[totalRec];
	// 定义3个整数数组，用来放年月日的整数值，如2010-3-8 变成年2010，月3 日8；
	int[] dayNum = new int[totalRec];
	int[] monthNum = new int[totalRec];
	int[] yearNum = new int[totalRec];
	// volumeData 保存每日成交量数据
	double[] volumeData = new double[totalRec];

	// 提取日期信息到数组
	public void createDateArray(String[][] n) {

		for (int x = 0; x < n.length; x++) {

			Date newDate = null;
			newDate = DateUtil.stringToDateTime(n[x][0]);
			dateArray[x] = newDate;

		}

	}

	// create a double array
	public void createDataArray(String[][] n) {
		for (int x = 0; x < n.length; x++) {

			for (int y = 0; y < n[x].length; y++) {
				switch (y) {
				case 0: {
					// 日期格式为2010-11-19
					dataArray[x][y] = 0;
					String strDate = DateUtil.stringToString(n[x][0], "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
					yearNum[x] = Integer.valueOf((strDate.substring(0, 4)))
							.intValue();
					monthNum[x] = Integer.valueOf((strDate.substring(5, 7)))
							.intValue();
					dayNum[x] = Integer.valueOf((strDate.substring(8, 10)))
							.intValue();
					break;
				}

				case 1:
					dataArray[x][y] = new Double(n[x][y]);// open
					openArray[x] = dataArray[x][y];
					break;
				case 2:
					dataArray[x][y] = new Double(n[x][y]);// high
					highArray[x] = dataArray[x][y];
					break;
				case 3:
					dataArray[x][y] = new Double(n[x][y]);// low
					lowArray[x] = dataArray[x][y];
					break;
				case 4:
					dataArray[x][y] = new Double(n[x][y]);// close
					closeArray[x] = dataArray[x][y];
					break;
				case 5:
					dataArray[x][y] = new Double(n[x][y]);// volume
					volumeData[x] = dataArray[x][y];
					break;
				case 6:
					dataArray[x][y] = new Double(n[x][y]);// adj close
					break;

				}

			}
		}

	}
	
	public void createExpArray(){
		dataExpArray = toExpArray(dataArray);
	}

	//转换为对数坐标的对数值
	public double[][] toExpArray(double[][] originArray){
		double [][] expArray=new double[totalRec][7];
		for(int i =0;i<totalRec;i++){
			for(int j=1;j<5;j++){
				expArray[i][j]=(java.lang.Math.log(originArray[i][j]));
				
			}
			
		}
		return  expArray;	
		}
	
	
	public double[] toExpArray(double[] originArray){
		double[] expArray = new double[originArray.length];
		for(int i=0;i<originArray.length;i++){
			expArray[i] = 10 * (java.lang.Math.log(originArray[i]));
		}
		return expArray;
	}

	// print data array
	public void printArray(double[][] dataArray1) {
		for (int x = 0; x < dataArray1.length; x++) {
			for (int y = 0; y < dataArray1[x].length; y++) {
				System.out.printf("%s \t", dataArray1[x][y]);
			}
			System.out.println();
		}
	}
}
