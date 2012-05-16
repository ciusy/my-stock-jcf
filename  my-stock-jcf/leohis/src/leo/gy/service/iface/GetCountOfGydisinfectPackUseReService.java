package leo.gy.service.iface;

import java.util.List;

import leo.entity.GydisinfectPackUseRe;

public interface GetCountOfGydisinfectPackUseReService {
	// 查看本科室所有无菌包
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit();

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit);

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN);

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit, String DPN);
	
	//查看本科室领用无菌包
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow();
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(String DPN);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit,String DPN);
	
	//根据无菌包ID查询出来使用记录，并把归还时间填上
	public boolean ModifyGydisinfectPackBackTime(int id);
	//向消毒包使用记录表里插入一条数据
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g);
	
	//无菌包归还方法用于无菌包归还页面，根据无菌包Id，科室id到使用记录表里查状态为没归还的（false），
	public boolean BackGydisinfectPack(int id,int u);

	//使用明细
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN);

	public Long getUidByDpid(int dpid);
	public boolean deleteUseInfo(Long UseId);
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount);
	public boolean setghByDpidandRt(int Dpid);
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did);
}
