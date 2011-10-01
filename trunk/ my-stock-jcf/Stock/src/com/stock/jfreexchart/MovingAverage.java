//St=a*Yt+(1-a)*S(t-1).

package com.stock.jfreexchart;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private final Queue<Double> window = new LinkedList<Double>();
	private final int period;
	private double sum = 0.0;
	private int count = 0;


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MovingAverage(int period) {
		assert period > 0 : "Period must be a positive integer";
		this.period = period;
	}

	public void newNum(double num) {
		count++;
		sum += num;
		window.add(num);
		if (window.size() > period) {
			sum -= window.remove();
		}
	}

	public double getAvg() {
		if (window.isEmpty() || (count < period))
			return -1; // technically the average is undefined
		return sum / window.size();
	}

	
	//W＝2÷（12+1）＝0.1538 
	//EMA(12)＝(收盘价－昨日的EMA)×0.1538＋昨日的EMA
	
	// **St=a*Yt+(1-a)*S(t-1).
	// 当t=1,s0不知道。当t=2,s2设置为y1

	// ema 算法1，假定求n天的ema。 第一个值就是序列中第一个值a1，第二个值就是第二个值c*a2+(1-c)*a1，第三个是
	// c*a3+(1-c)*a2, 如果数列不到n不给有效值
	public double getExpNum(double num) {
		count++;
		if (count == 1) {
			sum += num;
		} else {
			sum = 2 / (1.0 + period) * num + (1.0 - (2 / (1.0 + period))) * sum;
		}
		// window.add(num);
		// if (window.size() > period) {
		// sum -= window.remove();
		// }
		if (count < period)
			return -1;
		return sum;
	}

	public double getRSIExpNum(double num) {
		count++;
		if (count == 1) {
			sum += num;
		} else {
			sum = 2 / (1.0 + period) * num + (1.0 - (2 / (1.0 + period))) * sum;
		}
		// window.add(num);
		// if (window.size() > period) {
		// sum -= window.remove();
		// }
		if (count < period)
			return -1;
		return sum;
	}
	
	static public double[] calculate(double[] data, int days)
	{
		if (data == null) return null;
		if (days > data.length) days = data.length;
		double[] r = new double[data.length];
		for (int i = days - 1; i < data.length; i++) {
			double total = 0.0F;
			for (int j = 0; j < days; j++) {
				total += data[i - j];
			}
			r[i] = total / (double)days;
		}
		return r;
	}
	public static void main(String[] args) {
		double[] testData = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
		// int[] windowSizes = {3,5};
		int[] windowSizes = { 5 };
		for (int windSize : windowSizes) {
			MovingAverage ma = new MovingAverage(windSize);
			for (double x : testData) {
				// ma.newNum(x);
				// System.out.println("Next number = " + x + ", SMA = " +
				// ma.getAvg());
				System.out.println("Next number = " + x + ", eMA = "
						+ ma.getExpNum(x));
			}
			System.out.println();
		}
	}
}