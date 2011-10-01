package com.stock.trendline;

public class TrendStyle{
	
	//方向
	public enum Direct {
		Unkonwn{public String getName(){return "未知";}},
		Fall{public String getName(){return "下降";} },
		Rise{public String getName(){return "上升";} };
		public abstract String getName();
	}
	
	//13种颜色
	public enum Color{
		blue{public java.awt.Color getName(){return java.awt.Color.blue;}},	
		black{public java.awt.Color getName(){return java.awt.Color.black;}},	
		cyan{public java.awt.Color getName(){return java.awt.Color.cyan;}},	
		darkGray{public java.awt.Color getName(){return java.awt.Color.darkGray;}},	
		gray{public java.awt.Color getName(){return java.awt.Color.gray;}},	
		green{public java.awt.Color getName(){return java.awt.Color.green;}},	
		lightGray{public java.awt.Color getName(){return java.awt.Color.lightGray;}},	
		magenta{public java.awt.Color getName(){return java.awt.Color.magenta;}},	
		orange{public java.awt.Color getName(){return java.awt.Color.orange;}},	
		pink{public java.awt.Color getName(){return java.awt.Color.pink;}},	
		red{public java.awt.Color getName(){return java.awt.Color.red;}},	
		//white{public java.awt.Color getName(){return java.awt.Color.white;}},	
		yellow{public java.awt.Color getName(){return java.awt.Color.yellow;}};	
		public abstract java.awt.Color getName();
	}
	
	//线的属性
	public enum Line{
		segment{public String getName(){return "线段";}},
		straight{public String getName(){return "直线";}},
		ray{public String getName(){return "射线";}};
		public abstract String getName();
	}
	
	//趋势线的周期,时间级别
	public enum Period{
		quarter{public String getName(){return "季度";}},
		month{public String getName(){return "月";}},
		week{public String getName(){return "周";}},
		days{public String getName(){return "日";}},
		hours{public String getName(){return "时";}},
		min30{public String getName(){return "30分钟";}},
		min15{public String getName(){return "15分钟";}},
		min5{public String getName(){return "5分钟";}},
		min1{public String getName(){return "1分钟";}},
		mins{public String getName(){return "分钟";}};
		public abstract String getName();
	}
}
