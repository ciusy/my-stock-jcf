package com.stock.db;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class StockDBTemplate extends JdbcAbstractTemplate {
	
	//过滤最小的交易价格
	private static final double MIN_TRADE_PRICE = 0.16;

	/**
	 * 保存，导入
	 * @param stockId
	 * @param pcs
	 */
	public void saveStock(String stockId,PivotalCandleStick pcs) {
		String sql = "insert t_"+stockId+"(date,open,high,low,volumn,close) values (?,?,?,?,?,?)";
		Object[] params = {pcs.getDate(),pcs.getOpen(),pcs.getHigh(),pcs.getLow(),pcs.getVolumn(),pcs.getClose()};
		super.save(sql,params);
	}
	
	public void deleteStock(String stockId,PivotalCandleStick pcs){
		String sql = "delete from t_"+stockId+" where date = ?";
		Object[] params = {new java.sql.Date(DateUtil.stringToDateTime(DateUtil.dateToStringWithTime(pcs.getDate())).getTime())};
		delete(sql,params);
	}

	public void deleteStock(String stockId,String wheresql,Object[] params){
		String sql = "delete from t_"+stockId+wheresql;
		delete(sql,params);
	}
	
	/**
	 * 获取stock信息,前limit个
	 */
	public PivotalCandleStick[] getLimitStock(String stockId,String whereSql,Object[] params,int limit){
		
		//拼接sql语句
		String sql = "select DISTINCT date,high,low,open,close,volumn from " +
				"(select * from "+"t_"+stockId+" order by date desc limit "+limit+") as "+"t_"+stockId+
				(whereSql==null || "".equals(whereSql.trim())? " ": 
					" where "+ whereSql)+" order by date asc";
		
		List<PivotalCandleStick> pcslst = new ArrayList<PivotalCandleStick>();
		int index = 0;
		//获得结果集
		ResultSet rs = super.get(sql,params);
			try {
				while(rs.next()){
					PivotalCandleStick pcs = new PivotalCandleStick();
					pcs.setCi(index);
					pcs.setDate(new java.util.Date(rs.getDate("date").getTime()));
					pcs.setHigh(rs.getDouble("high"));
					pcs.setLow(rs.getDouble("low"));
					pcs.setOpen(rs.getDouble("open"));
					pcs.setClose(rs.getDouble("close"));
					pcs.setVolumn(rs.getInt("volumn"));
					
					pcslst.add(pcs);
					index ++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
		pcslst =filterErrorData(pcslst,stockId);	
			
		return (PivotalCandleStick[])pcslst.toArray(new PivotalCandleStick[0]);
		
	}
	
	/**
	 * 获取stock信息
	 */
	public PivotalCandleStick[] getStock(String stockId,String whereSql,Object[] params){
		
		//拼接sql语句
		String sql = "select DISTINCT date,high,low,open,close,volumn from "+"t_"+stockId+
				(whereSql==null || "".equals(whereSql.trim())? " ": 
					" where "+ whereSql)+" order by date asc";
		
		List<PivotalCandleStick> pcslst = new ArrayList<PivotalCandleStick>();
		int index = 0;
		//获得结果集
		ResultSet rs = super.get(sql,params);
			try {
				while(rs.next()){
					PivotalCandleStick pcs = new PivotalCandleStick();
					pcs.setCi(index);
					pcs.setDate(new java.util.Date(rs.getDate("date").getTime()));
					pcs.setHigh(rs.getDouble("high"));
					pcs.setLow(rs.getDouble("low"));
					pcs.setOpen(rs.getDouble("open"));
					pcs.setClose(rs.getDouble("close"));
					pcs.setVolumn(rs.getInt("volumn"));
					
					pcslst.add(pcs);
					index ++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
		return (PivotalCandleStick[])pcslst.toArray(new PivotalCandleStick[0]);
		
	}
	
	public List<String> getStockTableName(String whereSql,Object[] params){
		String sql = "Select table_name from INFORMATION_SCHEMA.TABLES Where table_schema = 'stock' AND table_name LIKE 't_%' "+
						(whereSql==null || "".equals(whereSql.trim())? " ": 
							" and "+ whereSql)+"";
		List<String> tablelst = new ArrayList<String>();
		//获得结果集
		ResultSet rs = super.get(sql,params);
			try {
				while(rs.next()){
					tablelst.add(rs.getString("table_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		return tablelst;
	}
	
	
	public void createTable(String sql){
		super.create(sql);
	}
	
	
	public static List<PivotalCandleStick> filterErrorData(List<PivotalCandleStick> pcslst,String stockId){
		String filePath = StockDBTemplate.class.getClass().getResource("/").getPath().substring(0, StockDBTemplate.class.getClass().getResource("/").getPath().length()-4)+"out/";
		List<PivotalCandleStick> newlst = null;
		for(int i=0;i<pcslst.size();i++){
			if(pcslst.get(i).getClose() <= MIN_TRADE_PRICE || pcslst.get(i).getHigh() <= MIN_TRADE_PRICE 
					|| pcslst.get(i).getLow() <= MIN_TRADE_PRICE || pcslst.get(i).getOpen() <= MIN_TRADE_PRICE){
				newlst = pcslst.subList(i+1, pcslst.size());
				PrintWriter pw;
				try {
					pw = new PrintWriter(new FileOutputStream(filePath+DateUtil.dateToString(new Date())+"error.TXT",true),true); //false 不追加
					pw.println("[ERROR STOCK_INFO]:"+stockId+" "+pcslst.get(i));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}   
			}
		}
		
		return newlst == null ? pcslst : newlst;
	}
	
	
	public void deleteErrorData(String stockId){
		PivotalCandleStick[] pcsArray = getStock(stockId, "", null);
		for(int i=0;i<pcsArray.length;i++){
			if(pcsArray[i].getClose() <= MIN_TRADE_PRICE || pcsArray[i].getHigh() <= MIN_TRADE_PRICE 
					|| pcsArray[i].getLow() <= MIN_TRADE_PRICE || pcsArray[i].getOpen() <= MIN_TRADE_PRICE){
				deleteStock(stockId," where date <= ?",new Object[]{new java.sql.Date(DateUtil.stringToDateTime(DateUtil.dateToStringWithTime(pcsArray[i].getDate())).getTime())});
			}
		}
	}
	
	
}

