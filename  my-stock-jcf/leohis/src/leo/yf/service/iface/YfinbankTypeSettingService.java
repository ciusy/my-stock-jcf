package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfinbankTypeSetting;

public interface YfinbankTypeSettingService {
	/**
	 * 查找入库类型内容
	 * @param id 类型ID
	 * @param PharmacyID 药房ID
	 * @param TypeName 类型名称
	 * @return
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSetting(Integer id, Integer PharmacyID, String TypeName);
	public boolean addYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting);
	public boolean delYfinbankTypeSetting(Integer id);
	public boolean updateYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting);
	/**
	 * 根据主键查询入库类型
	 * @param inbankTypeId
	 * @return
	 */
	public YfinbankTypeSetting getYfinbankTypeSettingByinbankTypeId(Integer inbankTypeId);
	/**
	 * 查询所有入库类型
	 * @return
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSettingAll();
}
