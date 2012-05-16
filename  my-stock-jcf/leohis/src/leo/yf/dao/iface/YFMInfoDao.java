package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmdosageUnit;
import leo.entity.Yfminfo;

public interface YFMInfoDao extends Dao<Yfminfo>{
	public List<Yfminfo> getYFMInfo(String MName, String spell, Integer MInfoID,Integer MedicalInstitutionID); // getyFMInfo�ӿ�
	public boolean addYFInsertMInfoDao(Yfminfo yfminfo);
	public boolean delYFMInfo(Integer minfoid);
	public boolean updateYFMInfo(Yfminfo yfminfo);
	public Integer getYFMinfoID(); //�������¼����ҩƷ��ϢID
	public String[][] getYFMInfo_Alias(String MName, String spell); //����ҩƷ���ƺͱ�������
	/*
    ����ҩƷ��ϢID�õ�ҩ�ⵥλ��ҩ����λ��ת����
0 ҩ�ⵥλ,
1ҩ����λ,
2ת����
*/ 	public String[][] getUnit(Integer minfoid);
	public String[][] getYFMInfo_Stock(String MName, String spell, Integer MedicalInstitutionID, Integer PharmacyID); //����ҩƷ���ƺͱ������ң�����ĳһҩ���п���ҩƷ
/**
 * ��������ȡҩƷ��Ϣ	
 * @param type
 * @return
 */
	public List<Yfminfo> getYFMInfoByStyle(String type);
	/**
	 * ����ҩƷ��ϢID��ѯҩƷ
	 * @param minfoId
	 * @return
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId);
	/**
	 * ����ƴ����дģ����ѯҩƷ��Ϣ
	 * @param spell ƴ����д
	 * @return
	 */
	public List<Yfminfo> getYfminfoBySpell(String spell);
	/**
	 * ����ҩƷ���ͺ�ҩ����ȡҩƷ��Ϣ
	 * @param YaoFanID ҩ��ID
	 * @param LeiXing ҩƷ����
	 * @return
	 */
	public String[][] getYaoPinXinXibyLeiXingYaoFang(Integer YaoFanID, String LeiXing);
	/**
	 * ��ѯ����ҩƷ
	 * @return
	 */
	public List<Yfminfo> getYFMinfoAll();
	/**
	 * ����ҩƷ���ƺ�ƴ����ѯҩƷ��Ϣ
	 * @param MName
	 * @param spell
	 * @return
	 */
	public List<Yfminfo> getYFMInfoAlias(String MName, String spell);
}
