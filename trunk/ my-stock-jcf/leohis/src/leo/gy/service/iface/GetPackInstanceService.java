package leo.gy.service.iface;

import java.util.List;
import leo.entity.GydisinfectPackInstance;



public interface GetPackInstanceService {
	public List<GydisinfectPackInstance> getAllPackKindInstance();
	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance);
	public boolean deletePackInstance(Integer DisinfectPackID);
	public boolean updatePackInstance(GydisinfectPackInstance disinfectPackInstance);
	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID);
	
	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID);
	
	//mkj�޾�������--�������ÿ��Һ��޾������ͽ��ж�ȡ
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid);
	//mkj�޾�������--����IDȥ������ʵ����
	public boolean ModifyProvidePackInstanceById(int id,int intU);
	
	//mkj�޾����黹--�������ÿ��Һ��޾������ͽ��ж�ȡ����������״̬DisinfectPackStatus��������
	//��������ǰ���ڿ���UDisinfectPackIn�����ÿ���
	public List<GydisinfectPackInstance> GetPackInstanceBack(String Uid,String Did,int UIid);
	
	//mkj�޾����黹--����IDȥ������ʵ����GYDisinfectPackInstance���ҵ��������ݸ������ڿ���UDisinfectPackInΪ��Ӧ�ң�
	//������״̬DisinfectPackStatusΪ��������
	public boolean BackProvidePackInstanceById(int id);
	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(int DID,int DPI,String DPS );
	public boolean setDPSByDPID(int dpid);
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd();
	public boolean setyxdByDPID(int dpid);
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid);
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did);
	public boolean setUBSpeakByDpidandUid(int dpid ,int uid);
	public List<GydisinfectPackInstance> getsqByUid(int Uid);
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did);
	public boolean setdpInByDpidandUid(int Dpid ,int Uid);
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did);
	public boolean setghByDpid(int Dpid);
}
