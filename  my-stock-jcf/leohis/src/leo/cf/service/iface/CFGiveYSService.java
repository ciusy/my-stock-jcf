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
	 * 查询所有省
	 * 
	 * @return
	 */
	public List<Cfprovince> getCfprovinceAll();

	/**
	 * 根据省ID查询所有市
	 * 
	 * @param provId
	 * @return
	 */
	public List<Cfcity> getCfcityByprovID(Integer provId);

	/**
	 * 根据市id查询县
	 * 
	 * @param cityId
	 * @return
	 */
	public List<Cfprefecture> getCfprefectureBycityId(Integer cityId);

	/**
	 * 根据县查询乡
	 * 
	 * @param prefectureId
	 * @return
	 */
	public List<Cftown> getCftownByprefectureId(Long prefectureId);

	/**
	 * 根据乡查询村
	 * 
	 * @param townId
	 * @return
	 */
	public List<Cfvillage> getCfvillageBytownId(Long townId);

	/**
	 * 根据村查询组
	 * 
	 * @param villageId
	 * @return
	 */
	public List<Cfgroup> getCfgroupByvillageId(Long villageId);

	/**
	 * 根据省id查询省名
	 * 
	 * @param provID
	 * @return
	 */
	public String getProvinceName(Integer provID);

	/**
	 * 根据县id查询县名
	 * 
	 * @param prefectureId
	 * @return
	 */
	public String getPrefectureByprefectureId(Long prefectureId);

	/**
	 * 根据乡镇id查询乡镇名称
	 * 
	 * @param townId
	 * @return
	 */
	public String getTownNameBytownId(Long townId);

	/**
	 * 根据村id查询村名
	 * 
	 * @param villageId
	 * @return
	 */
	public String getVillageNameByvillageId(Long villageId);
}
