package leo.gy.service.iface;

import java.util.List;

import leo.entity.GydisinfectPackUseRe;

public interface GetCountOfGydisinfectPackUseReService {
	// �鿴�����������޾���
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit();

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit);

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN);

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit, String DPN);
	
	//�鿴�����������޾���
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow();
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(String DPN);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit,String DPN);
	
	//�����޾���ID��ѯ����ʹ�ü�¼�����ѹ黹ʱ������
	public boolean ModifyGydisinfectPackBackTime(int id);
	//��������ʹ�ü�¼�������һ������
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g);
	
	//�޾����黹���������޾����黹ҳ�棬�����޾���Id������id��ʹ�ü�¼�����״̬Ϊû�黹�ģ�false����
	public boolean BackGydisinfectPack(int id,int u);

	//ʹ����ϸ
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN);

	public Long getUidByDpid(int dpid);
	public boolean deleteUseInfo(Long UseId);
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount);
	public boolean setghByDpidandRt(int Dpid);
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did);
}
