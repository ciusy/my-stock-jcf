package org.istock.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.istock.bean.BaseBean;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("reportAction")
public class ReportAction extends ActionSupport {

	private List<BaseBean> daylist; 
	
	public String showDay() throws Exception {
		Logger logger = Logger.getLogger(ReportAction.class);
		daylist = new ArrayList<BaseBean>();
		/*================数据模拟==================*/
		daylist.add(createBean(1L,"软件A","#FF0000"));
		daylist.add(createBean(2L,"软件B","#FFC0CB"));
		daylist.add(createBean(3L,"软件C","#40E0D0"));
		daylist.add(createBean(4L,"软件D","#9ACD32"));
		daylist.add(createBean(5L,"软件E","#00FF7F"));
		/*=========================================*/
		ActionContext.getContext().getSession().put("chartDataList", daylist);
		System.out.println("-----------in showday(------------");
		logger.debug("-----------in showday(------------");
		return "show-suc";
	}

	/**
	 * 创建模拟数据
	 * @author Christy Lan
	 * @version 1.0
	 * @param 
	 * @return BaseBean
	 * @exception
	 */
	private BaseBean createBean(Long id, String softName, String color){
		BaseBean bean = new BaseBean();
		bean.setSoftId(id);
		bean.setSoftName(softName);
		bean.setColor(color);
		Map<Integer, Integer> dataMap = new TreeMap<Integer, Integer>();
		//一天24小时
		for(int i = 1; i <= 24; i++){
			dataMap.put(i, getRandom());//模拟每小时的下载量
		}
		bean.setDataMap(dataMap);
		return bean;
		
	}
	
	private Integer getRandom(){
		return (int)(Math.random()*1000);
	}

	public List<BaseBean> getDaylist() {
		return daylist;
	}

	public void setDaylist(List<BaseBean> daylist) {
		this.daylist = daylist;
	}
	
}
