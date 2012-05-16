package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfinbankTypeSetting;

public interface YfinbankTypeSettingService {
	/**
	 * ���������������
	 * @param id ����ID
	 * @param PharmacyID ҩ��ID
	 * @param TypeName ��������
	 * @return
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSetting(Integer id, Integer PharmacyID, String TypeName);
	public boolean addYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting);
	public boolean delYfinbankTypeSetting(Integer id);
	public boolean updateYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting);
	/**
	 * ����������ѯ�������
	 * @param inbankTypeId
	 * @return
	 */
	public YfinbankTypeSetting getYfinbankTypeSettingByinbankTypeId(Integer inbankTypeId);
	/**
	 * ��ѯ�����������
	 * @return
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSettingAll();
}
