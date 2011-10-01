package com.stock.trendline;

import com.stock.trendline.TrendStyle.Direct;

/**
 * 一个转折对应的若干波段segmengtList
 * 也就是一个趋势对应的若干波段
 * @author jcf
 *
 */
public class TrendSegment {
	
	//这个趋势的开始波段号
	private int endId;
	//这个趋势结束的波段号
	private int startId;
	//这个趋势的类型
	private TrendStyle.Direct style;
	
	public TrendSegment(){}
	
	public TrendSegment( int startId,int endId, Direct style) {
		this.endId = endId;
		this.startId = startId;
		this.style = style;
	}



	public int getEndId() {
		return endId;
	}
	public void setEndId(int endId) {
		this.endId = endId;
	}
	public int getStartId() {
		return startId;
	}
	public void setStartId(int startId) {
		this.startId = startId;
	}

	public TrendStyle.Direct getStyle() {
		return style;
	}
	public void setStyle(TrendStyle.Direct style) {
		this.style = style;
	}
	public int getLength(){
		return endId-startId;
	}
	
	@Override
	public String toString() {
		return "TrendSegment [endId=" + endId + ", startId=" + startId
				+ ", style=" + style.getName() + "]";
	}
	
}
