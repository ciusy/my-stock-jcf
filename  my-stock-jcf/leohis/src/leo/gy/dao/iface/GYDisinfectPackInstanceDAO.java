package leo.gy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GydisinfectPackInstance;

public interface GYDisinfectPackInstanceDAO extends
		Dao<GydisinfectPackInstance> {
	// ��ȡ�����޾���״̬Ϊ�ǡ��ѱ��ϡ�����
	public List<GydisinfectPackInstance> getAllPackKindInstance();

	// ����һ������
	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance);

	// ɾ��һ������
	public boolean deletePackInstance(Integer DisinfectPackID);

	// ����һ������
	public boolean updatePackInstance(
			GydisinfectPackInstance disinfectPackInstance);


	/**
	 * ͨ��������ID����һ������
	 * @param DisinfectPackID int ������ID
	 * @return
	 */
	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID);
	
	//mkj�޾�������--�������ÿ��Һ��޾������ͽ��ж�ȡ
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid);
	
	//mkj�޾�������--����IDȥ������ʵ����GYDisinfectPackInstance���ҵ��������ݸ������ڿ���UDisinfectPackIn��
	//������״̬DisinfectPackStatus��ԤԼ����UBespeakֵΪ��
	public boolean ModifyProvidePackInstanceById(int id,int intU);
	
	//mkj�޾����黹--�������ÿ��Һ��޾������ͽ��ж�ȡ����������״̬DisinfectPackStatus��������
	//��������ǰ���ڿ���UDisinfectPackIn�����ÿ���
	//BUid�黹���ң�Did�޾�����UIid������
	public List<GydisinfectPackInstance> GetPackInstanceBack(String BUid,String Did,int UIid);
	
	//mkj�޾����黹--����IDȥ������ʵ����GYDisinfectPackInstance���ҵ��������ݸ������ڿ���UDisinfectPackInΪ��Ӧ�ң�
	//������״̬DisinfectPackStatusΪ��������
	public boolean BackProvidePackInstanceById(int id);

	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID);

	/**
	 * ͨ���޾�������ID�����ڿ��ҡ�������״̬����������� ��������Ϊ�գ�
	 * ����Ϊ�գ�����Ϊ����-2�� ���ȫΪ���򷵻���������
	 * 
	 * @param DID:�޾�������ID��DPI�����ڿ��ң�DPS��������״̬
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(
			int DID, int DPI, String DPS);

	/**
	 * ͨ���޾���ID�޸��޾�����״̬Ϊ���ѱ��ϡ�
	 * 
	 * @param int dpid �޾���ID
	 */
	public boolean setDPSByDPID(int dpid);
	/**
	 * ��ȡ���޾���״̬Ϊ��������"������
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd(); 
	/**
	 * ͨ���޾���ID�޸��޾���״̬Ϊ����������
	 * @param  int dpid
	 */
	public boolean setyxdByDPID(int dpid);
	/**
	 * ͨ������ID��ѯ���ڿ��ҵ����в��ǡ��ѱ��ϡ����޾���
	 * @param ����ID ��int Uid�� 
	 */
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid);
	/**
	 * ͨ���޾�������ID��ѯ���и����͵ġ����������롰���������޾���,
	 * ��ԤԼ����Ϊ-1����ԤԼ���޾�������IDΪ-2ʱ��ʾȫ�����͡�
	 * @param �޾�������ID ��int Did;
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did);
	/**
	 * ͨ��������ID�Ϳ���ID����ԤԼ����
	 * @param dpid  int ������ID
	 * @param uid  int ����ID
	 * @return
	 */
	public boolean setUBSpeakByDpidandUid(int dpid, int uid);
	/**
	 * ��ԤԼ����ID��ѯ��Ӧ��������ķǡ������á��޾�����
	 * @param Uid		int ԤԼ����ID
	 * @return
	 */
	public List<GydisinfectPackInstance> getsqByUid(int Uid);
	/**
	 * ͨ������ID���޾������Ͳ�ѯ�޾���ʵ����DidΪ-2ʱΪȫ�����ͣ��Ҳ��ǡ������á�
	 * @param Uid		int ԤԼ����ID
	 * @param Did		int �޾�������ID
	 * @return
	 */ 
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did);
	/**
	 * ͨ���޾���ID�����޾�����ǰ���ڿ���ΪUid,������״̬Ϊ�������á���
	 * @param Dpid			int �޾���ID
	 * @param Uid			int ����ID
	 * @return
	 */
	public boolean setdpInByDpidandUid(int Dpid ,int Uid);
	/**
	 * ͨ������ID���޾�������ID��ѯ������״̬Ϊ�������á�������
	 * @param Uid		int ����ID
	 * @param Did		int �޾�������ID		-2ʱΪȫ������
	 * @return
	 */
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did);
	/**
	 * ͨ��������ID�����޾������ڿ���Ϊ������ID��ԤԼ����Ϊ-1��������״̬Ϊ����������
	 * @param Dpid			int ������ID
	 * @return
	 */
	public boolean setghByDpid(int Dpid);

}
