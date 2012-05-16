package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfminfo;

public interface YFMInFoService {
	public List<Yfminfo> getYFMInfo(String MName, String spell, Integer MInfoID,Integer MedicalInstitutionID); // getyFMInfo接口
	public boolean addYFInsertMInfoDao(Yfminfo yfminfo); 
	public boolean delYFMInfo(Integer minfoid);
	public boolean updateYFMInfo(Yfminfo yfminfo);
	public Integer getYFMinfoID();
	public String[][] getYFMInfo_Alias(String MName, String spell);
	public String[][] getUnit(Integer minfoid);
	public String[][] getYFMInfo_Stock(String MName, String spell, Integer MedicalInstitutionID, Integer PharmacyID);
	public List<Yfminfo> getYFMInfoByStyle(String type);
	/**
	 * 根据药品信息ID查询药品
	 * @param minfoId
	 * @return
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId);
	/**
	 * 根据拼音缩写模糊查询药品信息
	 * @param spell 拼音缩写
	 * @return
	 */
	public List<Yfminfo> getYfminfoBySpell(String spell);
	/**
	 * 按照药品类型和药房提取药品信息
	 * @param YaoFanID 药房ID
	 * @param LeiXing 药品类型
	 * @return
	 */
	public String[][] getYaoPinXinXibyLeiXingYaoFang(Integer YaoFanID, String LeiXing);
	/**
	 * 查询所有药品
	 * @return
	 */
	public List<Yfminfo> getYFMinfoAll();
	/**
	 * 重载药品名称和拼音查询药品信息
	 * @param MName
	 * @param spell
	 * @return
	 */
	public List<Yfminfo> getYFMInfoAlias(String MName, String spell);
}
