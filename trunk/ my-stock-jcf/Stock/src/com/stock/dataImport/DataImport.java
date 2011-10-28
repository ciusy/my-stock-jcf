package com.stock.dataImport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.stock.db.StockDBTemplate;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class DataImport {

	/**
	 * 从txt中读取有效的pivotalCandleStick保存到list中
	 * txt中文件格式为 日期MM/dd/yyyy 分隔符\t .....
	 * 按日期从小到大排列
	 * @param fname
	 * @return
	 */
	private List<PivotalCandleStick> readPivotalCandleStickFromTxt(String fname) {
		
		//日期有效性验证，无时间格式 MM/dd/yyyy
		Pattern datePattern1 = Pattern.compile("^\\d{1,2}(\\-|\\/|\\.)\\d{1,2}\\1\\d{4}$");
		//日期有效性验证，无时间格式 yyyy-MM-dd
		Pattern datePattern2 = Pattern.compile("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$"); 
		
		List<PivotalCandleStick> pcslist = new ArrayList<PivotalCandleStick>();
		String line = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fname)));
			while ((line = reader.readLine()) != null && line.trim() != "") {
				String[] result = line.split("\t");
				if (result.length == 7 && validate(result)) {
					PivotalCandleStick pcs = new PivotalCandleStick();
					if(datePattern1.matcher(result[0]).matches())
						pcs.setDate(DateUtil.stringToDateTime(DateUtil.stringToString(result[0], "MM/dd/yyyy", "yyyy-MM-dd")));
					else if(datePattern2.matcher(result[0]).matches())
						pcs.setDate(DateUtil.stringToDateTime(result[0]));
					pcs.setOpen(Double.valueOf(result[1]));
					pcs.setHigh(Double.valueOf(result[2]));
					pcs.setLow(Double.valueOf(result[3]));
					pcs.setClose(Double.valueOf(result[4]));
					pcs.setVolumn(Integer.valueOf(result[5]));
					pcslist.add(pcs);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return StockDBTemplate.filterErrorData(pcslist,fname);
	}

	/**
	 * 导入数据，从后往前导入，假如存在则终止
	 * @param strPath 源路径
	 * @return
	 */
	public void importPivotalCandleStick(String strPath) {
		
		File path = new File(strPath);
		if (path.exists() && path.isDirectory()) {
			try {
				String[] fname = path.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						if (name != null && name.toLowerCase().endsWith(".txt"))
							return true;
						else
							return false;
					}
				});
				for (int i = 0; i < fname.length; i++) {
					StockDBTemplate template = new StockDBTemplate();
					System.out.println(fname[i]+" "+readPivotalCandleStickFromTxt(strPath + "\\" + fname[i]).size());
					//获取有效的stock信息
					List<PivotalCandleStick> pcslist = readPivotalCandleStickFromTxt(strPath + "\\" + fname[i]);
					
					//获取文件名即表名和股票代码
					String stockId = fname[i].substring(0,fname[i].lastIndexOf("."));
					
					//导入数据
					if(pcslist != null && pcslist.size()>0){
						
						//判断数据表是否存在，不存在则创建
						template.createTable(stockCreateSql(stockId));
						
						//倒序导入,如果数据库中存在此条记录,则终止导入
						for(int j=pcslist.size()-1;j>=0;j--){
							
							PivotalCandleStick pcs = pcslist.get(j);
							
							if(template.getStock(stockId, "date = ?", new Object[]{new java.sql.Date(DateUtil.stringToDateTime(DateUtil.dateToStringWithTime(pcs.getDate())).getTime())}).length<=0)
								template.saveStock(stockId, pcs);
							else break;
								
						}
						
					}
					
					template.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 导入数据，全部比较和导入
	 * @param strPath 源路径
	 * @param overwrite 是否重写覆盖数据库原有的相同日期的数据
	 * @param check 在导入的时候是否检验数据库中是否存在该条数据，false时可能会有冗余数据
	 * @return
	 */
	public void importPivotalCandleStickFullCheck(String strPath,boolean overwrite,boolean check) {
		
		
		File path = new File(strPath);
		if (path.exists() && path.isDirectory()) {
			try {
				String[] fname = path.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						if (name != null && name.toLowerCase().endsWith(".txt"))
							return true;
						else
							return false;
					}
				});
				for (int i = 0; i < fname.length; i++) {
					StockDBTemplate template = new StockDBTemplate();
					System.out.println(fname[i]+" "+readPivotalCandleStickFromTxt(strPath + "\\" + fname[i]).size());
					//获取有效的stock信息
					List<PivotalCandleStick> pcslist = readPivotalCandleStickFromTxt(strPath + "\\" + fname[i]);
					//获取文件名即表名和股票代码
					String stockId = fname[i].substring(0,fname[i].lastIndexOf("."));
					
					//导入数据
					if(pcslist != null && pcslist.size()>0){
						
						//判断数据表是否存在，不存在则创建
						template.createTable(stockCreateSql(stockId));
						
						for(PivotalCandleStick pcs : pcslist){
							if(check){//检验
								if(template.getStock(stockId, "date = ?", new Object[]{new java.sql.Date(DateUtil.stringToDateTime(DateUtil.dateToStringWithTime(pcs.getDate())).getTime())}).length<=0)
									template.saveStock(stockId, pcs);
								else if(overwrite){
									template.deleteStock(stockId, pcs);
									template.saveStock(stockId, pcs);
								}
							}else{//不检验
								template.saveStock(stockId, pcs);
							}
								
						}
						
					}
					
					template.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void deleteErrorData(String stockId){
		StockDBTemplate template = new StockDBTemplate();
		template.deleteErrorData(stockId);
		template.close();
	}

	public boolean validate(String[] result) {
		//日期有效性验证，无时间格式 MM/dd/yyyy
		Pattern datePattern1 = Pattern.compile("^\\d{1,2}(\\-|\\/|\\.)\\d{1,2}\\1\\d{4}$");
		//日期有效性验证，无时间格式 yyyy-MM-dd
		Pattern datePattern2 = Pattern.compile("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$"); 
		if(!datePattern1.matcher(result[0]).matches() && !datePattern2.matcher(result[0]).matches()) return false;
		// 验证价格Double的有效性
		Pattern doublePattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
		for (int i = 1; i < result.length; i++) {
			if (!doublePattern.matcher(result[i]).matches())
				return false;
		}
		return true;
	}
	
	public String stockCreateSql(String stockId){
		return "CREATE TABLE if not EXISTS t_"+stockId+"("+
				  "id bigint(20) NOT NULL AUTO_INCREMENT,"+
				  "date datetime NOT NULL,"+
				  "open double(15,3) DEFAULT NULL,"+
				  "high double(15,3) DEFAULT NULL,"+
				  "low double(15,3) DEFAULT NULL,"+
				  "close double(15,3) DEFAULT NULL,"+
				  "volumn bigint(20) DEFAULT NULL,"+
				  "other double(15,3) DEFAULT NULL,"+
				  "PRIMARY KEY (id)"+
				") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gb2312";
	}

}