package leo.os.dao.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;

public interface OsmedicalInstInfoDao {
	/**
	 * 通过ID获得医疗机构名称
	 * @param mid 医疗机构ID
	 * @return
	 */
	public String getOsmedicalInstInfoName(int mid);
	/**
	 * 通过ID获得医疗机构对象
	 * @param mid 医疗机构ID
	 * @return
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid);
	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo();
	/**
	 * 保存医疗机构
	 * @param osmedicalInstInfo 医疗机构
	 * @return
	 */
	public boolean addOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo);
	/**
	 * 修改医疗机构
	 * @param osmedicalInstInfo 医疗机构
	 * @return
	 */
	public boolean updateOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo);
}
