package leo.ys.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import leo.common.util.CommonUtil;
import leo.common.util.DateUtil;
import leo.entity.Czdispose;
import leo.entity.Ghregister;
import leo.entity.MzopDn;
import leo.gh.dao.iface.GhregisterDao;
import leo.gh.dao.iface.GhregisterTypeDao;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.mz.dao.iface.MzopDnDao;
import leo.ys.service.iface.YSZhanNeiService;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.bc.dao.iface.CzshbioIsreDao;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;

public class YSZhanNeiServiceImpl implements YSZhanNeiService {
	private GhregisterDao ghregisterDao;
	private GhregisterTypeDao ghregisterTypeDao;
	private MzopDnDao mzopDnDao;
	private MzCzdisposeDao mzCzdisposeDao;
	private CzshbioIsreDao czshbioIsreDao;
	private MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao;

	
	public void setMzCzdisposeItemDescribeDao(
			MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao) {
		this.mzCzdisposeItemDescribeDao = mzCzdisposeItemDescribeDao;
	}

	public void setCzshbioIsreDao(CzshbioIsreDao czshbioIsreDao) {
		this.czshbioIsreDao = czshbioIsreDao;
	}

	public void setMzopDnDao(MzopDnDao mzopDnDao) {
		this.mzopDnDao = mzopDnDao;
	}

	public void setGhregisterTypeDao(GhregisterTypeDao ghregisterTypeDao) {
		this.ghregisterTypeDao = ghregisterTypeDao;
	}

	public void setGhregisterDao(GhregisterDao ghregisterDao) {
		this.ghregisterDao = ghregisterDao;
	}

	public void setMzCzdisposeDao(MzCzdisposeDao mzCzdisposeDao) {
		this.mzCzdisposeDao = mzCzdisposeDao;
	}

	public String addTiJiaoJianChaXiangMu(Integer YiLiaoJiGouID, Long FuWuDuiXiangID, Integer[] XiangMuLeiXingID, Long YiShengID, Integer KeShiID, String ShiJian){
		String date;
		String MZH = "";
		String ZDH = "";
		String YMH = "";
		Integer GuaHaoLeiXingID;
		Integer ZhiXingKeShi;
		Ghregister ghregister;
		Czdispose czd;
		MzopDn mzopDn;
		
		date = ShiJian.substring(0,4) + ShiJian.substring(5,7) + ShiJian.substring(8,10);
		MZH = ghregisterDao.getMaxopnumByDate(date);
		if (MZH == null || MZH.equals("")) {
			MZH = "01" + date + "000001";
		} else {
			MZH = CommonUtil.GetNewFlowNum(MZH); //�����
		}
		GuaHaoLeiXingID = ghregisterTypeDao.getGhregisterTypeCunZai("��ǰ����", YiLiaoJiGouID); //�Һ�����ID
		
		ghregister = new Ghregister(); //�����ҺŶ���
			ghregister.setOpnum(MZH); //�����
			ghregister.setRtid(GuaHaoLeiXingID); //�Һ�����ID
			ghregister.setRpname("��ǰ����"); //�Һ���Ŀ��[����]
			ghregister.setExpertOrNot(false); //�Ƿ���ר�Һ�(����)
			ghregister.setSid(-1l); //Ա��ID
			ghregister.setCsId(FuWuDuiXiangID); //�������ID
			ghregister.setCostTypeId(-1); //��������ID
			ghregister.setRu(-1); //�Һſ���(����)
			ghregister.setRegistrar(YiShengID); //�Һ�Ա
			ghregister.setRtime(DateUtil.stringToTimeStamp(ShiJian)); //�Һ�ʱ��
			ghregister.setRstatus("��ʹ��"); //�Һ�״̬
			ghregister.setRealPrice(0d); //ʵ�ռ۸�[����]
			ghregister.setReceivablePrice(0d); //Ӧ�ռ۸�(����)
			ghregister.setIfCg("���շ�");  //�Ƿ����շ�
		ghregisterDao.addGhregister(ghregister); //�Һ�
		
		
		ZDH = mzopDnDao.getMaxId();
		if (ZDH.equals("no"))
		{
			ZDH = "02" + date + "000001";
		}else{
			if (ZDH.substring(2,10).equals(date)){
				ZDH = CommonUtil.GetNewFlowNum(ZDH);
			}
			else{
				ZDH = "02" + date + "000001"; //��Ϻ�
			}
		}
		mzopDn = new MzopDn(); //������϶���
			mzopDn.setOpDnId(ZDH); //�������ID
			mzopDn.setOpnum(MZH); //�����
			mzopDn.setCsId(FuWuDuiXiangID); //�������ID
			mzopDn.setDoctorId(YiShengID); //ҽ��ID
			mzopDn.setChief(""); //����
			mzopDn.setDn(""); //���
			mzopDn.setDnTime(DateUtil.stringToTimeStamp(ShiJian)); //���ʱ��
			mzopDn.setAlterDntimeId(""); //�޸ĺ����ID
			mzopDn.setNote("��ǰ����"); //��ע
			mzopDn.setStatus("�ɴ���"); //״̬
			mzopDn.setCsu(-1); //�շѿ��ң����ࣩ
		mzopDnDao.addMzopDn(mzopDn); //���
		
		YMH = mzCzdisposeDao.getMaxitemId();
		if (YMH.equals("no")){
			YMH = "13" + date + "000001";
		}else{
			if (!YMH.substring(2,10).equals(date)){
				YMH = "13" + date + "000001"; 
			}
		}
		
		for (int i= 0;i<XiangMuLeiXingID.length;i++){
			ZhiXingKeShi = mzCzdisposeItemDescribeDao.getZhiXingKeShi(XiangMuLeiXingID[i]);
			YMH = CommonUtil.GetNewFlowNum(YMH);
			czd = new Czdispose();
			czd.setItemId(YMH); //��ĿID
			czd.setItemTypeId(XiangMuLeiXingID[i]); //��Ŀ����ID
			czd.setAu(KeShiID); //�������
			czd.setAproposer(YiShengID); //������
			czd.setAtime(DateUtil.stringToTimeStamp(ShiJian)); //����ʱ��;
			czd.setCsId(FuWuDuiXiangID); //�������ID(����)
			czd.setAkind("��������"); //��������
			czd.setKindId(ZDH); //������ID
			czd.setExplain(""); //˵��
			czd.setStatus("�ѽ��ѿ�ִ��"); //״̬
			czd.setReceivableP(0d); //Ӧ�գ����ࣩ
			czd.setRealP(0d); //ʵ��
			czd.setFnBlockId(-1); //���ܿ�ID(����)
			czd.setExecutePerson(-1l); //ִ����(����)
			czd.setExecuteTime(DateUtil.stringToTimeStamp("1900-01-01 00:00:00")); //ִ��ʱ��(����)
			czd.setExecuteU(ZhiXingKeShi); //ִ�п���(����)
			czd.setResultTable(""); //������ڱ��(����)
			czd.setNote(""); //��ע
			czd.setCsu(-1); //�շѿ��ң����ࣩ
			czd.setCostTypeId(-1); //��������(����)
			mzCzdisposeDao.addCzdispose(czd); //����
		}
		return ZDH;
	}

	public String[][] getJianChaShuJu(String ZhenDuanHao, String XiangMu){
		return czshbioIsreDao.getCzshbioIsreByOpDnID(ZhenDuanHao, XiangMu);
	}
	
	
}
