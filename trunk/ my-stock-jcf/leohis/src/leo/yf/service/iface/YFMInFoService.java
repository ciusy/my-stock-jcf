package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfminfo;

public interface YFMInFoService {
	public List<Yfminfo> getYFMInfo(String MName, String spell, Integer MInfoID,Integer MedicalInstitutionID); // getyFMInfo�ӿ�
	public boolean addYFInsertMInfoDao(Yfminfo yfminfo); 
	public boolean delYFMInfo(Integer minfoid);
	public boolean updateYFMInfo(Yfminfo yfminfo);
	public Integer getYFMinfoID();
	public String[][] getYFMInfo_Alias(String MName, String spell);
	public String[][] getUnit(Integer minfoid);
	public String[][] getYFMInfo_Stock(String MName, String spell, Integer MedicalInstitutionID, Integer PharmacyID);
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
