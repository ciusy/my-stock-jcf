package org.istock.bean;

import java.util.Map;

public class BaseBean {
	
	private Long softId;//软件ID
	private String softName;//软件名字
	private String color;//该软件在amchart报表中显示的颜色
	private Map<Integer, Integer> dataMap;//存放统计信息
	
	public Long getSoftId() {
		return softId;
	}
	public void setSoftId(Long softId) {
		this.softId = softId;
	}
	public String getSoftName() {
		return softName;
	}
	public void setSoftName(String softName) {
		this.softName = softName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Map<Integer, Integer> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<Integer, Integer> dataMap) {
		this.dataMap = dataMap;
	}
}
