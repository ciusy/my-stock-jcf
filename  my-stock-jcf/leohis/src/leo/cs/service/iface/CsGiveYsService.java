package leo.cs.service.iface;

import leo.entity.Csconsumer;
import leo.entity.CsconsumerInfo;
import leo.entity.OsmedicalInstInfo;


/**
 * 孕前优生服务对象
 * @author abc
 *
 */
public interface CsGiveYsService {
	
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
	
	/**
	 * Email验证
	 * @param email地址
	 * @return 验证结果
	 */
	public String valiEmail(String email);
	/**
	 * 根据中文生成拼音简码
	 * @param chinese
	 * @return
	 */
	public String getSpell(String chinese);
	/**
	 * 新建服务对象
	 * @param csconsumer 服务对象
	 * @param csconsumerinfo 服务对象附加信息
	 * @return
	 */
	public Boolean addCsconsumerInfo(Csconsumer csconsumer, CsconsumerInfo csconsumerinfo);
	/**
	 * 根据服务对象id查询服务对象
	 * @param csId
	 * @return
	 */
	public Csconsumer getCsconsumerByCsID(Long csId);
}
