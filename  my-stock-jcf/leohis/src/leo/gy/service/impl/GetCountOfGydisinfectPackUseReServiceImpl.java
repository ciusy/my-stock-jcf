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
	
	//�����޾���ID��ѯ����ʹ�ü�¼�����ѹ黹ʱ������
	public boolean ModifyGydisinfectPackBackTime(int id){
		return gdao.ModifyGydisinfectPackBackTime(id);
	}
	
	//��������ʹ�ü�¼�������һ������
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g){
		return gdao.addGydisinfectPackUseReInfo(g);
	}
	
	//�޾����黹���������޾����黹ҳ�棬�����޾���Id������id��ʹ�ü�¼�����״̬Ϊû�黹�ģ�false����
	public boolean BackGydisinfectPack(int id,int u){
		return gdao.BackGydisinfectPack(id,u);
	}
	//ʹ����ϸ
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
