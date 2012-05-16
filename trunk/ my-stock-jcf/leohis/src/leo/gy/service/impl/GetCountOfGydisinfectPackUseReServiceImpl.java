package leo.gy.service.impl;

import java.util.List;

import leo.gy.service.iface.GetCountOfGydisinfectPackUseReService;
import leo.entity.GydisinfectPackUseRe;

import leo.gy.dao.iface.GydisinfectPackUseReDao;

public class GetCountOfGydisinfectPackUseReServiceImpl implements
		GetCountOfGydisinfectPackUseReService {
	GydisinfectPackUseReDao gdao;

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit() {
		return gdao.getAllGydisinfectPackInUnit();
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit) {
		return gdao.getAllGydisinfectPackInUnit(Unit);
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN) {
		return gdao.getAllGydisinfectPackInUnit(DPN);
	}

	// public String[][] getAllGydisinfectPackInfo(int Unit,String DPN){
	// return gdao.getAllGydisinfectPackInfo(Unit,DPN);
	// }
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit,
			String DPN) {
		return gdao.getAllGydisinfectPackInUnit(Unit, DPN);
	}
	
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow() {
		return gdao.getAllGydisinfectPackInUnit();
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit) {
		return gdao.getAllGydisinfectPackInUnit(Unit);
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(String DPN) {
		return gdao.getAllGydisinfectPackBorrow(DPN);
	}

	// public String[][] getAllGydisinfectPackInfo(int Unit,String DPN){
	// return gdao.getAllGydisinfectPackInfo(Unit,DPN);
	// }
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit,
			String DPN) {
		return gdao.getAllGydisinfectPackBorrow(Unit, DPN);
	}
	
	//根据无菌包ID查询出来使用记录，并把归还时间填上
	public boolean ModifyGydisinfectPackBackTime(int id){
		return gdao.ModifyGydisinfectPackBackTime(id);
	}
	
	//向消毒包使用记录表里插入一条数据
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g){
		return gdao.addGydisinfectPackUseReInfo(g);
	}
	
	//无菌包归还方法用于无菌包归还页面，根据无菌包Id，科室id到使用记录表里查状态为没归还的（false），
	public boolean BackGydisinfectPack(int id,int u){
		return gdao.BackGydisinfectPack(id,u);
	}
	//使用明细
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN){
		return gdao.GetUseRe(StartDate,CutOffDate,strUnit,strDPN);
	}
	
	public void setGdao(GydisinfectPackUseReDao gdao) {
		this.gdao = gdao;
	}
	public Long getUidByDpid(int dpid)
	{
		return gdao.getUidByDpid(dpid);
	}
	public boolean deleteUseInfo(Long UseId)
	{
		return gdao.deleteUseInfo(UseId);
	}
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount)
	{
		return gdao.setDtByDpidandDt(Dpid,Uid,amount);
	}
	public boolean setghByDpidandRt(int Dpid)
	{
		return gdao.setghByDpidandRt(Dpid);
	}
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did)
	{
		return gdao.getmxByDtandRtandUidandDid(Dt, Rt, Uid, Did);
	}
}
