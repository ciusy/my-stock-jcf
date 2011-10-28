package com.stock.test;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.stock.accessFile.ReadFromFile;
import com.stock.db.StockDBTemplate;
import com.stock.trendline.DateUtil;
import com.stock.trendline.TrendLineManager;
import com.stock.trendline.TrendStyle;

public class TrendLineManagerTest {
	
	//主测试用例,调用方法
	@Test
	public void testTrendLine(){
		trendLineScan(TrendStyle.Period.days,"C:\\jcb_zxjt\\T0002\\");
//		trendLineScan(TrendStyle.Period.week,"C:\\jcb_zxjt\\T0002\\");
	}
	
	
	/**分离出来提供调用的类**/
	/**
	 * @param period 趋势线类型
	 * @param linepath 通达信T0002路径
	 */
	public void trendLineScan(TrendStyle.Period period,String linepath){
		
		int linePeriod = 0;
		
		//从数据库中读取数据扫描
		StockDBTemplate template = new StockDBTemplate();
		String whereSql = "";//"table_name = ?";//数据库查询条件 如: date = ? and date = ?
		Object[] params = null;//new Object[]{"t_sz300081"};//查询条件的参数
		List<String> tbls = template.getStockTableName(whereSql,params);
		
		/*******************需要修改的地方为这两行 *******************/
//		TrendStyle.Period period = TrendStyle.Period.week;//周线 //TrendStyle.Period.days;//日线
		if(period == TrendStyle.Period.week)
			linePeriod = 5;//周线//4; //line.dat里面日线的代码是4
		else
		if(period == TrendStyle.Period.days)
			linePeriod = 4;
		/***********************************************************/
		
		//保存line.dat 路径
		//this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().length()-4)+"/out/"
//		String linepath = "C:\\jcb_zxjt\\T0002\\";
//		ReadFromFile.renameFile(linepath+"line.dat");//备份旧文件
		//保存自选股ZXG.blk 路径
		String zxgpath = linepath+"blocknew\\";
//		ReadFromFile.renameFile(zxgpath+"ZXG.blk");
		//保存xml路径
		String xmlpath = this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().length()-4)+"out/";
		
		for(int i=0;i<tbls.size();i++){
			
			//趋势线管理类
			TrendLineManager tlm = new TrendLineManager();
			
			//获取股票代码
			String stockId = tbls.get(i).substring(tbls.get(i).indexOf("_")+1); //sh600416
			if(stockId.length() != 8) continue; //忽略不符合条件的股票 数据
			
			//准备line.dat参数
			String stockCode = stockId.substring(2); // 600416
			int market = stockId.substring(0,2).endsWith("sh") ? 1 : 0;
			
			boolean lineState = false;//趋势线的性质是否良好
			System.out.println("["+stockId+"]...");
			//生成趋势线
			tlm.getTrendLines(period,stockId,template);
			
//			for(TrendLine tl : tlm.getTrendLineList()){
//				System.out.println(TrendLineManager.slopeEffective(tl.getSlope())+""+tl.getSlope()+" "+tl.isVisable()+"*"+DateUtil.dateToString(tl.getCdlStickPeriodFirst().getDate())+"-->"+DateUtil.dateToString(tl.getCdlStickPeriodSecond().getDate()));
//			}
			
			//获取最后几条有效趋势线
			int linecount = 1; //考虑的趋势线为最后一条，可修改
			for(int j=tlm.getTrendLineList().size()-linecount;j<tlm.getTrendLineList().size()&&j>0;j++){
				//趋势线性质良好时
				if(tlm.getTrendLineList().get(j).isVisable() && tlm.getTrendLineList().get(j).len()>=2){
					String zxgname = "ZXG";
					lineState = true;
					//写line.dat到指定的路径
					ReadFromFile.writeLinedat(linepath+DateUtil.dateToString(new Date(), "yyyyMMdd")+"line.dat",
							market,linePeriod,stockCode,
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickPeriodFirst().getDate(),"yyyyMMdd"))),
							tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
									(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getLow():
										(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getHigh(),
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickPeriodSecond().getDate(),"yyyyMMdd"))),
							tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
									(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getLow():
										(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getHigh()
							);
					//保存趋势线信息到xml
					tlm.toXml(tlm.getTrendLineList().get(j),xmlpath+"trend_lines.xml");
					if(period == TrendStyle.Period.days){
						if(tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise)
							zxgname = "uptd";
						else if(tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Fall)
							zxgname = "dntd";
					}else if(period == TrendStyle.Period.week){
						if(tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise)
							zxgname = "uptw";
						else if(tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Fall)
							zxgname = "dntw";
					}
					ReadFromFile.writeZXGblk(zxgpath+zxgname+".blk",market+stockCode);
				}
			}
			
			//保存ZXG.blk
//			if(lineState){
//				ReadFromFile.writeZXGblk(zxgpath+"ZXG.blk",market+stockCode);
//			}
			
		}
		
		template.close();
	}
	
	//---------------------------------测试用例分割线-----------------------------------------------
	@Test
	public void testTrendLineScan(){
		
		//从数据库中读取数据扫描
		StockDBTemplate template = new StockDBTemplate();
		String whereSql = "";//数据库查询条件 如: date = ? and date = ?
		Object[] params = null;//new Object[]{"t_sz300133"};//查询条件的参数
		List<String> tbls = template.getStockTableName(whereSql,params);
		
		/*******************需要修改的地方为这两行 *******************/
		TrendStyle.Period period = TrendStyle.Period.week;//周线 //TrendStyle.Period.days;//日线
		int linePeriod = 5;//周线//4; //line.dat里面日线的代码是4
		/**********************************************************/
		
		//保存line.dat 路径
		//this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().length()-4)+"/out/"
		String linepath = "C:\\jcb_zxjt\\T0002\\";
		ReadFromFile.renameFile(linepath+"line.dat");//备份旧文件
		//保存自选股ZXG.blk 路径
		String zxgpath = "C:\\jcb_zxjt\\T0002\\blocknew\\";
		ReadFromFile.renameFile(zxgpath+"ZXG.blk");
		//保存xml路径
		String xmlpath = this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().length()-4)+"out/";
		
		for(int i=0;i<tbls.size();i++){
			
			//趋势线管理类
			TrendLineManager tlm = new TrendLineManager();
			
			//获取股票代码
			String stockId = tbls.get(i).substring(tbls.get(i).indexOf("_")+1); //sh600416
			if(stockId.length() != 8) continue; //忽略不符合条件的股票 数据
			
			//准备line.dat参数
			String stockCode = stockId.substring(2); // 600416
			int market = stockId.substring(0,2).endsWith("sh") ? 1 : 0;
			
			boolean lineState = false;//趋势线的性质是否良好
			System.out.println("["+stockId+"]...");
			//生成趋势线
			tlm.getTrendLines(period,stockId,template);
			
			//获取最后几条有效趋势线
			int linecount = 1; //考虑的趋势线为最后一条，可修改
			for(int j=tlm.getTrendLineList().size()-linecount;j<tlm.getTrendLineList().size()&&j>0;j++){
				//趋势线性质良好时
				if(tlm.getTrendLineList().get(j).isVisable()){
					lineState = true;
					//写line.dat到指定的路径
					ReadFromFile.writeLinedat(linepath+"line.dat",
							market,linePeriod,stockCode,
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickPeriodFirst().getDate(),"yyyyMMdd"))),
							tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
									(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getLow():
										(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getHigh(),
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickPeriodSecond().getDate(),"yyyyMMdd"))),
							tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
									(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getLow():
										(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getHigh()
							);
					//保存趋势线信息到xml
					tlm.toXml(tlm.getTrendLineList().get(j),xmlpath+"trend_lines.xml");
				}
			}
			
			//保存ZXG.blk
			if(lineState){
				ReadFromFile.writeZXGblk(zxgpath+"ZXG.blk",market+stockCode);
			}
			
		}
		
		template.close();
	}
	
}
