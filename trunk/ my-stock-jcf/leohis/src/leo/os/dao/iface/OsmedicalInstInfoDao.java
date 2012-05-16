package leo.os.dao.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;

public interface OsmedicalInstInfoDao {
	/**
	 * ͨ��ID���ҽ�ƻ�������
	 * @param mid ҽ�ƻ���ID
	 * @return
	 */
	public String getOsmedicalInstInfoName(int mid);
	/**
	 * ͨ��ID���ҽ�ƻ�������
	 * @param mid ҽ�ƻ���ID
	 * @return
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid);
	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo();
	/**
	 * ����ҽ�ƻ���
	 * @param osmedicalInstInfo ҽ�ƻ���
	 * @return
	 */
	public boolean addOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo);
	/**
	 * �޸�ҽ�ƻ���
	 * @param osmedicalInstInfo ҽ�ƻ���
	 * @return
	 */
	public boolean updateOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo);
}
