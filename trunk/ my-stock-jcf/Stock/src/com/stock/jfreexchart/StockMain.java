package com.stock.jfreexchart;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.Paint;
import org.jfree.data.time.*;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;

import com.stock.trendline.DataManager;
import com.stock.trendline.DateUtil;
import com.stock.trendline.PivotalCandleStick;
import com.stock.trendline.TrendLine;
import com.stock.trendline.TrendLineManager;
import com.stock.trendline.TrendStyle;

public class StockMain {

	public static void main(String[] args) {

		DataManager dm = new DataManager();
		
//		PivotalCandleStick[] pcsArray = dm.getExpPivotalCandleStick("600416", "", null);
		PivotalCandleStick[] pcsArray = dm.getPivotalCandleStick("600416", "", null,300);
		
		TrendLineManager tlm = new TrendLineManager();
		tlm.getTrendLines(TrendStyle.Period.days,"600416");

		// 简单平均的数据源
		double[] averageDoubleArray = new double[pcsArray.length];
		Day[] averageDayArray = new Day[pcsArray.length];
		
		// 生成起始日期和终止日期 日期格式"yyyy-MM-dd"
		// ??现在的dateEnd有问题，就是月末加一要进月份甚至年份
		String dateBegin = DateUtil.dateToString(pcsArray[0].getDate());
		String dateEnd = DateUtil.dateToString(DateUtil.dateIncreaseByDay(pcsArray[pcsArray.length-1].getDate(), 1));

		double highValue = Double.MIN_VALUE;// 设置K线数据当中的最大值
		double minValue = Double.MAX_VALUE;// 设置K线数据当中的最小值
		double high2Value = Double.MIN_VALUE;// 设置成交量的最低值
		double min2Value = Double.MAX_VALUE;// 设置成交量的最大值

		// 高开低收数据序列，股票K线图的四个数据，依次是开，高，低，收
		OHLCSeries series = new OHLCSeries("");
		TimeSeries series2 = new TimeSeries("");
		TimeSeries trendLineSeries = new TimeSeries("");
		
		for(TrendLine tl : tlm.getTrendLineList()){
			if(tl.getTrendStyle() == TrendStyle.Direct.Rise){
				trendLineSeries.addOrUpdate(new Day(tl.getCdlStickFirst().getDate()), tl.getCdlStickFirst().getLow());
				trendLineSeries.addOrUpdate(new Day(tl.getCdlStickSecond().getDate()), tl.getCdlStickSecond().getLow());
			}else{
				trendLineSeries.addOrUpdate(new Day(tl.getCdlStickFirst().getDate()), tl.getCdlStickFirst().getHigh());
				trendLineSeries.addOrUpdate(new Day(tl.getCdlStickSecond().getDate()), tl.getCdlStickSecond().getHigh());
			}
		}
		
		// 保留K线数据的数据集，必须申明为final，后面要在匿名内部类里面用到
		final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();
		// 保留成交量数据的集合
		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		TimeSeriesCollection timeseriescollection2 = new TimeSeriesCollection();
		
		TimeSeriesCollection trend_line_dataset = new TimeSeriesCollection();
		trend_line_dataset.addSeries(trendLineSeries);
		
		// 这里要注意到是文件日期的顺序，就是文件里面最前面的是最近的数据，而计算均线要从旧的数据开始计算
		for(int i = 0; i < pcsArray.length; i++){
			averageDayArray[i] = new Day(pcsArray[i].getDate());
			averageDoubleArray[i] = pcsArray[i].getClose();
			series.add(new Day(pcsArray[i].getDate()),pcsArray[i].getOpen(),
					pcsArray[i].getHigh(),pcsArray[i].getLow(),
					pcsArray[i].getClose());
			series2.add(new Day(pcsArray[i].getDate()),pcsArray[i].getVolumn()/ 100);
		}
		
		seriesCollection.addSeries(series);
		timeSeriesCollection.addSeries(series2);

		// 获取K线数据的最高值和最低值
		// 一共有多少个序列，目前为一个
		int seriesCount = seriesCollection.getSeriesCount();
		
		for(int i = 0; i <seriesCount; i++){
			int itemCount = seriesCollection.getItemCount(i);
			// 每一个序列有多少个数据项
			for (int j = 0; j < itemCount; j++) {
				if (highValue < seriesCollection.getHighValue(i, j)) {
					// 取第i个序列中的第j个数据项的最大值
					highValue = seriesCollection.getHighValue(i, j);
				}
				if (minValue > seriesCollection.getLowValue(i, j)) {
					// 取第i个序列中的第j个数据项的最小值
					minValue = seriesCollection.getLowValue(i, j);
				}
			}

		}

		// 获取成交量最高值和最低值
		int seriesCount2 = timeSeriesCollection.getSeriesCount();
		// 一共有多少个序列，目前为一个
		for (int i = 0; i < seriesCount2; i++) {
			int itemCount = timeSeriesCollection.getItemCount(i);
			// 每一个序列有多少个数据项
			for (int j = 0; j < itemCount; j++) {
				if (high2Value < timeSeriesCollection.getYValue(i, j)) {
					// 取第i个序列中的第j个数据项的值
					high2Value = timeSeriesCollection.getYValue(i, j);
				}
				if (min2Value > timeSeriesCollection.getYValue(i, j)) {
					// 取第i个序列中的第j个数据项的值
					min2Value = timeSeriesCollection.getYValue(i, j);
				}
			}

		}

		// 处理均线，均线的render是XYLineAndShapeRenderer。
		// 设置若干个时间线的Render，目的是用来让几条均线显示不同的颜色，和为时间线加上鼠标提示
		XYLineAndShapeRenderer xyLineRender = new XYLineAndShapeRenderer(true,
				false); //定义线和节点可见不可见的问题
		// 定义鼠标提示格式
		xyLineRender.setBaseToolTipGenerator(new StandardXYToolTipGenerator(
				"{0}: ({1}, {2})", new SimpleDateFormat("yyyy-MM-dd"),
				new DecimalFormat("0.00")));
		xyLineRender.setSeriesPaint(0, Color.red);// 定义划线颜色
		
		// 获取均线，时间的数据集，先要求的均线的数组
		// 获取均线数组n日
		TimeSeries avg_line5 = new TimeSeries("average line 5");
		MovingAverage ma5 = new MovingAverage(5);
		TimeSeries avg_line10 = new TimeSeries("average line 10");
		MovingAverage ma10 = new MovingAverage(10);

		for (double x : averageDoubleArray) {
			ma5.newNum(x);
			if (ma5.getAvg() > 0) {
				avg_line5
						.add(averageDayArray[ma5.getCount() - 1], ma5.getAvg());
				// System.out.println("Next number = " + x + " count "+
				// ma5.getCount()+", SMA = " + ma5.getAvg());
			}

		}
		// 本段是sma 10的程序
		// for (double x :avgDblArray ) {
		// ma10.newNum(x);
		// if(ma10.getAvg()>0){
		// avg_line10.add(avgDayArray[ma10.getCount()-1], ma10.getAvg());
		// //System.out.println("Next number = " + x + " count "+
		// ma10.getCount()+", SMA = " + ma10.getAvg());
		// }
		//
		//
		// 本段是expma 10的程序
		double tempExp = 0;

		for (double x : averageDoubleArray) {
			// ma10.newNum(x);
			tempExp = ma10.getExpNum(x);
			if (tempExp > 0) {
				avg_line10.add(averageDayArray[ma10.getCount() - 1], tempExp);
				// System.out.println("Next number = " + x + " count "+
				// ma10.getCount()+", SMA = " + ma10.getAvg());
			}

		}

		TimeSeriesCollection avg_line5_dataset = new TimeSeriesCollection();
		avg_line5_dataset.addSeries(avg_line5);
		avg_line5_dataset.addSeries(avg_line10);

		// 设置K线图的画图器，
		// 必须申明为final，后面要在匿名内部类里面用到
		final CandlestickRenderer candlestickRender = new CandlestickRenderer();
		// 设置是否使用自定义的边框线，程序自带的边框线的颜色不符合中国股票市场的习惯
		candlestickRender.setUseOutlinePaint(true);
		// 设置如何对K线图的宽度进行设定
		candlestickRender
				.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_AVERAGE);
		// 设置各个K线图之间的间隔
		candlestickRender.setAutoWidthGap(0.001);
		// 设置股票上涨的K线图颜色
		candlestickRender.setUpPaint(Color.RED);
		// 设置股票下跌的K线图颜色
		candlestickRender.setDownPaint(Color.GREEN);
		
		// 设置x轴，也就是时间轴
		DateAxis stepAxis = new DateAxis();
		// 设置不采用自动设置时间范围
		stepAxis.setAutoRange(false);
		stepAxis.setVisible(true);
		try {
			// todo
			// 这里要自动生成时间区间×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
			
			// 设置时间范围，注意时间的最大值要比已有的时间最大值要多一天
			stepAxis.setRange(DateUtil.stringToDate(dateBegin),
					DateUtil.stringToDate(dateEnd));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 设置时间线显示的规则，用这个方法就摒除掉了周六和周日这些没有交易的日期(很多人都不知道有此方法)，
		// 使图形看上去连续
		stepAxis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
		// 设置不采用自动选择刻度值
		stepAxis.setAutoTickUnitSelection(false);
		// 设置标记的位置
		stepAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
		// 设置标准的时间刻度单位
		stepAxis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());
		// 设置时间刻度的间隔，一般以周为单位
		stepAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 14));
		// 设置显示时间的格式
		stepAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));

		// NumberAxis y1Axis = new NumberAxis();
//		 priceLogAxis.setStandardTickUnits(LogAxis
//		 .createLogTickUnits(Locale.ENGLISH));
	
		// 设定y轴，就是数字轴
		LogAxis priceLogAxis = new LogAxis();

		priceLogAxis.setBase(java.lang.Math.E);
//		priceLogAxis.setNumberFormatOverride(new LogFormat(java.lang.Math.E,
//				"e", true));
	
		priceLogAxis.setNumberFormatOverride(new DecimalFormat("#0.00") );
		priceLogAxis.setAutoRange(true);
		
		// 设定y轴值的范围，比最低值要低一些，比最大值要大一些，这样图形看起来会美观些
//		priceLogAxis.setTickUnit(new NumberTickUnit(
//				(highValue * 1.1 - minValue * 0.9) / 10));

		/*
		 * plot dataset and candlestickrender
		 */

		XYPlot plot1 = new XYPlot(seriesCollection, stepAxis, priceLogAxis,
				candlestickRender);
		
		
		

		// 加上均线的dataset 和render
		plot1.setDataset(1, avg_line5_dataset);
		plot1.setRenderer(1, xyLineRender);
		
		//TrendLine
		plot1.setDataset(2, trend_line_dataset);
		plot1.setRenderer(2, xyLineRender);

		// 设置画图区域对象
		XYBarRenderer xyBarRender = new XYBarRenderer() {
			
			private static final long serialVersionUID = 1L;
			
			// 匿名内部类用来处理当日的成交量柱形图的颜色与K线图的颜色保持一致
			public Paint getItemPaint(int i, int j) {
				// 收盘价高于开盘价，股票上涨，选用股票上涨的颜色
				if (seriesCollection.getCloseValue(i, j) > seriesCollection
						.getOpenValue(i, j)) {
					return candlestickRender.getUpPaint();
				} else {
					return candlestickRender.getDownPaint();
				}
			}
		};
		
		// 设置柱形图之间的间隔
		xyBarRender.setMargin(0.1);
		// 设置Y轴，为数值,后面的设置，参考上面的y轴设置
		NumberAxis volumeAxis = new NumberAxis();
		
		volumeAxis.setAutoRange(false);
		volumeAxis.setRange(min2Value * 0.9, high2Value * 1.1);
		volumeAxis.setTickUnit(new NumberTickUnit(
				(high2Value * 1.1 - min2Value * 0.9) / 4));
		
		// 建立第二个画图区域对象，主要此时的x轴设为了null值，因为要与第一个画图区域对象共享x轴
		XYPlot plot2 = new XYPlot(timeSeriesCollection, null, volumeAxis,
				xyBarRender);
		
		
		
		//------------------------shiyanqu-------------------------------------------------------
		//jcf
		// 获取渲染对象
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot1.getRenderer();
//        renderer.setBaseItemLabelsVisible(true);
	//renderer.setDrawShapes(true); 
	//renderer.setShapesFilled(true);
        
        //设置数据显示位置
        //ItemLabelPosition p = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER_LEFT,TextAnchor.CENTER_LEFT, -Math.PI / 2.0 );
//        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
        //显示折点相应数据
//        renderer.setBaseItemLabelGenerator(new CategoryItemLabelGenerator());  
		//-------------------------------------------------------------------------------
		
		// 建立一个恰当的联合图形区域对象，以x轴为共享轴
		CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(
				stepAxis);
		// 添加图形区域对象，后面的数字是计算这个区域对象应该占据多大的区域2/3
		combineddomainxyplot.add(plot1, 3);
		// 添加图形区域对象，后面的数字是计算这个区域对象应该占据多大的区域1/3
		combineddomainxyplot.add(plot2, 1);
		// 设置两个图形区域对象之间的间隔空间
		combineddomainxyplot.setGap(10);

		JFreeChart chart = new JFreeChart("湘电股份",
				JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, false);
		ChartFrame frame = new ChartFrame("China unicom ADR", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
