package leo.os.service.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

/**
 * 
 * @author xuxiangpan
 * 
 */
public interface OsGiveSfService {

	/**
	 * add by xu ����ids���ϲ������е�ҽ����Ա
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids);

	/**
	 * �ṩ�ڲ�Ա����ֵ�ĳ�ʼ����ʹ�� add bu xu
	 * 
	 * @param medicalOrgnizal
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal);

	/**
	 * �ڲ�Ա����ֵ�ĳ�ʼ�����ѯ��ť�Ĳ���
	 * 
	 * @param medicalOrgnizal
	 * @param name
	 *            ƴ��������ߺ�������
	 * @param isSpell
	 *            �Ƿ���ƴ������ͺ�������
	 * @return
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal,
			String name, Boolean isSpell);

	/**
	 * �޸�Ա���ļ��ʵ������
	 * 
	 * @param sid
	 * @param cash
	 */
	public void updateOsstuffCharageBalance(String sid, String cash);

	/**
	 * ����ҽ�ƻ���Id �Ϳ��ҵ����������������п���
	 * 
	 * @param medicalOrgnizal
	 * @param type
	 * @return
	 */
	public List<Osuform> getInpatientDept(Integer medicalOrgnizal, String type);

	/**
	 * ����ids��ѯ��Ӧ�����еĿ���
	 * 
	 * @param osUFormIds
	 * @return
	 */
	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds);

	/**
	 * ����ҽ�ƻ���id��ѯ�������е����еĿ���
	 * 
	 * @param mid
	 * @return
	 */
	public List<Osuform> getUFormByMid(Integer mid);

	/**
	 * add by xu
	 * 
	 * @param id
	 * @return
	 */
	public Osuform getUFormById(Integer id);

	public OsmedicalInstInfo getMediacalInstInfoById(Integer id);
}
