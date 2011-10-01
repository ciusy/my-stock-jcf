package com.stock.trendline;

import java.util.Date;

/**
 * 蜡烛
 * @author
 *
 */
public class PivotalCandleStick {

	private int ci;
	private Date date;
	private double high;
	private double low;
	//add
	private double open;
	private double close;
	private int volumn;
	
	

	public PivotalCandleStick() {
	}

	public PivotalCandleStick(double h, double l, Date d, int ci) {
		this.high = h;
		this.low = l;
		this.date = d;
		this.ci = ci;
	}

	public int getCi() {
		return ci;
	}

	public Date getDate() {
		return date;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public void setLow(double low) {
		this.low = low;
	}
	
	

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PivotalCandleStick))
			return false;
		PivotalCandleStick p = (PivotalCandleStick)obj;
			return p.ci == this.ci 
					&& p.close == this.close 
					&& p.date == this.date 
					&& p.high == this.high && p.low == this.low && p.volumn == this.volumn && p.open == this.open
					; 
	}

	@Override
	public String toString() {
		return "PivotalCandleStick [ci=" + ci + ", close=" + close + ", date="
				+ DateUtil.dateToString(date) + ", high=" + high + ", low=" + low + ", open=" + open
				+ ", volumn=" + volumn + "]";
	}
	
}