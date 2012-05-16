package leo.cs.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Csconsumer;

public interface CsconsumerDao extends Dao<Csconsumer> {
	public Csconsumer getCInfoById(Long id);//根据服务对象ID查找服务对象
	public Boolean addCsconsumerInfo(Csconsumer csconsumer);//添加服务对象信息
	public Boolean updateCsconsumerInfo(Csconsumer csconsumer);//更新服务对象信息
	
	/*根据姓名，或姓名拼音缩写，或身份证号，或医疗卡号，或地址（县，镇，村）找到消费者*/
	public String[][] getCInfo(String csname,String spell,String idcardNum,String prefecture,String town,String village,String tgroup,String medicalCardNum);

	/**
	 * add by xu 根据id集合返回服务对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<Csconsumer> getByIds(List<Long> ids);
	
	/**
	 * 根据身份证号查询服务对象
	 * @param idCardNum
	 * @return
	 */
	public Csconsumer getCInfoByIDCardNum(String idCardNum);
	
	/**
	 * 计算用户年龄 
	 * @param  useryear,sdata
	 * @return number
	 */
	public int getCountAge(String useryear , String sdate);
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<Csconsumer> getByLikeValue(String value, boolean isSpell);
	
	/**
	 * 根据出生日期返回服务对象
	 * @param 
	 * @return 
	 */
	public List<Csconsumer> getByBirthTime(String startTime,String endTime);
	public List<Csconsumer> getByAge(String nowTime,String csage);
	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard, int flag);
	/**
	 * 根据条件提取服务对象
	 * @param Shi 市
	 * @param Xian 县
	 * @param Xiang 乡
	 * @param Cun 村
	 * @param Zu 组
	 * @param ShengFenZheng 身份证 
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param FuWuDuiXiangID 服务对象ID
	 * @return
	 */
	public List<Csconsumer> getDuiXiangByHuShi(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie, Long FuWuDuiXiangID);
	
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,String spell,String IDcardnum);
	/**
	 * 修改农身体证号,农合号,手机
	 * @param CsID 服务对象ID
	 * @param IDCardNum 身份证号
	 * @param RuralCooperCode 农合号
	 * @param Cellphone 手机
	 * @return
	 */
	public boolean updateCSConsumerZhuYuan(Long CsID, String IDCardNum, String RuralCooperCode, String Cellphone);
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	
	/**
	 * 提取服务对象表(电子病历使用)
	 * @param Shi 市
	 * @param Xian 县
	 * @param Xiang 乡
	 * @param Cun 村
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @return
	 */
	public String[][] getFuWuDuiXiangBiao(String Shi, String Xian, String Xiang, String Cun, String XingMing, String XingMingSuoXie);
	
}