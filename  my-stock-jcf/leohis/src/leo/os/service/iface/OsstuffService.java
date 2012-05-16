package leo.os.service.iface;

import java.util.List;

import leo.entity.OsfnAuthorityForm;
import leo.entity.Osstuff;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 3, 2011 5:04:30 PM
 */
public interface OsstuffService {
	public List<Osstuff> getOsstuff(Integer meiid);
	public Osstuff getStuffBySid(Long sid);
	public String getSNameBySid(long sid);
	public Double getYuE(Long SID);
	public String[][] getNameAndID(Integer ksid, String ZhiCheng);
	/**
	 * ͨ��������ѯԱ��
	 * @param sname ����
	 * @param zige �ʸ�
	 * @param zhiwu ְ��
	 * @param bianzhi ����
	 * @param uid Ĭ�Ͽ���
	 * @param mid ����ҽ�ƻ���
	 * @return
	 */
	public List<Osstuff> getOsstuffBycondition(String sname,String spell,String zige,String zhiwu,String bianzhi,int uid,int mid);
	/**
	 * �����Ա
	 * @param osstuff Ա����Ϣ
	 * @param KeShiID ����ID(���ѡ��Ĭ�Ͽ���,���Զ����䵽�˿���,-2:���������)
	 * @param CaiDan �˵�
	 * @param MoRenCaiDan ��Ĭ�ϲ˵���
	 * @return
	 */
	public boolean addOsstuff(Osstuff osstuff, Integer KeShiID);
	/**
	 * �޸���Ա
	 * @param osstuff Ա����Ϣ
	 * @param YongGongID Ա��ID
	 * @param MoRenKeShi_Y ԭĬ�Ͽ���
	 * @param MoRenKeShi_X ��Ĭ�Ͽ���
	 * @return
	 */
	public boolean updateOsstuff(Osstuff osstuff, Long YongGongID, Integer MoRenKeShi_Y, Integer MoRenKeShi_X);
	/**
	 * ɾ����Ա
	 * @param osstuff
	 * @return
	 */
	public boolean deleteOsstuff(Osstuff osstuff);
	/**
	 * ����ҽ�ƻ����͵�¼���Ʋ����Ƿ����
	 * @param lgname ��¼����
	 * @param mid ҽ�ƻ���ID
	 * @param SID Ա��ID (-2�����Դ������������޸��ж�)
	 * @return
	 */
	public boolean loginname(String lgname,int mid,Long SID);
	/**
	 * ��ѯ������Ա
	 * @param lgname
	 * @param mid
	 * @return
	 */
	public Osstuff getOsstuffByLoginname(String lgname,int mid);
	/**
	 * ����Ա��IDɾ��Ա��
	 * @param SID Ա��ID
	 * @return
	 */
	public boolean delOsstuffById(Long SID);
	/**
	 * ���������Ա
	 * @param uid
	 * @return
	 */
	 public String[][] getsnamesidbyuid(int uid);
}
