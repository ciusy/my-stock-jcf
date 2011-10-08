package com.stock.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;

public class StockDBTemplate extends JdbcAbstractTemplate {

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

	/**
	 * 获取stock信息,前300个
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
			
		return (PivotalCandleStick[])pcslst.toArray(new PivotalCandleStick[0]);
		
	}
	
	/**
	 * 获取stock信息,前300个
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
	
	
}

