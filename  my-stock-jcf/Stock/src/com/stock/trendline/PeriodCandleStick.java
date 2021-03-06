package com.stock.trendline;

import com.stock.trendline.TrendStyle.Period;

public class PeriodCandleStick {
	
	private int id;
	private PivotalCandleStick cdlStickHigh;
	private PivotalCandleStick cdlStickLow;
	private TrendStyle.Period period;
	private PivotalCandleStick cdlStickOpen;
	private PivotalCandleStick cdlStickClose;
	
	//根据period在通达信显示的 PivotalCandleStick
	private PivotalCandleStick cdlPeriodPoint;
	
	public PeriodCandleStick() {
	}
	
//	public PeriodCandleStick(int id, PivotalCandleStick cdlStickHigh,
//			PivotalCandleStick cdlStickLow, Period period,
//			PivotalCandleStick cdlStickOpen,PivotalCandleStick cdlStickClose) {
//		this.id = id;
//		this.cdlStickHigh = cdlStickHigh;
//		this.cdlStickLow = cdlStickLow;
//		this.period = period;
//		this.cdlStickClose = cdlStickClose;
//		this.cdlStickOpen = cdlStickOpen;
//	}
	
	public PeriodCandleStick(int id, PivotalCandleStick cdlStickHigh,
			PivotalCandleStick cdlStickLow, Period period,
			PivotalCandleStick cdlStickOpen, PivotalCandleStick cdlStickClose,
			PivotalCandleStick cdlPeriodPoint) {
		super();
		this.id = id;
		this.cdlStickHigh = cdlStickHigh;
		this.cdlStickLow = cdlStickLow;
		this.period = period;
		this.cdlStickOpen = cdlStickOpen;
		this.cdlStickClose = cdlStickClose;
		this.cdlPeriodPoint = cdlPeriodPoint;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PivotalCandleStick getCdlStickHigh() {
		return cdlStickHigh;
	}
	public void setCdlStickHigh(PivotalCandleStick cdlStickHigh) {
		this.cdlStickHigh = cdlStickHigh;
	}
	public PivotalCandleStick getCdlStickLow() {
		return cdlStickLow;
	}
	public void setCdlStickLow(PivotalCandleStick cdlStickLow) {
		this.cdlStickLow = cdlStickLow;
	}
	public TrendStyle.Period getPeriod() {
		return period;
	}
	public void setPeriod(TrendStyle.Period period) {
		this.period = period;
	}
	public PivotalCandleStick getCdlStickOpen() {
		return cdlStickOpen;
	}
	public void setCdlStickOpen(PivotalCandleStick cdlStickOpen) {
		this.cdlStickOpen = cdlStickOpen;
	}
	public PivotalCandleStick getCdlStickClose() {
		return cdlStickClose;
	}
	public void setCdlStickClose(PivotalCandleStick cdlStickClose) {
		this.cdlStickClose = cdlStickClose;
	}
	public PivotalCandleStick getCdlPeriodPoint() {
		return cdlPeriodPoint;
	}
	public void setCdlPeriodPoint(PivotalCandleStick cdlPeriodPoint) {
		this.cdlPeriodPoint = cdlPeriodPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PeriodCandleStick))
			return false;
		PeriodCandleStick p = (PeriodCandleStick)obj;
			return p.cdlStickClose.equals(cdlStickClose) && p.cdlStickHigh.equals(cdlStickHigh)
			       && p.cdlStickLow.equals(cdlStickLow) && p.cdlStickOpen.equals(cdlStickOpen)
			       && p.id == id && p.period == period && p.cdlPeriodPoint.equals(cdlPeriodPoint);
	}

	@Override
	public String toString() {
		return "PeriodCandleStick [cdlPeriodPoint="+DateUtil.dateToStringWithTime(cdlPeriodPoint.getDate())+"],cdlStickHigh=" + DateUtil.dateToStringWithTime(cdlStickHigh.getDate())
				+ "["+cdlStickHigh.getCi()+"], cdlStickLow=" + DateUtil.dateToStringWithTime(cdlStickLow.getDate()) 
				+ "["+cdlStickLow.getCi()+"], id=" + id + ", period="
				+ period + "]";
	}
	
}
