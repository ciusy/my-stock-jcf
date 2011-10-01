package com.stock.trendline;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class TrendLineXML {

	SAXBuilder sb = new SAXBuilder();
	XMLOutputter out = new XMLOutputter();

	//写入到Trend_lines.xml中，得有模板文件
	public void createTrendLineXML(TrendLine tl,String fileName){
		try {
			File file = new File(fileName);
			if(!file.exists()) file.createNewFile();
			Document doc = sb.build(fileName);
			doc.removeContent();
			Element trendLines = new Element("trend_lines");
			doc.addContent(trendLines);
			
			Element root = doc.getRootElement();
			
			String value0 = "";
			String value1 = "";
			Element trendLine = new Element("trend_line");
			trendLine.addContent(new Element("date0").setText(DateUtil.dateToStringWithTime(tl.getCdlStickFirst().getDate())));
			trendLine.addContent(new Element("date1").setText(DateUtil.dateToStringWithTime(tl.getCdlStickSecond().getDate())));
			value0 = tl.getTrendStyle() == TrendStyle.Direct.Rise ? Double.toString(tl.getCdlStickFirst().getLow()):Double.toString(tl.getCdlStickFirst().getHigh());
			trendLine.addContent(new Element("value0").setText(value0));
			value1 = tl.getTrendStyle() == TrendStyle.Direct.Rise ? Double.toString(tl.getCdlStickSecond().getLow()):Double.toString(tl.getCdlStickSecond().getHigh());
			trendLine.addContent(new Element("value1").setText(value1));
			trendLine.addContent(new Element("line_color").setText(Integer.toHexString(tl.getColor().getName().getRGB())));
			trendLine.addContent(new Element("line_alpha").setText(""));
			trendLine.addContent(new Element("line_width").setText(""));
			trendLine.addContent(new Element("dash_length").setText("5"));
			trendLine.addContent(new Element("axis").setText(""));
			trendLine.addContent(new Element("chart_id").setText("0"));
			trendLine.addContent(new Element("locked").setText("true"));
			root.addContent(trendLine);
			Format format = Format.getCompactFormat();
			format.setEncoding("UTF-8");
			format.setIndent("  ");
			
			XMLOutputter xml = new XMLOutputter(format);
			xml.output(doc, new FileOutputStream(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * xml中标注事件，“破”事件预警标识
	 */
	public void eventSettingsXML(List<TrendLine> trendLineList,String fileName){
		File file = new File(fileName);
			try {
				if(!file.exists())file.createNewFile();
				Document doc = sb.build(fileName);
				Element root = doc.getRootElement();
				Element data_set = root.getChild("data_sets").getChild("data_set");
				Element events = data_set.getChild("events");
				
				events.removeChildren("event");
				
				for(int i = 0 ;i<trendLineList.size();i++){
					TrendLine tl = trendLineList.get(i);
					String hint = "趋势线日期:"+DateUtil.dateToStringWithTime(tl.getCdlStickFirst().getDate())+"至"+DateUtil.dateToStringWithTime(tl.getCdlStickSecond().getDate())+
									"\n 颜色为:"+tl.getColor()+"  的"+tl.getTrendStyle().getName()+"线";
					if(tl.getBreakCdlStick() != null){
						Element event = new Element("event");
						event.addContent(new Element("date").setText(DateUtil.dateToStringWithTime(tl.getBreakCdlStick().getDate())));
						event.addContent(new Element("letter").setText(Integer.toString(i)));
						event.addContent(new Element("color").setText(Integer.toHexString(tl.getColor().getName().getRGB())));
						event.addContent(new Element("size").setText("15"));
						event.addContent(new Element("description").setText(hint));
						events.addContent(event);
					}
				}
				
				
				Format format = Format.getCompactFormat();
				format.setEncoding("UTF-8");
				format.setIndent("  ");
				
				XMLOutputter xml = new XMLOutputter(format);
				xml.output(doc, new FileOutputStream(fileName));
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JDOMException e) {
				e.printStackTrace();
			}
		
	}
	
	public void resetContent(String fileName){
		try {
			Document doc = sb.build(new FileInputStream(fileName));// 读入指定文件
			Element rootElement = doc.getRootElement(); // 获得根节点
			rootElement.removeContent();
			out.output(doc, new FileOutputStream(fileName)); // 输出到XML文件中
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
