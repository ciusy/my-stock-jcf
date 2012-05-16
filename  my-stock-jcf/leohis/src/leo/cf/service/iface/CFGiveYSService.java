package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;

public interface CFGiveYSService {
	/**
	 * ��ѯ����ʡ
	 * 
	 * @return
	 */
	public List<Cfprovince> getCfprovinceAll();

	/**
	 * ����ʡID��ѯ������
	 * 
	 * @param provId
	 * @return
	 */
	public List<Cfcity> getCfcityByprovID(Integer provId);

	/**
	 * ������id��ѯ��
	 * 
	 * @param cityId
	 * @return
	 */
	public List<Cfprefecture> getCfprefectureBycityId(Integer cityId);

	/**
	 * �����ز�ѯ��
	 * 
	 * @param prefectureId
	 * @return
	 */
	public List<Cftown> getCftownByprefectureId(Long prefectureId);

	/**
	 * �������ѯ��
	 * 
	 * @param townId
	 * @return
	 */
	public List<Cfvillage> getCfvillageBytownId(Long townId);

	/**
	 * ���ݴ��ѯ��
	 * 
	 * @param villageId
	 * @return
	 */
	public List<Cfgroup> getCfgroupByvillageId(Long villageId);

	/**
	 * ����ʡid��ѯʡ��
	 * 
	 * @param provID
	 * @return
	 */
	public String getProvinceName(Integer provID);

	/**
	 * ������id��ѯ����
	 * 
	 * @param prefectureId
	 * @return
	 */
	public String getPrefectureByprefectureId(Long prefectureId);

	/**
	 * ��������id��ѯ��������
	 * 
	 * @param townId
	 * @return
	 */
	public String getTownNameBytownId(Long townId);

	/**
	 * ���ݴ�id��ѯ����
	 * 
	 * @param villageId
	 * @return
	 */
	public String getVillageNameByvillageId(Long villageId);
}
