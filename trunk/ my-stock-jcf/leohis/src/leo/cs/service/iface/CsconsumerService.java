package leo.cs.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsefileInfo;
import leo.entity.CsmarriageHistory;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;
import leo.entity.GhmrCg;

public interface CsconsumerService {
	public Csconsumer getCInfoById(Long id);

	public Boolean addCsconsumerInfo(Csconsumer csconsumer);// 添加服务对象信息

	public Boolean updateCsconsumerInfo(Csconsumer csconsumer);// 更新服务对象信息

	/**
	 * add by xu
	 * 根据id集合返回服务对象
	 * @param ids
	 * @return
	 */
	List<Csconsumer> getByIds(List<Long> ids);
	
	/*根据姓名，或姓名拼音缩写，或身份证号，或医疗卡号，或地址（县，镇，村）找到消费者*/
	public String[][] getCInfo(String csname,String spell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	//	public String[][] getCInfo(String csname,String nameForShort,String idcardNum,String prefecture,String town,String village,String medicalCardNum);
	public CsmedicalCard getCsmedicalCardByCsid(long csid);
	/**
	 * 添加医疗卡
	 * 
	 * @param csmedicalCard
	 * @return
	 */
	public Boolean addCsmedicalCard(CsmedicalCard csmedicalCard);
	/**
	 * 修改医疗卡
	 * 
	 * @param csmedicalCard
	 * @return
	 */
	public Boolean updateCsmedicalCard(CsmedicalCard csmedicalCard);
	/**
	 * 查询医疗卡
	 * 
	 * @param csid
	 * @return
	 */
	public CsmedicalCard getCsmedicalCardOnlyByCsid(long csid);
	/**
	 * 查询医疗卡详单
	 * 
	 * @param stdate eddate csid
	 * @return
	 */
	public String[][] getCsmedicalCardDetailByDateandcsid(
			String stdate, String eddate, long csid); 
	/**
	 * 添加医疗卡详单
	 * 
	 * @param csmedicalCardDetail
	 * @return
	 */
	public Boolean addCsmedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail);
	/**
	 * 通过医疗卡查询服务对象
	 * 
	 * @param medicalCardNum
	 * @return
	 */
	public long getCsIDByMedicalCardNum(String medicalCardNum);
	
	public Csconsumer getCInfoByIDCardNum(String idCardNum);
	
	/**
	 * 计算用户年龄 
	 * @param  useryear,sdata
	 * @return number
	 */
	public int getCountAge(String useryear , String sdate);
	
	public List<Csconsumer> getByBirthTime(String startTime,String endTime);

	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard, int flag);
	
	public boolean addGhmrCg(GhmrCg ghmrCg);
	/**
	 * 通过csID获得电子病历
	 * @param csID
	 * @return
	 */
	public CsefileInfo getCsefileInfoByCsID(long csID);
	/**
	 * 通过csID获得结婚史
	 * @param csID
	 * @return
	 */
	public List<CsmarriageHistory> getCsmarriageHistoryByCsID(Long csID);

	/**
	 * 添加电子病历
	 * @param csefileInfo
	 * @return
	 */
	public boolean addCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * 修改电子病历
	 * @param csefileInfo
	 * @return
	 */
	public boolean updateCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * 删除电子病历
	 * @param csefileInfo
	 * @return
	 */
	public boolean deleteCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * 添加婚姻历史
	 * @param csmarriageHistory
	 * @return
	 */
	public boolean addCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    /**
     * 更改婚姻历史
     * @param csmarriageHistory
     * @return
     */
	public boolean updateCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    /**
     * 删除婚姻历史
     * @param csmarriageHistory
     * @return
     */
	public boolean deleteCsmarriageHistory(CsmarriageHistory csmarriageHistory);
	/**
	 * 通过主键获得婚姻史
	 * @param id
	 * @return
	 */
	public CsmarriageHistory getCsmarriageHistoryByID(long id);
	/**
	 * 姓名 拼音 身份证 查询
	 * @param csname
	 * @param spell
	 * @param IDcardnum
	 * @return
	 */
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,String spell,String IDcardnum);
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	/**
	 * 提取服务对象(电子病历使用)
	 * @param Date_B 挂号开始日期
	 * @param Date_e 挂号结束日期
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param YiLiaoJiGou 医疗机构
	 * @param ShiFouChuYuan 是否出院
	 * @param LeiXing 类型(门诊,在院,出院,服务对象)
	 * @return
	 */
	public String[][] getFuWuDuiXian(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou, Integer ShiFouChuYuan, String LeiXing);

	public List<GhmrCg> getGhmrCgfortg(long sid, String stdate,String eddate) throws Exception;

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
	
	/**
	 * 根据省ID返回市
	 * @param ShengId 省ID
	 * @return
	 */
	public List<Cfcity> getShiJiLieBiao(Integer ShengId);
	/**
	 * 根据市ID返回县
	 * @param ShiId 市ID
	 * @return
	 */
	public List<Cfprefecture> getXianJiLieBiao(long ShiId); 
	/**
	 * 根据县ID返回乡镇
	 * @param prefectureId
	 * @return
	 */
	public  List<Cftown> getXiangJiLieBiao(long  XianID);
	/**
	 * 根据乡ID返回村
	 * @param XiangId
	 * @return
	 */
	public List<Cfvillage> getCunJiLieBiao(long XiangId);
	


}
