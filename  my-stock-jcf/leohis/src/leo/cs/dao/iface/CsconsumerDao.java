package leo.cs.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Csconsumer;

public interface CsconsumerDao extends Dao<Csconsumer> {
	public Csconsumer getCInfoById(Long id);//���ݷ������ID���ҷ������
	public Boolean addCsconsumerInfo(Csconsumer csconsumer);//��ӷ��������Ϣ
	public Boolean updateCsconsumerInfo(Csconsumer csconsumer);//���·��������Ϣ
	
	/*����������������ƴ����д�������֤�ţ���ҽ�ƿ��ţ����ַ���أ��򣬴壩�ҵ�������*/
	public String[][] getCInfo(String csname,String spell,String idcardNum,String prefecture,String town,String village,String tgroup,String medicalCardNum);

	/**
	 * add by xu ����id���Ϸ��ط������
	 * 
	 * @param ids
	 * @return
	 */
	public List<Csconsumer> getByIds(List<Long> ids);
	
	/**
	 * �������֤�Ų�ѯ�������
	 * @param idCardNum
	 * @return
	 */
	public Csconsumer getCInfoByIDCardNum(String idCardNum);
	
	/**
	 * �����û����� 
	 * @param  useryear,sdata
	 * @return number
	 */
	public int getCountAge(String useryear , String sdate);
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<Csconsumer> getByLikeValue(String value, boolean isSpell);
	
	/**
	 * ���ݳ������ڷ��ط������
	 * @param 
	 * @return 
	 */
	public List<Csconsumer> getByBirthTime(String startTime,String endTime);
	public List<Csconsumer> getByAge(String nowTime,String csage);
	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard, int flag);
	/**
	 * ����������ȡ�������
	 * @param Shi ��
	 * @param Xian ��
	 * @param Xiang ��
	 * @param Cun ��
	 * @param Zu ��
	 * @param ShengFenZheng ���֤ 
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param FuWuDuiXiangID �������ID
	 * @return
	 */
	public List<Csconsumer> getDuiXiangByHuShi(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie, Long FuWuDuiXiangID);
	
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,String spell,String IDcardnum);
	/**
	 * �޸�ũ����֤��,ũ�Ϻ�,�ֻ�
	 * @param CsID �������ID
	 * @param IDCardNum ���֤��
	 * @param RuralCooperCode ũ�Ϻ�
	 * @param Cellphone �ֻ�
	 * @return
	 */
	public boolean updateCSConsumerZhuYuan(Long CsID, String IDCardNum, String RuralCooperCode, String Cellphone);
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	
	/**
	 * ��ȡ��������(���Ӳ���ʹ��)
	 * @param Shi ��
	 * @param Xian ��
	 * @param Xiang ��
	 * @param Cun ��
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @return
	 */
	public String[][] getFuWuDuiXiangBiao(String Shi, String Xian, String Xiang, String Cun, String XingMing, String XingMingSuoXie);
	
}