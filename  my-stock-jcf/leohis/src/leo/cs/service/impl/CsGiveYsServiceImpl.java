package leo.cs.service.impl;

import leo.common.util.ChineseToSpell;
import leo.common.validata.ifac.IValiData;
import leo.common.validata.impl.ValiDataImpl;
import leo.cs.dao.iface.CSConsumerInfoDao;
import leo.cs.dao.iface.CsconsumerDao;
import leo.cs.service.iface.CsGiveYsService;
import leo.entity.Csconsumer;
import leo.entity.CsconsumerInfo;
import leo.entity.OsmedicalInstInfo;
import leo.os.dao.iface.OsmedicalInstInfoDao;

public class CsGiveYsServiceImpl implements CsGiveYsService {
	OsmedicalInstInfoDao osmDao = null;
	CsconsumerDao csconsumerDao = null;
	CSConsumerInfoDao csconsumerinfoDao = null;
	public void setCsconsumerinfoDao(CSConsumerInfoDao csconsumerinfoDao) {
		this.csconsumerinfoDao = csconsumerinfoDao;
	}
	public void setCsconsumerDao(CsconsumerDao csconsumerDao) {
		this.csconsumerDao = csconsumerDao;
	}
	IValiData validata = new ValiDataImpl();
	public void setOsmDao(OsmedicalInstInfoDao osmDao) {
		this.osmDao = osmDao;
	}
	/**
	 * 通过ID获得医疗机构名称
	 * @param mid 医疗机构ID
	 * @return
	 */
	public String getOsmedicalInstInfoName(int mid) {
		
		return osmDao.getOsmedicalInstInfoName(mid);
	}
	/**
	 * 根据医疗机构ID查询医疗机构对象
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid) {
		// TODO Auto-generated method stub
		OsmedicalInstInfo osm = osmDao.getOsmedicalInstInfoById(mid);
		return osm;
	}
	/**
	 * Email验证
	 */
	public String valiEmail(String email) {
		// TODO Auto-generated method stub		
		return validata.valiEmail(email);
	}
	/**
	 * 根据中文生成拼音简码
	 */
	public String getSpell(String chinese){
		return ChineseToSpell.getPinYinHeadChar(chinese);
	}
	/**
	 * 新建服务对象
	 */
	public Boolean addCsconsumerInfo(Csconsumer csconsumer,
			CsconsumerInfo csconsumerinfo) {
		try {
			// 添加服务对象
			csconsumerDao.addCsconsumerInfo(csconsumer);
			// 根据身份证号查询服务对象
			Csconsumer csc = csconsumerDao.getCInfoByIDCardNum(csconsumer.getIdcardNum());
			// 添加服务对象附加信息			
			csconsumerinfo.setCsId(csc.getCsId());// 使用服务对象id作为主键添加服务对象附加信息
			csconsumerinfoDao.addCsconsumerInfo(csconsumerinfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据服务对象id查询服务对象
	 */
	public Csconsumer getCsconsumerByCsID(Long csId) {
		// TODO Auto-generated method stub
		return csconsumerDao.getCInfoById(csId);
	}
}
