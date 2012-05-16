package leo.os.service.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

/**
 * 
 * @author xuxiangpan
 * 
 */
public interface OsGiveSfService {

	/**
	 * add by xu 根据ids集合查找所有的医护人员
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids);

	/**
	 * 提供内部员工充值的初始界面使用 add bu xu
	 * 
	 * @param medicalOrgnizal
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal);

	/**
	 * 内部员工充值的初始界面查询按钮的操作
	 * 
	 * @param medicalOrgnizal
	 * @param name
	 *            拼音简码或者汉语名字
	 * @param isSpell
	 *            是否是拼音简码和汉语名字
	 * @return
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal,
			String name, Boolean isSpell);

	/**
	 * 修改员工的记帐单的余额
	 * 
	 * @param sid
	 * @param cash
	 */
	public void updateOsstuffCharageBalance(String sid, String cash);

	/**
	 * 根据医疗机构Id 和科室的类别获得这个类别的所有科室
	 * 
	 * @param medicalOrgnizal
	 * @param type
	 * @return
	 */
	public List<Osuform> getInpatientDept(Integer medicalOrgnizal, String type);

	/**
	 * 根据ids查询对应的所有的科室
	 * 
	 * @param osUFormIds
	 * @return
	 */
	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds);

	/**
	 * 根据医疗机构id查询其下面中的所有的科室
	 * 
	 * @param mid
	 * @return
	 */
	public List<Osuform> getUFormByMid(Integer mid);

	/**
	 * add by xu
	 * 
	 * @param id
	 * @return
	 */
	public Osuform getUFormById(Integer id);

	public OsmedicalInstInfo getMediacalInstInfoById(Integer id);
}
