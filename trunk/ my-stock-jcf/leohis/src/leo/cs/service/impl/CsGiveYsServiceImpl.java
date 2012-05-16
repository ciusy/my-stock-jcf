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
	 * ͨ��ID���ҽ�ƻ�������
	 * @param mid ҽ�ƻ���ID
	 * @return
	 */
	public String getOsmedicalInstInfoName(int mid) {
		
		return osmDao.getOsmedicalInstInfoName(mid);
	}
	/**
	 * ����ҽ�ƻ���ID��ѯҽ�ƻ�������
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid) {
		// TODO Auto-generated method stub
		OsmedicalInstInfo osm = osmDao.getOsmedicalInstInfoById(mid);
		return osm;
	}
	/**
	 * Email��֤
	 */
	public String valiEmail(String email) {
		// TODO Auto-generated method stub		
		return validata.valiEmail(email);
	}
	/**
	 * ������������ƴ������
	 */
	public String getSpell(String chinese){
		return ChineseToSpell.getPinYinHeadChar(chinese);
	}
	/**
	 * �½��������
	 */
	public Boolean addCsconsumerInfo(Csconsumer csconsumer,
			CsconsumerInfo csconsumerinfo) {
		try {
			// ��ӷ������
			csconsumerDao.addCsconsumerInfo(csconsumer);
			// �������֤�Ų�ѯ�������
			Csconsumer csc = csconsumerDao.getCInfoByIDCardNum(csconsumer.getIdcardNum());
			// ��ӷ�����󸽼���Ϣ			
			csconsumerinfo.setCsId(csc.getCsId());// ʹ�÷������id��Ϊ������ӷ�����󸽼���Ϣ
			csconsumerinfoDao.addCsconsumerInfo(csconsumerinfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ���ݷ������id��ѯ�������
	 */
	public Csconsumer getCsconsumerByCsID(Long csId) {
		// TODO Auto-generated method stub
		return csconsumerDao.getCInfoById(csId);
	}
}
