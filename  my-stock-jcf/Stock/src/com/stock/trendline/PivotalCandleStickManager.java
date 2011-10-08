package com.stock.trendline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;

/**
 * 蜡烛图处理类
 */
public class PivotalCandleStickManager {
	
	private static final int TREND_LENTH = 5;
	private static final double MAX_SLOPE = 500.7;
	private static final double MIN_SLOPE = 0.00000000005;
	private static final int RSI14_DOWN = 50; //55
	private static final int RSI14_UP = 40; //45
	private static final double EFFECTIVE_RAISE_FALL_PERCENT = 0.12;
	
	private int arrayLength = 0;
	private int currentPos = 0;
    
	private Map<Integer,Trend> highMap = new LinkedHashMap<Integer,Trend>(); 
	private Map<Integer,Trend> lowMap = new LinkedHashMap<Integer,Trend>(); 
	
	private  List<Trend> segmentList = new ArrayList<Trend>();
	private  Trend currentTrend = null;
	
	/**
	 * 开始，取最前面的两个candlestick比较，如果前包后，表明没有产生趋势，第一个蜡烛对信息应该暂时保存起来，
	 * 第二个和第三个比较,如果一直前包后,就循环下去，直到有趋势产生或到数据结束 如果有趋势，就设置这个趋势。 如果后包前，忽略第一个蜡烛的信息，
	 * 从第二个蜡烛递归做
	 * 
	 * 该方法主要作用是找出具有趋势的蜡烛集合
	 */
	public PivotalCandleStick[] mergePivotalCandleStick(
			PivotalCandleStick[] cStick){

		if (cStick == null)
			return null;

		int index = 0;
		boolean checkLastPair = false;
		List<PivotalCandleStick> pcs = new ArrayList<PivotalCandleStick>();

		while (index < cStick.length - 1) {
			
			if (compareAdjacentFirstlong(cStick[index], cStick[index + 1])){
				PivotalCandleStick temporary = null;
				temporary = cStick[index + 1];
				cStick[index + 1] = cStick[index];
				cStick[index] = temporary;
				index++;
				checkLastPair = false;
				continue;
			}
			
			if (compareAdjacentSecondlong(cStick[index], cStick[index + 1])){
				index++;
				checkLastPair = false;
				continue;
			} else {
				checkLastPair = true;
				pcs.add(cStick[index]);
				index++;
				continue;
			}

		}

		if (checkLastPair == true)
			pcs.add(cStick[index]);

		return (PivotalCandleStick[]) pcs.toArray(new PivotalCandleStick[0]);

	}
	
	//mergePivotalCandleStick通用
	public List<PeriodCandleStick> mergePeriodCandleStick(
			List<PeriodCandleStick> periodCandleList){

		if(periodCandleList == null || periodCandleList.size() == 0)
			return null;

		List<PeriodCandleStick> periodcs = new ArrayList<PeriodCandleStick>();
		
		for(int i=0;i<periodCandleList.size()-1;i++){
			
			//前包后
			if(compareAdjacentFirstlong(periodCandleList.get(i),periodCandleList.get(i+1))){
				PeriodCandleStick temp = null;
				temp = periodCandleList.get(i+1);
				periodCandleList.set(i+1, periodCandleList.get(i));
				periodCandleList.set(i, temp);
			}else if(!compareAdjacentSecondlong(periodCandleList.get(i),periodCandleList.get(i+1))){
				periodcs.add(periodCandleList.get(i));
//				if(i == periodCandleList.size()-2) periodcs.add(periodCandleList.get(i+1));
			}
			if(i == periodCandleList.size()-2) periodcs.add(periodCandleList.get(i+1));
		}
		
//System.out.println("------------mergePeriodCandleStick-----------");
//for(int i = 0;i<periodcs.size();i++){
//	System.out.println(DateUtil.dateToString(periodcs.get(i).getCdlStickHigh().getDate()));
//}		
		return periodcs;

	}

	// 找到数组的第一个有效的趋势波点
	public void setupTrend(PivotalCandleStick[] cStick) {

		int index = 0;

		while ((index < cStick.length - 2)) {

			if (compareAdjacentHigher(cStick[index], cStick[index + 1])){
				setCurrentTrend(generateTrendPair(cStick[index],
						cStick[index + 1]));
				currentTrend.setUp(true);
//				highList.add(currentTrend);
				segmentList.add(currentTrend);
				highMap.put(segmentList.size()-1, currentTrend);
				currentPos = index + 2;
				break;
			}

			if (compareAdjacentLower(cStick[index], cStick[index + 1])){
				setCurrentTrend(generateTrendPair(cStick[index],
						cStick[index + 1]));
				currentTrend.setUp(false);
//				lowList.add(currentTrend);
				segmentList.add(currentTrend);
				lowMap.put(segmentList.size()-1, currentTrend);
				currentPos = index + 2;
				break;
			}

		}
		
		index ++ ;

	}
	
	// 找到List的第一个有效的趋势波点    通用
	public void setupTrend(List<PeriodCandleStick> periodCandleList) {

		for(int i=0;i<periodCandleList.size()-1;i++){
			
			if (compareAdjacentHigher(periodCandleList.get(i),periodCandleList.get(i+1))){
				//上升趋势
				setCurrentTrend(generateTrendPair(periodCandleList.get(i),
						periodCandleList.get(i+1)));
				currentTrend.setUp(true);
				segmentList.add(currentTrend);
				highMap.put(segmentList.size()-1,currentTrend);
				currentPos = i + 2;
				break;
			}

			if (compareAdjacentLower(periodCandleList.get(i),periodCandleList.get(i+1))){
				//下降趋势
				setCurrentTrend(generateTrendPair(periodCandleList.get(i),
						periodCandleList.get(i+1)));
				currentTrend.setUp(false);
				segmentList.add(currentTrend);
				lowMap.put(segmentList.size()-1,currentTrend);
				currentPos = i + 2;
				break;
			}
			
		}

	}
	
	
	

	// 找到转折点
	public List<TrendSegment> findPivotalCandleStick(List<Trend> list){
		
		List<TrendSegment> trendSegmentList = new ArrayList<TrendSegment>();
		
		int highIndex = -1;
		int lowIndex = -1;
		double high = 0.0;
		double low = 1000000.0;
		
		int upStartIndex = -1;
		int downStartIndex = -1;
		
		//在某一趋势结束后才开始下一个趋势
		boolean isRaiseEnd = true;
		boolean isFallEnd = true;
		
		double diffY;int diffX;

		for(int i = 0;i<list.size();i++){
			
			if(list.get(i).isUp() && isFallEnd){
				
				isRaiseEnd = false;
				if(upStartIndex == -1) upStartIndex = i; 
				//初步计算斜率，分隔掉过平、过陡的趋势线
				diffY = list.get(i).getCdlStickFirst().getLow()- list.get(upStartIndex).getCdlStickFirst().getLow();
				diffX = list.get(i).getCdlStickFirst().getCi()-list.get(upStartIndex).getCdlStickFirst().getCi();
				
				if(list.get(i).getCdlStickSecond().getHigh() < high ||
						Math.abs(TrendLineManager.getSlope(diffY, diffX)) > MAX_SLOPE ||
						Math.abs(TrendLineManager.getSlope(diffY, diffX)) < MIN_SLOPE){
					//上升趋势结束，保存趋势线
					TrendSegment ts = new TrendSegment();
					ts.setStartId(upStartIndex);
					ts.setEndId(highIndex);
					ts.setStyle(TrendStyle.Direct.Rise);
					trendSegmentList.add(ts);
					//此时的上升趋势作为下一个上升趋势的起点
					upStartIndex = i ;
					isRaiseEnd = true;
					//在上升趋势结束的时候要把前一个的下降趋势保存下来,供下面的下降趋势做开始起点
					downStartIndex = i -1;
					low = list.get(i -1).getCdlStickSecond().getLow();
					lowIndex = i -1;
				}
				
				high = list.get(i).getCdlStickSecond().getHigh();
				highIndex = i;
				 
			}else if(!list.get(i).isUp() && isRaiseEnd){
				
				isFallEnd = false;
				if(downStartIndex == -1) downStartIndex = i;
				//初步计算斜率，筛选掉过平、过陡的趋势线
				diffY = list.get(i).getCdlStickFirst().getHigh()- list.get(downStartIndex).getCdlStickFirst().getHigh();
				diffX = list.get(i).getCdlStickFirst().getCi()-list.get(downStartIndex).getCdlStickFirst().getCi();
				if (list.get(i).getCdlStickSecond().getLow() > low || 
						Math.abs(TrendLineManager.getSlope(diffY, diffX)) > MAX_SLOPE || 
						Math.abs(TrendLineManager.getSlope(diffY, diffX)) < MIN_SLOPE){
					//下降趋势结束保存趋势线
					TrendSegment ts = new TrendSegment();
					ts.setStartId(downStartIndex);
					ts.setEndId(lowIndex);
					ts.setStyle(TrendStyle.Direct.Fall);
					trendSegmentList.add(ts);
					//此时的下降趋势作为下一个下降趋势的起点
					downStartIndex = i;
					isFallEnd = true;
					//下降趋势结束的时候要把前一个上升趋势的状态保存下来，供下一个上升趋势的开始起点
					upStartIndex = i - 1;
					high = list.get(i-1).getCdlStickSecond().getHigh();
					highIndex = i-1;
				}
				
				low = list.get(i).getCdlStickSecond().getLow();
				lowIndex = i;

			}

		}

		return trendSegmentListFilter(trendSegmentList);

	}
	
	
	//找到上升或者下降趋势的起始波段号和结束波段号，也就是整个趋势段
	public List<TrendSegment> findPeriodCandleStick(List<PeriodCandleStick> originalPeriodCandleList,
			List<Trend> list){

		List<TrendSegment> trendSegmentList = new ArrayList<TrendSegment>();
		
		int highIndex = -1;
		int lowIndex = -1;
		double high = 0.0;
		double low = 1000000.0;
		double fallhigh = 1000000.0;//记录下降趋势的最高点
		double uplow = 0.0;//记录上升趋势的最低点
		
		int upStartIndex = -1;
		int downStartIndex = -1;
		
		//在某一趋势结束后才开始下一个趋势
		boolean isRaiseEnd = true;
		boolean isFallEnd = true;
		
		double diffY;
		int diffX;
		
		double rsi =0;
		double raisefallPercent = 0;

		for(int i = 0;i<list.size();i++){
			//上升趋势
			if(list.get(i).isUp() && isFallEnd){
				
				if(i == 0) list.get(i).getPeriodFirst().getCdlStickLow().getLow();
				
				isRaiseEnd = false;
				if(upStartIndex == -1) upStartIndex = i; 
				//初步计算斜率，分隔掉过平、过陡的趋势线
				diffY = list.get(i).getPeriodFirst().getCdlStickLow().getLow()- 
							list.get(upStartIndex).getPeriodFirst().getCdlStickLow().getLow();
				diffX = list.get(i).getPeriodFirst().getCdlStickLow().getCi()-
							list.get(upStartIndex).getPeriodFirst().getCdlStickLow().getCi();
				
				//当一般上升趋势结束的时候计算rsi和下降的幅度
				if(list.get(i).getPeriodSecond().getCdlStickHigh().getHigh() < high){
					rsi = getRSI14(originalPeriodCandleList,list.get(i).getPeriodFirst());
					//计算下降的幅度
					if(i>0)raisefallPercent = 
						(list.get(i-1).getPeriodFirst().getCdlStickHigh().getHigh()-
								list.get(i-1).getPeriodSecond().getCdlStickLow().getLow())/
								list.get(i-1).getPeriodFirst().getCdlStickHigh().getHigh();
				}
				
				if((list.get(i).getPeriodSecond().getCdlStickHigh().getHigh() < high 
						&& (
								rsi < RSI14_UP || 
								raisefallPercent >= EFFECTIVE_RAISE_FALL_PERCENT
							)
					) 
				   || i == list.size()-1	
//				   || !TrendLineManager.slopeEffective(TrendLineManager.getSlope(diffY, diffX))
				   ){
					//当到达蜡烛的末尾的时候趋势段结束的index为末尾i
					if(i == list.size()-1)highIndex = i;
					//上升趋势结束，保存趋势线
					TrendSegment ts = new TrendSegment();
					ts.setStartId(upStartIndex);
					ts.setEndId(highIndex);
					ts.setStyle(TrendStyle.Direct.Rise);
					trendSegmentList.add(ts);
					
					//此时的上升趋势作为下一个上升趋势的起点
					upStartIndex = i ;
					isRaiseEnd = true;
					//在上升趋势结束的时候要把前一个的下降趋势保存下来,供下面的下降趋势做开始起点
					if(i-1>0){
						downStartIndex = i -1;
						low = list.get(i -1).getPeriodSecond().getCdlStickLow().getLow();
						fallhigh = list.get(i -1).getPeriodFirst().getCdlStickHigh().getHigh();
						lowIndex = i -1;
					}
					
				}else if(list.get(i).getPeriodSecond().getCdlStickHigh().getHigh() >= high && 
						list.get(i).getPeriodFirst().getCdlStickLow().getLow() <= uplow){
					upStartIndex = i;
					uplow = list.get(i).getPeriodFirst().getCdlStickLow().getLow();
				}
				
				high = list.get(i).getPeriodSecond().getCdlStickHigh().getHigh();
				highIndex = i;
				 
			}else if((!list.get(i).isUp() && isRaiseEnd) 
					|| (list.get(i).isUp()&&isRaiseEnd&&i==list.size()-1) //用于修正趋势还未形成时，已经到了蜡烛的末尾，会有trend的turn问题
					){ //下降趋势
				
				if(i==0) fallhigh = list.get(i).getPeriodFirst().getCdlStickHigh().getHigh();
				
				isFallEnd = false;
				if(downStartIndex == -1) downStartIndex = i;
				//初步计算斜率，筛选掉过平、过陡的趋势线
				diffY = list.get(i).getPeriodFirst().getCdlStickHigh().getHigh()-
						list.get(downStartIndex).getPeriodFirst().getCdlStickHigh().getHigh();
				diffX = list.get(i).getPeriodFirst().getCdlStickHigh().getCi()-
						list.get(downStartIndex).getPeriodFirst().getCdlStickHigh().getCi();
				
				//当一般下降趋势结束的时候计算rsi和下降的幅度
				if(list.get(i).getPeriodSecond().getCdlStickLow().getLow() > low){
					//计算rsi
					rsi = getRSI14(originalPeriodCandleList,list.get(i).getPeriodFirst());
					//计算上升的幅度
					if(i>0)raisefallPercent = 
						(list.get(i-1).getPeriodSecond().getCdlStickHigh().getHigh()-
								list.get(i-1).getPeriodFirst().getCdlStickLow().getLow())/
								list.get(i-1).getPeriodFirst().getCdlStickLow().getLow();
				}
				
				if ((list.get(i).getPeriodSecond().getCdlStickLow().getLow() > low  
						&&(rsi > RSI14_DOWN || raisefallPercent >= EFFECTIVE_RAISE_FALL_PERCENT))
					|| i == list.size()-1
//					|| !TrendLineManager.slopeEffective(TrendLineManager.getSlope(diffY, diffX))
					){
					//当到达蜡烛的末尾的时候趋势段结束的index为末尾i
					if(i == list.size()-1 && !list.get(i).isUp())lowIndex = i;
					//下降趋势结束保存趋势线
					TrendSegment ts = new TrendSegment();
					ts.setStartId(downStartIndex);
					ts.setEndId(lowIndex);
					ts.setStyle(TrendStyle.Direct.Fall);
					trendSegmentList.add(ts);
					//此时的下降趋势作为下一个下降趋势的起点
					downStartIndex = i;
					isFallEnd = true;
					//下降趋势结束的时候要把前一个上升趋势的状态保存下来，供下一个上升趋势的开始起点
					if(i-1>0){
						upStartIndex = i - 1;
						high = list.get(i-1).getPeriodSecond().getCdlStickHigh().getHigh();
						uplow = list.get(i-1).getPeriodFirst().getCdlStickLow().getLow();
						highIndex = i-1;
					}
					
				}else if(list.get(i).getPeriodSecond().getCdlStickLow().getLow() <= low && 
						list.get(i).getPeriodFirst().getCdlStickHigh().getHigh() >= fallhigh){
					downStartIndex = i;
					fallhigh = list.get(i).getPeriodFirst().getCdlStickHigh().getHigh();
				}
				
				low = list.get(i).getPeriodSecond().getCdlStickLow().getLow();
				lowIndex = i;

			}

		}
		
//System.out.println("-----------trendSegmentList---------------");
//for(int i = 0;i<trendSegmentList.size();i++){
//	System.out.println(trendSegmentList.get(i).getStyle()+" "+
//			DateUtil.dateToString(list.get(trendSegmentList.get(i).getStartId()).getPeriodFirst().getCdlStickHigh().getDate())
//			+"-->"+
//			DateUtil.dateToString(list.get(trendSegmentList.get(i).getEndId()).getPeriodSecond().getCdlStickHigh().getDate()));
//}
//
//System.out.println("-----------highMap---------------");
//for(int i :highMap.keySet()){
//	System.out.println(highMap.get(i).getPeriodFirst()+"-->"+highMap.get(i).getPeriodSecond());
//}
//
//System.out.println("-----------lowMap---------------");
//for(int i :lowMap.keySet()){
//	System.out.println(lowMap.get(i).getPeriodFirst()+"-->"+lowMap.get(i).getPeriodSecond());
//}
		
		//根据segmentList的长度过滤合并趋势
//		return trendSegmentListFilter(trendSegmentList);
return trendSegmentList;

	}
	
	

	//找波段
	public void assembly(PivotalCandleStick[] cStick) {

		setupTrend(cStick);
		
		while (currentPos < cStick.length) {
			
			if (currentTrend != null) {
				updateTrend(currentTrend, cStick[currentPos]);// 必须有全程变量追踪当前的蜡烛位置
			}

			currentPos++;
			continue;

		}
	 
	}
	
	//找波段 通用版
	public void assembly(List<PeriodCandleStick> periodCandleList) {

		setupTrend(periodCandleList);
		
		while (currentPos < periodCandleList.size()) {
			
			if (currentTrend != null) {
				updateTrend(currentTrend, periodCandleList.get(currentPos));// 必须有全程变量追踪当前的蜡烛位置
			}

			currentPos++;
			
		}
	 
	}

	// 数据开始是 高/低/日期 数组，变成candlestick数组，然后后开始初始化再比较
	public PivotalCandleStick[] transData(double[] h, double[] l,Date[] d){

		arrayLength = h.length;

		PivotalCandleStick[] cStick = new PivotalCandleStick[arrayLength];
		
		for (int i = 0; i < cStick.length; i++) {
			cStick[i] = new PivotalCandleStick(h[arrayLength - i - 1],
					l[arrayLength - i - 1], d[arrayLength - i - 1], i);
		}

		return cStick;

	}
	
	
	// 这是假想的初始趋势，第一根蜡烛，趋势可上可下，保存其高低值
	public Trend generateTrendSingle(PivotalCandleStick cStick,
			boolean up) {
		Trend nTrend = new Trend();
		nTrend.setCdlStickFirst(cStick);
		nTrend.setCdlStickSecond(cStick);
		nTrend.setUp(up);
		return nTrend;
	}

	//组装Trend
	public  Trend generateTrendPair(PivotalCandleStick cFStick,
			PivotalCandleStick cSStick) {
		Trend nTrend = new Trend();
		nTrend.setCdlStickFirst(cFStick);
		nTrend.setCdlStickSecond(cSStick);
		return nTrend;
	}
	
	//组装Trend 通用
	public  Trend generateTrendPair(PeriodCandleStick cFStick,
			PeriodCandleStick cSStick) {
		Trend nTrend = new Trend();
		nTrend.setPeriodFirst(cFStick);
		nTrend.setPeriodSecond(cSStick);
		return nTrend;
	}

	// 更新趋势集合
	public void updateTrend(Trend trend, PivotalCandleStick third) {

		if (trend.isUp()) {
			if (compareAdjacentHigher(trend.getCdlStickSecond(), third)) {
				highMap.remove(segmentList.indexOf(trend));
				segmentList.remove(trend);
				
				trend.setCdlStickSecond(third);

				segmentList.add(trend);
				highMap.put(segmentList.size()-1, trend);
			} else if (compareAdjacentLower(trend.getCdlStickSecond(), third)) {

				Trend newTrend = new Trend();

				newTrend.setCdlStickFirst(trend.getCdlStickSecond());
				newTrend.setCdlStickSecond(third);
				newTrend.setUp(false);
				currentTrend = newTrend;
				segmentList.add(newTrend);
				lowMap.put(segmentList.size()-1, newTrend);
			}

		} else {
			if (compareAdjacentHigher(trend.getCdlStickSecond(), third)) {
				Trend newTrend = new Trend();

				newTrend.setCdlStickFirst(trend.getCdlStickSecond());
				newTrend.setCdlStickSecond(third);
				newTrend.setUp(true);
				currentTrend = newTrend;
				segmentList.add(newTrend);
				highMap.put(segmentList.size()-1, newTrend);

			} else if (compareAdjacentLower(trend.getCdlStickSecond(), third)) {
				lowMap.remove(segmentList.indexOf(trend));
				segmentList.remove(trend);
				trend.setCdlStickSecond(third);// 原来的趋势保留，给后面的蜡烛赋值
				segmentList.add(trend);
				lowMap.put(segmentList.size()-1, trend);
			}

		}

	}
	
	
	// 更新趋势集合 通用
	public void updateTrend(Trend trend, PeriodCandleStick third) {

		if (trend.isUp()) {
			if (compareAdjacentHigher(trend.getPeriodSecond(), third)) {
				
				highMap.remove(segmentList.indexOf(trend));
				segmentList.remove(trend);
				
				trend.setPeriodSecond(third);

				segmentList.add(trend);
				highMap.put(segmentList.size()-1, trend);
				
			} else if (compareAdjacentLower(trend.getPeriodSecond(), third)) {

				Trend newTrend = new Trend();

				newTrend.setPeriodFirst(trend.getPeriodSecond());
				newTrend.setPeriodSecond(third);
				newTrend.setUp(false);
				currentTrend = newTrend;
				segmentList.add(newTrend);
				lowMap.put(segmentList.size()-1, newTrend);
				
			}

		} else {
			if (compareAdjacentHigher(trend.getPeriodSecond(), third)) {
				
				Trend newTrend = new Trend();

				newTrend.setPeriodFirst(trend.getPeriodSecond());
				newTrend.setPeriodSecond(third);
				newTrend.setUp(true);
				currentTrend = newTrend;
				segmentList.add(newTrend);
				highMap.put(segmentList.size()-1, newTrend);

			} else if (compareAdjacentLower(trend.getPeriodSecond(), third)) {
				
				lowMap.remove(segmentList.indexOf(trend));
				segmentList.remove(trend);
				trend.setPeriodSecond(third);// 原来的趋势保留，给后面的蜡烛赋值
				segmentList.add(trend);
				lowMap.put(segmentList.size()-1, trend);
				
			}

		}

	}

	/**
	 * 相邻两个candlestick 的四种关系
	 */
	// 一、相邻两个candlestick比较，如果前面的包容后面的，返回True；其他返回false
	public boolean compareAdjacentFirstlong(PivotalCandleStick first,
			PivotalCandleStick second) {

		if ((first.getHigh() >= second.getHigh()) && (first.getLow() <= second.getLow())) {
			return true;
		}
		return false;

	}
	
	//一、compareAdjacentFirstlong 通用Period
	public boolean compareAdjacentFirstlong(PeriodCandleStick first,
			PeriodCandleStick second) {

		if ((first.getCdlStickHigh().getHigh() >= second.getCdlStickHigh().getHigh()) && 
				(first.getCdlStickLow().getLow() <= second.getCdlStickLow().getLow())) {
			return true;
		}
		return false;

	}

	//二、 相邻两个candlestick比较，如果后面的包容前面的，返回True；其他返回false
	public boolean compareAdjacentSecondlong(PivotalCandleStick first,
			PivotalCandleStick second) {

		if ((first.getHigh() <= second.getHigh()) && (first.getLow() >= second.getLow())) {
			return true;
		}
		return false;

	}
	
	//二、compareAdjacentSecondlong Period 通用
	public boolean compareAdjacentSecondlong(PeriodCandleStick first,
			PeriodCandleStick second) {

		if ((first.getCdlStickHigh().getHigh() <= second.getCdlStickHigh().getHigh()) && 
				(first.getCdlStickLow().getLow() >= second.getCdlStickLow().getLow())) {
			return true;
		}
		return false;

	}

	//三、 必须保证调用前面两个方法之后才能调用本方法，看后面的k线是不是有高点
	public boolean compareAdjacentHigher(PivotalCandleStick first,
			PivotalCandleStick second) {

		if ((first.getHigh() <= second.getHigh()) && (first.getLow() < second.getLow())) {
			return true;
		}
		return false;
	}
	
	//三、 必须保证调用前面两个方法之后才能调用本方法，看后面的k线是不是有高点  通用
	public boolean compareAdjacentHigher(PeriodCandleStick first,
			PeriodCandleStick second) {

		if ((first.getCdlStickHigh().getHigh() <= second.getCdlStickHigh().getHigh()) && 
				(first.getCdlStickLow().getLow() < second.getCdlStickLow().getLow())) {
			return true;
		}
		return false;
	}

	//四、
	public boolean compareAdjacentLower(PivotalCandleStick first,
			PivotalCandleStick second) {
		if ((first.getHigh() >= second.getHigh()) && (first.getLow() > second.getLow())){
			return true;
		}
		return false;
	}
	
	//四、通用
	public boolean compareAdjacentLower(PeriodCandleStick first,
			PeriodCandleStick second) {
		if ((first.getCdlStickHigh().getHigh() >= second.getCdlStickHigh().getHigh()) && 
				(first.getCdlStickLow().getLow() > second.getCdlStickLow().getLow())){
			return true;
		}
		return false;
	}

	/**
	 * 趋势线的过滤
	 * @param tslist
	 * @return
	 */
	public List<TrendSegment> trendSegmentListFilter(List<TrendSegment> tslist){
		
		if(tslist == null || tslist.size() <= 0) return null;
		
		List<TrendSegment> newTSList = new ArrayList<TrendSegment>();
		
		int startId = tslist.get(0).getStartId();
		int endId = tslist.get(0).getEndId();
		TrendStyle.Direct direct = tslist.get(0).getStyle();
		
		for(int i=0;i<tslist.size();i++){
			
			if(i<tslist.size()-1){
				if(i == 0 && i!=tslist.size() && tslist.get(i).getLength() < TREND_LENTH && tslist.get(i+1).getLength() >= TREND_LENTH ){
					startId = tslist.get(i+1).getStartId();
					endId = tslist.get(i+1).getEndId();
					direct = tslist.get(i+1).getStyle();
				}else if(tslist.get(i+1).getLength() < TREND_LENTH){
					endId = tslist.get(i+1).getEndId();
				}else if(tslist.get(i+1).getStyle() == direct){
					endId = tslist.get(i+1).getEndId();
				}else{
					TrendSegment ts = new TrendSegment();
					ts.setStartId(startId);
					ts.setEndId(endId);
					ts.setStyle(direct);
					newTSList.add(ts);
					
					startId = tslist.get(i+1).getStartId();
					endId = tslist.get(i+1).getEndId();
					direct = tslist.get(i+1).getStyle();
					
				}
			}else if(i == tslist.size()-1){
				if(tslist.get(i).getLength() >=TREND_LENTH || (tslist.get(i).getLength()<TREND_LENTH && startId !=tslist.get(i).getStartId())){
					endId = tslist.get(i).getEndId();
					TrendSegment ts = new TrendSegment();
					ts.setStartId(startId);
					ts.setEndId(endId);
					ts.setStyle(direct);
					newTSList.add(ts);
				}

			}
			
			
		}
		
		return newTSList;
		
	}
	
	
	public PeriodCandleStick[] transData(double[] h, double[] l,
			Date[] d,TrendStyle.Period period){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		PivotalCandleStick[] pcs = transData(h, l, d);
		
		
		switch(period.ordinal()){
		case 0: pcslst = getPeriodCandleStickByQuarter(pcs);
		}
		
		
		return (PeriodCandleStick[])pcslst.toArray(new PeriodCandleStick[0]);
	}
	
	
	
	public int getQuarter(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		return (c.get(Calendar.MONTH)+1)%3 == 0 ? (c.get(Calendar.MONTH)+1)/3 : (c.get(Calendar.MONTH)+1)/3 + 1;
	}
	
	/**
	 * 月蜡烛数据 PeriodCandleStick
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByMonth(PivotalCandleStick[] pcs){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick(); 
		
		Calendar c=Calendar.getInstance();
		c.setTime(pcs[0].getDate());
		
		pcsOpen = pcs[0];
		pcsClose = pcs[0];
		
		int month = c.get(Calendar.MONTH);
		
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			Calendar c2=Calendar.getInstance();
			c2.setTime(pcs[i].getDate());
			
			if(c2.get(Calendar.MONTH)== month){
				
				//比较数据取得较大的那个
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsClose = pcs[i];
				
				//最后结尾
				if(i== pcs.length -1){
					PeriodCandleStick periodcs = 
						new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.month,pcsOpen,pcsClose,pcs[i]);
					pcslst.add(periodcs);
				}
				
			}else{
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.month,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				month = c2.get(Calendar.MONTH);
				
				high = 0.0;
				low = 100000.0;
				
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}
			
		}
		
		return pcslst;
		
	}
	
	
	
	
	
	/**
	 * 季度蜡烛数据
	 * @param pcs
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByQuarter(PivotalCandleStick[] pcs){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick();
		
		pcsOpen = pcs[0];
		pcsClose = pcs[0];
		
		int quarter = getQuarter(pcs[0].getDate());
		
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			if(getQuarter(pcs[i].getDate()) == quarter){
				
				//比较取得较大的那个
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsClose = pcs[i];
				
				if(i == pcs.length - 1){
					PeriodCandleStick periodcs = 
						new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.quarter,pcsOpen,pcsClose,pcs[i]);
					pcslst.add(periodcs);
				}

			}else{
				
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.quarter,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				quarter = getQuarter(pcs[i].getDate());
				
				high = 0.0;
				low = 100000.0;
				
				//比较取得较大的那个
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}
			
			
			
		}
		
		return pcslst;
	}
	
	/**
	 * 周蜡烛数据 PeriodCandleStick
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByWeek(PivotalCandleStick[] pcs){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick(); 
		
		Calendar c=Calendar.getInstance();
		c.setTime(pcs[0].getDate());
		
		pcsOpen = pcs[0];
		pcsClose = pcs[0];
		
		int week = c.get(Calendar.WEEK_OF_YEAR);
		int year = c.get(Calendar.YEAR);
		
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			Calendar c2=Calendar.getInstance();
			c2.setTime(pcs[i].getDate());
			
			if(c2.get(Calendar.WEEK_OF_YEAR) == week && c2.get(Calendar.YEAR) == year){
				//比较数据
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsClose = pcs[i];
				
				if(i == pcs.length -1){
					PeriodCandleStick periodcs = 
						new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.week,pcsOpen,pcsClose,pcs[i]);
					pcslst.add(periodcs);
				}
				
			}else{
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.week,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				week = c2.get(Calendar.WEEK_OF_YEAR);
				year = c2.get(Calendar.YEAR);
				
				high = 0.0;
				low = 100000.0;
				
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}
			
		}
		
		return pcslst;
		
	}
	
	/**
	 * 多日蜡烛数据 PeriodCandleStick 一
	 * @return
	 */
//	public List<PeriodCandleStick> getPeriodCandleStickByDays(PivotalCandleStick[] pcs,int len){
//		
//		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
//		
//		double high = 0.0;
//		double low = 100000.0;
//		
//		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
//		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
//		
//		int index = 0;
//		
//		for(int i=0;i<pcs.length;){
//			
//			high = 0.0;
//			low = 100000.0;
//			
//			int temp=i+len-1 < pcs.length ?i+len:pcs.length;
//			for(int j=i;j<temp;j++){
//				//比较数据
//				if(pcs[j].getHigh() >= high){
//					high = pcs[j].getHigh();
//					pcsHigh = pcs[j];
//				}
//				if(pcs[j].getLow() <= low){
//					low = pcs[j].getLow();
//					pcsLow = pcs[j];
//				}
//			}
//			
//			PeriodCandleStick periodcs = 
//				new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.days);
//			pcslst.add(periodcs);
//			index ++ ;
//			
//			i = i+len;
//			
//		}
//		
//		return pcslst;
//		
//	}
	
	/**
	 * 多日蜡烛数据 PeriodCandleStick 二
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByDaysExtend(PivotalCandleStick[] pcs,int len){

		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick(); 
		
		pcsOpen = pcs[0];
		pcsClose = pcs[0];
		
		Date begin = pcs[0].getDate();
		Date end = pcs[0].getDate();
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			end = pcs[i].getDate();
			
			if(DateUtil.getBetweenDay(begin,end) <= len){
				//比较数据
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				pcsClose = pcs[i];
				
			}else{
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.days,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				begin = end;
				
				high = 0.0;
				low = 100000.0;
				
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}
			
			if(i == pcs.length -1){
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.days,pcsOpen,pcsClose,pcs[i]);
				pcslst.add(periodcs);
			}
			
		}
		
//System.out.println("------------getPeriodCandleStickByDaysExtend-----------");
//for(int i = 0;i<pcslst.size();i++){
//			System.out.println(DateUtil.dateToString(pcslst.get(i).getCdlStickHigh().getDate()));
//}
		
		return pcslst;
		
	}
	
	
	/**
	 * 多时蜡烛数据 PeriodCandleStick
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByHours(PivotalCandleStick[] pcs,int len){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick(); 
		
		pcsOpen = pcs[0];
		pcsClose = pcs[0];
		
		Date begin = pcs[0].getDate();
		Date end = pcs[0].getDate();
		
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			end = pcs[i].getDate();
			
			if(DateUtil.getBetweenHour(begin, end) <= len){
				
				//比较数据
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsClose = pcs[i];
				
			}else{
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.hours,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				begin = end;
				
				high = 0.0;
				low = 100000.0;
				
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}
			
			if(i == pcs.length-1){
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,TrendStyle.Period.hours,pcsOpen,pcsClose,pcs[i]);
				pcslst.add(periodcs);
			}
			
		}
		
		return pcslst;
		
	}
	
	
	/**
	 * 多分钟蜡烛数据 PeriodCandleStick
	 * @return
	 */
	public List<PeriodCandleStick> getPeriodCandleStickByMins(PivotalCandleStick[] pcs,TrendStyle.Period period,int len){
		
		List<PeriodCandleStick> pcslst = new ArrayList<PeriodCandleStick>();
		
		double high = 0.0;
		double low = 100000.0;
		
		PivotalCandleStick pcsHigh = new PivotalCandleStick(); 
		PivotalCandleStick pcsLow = new PivotalCandleStick(); 
		PivotalCandleStick pcsOpen = new PivotalCandleStick(); 
		PivotalCandleStick pcsClose = new PivotalCandleStick(); 
		
		pcsOpen=pcs[0];
		pcsClose=pcs[0];
		
		Date begin = pcs[0].getDate();
		Date end = pcs[0].getDate();
		
		int index = 0;
		
		for(int i=0;i<pcs.length;i++){
			
			end = pcs[i].getDate();
			
			if(DateUtil.getBetweenMinute(begin, end) <= len){
				
				//比较数据
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsClose = pcs[i];
				
			}else{
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,period,pcsOpen,pcsClose,pcs[i-1]);
				pcslst.add(periodcs);
				index ++ ;
				
				begin = end;
				
				high = 0.0;
				low = 100000.0;
				
				if(pcs[i].getHigh() >= high){
					high = pcs[i].getHigh();
					pcsHigh = pcs[i];
				}
				if(pcs[i].getLow() <= low){
					low = pcs[i].getLow();
					pcsLow = pcs[i];
				}
				
				pcsOpen = pcs[i];
				pcsClose = pcs[i];
				
			}			

			if(i==pcs.length -1){
				PeriodCandleStick periodcs = 
					new PeriodCandleStick(index,pcsHigh,pcsLow,period,pcsOpen,pcsClose,pcs[i]);
				pcslst.add(periodcs);
			}
			
		}
		
		return pcslst;
		
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
	public double getRSI14(List<PeriodCandleStick> originalPeriodCandleList,PeriodCandleStick periodcs){
		double A=0.0,B=0.0,tmp=0.0;
		int startIndex = periodcs.getId()-14 >=0 ? periodcs.getId()-14 : 0;
		for(int i=startIndex;i<periodcs.getId();i++){
			tmp = originalPeriodCandleList.get(i+1).getCdlStickClose().getClose()-
					originalPeriodCandleList.get(i).getCdlStickClose().getClose();
			if(tmp>0) A += tmp;
			else B += tmp;
		}
		B = -1 * B;
		return A/(A+B)*100;
	}
	
	
	public Trend getCurrentTrend() {
		return currentTrend;
	}

	public List<Trend> getSegmentList() {
		return segmentList;
	}

	public void setCurrentTrend(Trend currentTrend) {
		this.currentTrend = currentTrend;
	}

	public void setSegmentList(List<Trend> segmentList) {
		this.segmentList = segmentList;
	}

	public Map<Integer, Trend> getHighMap() {
		return highMap;
	}

	public void setHighMap(Map<Integer, Trend> highMap) {
		this.highMap = highMap;
	}

	public Map<Integer, Trend> getLowMap() {
		return lowMap;
	}

	public void setLowMap(Map<Integer, Trend> lowMap) {
		this.lowMap = lowMap;
	}

}
