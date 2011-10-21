package com.stock.trendline;

/**
 * 趋势线
 * 
 * @author jcf
 * 
 */
public class TrendLine {

	//基点实际值
	private PivotalCandleStick cdlStickFirst;
	private PivotalCandleStick cdlStickSecond;
	//根据period生成的通达信上显示的[日期]
	private PivotalCandleStick cdlStickPeriodFirst;
	private PivotalCandleStick cdlStickPeriodSecond;
	//基点所在的蜡烛
	private PeriodCandleStick cdlPeriodFirst;
	private PeriodCandleStick cdlPeriodSecond;
	//TrendSegment
	private TrendSegment trendSegment;
	
	private double Slope;
	private TrendStyle.Direct trendStyle;
	private TrendStyle.Color color;
	private PivotalCandleStick breakCdlStick;
	private PivotalCandleStick turnCdlStick;
	private boolean visable;
	private TrendStyle.Period period;
	//拟合的直线信息 y = b*x+a
	private double b; //斜率
	private PivotalCandleStick startVirtualCandle;

	public PivotalCandleStick getCdlStickFirst() {
		return cdlStickFirst;
	}

	public PivotalCandleStick getCdlStickSecond() {
		return cdlStickSecond;
	}

	public void setCdlStickFirst(PivotalCandleStick cdlStickFirst) {
		this.cdlStickFirst = cdlStickFirst;
	}

	public void setCdlStickSecond(PivotalCandleStick cdlStickSecond) {
		this.cdlStickSecond = cdlStickSecond;
	}

	public double getSlope() {
		return Slope;
	}

	public void setSlope(double slope) {
		Slope = slope;
	}

	public TrendStyle.Direct getTrendStyle() {
		return trendStyle;
	}

	public void setTrendStyle(TrendStyle.Direct trendStyle) {
		this.trendStyle = trendStyle;
	}

	public TrendStyle.Color getColor() {
		return color;
	}

	public void setColor(TrendStyle.Color color) {
		this.color = color;
	}

	public PivotalCandleStick getBreakCdlStick() {
		return breakCdlStick;
	}

	public void setBreakCdlStick(PivotalCandleStick breakCdlStick) {
		this.breakCdlStick = breakCdlStick;
	}

	public PivotalCandleStick getTurnCdlStick() {
		return turnCdlStick;
	}

	public void setTurnCdlStick(PivotalCandleStick turnCdlStick) {
		this.turnCdlStick = turnCdlStick;
	}

	public boolean isVisable() {
		return visable;
	}

	public void setVisable(boolean visable) {
		this.visable = visable;
	}

	public TrendStyle.Period getPeriod() {
		return period;
	}

	public void setPeriod(TrendStyle.Period period) {
		this.period = period;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public PivotalCandleStick getStartVirtualCandle() {
		return startVirtualCandle;
	}

	public void setStartVirtualCandle(PivotalCandleStick startVirtualCandle) {
		this.startVirtualCandle = startVirtualCandle;
	}
	
	public PivotalCandleStick getCdlStickPeriodFirst() {
		return cdlStickPeriodFirst;
	}

	public void setCdlStickPeriodFirst(PivotalCandleStick cdlStickPeriodFirst) {
		this.cdlStickPeriodFirst = cdlStickPeriodFirst;
	}

	public PivotalCandleStick getCdlStickPeriodSecond() {
		return cdlStickPeriodSecond;
	}

	public void setCdlStickPeriodSecond(PivotalCandleStick cdlStickPeriodSecond) {
		this.cdlStickPeriodSecond = cdlStickPeriodSecond;
	}
	
	public PeriodCandleStick getCdlPeriodFirst() {
		return cdlPeriodFirst;
	}

	public void setCdlPeriodFirst(PeriodCandleStick cdlPeriodFirst) {
		this.cdlPeriodFirst = cdlPeriodFirst;
	}

	public PeriodCandleStick getCdlPeriodSecond() {
		return cdlPeriodSecond;
	}

	public void setCdlPeriodSecond(PeriodCandleStick cdlPeriodSecond) {
		this.cdlPeriodSecond = cdlPeriodSecond;
	}
	
	public TrendSegment getTrendSegment() {
		return trendSegment;
	}

	public void setTrendSegment(TrendSegment trendSegment) {
		this.trendSegment = trendSegment;
	}

	//trendLine的跨度
	public int len(){
//		return cdlStickSecond.getCi()-cdlStickFirst.getCi();
		return cdlPeriodSecond.getId() - cdlPeriodFirst.getId();
	}

}
