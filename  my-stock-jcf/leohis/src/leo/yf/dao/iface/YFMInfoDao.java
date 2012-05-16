package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmdosageUnit;
import leo.entity.Yfminfo;

public interface YFMInfoDao extends Dao<Yfminfo>{
	public List<Yfminfo> getYFMInfo(String MName, String spell, Integer MInfoID,Integer MedicalInstitutionID); // getyFMInfo接口
	public boolean addYFInsertMInfoDao(Yfminfo yfminfo);
	public boolean delYFMInfo(Integer minfoid);
	public boolean updateYFMInfo(Yfminfo yfminfo);
	public Integer getYFMinfoID(); //返回最新加入的药品信息ID
	public String[][] getYFMInfo_Alias(String MName, String spell); //按照药品名称和别名查找
	/*
    根据药品信息ID得到药库单位，药房单位，转换率
0 药库单位,
1药房单位,
2转换率
*/ 	public String[][] getUnit(Integer minfoid);
	public String[][] getYFMInfo_Stock(String MName, String spell, Integer MedicalInstitutionID, Integer PharmacyID); //按照药品名称和别名查找，查找某一药房有库存的药品
/**
 * 按类型提取药品信息	
 * @param type
 * @return
 */
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
