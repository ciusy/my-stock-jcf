package com.stock.trendline;

public class Trend {
	
	private PivotalCandleStick cdlStickFirst;
	private PivotalCandleStick cdlStickSecond;
	
	//Trend通用
	private PeriodCandleStick periodFirst;
	private PeriodCandleStick periodSecond;
	
	private boolean up;

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setCdlStickFirst(PivotalCandleStick cStick) {
		this.cdlStickFirst = cStick;
	}

	public PivotalCandleStick getCdlStickFirst() {
		return cdlStickFirst;
	}

	public void setCdlStickSecond(PivotalCandleStick cStick) {
		this.cdlStickSecond = cStick;
	}

	public PivotalCandleStick getCdlStickSecond() {
		return cdlStickSecond;
	}

	public PeriodCandleStick getPeriodFirst() {
		return periodFirst;
	}

	public void setPeriodFirst(PeriodCandleStick periodFirst) {
		this.periodFirst = periodFirst;
	}

	public PeriodCandleStick getPeriodSecond() {
		return periodSecond;
	}

	public void setPeriodSecond(PeriodCandleStick periodSecond) {
		this.periodSecond = periodSecond;
	}

}
