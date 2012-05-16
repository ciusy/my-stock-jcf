package leo.os.service.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

public interface GiveGhService {
	/**
	 * ������п���
	 * @return
	 */
	public List<Osuform> getRegestUFormByMid(int mid);
	/**
	 * ͨ���������ͻ�ÿ���ID�Ϳ�������
	 * @param rtId ��������ID
	 * @return
	 */
	public String[] getUformByRidAndMid(int rtId,int mid);
	/**
	 * ͨ������ID���Ҷ�Ӧ��ר��ҽ��
	 * @param uid ����ID
	 * @return
	 */
	public List<Osstuff> getExpertStuffByUid(int uid);
	/**
	 * ����ҽ�ƻ���id��ѯҽ�ƻ�������
	 * @param mid
	 * @return
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid);
	/**
	 * ͨ��ҽ�ƻ���ID��ÿ�������
	 * @param mid ҽ�ƻ���id
	 * @return
	 */
	public List<Osuform> getRegisterDivaricateUByMid(int mid);
	/**
	 * ͨ��ID���ҽ����Ա����
	 * @param uid ҽ����ԱID
	 * @return
	 */
	public String getSNameBySid(long sid);
	public int getUidByUName(int mid , String uname);
}
