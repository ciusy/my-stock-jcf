package com.stock.trendline;

import java.util.ArrayList;
import java.util.List;

public class TrendLineManager {
	
	//趋势线破掉百分比
	private static final double BREAK_PERCENT = 0.03;
	//趋势线最小蜡烛之间长度
	private static final int TREND_POINT_MIN_LEN = 14;
	//趋势线的角度水平角度小于15度（平）或大于75度（陡）
	private static final double MIN_TREND_ANGLE = 5;
	private static final double MAX_TREND_ANGLE = 85;
	
	//扫描蜡烛的数量,其他的类推,如周线 300*5
	private static final int CANDLE_COUNT = 300 ;
	
	private List<TrendLine> trendLineList = new ArrayList<TrendLine>(); 
	private PivotalCandleStickManager pcsm = new PivotalCandleStickManager();
	List<PeriodCandleStick> periodCandleList = new ArrayList<PeriodCandleStick>();
	List<PeriodCandleStick> originalPeriodCandleList = new ArrayList<PeriodCandleStick>();
//	Formulas formula = new Formulas();
	
//	PivotalCandleStick[] originalCandle = null;
	PivotalCandleStick[] cStick = null;
	
//	//找到趋势线对应的点(日周期)
//	public void getTrendLines(){
//		
//		prepareData();
//		
//		List<TrendSegment> trendSegmentList = pcsm.findPivotalCandleStick(pcsm.getSegmentList());
//		
//		//遍历趋势段
//		for (int i=0;i<trendSegmentList.size();i++){
//			
//			TrendLine tline = null;
//			//上升趋势段
//			if(trendSegmentList.get(i).getStyle() == TrendStyle.Direct.Rise){
//				
////				double x
//				double slope = Double.MAX_VALUE;
//				
//				 for(int j : pcsm.getHighMap().keySet()){
//					 
//					 if(j >= trendSegmentList.get(i).getStartId() && j<= trendSegmentList.get(i).getEndId()){
//						//遍历上升的trend中的每一个蜡烛
//						PivotalCandleStick[] pcs = getTrendCandelIndexBetween(pcsm.getHighMap().get(j));
//						for(int p = 0;p<pcs.length;p++){
//						    double diffY =pcs[p].getLow()
//						    -pcsm.getHighMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst().getLow();
//						    double currentSlope = getSlope(diffY,pcs[p].getCi()-pcsm.getHighMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst().getCi());
//							if(slope > currentSlope){
//								slope = currentSlope;
//								tline = new TrendLine();
//								tline.setCdlStickFirst(pcsm.getHighMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst());
//								tline.setCdlStickSecond(pcs[p]);
//								tline.setTrendStyle(TrendStyle.Direct.Rise);
//								tline.setSlope(slope);
//								tline.setTurnCdlStick(pcsm.getHighMap().get(trendSegmentList.get(i).getEndId()).getCdlStickSecond());
//							}
//						}
//						 
//					 }
//								
//				 }
//				 
//				 if(tline != null){
//					 tline.setColor(TrendStyle.Color.values()[trendLineList.size()%TrendStyle.Color.values().length]);
//					 trendLineList.add(tline);
//				 }
//				
//			}else{
//				
//				double slope = -Double.MAX_VALUE;
//				//找到下降趋势段中的下降趋势单个波段遍历
//				for(int j : pcsm.getLowMap().keySet()){
//					
//					if(j >= trendSegmentList.get(i).getStartId() && j <= trendSegmentList.get(i).getEndId()){
//						//遍历下降的trend中的每一个蜡烛
//						PivotalCandleStick[] pcs = getTrendCandelIndexBetween(pcsm.getLowMap().get(j));
//						for(int p = 0;p<pcs.length;p++){
//							double diffY = pcs[p].getHigh()
//							-pcsm.getLowMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst().getHigh();
//							double currentSlope = getSlope(diffY,pcs[p].getCi()-pcsm.getLowMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst().getCi());
//							if(slope < currentSlope){
//								slope = currentSlope;
//								tline = new TrendLine();
//								tline.setCdlStickFirst(pcsm.getLowMap().get(trendSegmentList.get(i).getStartId()).getCdlStickFirst());
//								tline.setCdlStickSecond(pcs[p]);
//								tline.setTrendStyle(TrendStyle.Direct.Fall);
//								tline.setSlope(slope);
//								tline.setTurnCdlStick(pcsm.getLowMap().get(trendSegmentList.get(i).getEndId()).getCdlStickSecond());
//							}
//						}
//						
//					}
//					
//				}
//				
//				if(tline != null){
//					tline.setColor(TrendStyle.Color.values()[trendLineList.size()%TrendStyle.Color.values().length]);
//					trendLineList.add(tline);
//				}
//				 
//			}
//			
//		}
//		
//		trendLineFilter();
//		searchBreakCdlStick();
//	}
	
	
	//找到趋势线对应的点(add周期) 通用
	public void getTrendLines(TrendStyle.Period period,int len,String stockId,String whereSql,Object[] params){
		
		prepareData(period,len,stockId,whereSql,params);
		
		List<TrendSegment> trendSegmentList = pcsm.findPeriodCandleStick(originalPeriodCandleList,pcsm.getSegmentList());

		//TrendLine的第一个基点
		PivotalCandleStick basePointFirst = null ;
		//TrendLine的第一个基点在通达信上面显示的蜡烛
		PivotalCandleStick basePointPeriodFirst = null ;
		
		//第一个基点PeriodCandleStick的id，用于趋势基点较近的修正
		int basePointFirstPcsCi = -1;
		//遍历趋势段
		for(int i=0;i<trendSegmentList.size();i++){
			
			//找到的趋势线
			TrendLine tline = null;
			
			//上升趋势段
			if(trendSegmentList.get(i).getStyle() == TrendStyle.Direct.Rise){
				
				//当 basePointFirst为空时才从趋势的起点开始计算斜率
//				if(basePointFirst == null)
//					basePointFirst = pcsm.getHighMap().get(trendSegmentList.get(i).getStartId())
//		    							.getPeriodFirst().getCdlStickLow();
				
				//用于保存上升趋势段中的每个Trend的低点的Candle，用于找到拟合线
				List<PivotalCandleStick> hightFirstCandleList = new ArrayList<PivotalCandleStick>();
				//拟合趋势线的起始虚拟candle
				PivotalCandleStick beginpcs = null;
				
				double slope = Double.MAX_VALUE;
		
				 for(int j : pcsm.getHighMap().keySet()){
					 
					 if(j >= trendSegmentList.get(i).getStartId() && j<= trendSegmentList.get(i).getEndId()){
						 
						 //记录拟合线的起始candle
						 if(beginpcs == null){
							 beginpcs = new PivotalCandleStick();
							 beginpcs = pcsm.getHighMap().get(j).getPeriodFirst().getCdlStickLow();
						 }
						 
						//遍历上升的trend中的每一个蜡烛
						PeriodCandleStick[] periodcs = getTrendPeriodCandelIndexBetween(pcsm.getHighMap().get(j));
						for(int p = 0;p<periodcs.length;p++){
						    double diffY =periodcs[p].getCdlStickLow().getLow()
						    	-pcsm.getHighMap().get(trendSegmentList.get(i).getStartId())
						    	.getPeriodFirst().getCdlStickLow().getLow();
						    double currentSlope = 
						    	getSlope(diffY,periodcs[p].getCdlStickLow().getCi()-
						    			pcsm.getHighMap().get(trendSegmentList.get(i).getStartId())
						    			.getPeriodFirst().getCdlStickLow().getCi());
							if(slope > currentSlope){
								slope = currentSlope;
								tline = new TrendLine();
								tline.setCdlStickFirst(pcsm.getHighMap().get(trendSegmentList.get(i).getStartId()).getPeriodFirst().getCdlStickLow());
								tline.setCdlStickSecond(periodcs[p].getCdlStickLow());
								tline.setTrendStyle(TrendStyle.Direct.Rise);
								tline.setSlope(slope);
								tline.setPeriod(period);
								tline.setTurnCdlStick(pcsm.getHighMap().get(trendSegmentList.get(i).getEndId()).getPeriodSecond().getCdlStickHigh());
								tline.setCdlStickPeriodFirst(pcsm.getHighMap().get(trendSegmentList.get(i).getStartId()).getPeriodFirst().getCdlPeriodPoint());
								tline.setCdlStickPeriodSecond(periodcs[p].getCdlPeriodPoint());
							}
						}
						
						//找到低点
						hightFirstCandleList.add(pcsm.getHighMap().get(j).getPeriodFirst().getCdlStickLow());
						
					 }
								
				 }
				 
				 //准备拟合数据
				 double[] y = new double[hightFirstCandleList.size()];
				 double[] x = new double[hightFirstCandleList.size()];
				 for(int m=0;m<y.length;m++){
					 y[m] = hightFirstCandleList.get(m).getLow();
					 x[m] = hightFirstCandleList.get(m).getCi();
				 }
				 //设置Trendline 的拟合线的 斜率和起始点
				 trendLineFit(tline,x,y,hightFirstCandleList.size(),beginpcs);
				 
				 if(tline != null){
					 tline.setColor(TrendStyle.Color.values()[trendLineList.size()%TrendStyle.Color.values().length]);
					 trendLineList.add(tline);
				 }
				 
			}else{
				
				//当 basePointFirst为空时才从趋势的起点开始计算斜率
				if(basePointFirst == null){
					basePointFirst = pcsm.getLowMap().get(trendSegmentList.get(i).getStartId()).getPeriodFirst().getCdlStickHigh();
					basePointPeriodFirst = pcsm.getLowMap().get(trendSegmentList.get(i).getStartId()).getPeriodFirst().getCdlPeriodPoint();
				}
				//用于保存上升趋势段中的每个Trend的低点的Candle，用于找到拟合线
				List<PivotalCandleStick> lowFirstCandleList = new ArrayList<PivotalCandleStick>();
				//拟合趋势线的起始虚拟candle
				PivotalCandleStick beginpcs = null;
				
				double slope = -Double.MAX_VALUE;
				//找到下降趋势段中的下降趋势单个波段遍历
				for(int j : pcsm.getLowMap().keySet()){
					
					if(j >= trendSegmentList.get(i).getStartId() && j <= trendSegmentList.get(i).getEndId()){
						
						//记录拟合线的起始candle
						 if(beginpcs == null){
							 beginpcs = new PivotalCandleStick();
							 beginpcs = pcsm.getLowMap().get(j).getPeriodFirst().getCdlStickHigh();
						 }
						
						//遍历下降的trend中的每一个蜡烛
						PeriodCandleStick[] periodcs = getTrendPeriodCandelIndexBetween(pcsm.getLowMap().get(j));
						for(int p = 0;p<periodcs.length;p++){
							
							if(basePointFirstPcsCi != -1 && periodcs[p].getCdlStickHigh().getCi() < basePointFirstPcsCi) continue;
							
							double diffY = periodcs[p].getCdlStickHigh().getHigh()
								            - basePointFirst.getHigh();
							double currentSlope = 
								        getSlope(diffY,periodcs[p].getCdlStickHigh().getCi()
										    - basePointFirst.getCi());
							if(slope < currentSlope){
								slope = currentSlope;
								tline = new TrendLine();
								tline.setCdlStickFirst(basePointFirst);
								tline.setCdlStickSecond(periodcs[p].getCdlStickHigh());
								tline.setTrendStyle(TrendStyle.Direct.Fall);
								tline.setSlope(slope);
								tline.setPeriod(period);
								tline.setTurnCdlStick(pcsm.getLowMap().get(trendSegmentList.get(i).getEndId()).getPeriodSecond().getCdlStickLow());						
								tline.setCdlStickPeriodFirst(basePointPeriodFirst);
								tline.setCdlStickPeriodSecond(periodcs[p].getCdlPeriodPoint());
							}
						}
						
						//找到低点
						lowFirstCandleList.add(pcsm.getLowMap().get(j).getPeriodFirst().getCdlStickLow());
						
					}
					
				}
				
				//准备拟合数据
				 double[] y = new double[lowFirstCandleList.size()];
				 double[] x = new double[lowFirstCandleList.size()];
				 for(int m=0;m<y.length;m++){
					 y[m] = lowFirstCandleList.get(m).getHigh();
					 x[m] = lowFirstCandleList.get(m).getCi();
				 }
				 
				
				if(tline != null){
					
					//设置Trendline 的拟合线的 斜率和起始点
					 trendLineFit(tline,x,y,lowFirstCandleList.size(),beginpcs);
					 
					//当趋势线的基点太靠近时，重新寻找趋势线的基点
					if(tline.len() < TREND_POINT_MIN_LEN){
						basePointFirst = tline.getCdlStickSecond();
						basePointPeriodFirst = tline.getCdlStickPeriodFirst();
						basePointFirstPcsCi = tline.getCdlStickSecond().getCi(); //记录当前第二个基点作为下次的开始基点
						i = i - 1; 
					}else{
						tline.setColor(TrendStyle.Color.values()[trendLineList.size()%TrendStyle.Color.values().length]);
						trendLineList.add(tline);
						basePointFirst = null;
						basePointPeriodFirst = null;
						basePointFirstPcsCi = -1;
					}
				}else{
					basePointFirst = null;
					basePointPeriodFirst = null;
					basePointFirstPcsCi = -1;
				}
				 
			}
			
		}
		
		trendLineFilter();
		searchBreakCdlStick();
	}
	
	public void getTrendLines(TrendStyle.Period period,String stockId,String whereSql,Object[] params){
		getTrendLines(period,0,stockId,whereSql,params);
	}
	
	public void getTrendLines(TrendStyle.Period period,String stockId){
		getTrendLines(period,0,stockId,"",null);
	}
	
	public void getTrendLines(TrendStyle.Period period,int len,String stockId){
		getTrendLines(period,len,stockId,"",null);
	}
	
	
	/**
	 * 找到每个趋势线的"破"点
	 */
	protected void searchBreakCdlStick(){
		
		for(int i=0;i<trendLineList.size();i++){
			
			TrendLine tl = trendLineList.get(i);
			for(int j =tl.getTurnCdlStick().getCi();j<cStick.length;j++){
				
				double diffY;
				int diffX = j - tl.getCdlStickFirst().getCi();
				
				if(tl.getTrendStyle() == TrendStyle.Direct.Rise){
					diffY= cStick[j].getLow() - tl.getCdlStickFirst().getLow();
					if(tl.getSlope() > getSlope(diffY,diffX) && 
							(tl.getSlope()-getSlope(diffY,diffX))/tl.getSlope() >= BREAK_PERCENT){
						trendLineList.get(i).setBreakCdlStick(cStick[j]);
						break;
					}
				}else{
					diffY = cStick[j].getHigh() - tl.getCdlStickFirst().getHigh();
					if(tl.getSlope() < getSlope(diffY,diffX) && 
							Math.abs((tl.getSlope()-getSlope(diffY,diffX))/tl.getSlope()) >= BREAK_PERCENT){
						trendLineList.get(i).setBreakCdlStick(cStick[j]);
						break;
					}
				}
			
		     }
			
		}
	}
	
	
	/**
	 * 准备数据
	 */
//	public void prepareData(){
//		
//		DataManager rf = new DataManager();
//		rf.convertToArray();	
//		formula.createDataArray(rf.getArray());
//		formula.createDateArray(rf.getArray());
//		formula.createExpArray();		
//		cStick = new PivotalCandleStick[formula.highArray.length];
////		originalCandle = new PivotalCandleStick[formula.highArray.length];
//		
//		cStick = pcsm.transData(formula.highArray, formula.lowArray,formula.dateArray);
////		originalCandle = pcsm.transData(formula.highArray, formula.lowArray,formula.dateArray);;
//		
//		pcsm.assembly(
//				//找到具有趋势的那些点合并修改重拍
//				pcsm.mergePivotalCandleStick(
//						cStick	
//				)
//		);
//		
//	}
	
	/**
	 * 准备数据,带周期参数
	 */
	@SuppressWarnings("unchecked")
	public void prepareData(TrendStyle.Period period,int len,String stockId,String whereSql,Object[] params){

		DataManager dm = new DataManager();
		cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT);
		
		switch(period.ordinal()){
		case 0:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT*5*4*3);
			periodCandleList=pcsm.getPeriodCandleStickByQuarter(cStick);
			break;
		case 1:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT*5*4);
			periodCandleList=pcsm.getPeriodCandleStickByMonth(cStick);
			break;
		case 2:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT*5);
			periodCandleList=pcsm.getPeriodCandleStickByWeek(cStick);
			break;
		case 3:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT);
			periodCandleList=pcsm.getPeriodCandleStickByDaysExtend(cStick, len);
			break;
		case 4:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT);
			periodCandleList=pcsm.getPeriodCandleStickByHours(cStick, len);
			break;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			cStick = dm.getPivotalCandleStick(stockId,whereSql,params,CANDLE_COUNT);
			if(len < 1) len = 30;
			periodCandleList=pcsm.getPeriodCandleStickByMins(cStick,period,len);
			break;
		}
		
		originalPeriodCandleList = (List)((ArrayList)periodCandleList).clone();
//		Collections.copy(originalPeriodCandleList, periodCandleList);
		
		//找波段
		pcsm.assembly(
				//找到具有趋势的那些点合并修改重排列
				pcsm.mergePeriodCandleStick(
						periodCandleList	
				)
		);
		
	}
	
	
	/**
	 * 斜率的计算
	 * @param trendPoint
	 * @return
	 */
	public static double getSlope (double diffY,int diffX){
		double result = 0 ;
		result =  diffY/diffX;//day
		return result;
	}
	
	/**
	 * 趋势线斜率的有效幅度判定
	 * @param slope
	 * @return
	 */
	public static boolean slopeEffective(double slope){
		double absSlope = Math.abs(slope);
		if(absSlope <= Math.tan(Math.toRadians(MIN_TREND_ANGLE)) 
				|| absSlope >= Math.tan(Math.toRadians(MAX_TREND_ANGLE))) 
			return false;
		else 
			return true;
	}
	
	/**
	 * 14日RSI指标:
	 * 倒推包括当日在内的15个收盘价，以每一日的收盘价减去上一日的收盘价，得到14个数值，
	 * 这些数值有正有负。这样，RSI指标的计算公式具体如下：
	 * A=14个数字中正数之和
	 * B=14个数字中负数之和乘以（—1）
	 * RSI（14）=A÷（A＋B）×100
	 * 式中：A为14日中股价向上波动的大小
	 * B为14日中股价向下波动的大小
	 * A＋B为股价总的波动大小
	 * @param A
	 * @param B
	 * @return
	 */
//	public double getRSI14(PeriodCandleStick periodcs){
//		double A=0.0,B=0.0,tmp=0.0;
//		int startIndex = periodcs.getId()-14 >=0 ? periodcs.getId()-14 : 0;
//		for(int i=startIndex;i<periodcs.getId();i++){
//			tmp = originalPeriodCandleList.get(i+1).getCdlStickClose().getClose()-
//					originalPeriodCandleList.get(i).getCdlStickClose().getClose();
//			if(tmp>0) A += tmp;
//			else B += tmp;
//		}
//		B = -1 * B;
//		return A/(A+B)*100;
//	}
	
	
	/**
	 * 趋势线过滤
	 */
	protected void trendLineFilter(){
		
//		for(Iterator iter = trendLineList.iterator(); iter.hasNext();){
//			TrendLine tl = (TrendLine) iter.next();
//			//去除条件
//			if((tl.getTrendStyle() == TrendStyle.Direct.Rise && (tl.getSlope() < 0) || !slopeEffective(tl.getSlope())) || 
//			 (tl.getTrendStyle() == TrendStyle.Direct.Fall && (tl.getSlope() > 0 || !slopeEffective(tl.getSlope()))) || 
//			 (tl.getPeriod() == TrendStyle.Period.days && tl.len() < TREND_POINT_MIN_LEN)) //trendline的基点之间的跨度
//				iter.remove();
//		}
		
		for(int i=0;i<trendLineList.size();i++){
			TrendLine tl = trendLineList.get(i);
			//去除条件
			if((tl.getTrendStyle() == TrendStyle.Direct.Rise && (tl.getSlope() < 0) || !slopeEffective(tl.getSlope())) || 
			 (tl.getTrendStyle() == TrendStyle.Direct.Fall && (tl.getSlope() > 0 || !slopeEffective(tl.getSlope()))) || 
			 (tl.getPeriod() == TrendStyle.Period.days && tl.len() < TREND_POINT_MIN_LEN)) //trendline的基点之间的跨度
				trendLineList.get(i).setVisable(false);
			else
				trendLineList.get(i).setVisable(true);
		}
		
	}
	
	/**
	 * 获得趋势trend的包含的蜡烛
	 * @param trend
	 * @return
	 */
	protected PivotalCandleStick[] getTrendCandelIndexBetween(Trend trend){
		PivotalCandleStick[] pcsArray = new PivotalCandleStick[trend.getCdlStickSecond().getCi()-trend.getCdlStickFirst().getCi()+1];
		for(int i = 0 ;i<pcsArray.length;i++){
			pcsArray[i] = cStick[i+trend.getCdlStickFirst().getCi()];//pcsm.transData(formula.highArray, formula.lowArray,formula.dateArray)
		}
		return pcsArray;
	}
	
	//getTrendCandelIndexBetween 通用
	protected PeriodCandleStick[] getTrendPeriodCandelIndexBetween(Trend trend){
		PeriodCandleStick[] periodcsArray = 
			new PeriodCandleStick[trend.getPeriodSecond().getId()-trend.getPeriodFirst().getId()+1];
		for(int i = 0 ;i<periodcsArray.length;i++){
			periodcsArray[i] = originalPeriodCandleList.get(i+trend.getPeriodFirst().getId());//pcsm.transData(formula.highArray, formula.lowArray,formula.dateArray)
		}
		return periodcsArray;
	}
	
	public void toXml(TrendLine tl,String name){
		TrendLineXML xml = new TrendLineXML();
		xml.createTrendLineXML(tl,name);
//		xml.eventSettingsXML(trendLineList,name.substring(0, name.lastIndexOf("\\"))+"\\amstock_settings.xml");
	}
	
	
	/**
	 * 最小二乘法  或 拟合 法
	 * 求到多个点距离之和最短的一条直线
	 * x,y分别是点的xy坐标，是数组，ndata是点的个数，得出来的a,b是直线的系数
	 * y=b*x+a
	 */
	public double[] fit(double[] x,double[] y,int ndata){
		
		int i;
		double lxx,lxy,Avx,Avy;
		double a, b;
	
		Avx   =   0.0;
		Avy   =   0.0;
		lxx   =   0.0;
		lxy   =   0.0;
	
		for(i=0;i<ndata;i++){
			Avx   +=   x[i];
			Avy   +=   y[i];
		}
	
		Avx   /=   ndata;
		Avy   /=   ndata;
	
		for(i=0;i<ndata;i++){
			lxx   +=   (x[i]   -   Avx)   *   (x[i]   -   Avx);
			lxy   +=   (x[i]   -   Avx)   *   (y[i]   -   Avy);
		}
	
		b   =   lxy   /   lxx;
		a   =   Avy   - b * Avx;
		
		double [] result = new double[2];
		result[0] = b;
		result[1] = a;
		 
		return result;
		
	}
	
	/**
	 * 设置Trendline 的拟合线的 斜率和起始点
	 * @param tline
	 * @param x
	 * @param y
	 * @param ndata
	 * @param pcs
	 */
	public void trendLineFit(TrendLine tline,double[] x,double[] y,int ndata,PivotalCandleStick pcs){
		 double[] result = fit(x,y,ndata);
		 tline.setB(result[0]); 
		 PivotalCandleStick startVirtualpcs = new PivotalCandleStick();
		 
		 startVirtualpcs.setHigh(result[0]*pcs.getCi()+ result[1]);
		 startVirtualpcs.setLow(result[0]*pcs.getCi()+ result[1]);
		 startVirtualpcs.setDate(pcs.getDate());
		 
		 tline.setStartVirtualCandle(startVirtualpcs);
	}
	
	public List<TrendLine> getTrendLineList() {
		return trendLineList;
	}

	public void setTrendLineList(List<TrendLine> trendLineList) {
		this.trendLineList = trendLineList;
	}
	
	
}
