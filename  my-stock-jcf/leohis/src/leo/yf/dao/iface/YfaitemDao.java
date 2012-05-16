package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfaitem;

public interface YfaitemDao extends Dao<Yfaitem>{
	public boolean addYfaitem(Yfaitem yfaitem); //增加采购组项目
	public String[][] getCaiGouBiaoTao(String aformid, String date_b, String date_e,Integer pid,String InbankStatus);
	/*
       aformid 申请单号
       date_b, 申请开始日期
       date_e, 申请结束日期
       pid, 药房科室id
       InbankStatus 状态
	 */
	
	/**
	 * 根据申请单号查询申请项
	 */
	public List<Yfaitem> getYfaitem(String AFormID); 
	public boolean delYfaitem(String AFormID); //按照入库申请单ID删除
	
}
