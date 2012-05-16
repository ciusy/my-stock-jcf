package leo.yf.service.impl;

import java.util.List;

import leo.common.util.DateUtil;
import leo.entity.SfpadjustRecord;
import leo.entity.Yfprice;
import leo.yf.dao.iface.SfpadjustRecordDao;
import leo.yf.dao.iface.YfpriceDao;
import leo.yf.service.iface.YfpriceService;

public class YfpriceServiceImpl implements YfpriceService {
	private YfpriceDao yfpriceDao;
	private SfpadjustRecordDao sfpadjustRecordDao;
	
	public void setYfpriceDao(YfpriceDao yfpriceDao) {
		this.yfpriceDao = yfpriceDao;
	}


	public void setSfpadjustRecordDao(SfpadjustRecordDao sfpadjustRecordDao) {
		this.sfpadjustRecordDao = sfpadjustRecordDao;
	}


	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID,
			Integer MedicalInstID) {
		return yfpriceDao.getYfprice(ExbankType, MInfoID, MedicalInstID);
	}
	
	public boolean addTiaoJia(String[][] JiaGe){
/*
  	JiaGe[][0] ��������
  	JiaGe[][1] ԭ�۸�
  	JiaGe[][2]�ּ۸񣨳���۸�
  	JiaGe[][3]ҩƷ��ϢID
  	JiaGe[][4]ҽ�ƻ���ID
  	JiaGe[][5]������
  	JiaGe[][6]����ʱ��
  	JiaGe[][7]��������
  	JiaGe[][8]��������
 */
		Long cz;
		//����۸��
		Yfprice yfprice;
		SfpadjustRecord tjjl;
		for (int i=0;i<JiaGe.length;i++){
			cz = yfpriceDao.getCuiZai(JiaGe[i][0], Integer.parseInt(JiaGe[i][3]), Integer.parseInt(JiaGe[i][4]));
			if (cz != -1){ //�Ѿ����ڣ����޸�
				yfpriceDao.updateJiaGe(JiaGe[i][0], Integer.parseInt(JiaGe[i][3]), Integer.parseInt(JiaGe[i][4]), Double.parseDouble(JiaGe[i][2])); //�޸ļ۸���г���۸�
				sfpadjustRecordDao.updateJiLu(cz, Double.parseDouble(JiaGe[i][1]), Double.parseDouble(JiaGe[i][2]), Long.parseLong(JiaGe[i][5]), JiaGe[i][6], JiaGe[i][7], Double.parseDouble(JiaGe[i][8]));
			}
			else{ //�����ڣ������
				yfprice = new Yfprice();
				yfprice.setExbankType(JiaGe[i][0]); //��������
				yfprice.setExbankP(Double.parseDouble(JiaGe[i][2])); //����۸�
				yfprice.setMinfoId(Integer.parseInt(JiaGe[i][3])); //ҩƷ��ϢID
				yfprice.setMedicalInstId(Integer.parseInt(JiaGe[i][4])); //ҽ�ƻ���ID
				yfpriceDao.addYfprice(yfprice); //����۸��

				Long maxid = yfpriceDao.getmaxID(); //��ȡ�۸�����ID

				tjjl = new SfpadjustRecord();
				tjjl.setPid(maxid); //�۸�ID
				tjjl.setFormerP(Double.parseDouble(JiaGe[i][1])); //ԭ��
				tjjl.setNowadayP(Double.parseDouble(JiaGe[i][2])); //�ּ۸�
				tjjl.setAdjuster(Long.parseLong(JiaGe[i][5])); //������
				tjjl.setPadjustTime(DateUtil.stringToTimeStamp(JiaGe[i][6])); //����ʱ��
				tjjl.setAtype(JiaGe[i][7]); //��������
				tjjl.setAmount(Double.parseDouble(JiaGe[i][8])); //��������
				sfpadjustRecordDao.addSfpadjustRecordDao(tjjl); //������ۼ�¼��
			}
		}
		return true;
	}
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID){
		return yfpriceDao.getCuiZai(cklx, ypID, yljgID);
	}
	
	public boolean addCaiGouRuKuTiaoJia(String[][] YaoPinID_JiaGe, String[][] ChuKuLeiXing, Integer YiLiaoJiGouID){
		Yfprice yfprice;
		Double ckje;
		
		for (int i=0;i<YaoPinID_JiaGe.length;i++){ //ҩƷ��ϢID�����۸�
			for (int j=0;j<ChuKuLeiXing.length;j++){ //��������
				yfprice = new Yfprice();
				yfprice.setExbankType(ChuKuLeiXing[j][0]); //��������
				ckje = Double.parseDouble(YaoPinID_JiaGe[i][1]) * Double.parseDouble(ChuKuLeiXing[j][1]) / 100;
				yfprice.setExbankP(ckje); //����۸�
				yfprice.setMinfoId(Integer.parseInt(YaoPinID_JiaGe[i][0])); //ҩƷ��ϢID
				yfprice.setMedicalInstId(YiLiaoJiGouID); //ҽ�ƻ���ID
				
				yfpriceDao.addYfprice(yfprice); //����۸��
			}
		}
		return true;
	}
}
