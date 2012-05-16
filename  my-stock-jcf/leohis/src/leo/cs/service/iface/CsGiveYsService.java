package leo.cs.service.iface;

import leo.entity.Csconsumer;
import leo.entity.CsconsumerInfo;
import leo.entity.OsmedicalInstInfo;


/**
 * ��ǰ�����������
 * @author abc
 *
 */
public interface CsGiveYsService {
	
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
	
	/**
	 * Email��֤
	 * @param email��ַ
	 * @return ��֤���
	 */
	public String valiEmail(String email);
	/**
	 * ������������ƴ������
	 * @param chinese
	 * @return
	 */
	public String getSpell(String chinese);
	/**
	 * �½��������
	 * @param csconsumer �������
	 * @param csconsumerinfo ������󸽼���Ϣ
	 * @return
	 */
	public Boolean addCsconsumerInfo(Csconsumer csconsumer, CsconsumerInfo csconsumerinfo);
	/**
	 * ���ݷ������id��ѯ�������
	 * @param csId
	 * @return
	 */
	public Csconsumer getCsconsumerByCsID(Long csId);
}
