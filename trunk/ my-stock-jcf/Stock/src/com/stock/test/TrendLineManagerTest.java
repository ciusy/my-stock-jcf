package com.stock.test;

import java.util.List;

import org.junit.Test;

import com.stock.accessFile.ReadFromFile;
import com.stock.db.StockDBTemplate;
import com.stock.trendline.DateUtil;
import com.stock.trendline.TrendLine;
import com.stock.trendline.TrendLineManager;
import com.stock.trendline.TrendStyle;

public class TrendLineManagerTest {
	
	//主测试用例
	@Test
	public void testTrendLineScan(){
		
		//从数据库中读取数据扫描
		StockDBTemplate template = new StockDBTemplate();
		String whereSql = "";//数据库查询条件 如: date = ? and date = ?
		Object[] params = null;//new Object[]{"t_sh600048","t_sh600039"};//查询条件的参数
		List<String> tbls = template.getStockTableName(whereSql,params);
		
		
		TrendStyle.Period period = TrendStyle.Period.days;//日线
		int linePeriod = 4; //line.dat里面日线的代码是4，其他的待修改
		
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
			tlm.getTrendLines(period,stockId);
			
			//获取最后几条有效趋势线
			int linecount = 1; //考虑的趋势线为最后一条，可修改
			for(int j=tlm.getTrendLineList().size()-linecount;j<tlm.getTrendLineList().size()&&j>0;j++){
				//趋势线性质良好时
				if(tlm.getTrendLineList().get(j).isVisable()){
					lineState = true;
					//写line.dat到指定的路径
					ReadFromFile.writeLinedat(linepath+"line.dat",
							market,linePeriod,stockCode,
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickFirst().getDate(),"yyyyMMdd"))),
							tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
									(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getLow():
										(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getHigh(),
							Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickSecond().getDate(),"yyyyMMdd"))),
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
		
		
	}
	
	@Test
	public void test3(){
		TrendLineManager tlm = new TrendLineManager();
		//sh600585/000401
		tlm.getTrendLines(TrendStyle.Period.days,"sh601318");
		for(TrendLine tl : tlm.getTrendLineList()){
			System.out.println(tl.getTrendStyle());
			System.out.println(tl.getCdlStickFirst().getCi()+"-->"+tl.getCdlStickSecond().getCi());
			System.out.println(DateUtil.dateToString(tl.getCdlStickFirst().getDate())+"-->"+DateUtil.dateToString(tl.getCdlStickSecond().getDate()));
			System.out.println("--B:"+tl.getB()+DateUtil.dateToString(tl.getStartVirtualCandle().getDate()));
			
		}
//		tlm.toXml("f:\\java\\amchart\\amstock\\examples\\candlestick_test\\trend_lines.xml");
	}
	
	
	@Test
	public void testWriteToLinedat(){
		
		String[] stocks = new String[1];
		stocks[0] = "sz002617";
//		stocks[1] = "sh601318";
//		stocks[2] = "sh600000";
//		stocks[3] = "sh601628";
//		stocks[4] = "sh600018";
//		stocks[5] = "sh600050";
		
		for(int i=0;i<stocks.length;i++){
			String stockId = stocks[i];
			int market ;
			String sStockId = stockId.substring(stockId.length()-6);
			String path = this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().length()-4)+"/out/";
			
			if(stockId.startsWith("sh")) market = 1;
			else market = 2;
			
			TrendLineManager tlm = new TrendLineManager();
			tlm.getTrendLines(TrendStyle.Period.days,stockId);
			
			for(int j=tlm.getTrendLineList().size()-1;j<tlm.getTrendLineList().size();j++){
				ReadFromFile.writeLinedat(path+"line.dat",
						1,4,sStockId,
						Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickFirst().getDate(),"yyyyMMdd"))),
						tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
								(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getLow():
									(float)tlm.getTrendLineList().get(j).getCdlStickFirst().getHigh(),
						Integer.parseInt((DateUtil.dateToString(tlm.getTrendLineList().get(j).getCdlStickSecond().getDate(),"yyyyMMdd"))),
						tlm.getTrendLineList().get(j).getTrendStyle() == TrendStyle.Direct.Rise ? 
								(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getLow():
									(float)tlm.getTrendLineList().get(j).getCdlStickSecond().getHigh()
						);
			}
			
		}
		
	}
	
	@Test
	public void testWriteZXGblk(){

	}
	
	//
	public void test(String stockId,TrendStyle.Period period){
		TrendLineManager tlm = new TrendLineManager();
		System.out.println("-----------------------------"+stockId+"------------------------------------------");
		tlm.getTrendLines(period,stockId);
		for(TrendLine tl : tlm.getTrendLineList()){
			System.out.println(tl.getTrendStyle());
			System.out.println(tl.getCdlStickFirst().getCi()+"-->"+tl.getCdlStickSecond().getCi());
			System.out.println(DateUtil.dateToString(tl.getCdlStickFirst().getDate())+"-->"+DateUtil.dateToString(tl.getCdlStickSecond().getDate()));
			System.out.println("--B:"+tl.getB()+DateUtil.dateToString(tl.getStartVirtualCandle().getDate()));
			
		}
//		tlm.toXml("f:\\java\\amchart\\amstock\\examples\\candlestick_test\\trend_lines.xml");
	}
	
	@Test
	public void test2(){
		
		TrendLineManager tlm = new TrendLineManager();
		tlm.prepareData();
		
	}
	
	@Test
	public void testFit(){
		double[] x = {1,2,3,4,5};
		double[] y = {5,4,5,3,1};
		double a = 0.00 ,b= 0.00;
		TrendLineManager tlm = new TrendLineManager();
//		tlm.fit(x, y, 5, a, b);
	}
	
}
