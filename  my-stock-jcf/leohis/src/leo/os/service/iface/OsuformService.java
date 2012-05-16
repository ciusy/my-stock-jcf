package leo.os.service.iface;

import java.util.List;

import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.entity.OsunitHasS;


public interface OsuformService {

	/**
	 * ͨ��ID��ÿ�������
	 * @param uid ����ID
	 * @return
	 */
	public String getUNameByUid(int uid);
	/**
	 * ͨ��ID��ÿ��Ҷ���
	 * @param uid ����ID
	 * @return
	 */
	public Osuform getOsuformByUid(int uid);
	/**
	 * ͨ����������ҽ�ƻ���ID��ÿ���ID�Ϳ�������
	 * @param oType ������� ��mid ҽ�ƻ���ID
	 * @return
	 */
	public String[][] getUformByOTypeAndMid(String oType , int mid);
	/**
	 * added by Li Chenghai
	 * ͨ��Ա��ID�Ϳ�����𷵻�ȫ������ID�����ƣ����ؿ���˳��ɴ�oTypename�ж���
	 * @param sid Ա��ID
	 * @return
	 */
	public String[][] getUidBySidAndOType(int sid,String[] otypename);
	
	/*
	 * added by sun
	 * ������LIд�ģ��Լ�Ҫ���ã�����service��Ľӿ�
	 */
	
public String[][] getUidBySidAndOTypeForBchao(int sid,String otypename);
	
	/*
	 * added by sun
	 * ������LIд�ģ��Լ�Ҫ���ã�����service��Ľӿ�
	 */
	
	public int getUidByUName(int mid , String uname);
	
	/**
	 * ����ҽ�ƻ���ID�Ϳ������Ͳ�ѯ����
	 * @param meiId ҽ�ƻ���ID
	 * @param oType	��������
	 * @return	���Ҽ���
	 */
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType);
	/**
	 * ���ݿ���ID��ѯ���Ҷ�Ӧ�Ĺ���
	 * @param uid
	 * @return
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid);
	/**
	 * ��ȡ������������Ŀ������ƺ�ID
	 * @param oType
	 * @param mid
	 * @return
	 */
	public String[][] getUformNotType(String oType , int mid);
	/**
	 * ͨ��ҽ�ƻ���ID��ÿ����б�
	 * @param mid
	 * @return
	 */
	public List<Osuform> getUFormByMid(Integer mid);
	/**
	 * ��ӿ���
	 * @param osuform
	 * @return
	 */
	public boolean addUForm(Osuform osuform);
	/**
	 * �޸Ŀ���
	 * @param osuform
	 * @return
	 */
	public boolean updateUForm(Osuform osuform);
	/**
	 * ɾ������
	 * @param osuform
	 * @return
	 */
	public boolean deleteUForm(Osuform osuform);
	/**
	 * ͨ������ID��ѯ������Ա
	 * @param uid
	 * @return
	 */
	public List<OsunitHasS> getOsunitHasSByUid(int uid);
	/**
	 * ��ѯȫ��ҽ�ƻ���
	 * @return
	 */
	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo();
	/**
	 * ��ӿ�����Ա
	 * @param osunitHasS
	 * @return
	 */
	public boolean addOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * �޸Ŀ�����Ա
	 * @param osunitHasS
	 * @return
	 */
	public boolean updateOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * ɾ��������Ա
	 * @param osunitHasS
	 * @return
	 */
	public boolean deleteOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * ͨ��sid�������Ա
	 * @param sid
	 * @return
	 */
	public List<OsunitHasS> getOsunitHasSBySid(long sid);
	/**
	 * ɾ��sid����Ա����
	 * @param sid
	 * @return
	 */
	public boolean deleteOsunitHasSBySid(long sid);
	/**
	 * ͨ��sid uid�����Ա����
	 * @param sid
	 * @param uidlist
	 * @return
	 */
	public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist);
}
