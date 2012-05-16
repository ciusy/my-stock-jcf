package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Osstuff;

public interface OsstuffDao extends Dao<Osstuff> {
	/**
	 * ͨ����¼����������Ҷ�ӦԱ��
	 * 
	 * @param loginname
	 *            ��¼��
	 * @param password
	 *            ����
	 * @return
	 */
	public Osstuff getStuffByNameAndPassword(String loginname, String password);
	/**
	 * ͨ��Ա��ID
	 * 
	 * @param sid
	 *           
	 * 
	 *           
	 * @return
	 */
	public Osstuff getStuffBySid(Long sid);

	/**
	 * ͨ������ID���Ҷ�Ӧ��ר��ҽ��
	 * 
	 * @param uid
	 *            ����ID
	 * @return
	 */
	public List<Osstuff> getExpertStuffByUid(int uid);

	/**
	 * add by xu ����ids���ϲ������е�ҽ����Ա
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids);

	/**
	 * add by zhong �����û�����:�������Ϊ�û�����ԭ���룬�����룬ȷ�ϵ������룬�����Ƿ��޸ĳɹ����ַ�����
	 * 
	 */
	public String changePassword(String loginname, String oldpassword, String newpassword1, String newpassword2);

	/**
	 * ������ר�ҵ�ҽ����Ա
	 * 
	 * @return
	 */
	public List<Osstuff> getExpertSBasicInfo(int uid);

	public List<Osstuff> getOsstuff(Integer meiid); // ����ҽ�ƽṹ���ع�����Ա

	/**
	 * ͨ��ID���ҽ����Ա����
	 * 
	 * @param uid
	 *            ҽ����ԱID
	 * @return
	 */
	public String getSNameBySid(long sid);

	/**
	 * add bu xu
	 * @param medicalOrgnizal 
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal);

	/**
	 * add by xu
	 * @param medicalOrgnizal 
	 * 
	 * @param spellName
	 * @return
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal, String name, Boolean isSpell);
	
	/**
	 * ����Ա��ID��ȡ�������
	 * @param SID Ա��ID
	 * @return
	 */
	public Double getYuE(Long SID);
	/**
	 * ���ݿ���ID��ȡ��Ա���ƺͱ��
	 * @param ksid //����ID
	 * @param ZhiCheng //ְ��
	 * @return
	 */
	public String[][] getNameAndID(Integer ksid, String ZhiCheng);
	/**
	 * ��ȡԱ��
	 * @param sname ����
	 * @param spell ƴ����д
	 * @param zige �ʸ�����
	 * @param zhiwu ����ְ��
	 * @param bianzhi ��������
	 * @param uid Ĭ�Ͽ���
	 * @param mid ����ҽ�ƻ���
	 * @return
	 */
	public List<Osstuff> getOsstuffBycondition(String sname,String spell,String zige,String zhiwu,String bianzhi,int uid,int mid);
	public boolean addOsstuff(Osstuff osstuff);
	public boolean updateOsstuff(Osstuff osstuff);
	public boolean deleteOsstuff(Osstuff osstuff);
	/**
	 * ����ҽ�ƻ����͵�¼���Ʋ����Ƿ����
	 * @param lgname ��¼����
	 * @param mid ҽ�ƻ���ID
	 * @param SID Ա��ID (-2�����Դ������������޸��ж�)
	 * @return
	 */
	public boolean loginname(String lgname,int mid,Long SID);
	public Osstuff getOsstuffByLoginname(String lgname,int mid);
	/**
	 * ����Ա��IDɾ��Ա��
	 * @param SID Ա��ID
	 * @return
	 */
	public boolean delOsstuffById(Long SID);
	/**
	 * �޸�Ա���û���������
	 * @param SID Ա��ID
	 * @param LoginName �û���
	 * @param Password ����
	 * @return
	 */
	public boolean updateYongHu(Long SID, String LoginName, String Password);
	/**
	 * �ж��û���¼�����Ƿ����
	 * @param LoginName ��¼����
	 * @param SID Ա��ID
	 * @return true ����  false ������
	 */
	public boolean getYongHuCunZai(String LoginName, Long SID);
	 public String[][] getsnamesidbyuid(int uid);
}
