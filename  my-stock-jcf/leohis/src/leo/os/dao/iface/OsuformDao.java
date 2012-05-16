package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

public interface OsuformDao extends Dao<Osuform> {
	/**
	 * ����ҽ����Ա�����Ŀ���(LoginService)����
	 * @param uid
	 * @return
	 */
	public Osuform getUformByUid(int uid);
	/**
	 * ���ҿɹҺŵĿ��� ��ghģ����ã�
	 * @return
	 */
	public List<Osuform> getRegestUFormByMid(int mid);
	/**
	 * ͨ��ҽ��ID���ҿ�������
	 * @param mid ҽ�ƻ���ID
	 * @return 
	 */
	public List<Osuform> getRegisterDivaricateUByMid(int mid);
	/**
	 * ͨ����������ID���ҿ���
	 * @param rId ��������Id
	 * @return 
	 */
	
	public String[] getUformByRidAndMid(int rtId,int uid);
	/**
	 * added by Li Chenghai
	 * ͨ��ID��ÿ�������
	 * @param uid ����ID
	 * @return
	 */
	public String getUNameByUid(int uid);
	/**
	 * added by Li Chenghai
	 * ͨ��ID��ÿ��Ҷ���
	 * @param uid ����ID
	 * @return
	 */
	public Osuform getOsuformByUid(int uid);
	/**
	 * added by Li Chenghai
	 * ͨ����������ҽ�ƻ���ID��ÿ���ID�Ϳ�������,��������Ϊ��
	 * @param oType ������� ��mid ҽ�ƻ���ID
	 * @return
	 */
	public String[][] getUformByOTypeAndMid(String oType , int mid);
	/**
	 * added by Li Chenghai
	 * ͨ��ҽ�ƻ���ID�Ϳ������ƻ�ÿ���
	 * @param mid ҽ�ƻ���  uname ��������
	 * @return
	 */
	public int getUidByUName(int mid , String uname);
	/**
	 * added by Li Chenghai
	 * ͨ��Ա��ID�Ϳ�����𷵻�ȫ������ID�����ƣ����ؿ���˳��ɴ�oTypename�ж���
	 * @param sid Ա��ID
	 * @return
	 */
	public String[][] getUidBySidAndOType(int sid,String[] otypename);
	
	/**
	 * ����ҽ�ƻ���ID�Ϳ������Ͳ�ѯ����
	 * @param meiId ҽ�ƻ���ID
	 * @param oType	��������
	 * @return	���Ҽ���
	 */
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType);
	/** 
	 * add by xu 
	 * @param osUFormIds
	 * @return
	 */
	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds);
	/**
	 * ��ȡ������������Ŀ������ƺ�ID
	 * @param oType
	 * @param mid
	 * @return
	 */
	public String[][] getUformNotType(String oType , int mid);
	public List<Osuform> getUFormByMid(Integer mid);
	public boolean addUForm(Osuform osuform);
	/**
	 * �޸Ŀ���
	 * @param osuform
	 * @return
	 */
	public boolean updateUForm(Osuform osuform);
	public boolean deleteUForm(Osuform osuform);
	/**
	 * ���տ���IDɾ������
	 * @param ID����ID
	 * @return
	 */
	public boolean delUformByID(Integer ID);
	
}
