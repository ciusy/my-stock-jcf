package leo.gy.dao.iface;

import java.util.List;

import leo.entity.GydisinfectPackInstance;
import leo.entity.GydisinfectPackUseRe;
import leo.entity.GysupplyDisinfectPackInfo;

public interface GydisinfectPackUseReDao {
	//�鿴�����������޾���
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit();
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit,String DPN);
	
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
	
	/**ʹ����ϸ
	 * 
	 * @param StartDate ��ʼʱ��
	 * @param CutOffDate ��ֹʱ��
	 * @param strUnit	���ÿ���
	 * @param strDPN	�޾�������
	 * @return
	 */
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN);
	/**
	 * ��������ID���ʹ�ÿ���Ϊ-1��ʹ��ID UseID
	 * ����Ϊ-1������ʱû�п���ʹ�ã�������������
	 * @param dpid   int ������ID
	 * @return  UseID int ʹ��ID
	 * added by Sun
	 */
	public Long getUidByDpid(int dpid);
	/**
	 * ͨ��ʹ��IDɾ��һ������
	 * @param UseId   int ʹ��ID
	 * @return
	 * added by sun
	 */
	public boolean deleteUseInfo(Long UseId);
	/**
	 * ͨ��������ID������ʱ��ΪĬ��ֵ��ȷ�������������Ѹ�������������ʱ���ֶθ���Ϊϵͳ��ǰʱ��
	 * 
	 * @param Dpid		int ������ID
	 * @param Uid      int ���������ڿ���ID
	 * @param amount   double һ��ʹ�÷���
	 * @return
	 * added by sun
	 */
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount);
	/**
	 * ͨ��������ID���Ƿ��ѻ�Ϊfalse��ȷ���������ݣ������Ƿ��ѻ�Ϊtrue���黹ʱ��Ϊϵͳ��ǰʱ��
	 * @param Dpid  	int ������ID
	 * @return
	 * added by sun
	 */
	public boolean setghByDpidandRt(int Dpid);
	/**
	 * ��Ӧ��ʹ�ã���������ʱ�䡢�黹ʱ�䡢���ҡ��޾������Ͳ�ѯ�޾���ʹ�ü�¼
	 * @param Dt		String  ����ʱ��
	 * @param Rt		String  �黹ʱ��
	 * @param Uid		int     ����ID
	 * @param Did		int     �޾�������ID
	 * @return
	 * added by sun
	 */
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did);

}
