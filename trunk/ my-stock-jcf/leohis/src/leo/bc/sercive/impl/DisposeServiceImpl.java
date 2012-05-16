package leo.bc.sercive.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import leo.bc.dao.iface.CzacontentDao;
import leo.bc.dao.iface.CzbcultrasoundIsDao;
import leo.bc.dao.iface.CznkendIsDao;
import leo.bc.dao.iface.CzshbioIsreDao;
import leo.bc.dao.iface.DisposeDao;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.bc.sercive.iface.DisposeService;

import leo.entity.Csconsumer;
import leo.entity.Czacontent;
import leo.entity.CzbcultrasoundIs;
import leo.entity.Czdispose;
import leo.entity.CznkendIs;
import leo.entity.CzshbioIsre;
import leo.entity.Osstuff;
import leo.entity.Osuform;

import leo.os.service.iface.OsstuffService;
import leo.os.service.iface.OsuformService;
import leo.cf.service.iface.CfmedicalInstService;
import leo.cs.service.iface.CsconsumerService;

import leo.util.service.iface.GetTime;

public class DisposeServiceImpl implements DisposeService {
	DisposeDao disposeDao;
	CsconsumerService  csconsumerService;
	CzacontentDao czacontentDao;
	GetTime getTime;
	OsstuffService osstuffService ;
	OsuformService osuformService;
	CfmedicalInstService cfmedicalInstService ;
	CznkendIsDao cznkendIsDao;
	CzshbioIsreDao czshbioIsreDao;
	CzbcultrasoundIsDao czbcultrasoundIsDao;
	ZyInpatientDao  zyinpatientDao;
	
	public void setZyinpatientDao(ZyInpatientDao zyinpatientDao) {
		this.zyinpatientDao = zyinpatientDao;
	}
	int medicalInstId=1;//���������ʾҽ�ƻ���id,��ΪҪ����ҽ�ƻ���ȫ�����õ�service,Ҫ�������������

    public void setCzbcultrasoundIsDao(CzbcultrasoundIsDao czbcultrasoundIsDao){
    	this.czbcultrasoundIsDao=czbcultrasoundIsDao;
    	
    }
	public void setCsconsumerService(CsconsumerService csconsumerService) {
		this.csconsumerService = csconsumerService;
	}
	
	public void setOsstuffService(OsstuffService osstuffService) {
		this.osstuffService = osstuffService;
	}


	public void setDisposeDao(DisposeDao disposeDao) {
		this.disposeDao = disposeDao;
	}

	public void setCzacontentDao(CzacontentDao czacontentDao) {
		this.czacontentDao = czacontentDao;
	}

	
	public void setGetTime(GetTime getTime) {
		this.getTime = getTime;
	}

	public void setOsuformService(OsuformService osuformService) {
		this.osuformService = osuformService;
	}

	public void setCfmedicalInstService(CfmedicalInstService cfmedicalInstService) {
		this.cfmedicalInstService = cfmedicalInstService;
	}

	public void setCznkendIsDao(CznkendIsDao cznkendIsDao) {
		this.cznkendIsDao = cznkendIsDao;
	}

	public void setCzshbioIsreDao(CzshbioIsreDao czshbioIsreDao) {
		this.czshbioIsreDao = czshbioIsreDao;
	}

	public List<Czdispose> getDisposeInfo(int excuteU, int fnBlockID, int day,
			String nowTime) {

		return disposeDao.getDisposeInfo(excuteU,  day, nowTime);

	}

	/*
	 * ��ô��������Ϣ�����������ִ�п��ң����ܿ�id,���뵥��Ч�ڡ� ����String[][]��ά���飬�洢���ݣ�
	 * 1������Ŀid,2 �������id��3�������������4�Ա�5���䣬6�������id��7������ң�8����ҽ��id��9����ҽ����
//	 * 10��鲿λ��11����ժҪ��12�ٴ�����13���Ŀ�ļ�Ҫ��14����˵����15����ʱ��,16Ӧ��
	 */
	public String[][] getDisposeConsumerInfo(int executeU) {
		String nowTime = getTime.getTime();
		int day = Integer.parseInt(cfmedicalInstService.getValueBydisposeName(
				"�������Ч��", medicalInstId));//day��ʾ��õ�������Ч��

		List<Czdispose> list = disposeDao.getDisposeInfo(executeU,day, nowTime);
		String result[][] = new String[list.size()][18];
		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getItemId();
			
			Csconsumer csconsumer = csconsumerService.getCInfoById(list.get(i).getCsId());

			Osstuff osstuff = osstuffService.getStuffBySid(list.get(i).getAproposer());
	
			Osuform osuform = osuformService.getOsuformByUid(list.get(i).getAu());
			
			Czacontent czacontent = czacontentDao.getCzacontentByItemId(list.get(i).getItemId());
			if (csconsumer != null ) {
				result[i][0] = String.valueOf(list.get(i).getItemId()); // ��Ŀid
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // �����������
				result[i][3] = String.valueOf(csconsumer.getSex()); // ��������Ա�
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // ���䣬�Ȼ�ó���ʱ��
				result[i][4] = result[i][4].substring(0, 4);//������
		
				/* ���������ݼ�ȥ������ݵõ����� */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // �������id
				result[i][6] = String.valueOf(osuform.getUname()); // �������
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // ����ҽ��id
				result[i][8] = String.valueOf(osstuff.getSname()); // ����ҽ��
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//��鲿λ
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//����ժҪ
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //�ٴ�����
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//���Ŀ�ĺ�Ҫ��
				result[i][13] = String.valueOf(czacontent.getElseState());//����˵��
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//����ʱ��
				result[i][14] = result[i][14].substring(0, 10);  
				result[i][15] = String.valueOf(list.get(i).getAkind());//��������
				result[i][16] = String.valueOf(list.get(i).getKindId());//��������ID
				result[i][17] = String.valueOf(list.get(i).getReceivableP());//����

			}
		}

		return result;
	}

	public void setDisposeStatus(String itemid, Long executePerson,String executeTime) {
		disposeDao.setDisposeStatus(itemid, executePerson, executeTime);
	}
	public boolean updateDepositBalance(String ZhuYuanHao, double FeiYong) {
		
		// TODO Auto-generated method stub
		FeiYong=0-FeiYong;
		return zyinpatientDao.updateDepositBalance(ZhuYuanHao, FeiYong);
		
	}

	public boolean addCznkendIs(CznkendIs cznkendIs) {// ��д�ڿ������棻
		return cznkendIsDao.addCznkendIs(cznkendIs);
	}

	public boolean addCzshbioIsre(CzshbioIsre czshbioIsre) {// ��д�������鱨�棻
		return czshbioIsreDao.addCzshbioIsre(czshbioIsre);
	}
     

										// csname  �������֣�uname ����������֣�csage ���䡣
	public String[][] getYetDisposeInfo(int executeU,String csName,String uname,String csage,String starttime,String endtime){
		csName.trim();
		uname.trim();
		csage.trim();
		String nowTime = getTime.getTime();
		List<Czdispose> list = disposeDao.getYetDisposeInfo(executeU, starttime,endtime);
		String result[][] = new String[list.size()][16];
		int size = list.size();
//		System.out.println("hello");
//		System.out.println(starttime);
//		System.out.println(endtime);
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getItemId();
			
			Csconsumer csconsumer = csconsumerService.getCInfoById(list.get(i).getCsId());

			Osstuff osstuff = osstuffService.getStuffBySid(list.get(i).getAproposer());
	
			Osuform osuform = osuformService.getOsuformByUid(list.get(i).getAu());
			
			Czacontent czacontent = czacontentDao.getCzacontentByItemId(list.get(i).getItemId());
			if (csconsumer != null ) {
				
				result[i][0] = String.valueOf(list.get(i).getItemId()); // ��Ŀid
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // �����������
				result[i][3] = String.valueOf(csconsumer.getSex()); // ��������Ա�
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // ���䣬�Ȼ�ó���ʱ��
				result[i][4] = result[i][4].substring(0, 4);//������
		
				/* ���������ݼ�ȥ������ݵõ����� */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // �������id
				result[i][6] = String.valueOf(osuform.getUname()); // �������
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // ����ҽ��id
				result[i][8] = String.valueOf(osstuff.getSname()); // ����ҽ��
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//��鲿λ
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//����ժҪ
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //�ٴ�����
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//���Ŀ�ĺ�Ҫ��
				result[i][13] = String.valueOf(czacontent.getElseState());//����˵��
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//����ʱ��
				result[i][14] = result[i][14].substring(0, 10);  
				result[i][15] = String.valueOf(list.get(i).getExecuteTime()); //ִ��ʱ��
				result[i][15] = result[i][15].substring(0, 10); 

			}
		}

		return result;
		
	}

	public CzbcultrasoundIs getCzbcultrasoundIs(String itemId) {
		
		return czbcultrasoundIsDao.getCzbcultrasoundIs(itemId);
	}
	/*
	 * ��ô��������Ϣ�����������ִ�п��ң����ܿ�id,���뵥��Ч�ڡ� ����String[][]��ά���飬�洢���ݣ�
	 * 1������Ŀid,2 �������id��3�������������4�Ա�5���䣬6�������id��7������ң�8����ҽ��id��9����ҽ����
//	 * 10��鲿λ��11����ժҪ��12�ٴ�����13���Ŀ�ļ�Ҫ��14����˵����15����ʱ��,16 �������࣬17������ID,18Ӧ��
	 */
	public String[][] getDisposeConsumerInfoEx(int executeU) {
		// TODO Auto-generated method stub
		String nowTime = getTime.getTime();
		int day = Integer.parseInt(cfmedicalInstService.getValueBydisposeName(
				"�������Ч��", medicalInstId));//day��ʾ��õ�������Ч��

		List<Czdispose> list = disposeDao.getDisposeInfo(executeU,day, nowTime);
		String result[][] = new String[list.size()][18];
		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getItemId();
			
			Csconsumer csconsumer = csconsumerService.getCInfoById(list.get(i).getCsId());

			Osstuff osstuff = osstuffService.getStuffBySid(list.get(i).getAproposer());
	
			Osuform osuform = osuformService.getOsuformByUid(list.get(i).getAu());
			
			Czacontent czacontent = czacontentDao.getCzacontentByItemId(list.get(i).getItemId());
			if (csconsumer != null ) {
				result[i][0] = String.valueOf(list.get(i).getItemId()); // ��Ŀid
				result[i][1] = String.valueOf(list.get(i).getCsId());
				result[i][2] = String.valueOf(csconsumer.getCsname()); // �����������
				result[i][3] = String.valueOf(csconsumer.getSex()); // ��������Ա�
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // ���䣬�Ȼ�ó���ʱ��
				result[i][4] = result[i][4].substring(0, 4);//������
		
				/* ���������ݼ�ȥ������ݵõ����� */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // �������id
				if(osuform!=null)
				{
					result[i][6] = String.valueOf(osuform.getUname()); // �������
				}
				else
				{
					result[i][6]="";
				}
				
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // ����ҽ��id
				if(osstuff!=null)
				{
					result[i][8] = String.valueOf(osstuff.getSname()); // ����ҽ��
				}
				else
				{
					result[i][8]="";
				}
			
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//��鲿λ
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//����ժҪ
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //�ٴ�����
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//���Ŀ�ĺ�Ҫ��
				result[i][13] = String.valueOf(czacontent.getElseState());//����˵��
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//����ʱ��
				result[i][14] = result[i][14].substring(0, 10);  
				
				result[i][15] = String.valueOf(list.get(i).getAkind()); // ��������
				result[i][16] = String.valueOf(list.get(i).getKindId());
				result[i][17] = String.valueOf(list.get(i).getReceivableP());
				
				

			}
		}

		return result;

	}
	public String[][] getYetDisposeInfoEx(int executeU, String csName,
			String uname, String csage, String starttime, String endtime) {
		// TODO Auto-generated method stub
		csName.trim();
		uname.trim();
		csage.trim();
		String nowTime = getTime.getTime();
		List<Czdispose> list = disposeDao.getYetDisposeInfo(executeU, starttime,endtime);
		String result[][] = new String[list.size()][18];
		int size = list.size();
//		System.out.println("hello");
//		System.out.println(starttime);
//		System.out.println(endtime);
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getItemId();
			
			Csconsumer csconsumer = csconsumerService.getCInfoById(list.get(i).getCsId());

			Osstuff osstuff = osstuffService.getStuffBySid(list.get(i).getAproposer());
	
			Osuform osuform = osuformService.getOsuformByUid(list.get(i).getAu());
			
			Czacontent czacontent = czacontentDao.getCzacontentByItemId(list.get(i).getItemId());
			if (csconsumer != null ) {
				
				result[i][0] = String.valueOf(list.get(i).getItemId()); // ��Ŀid
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // �����������
				result[i][3] = String.valueOf(csconsumer.getSex()); // ��������Ա�
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // ���䣬�Ȼ�ó���ʱ��
				result[i][4] = result[i][4].substring(0, 4);//������
		
				/* ���������ݼ�ȥ������ݵõ����� */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // �������id
				result[i][6] = String.valueOf(osuform.getUname()); // �������
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // ����ҽ��id
				result[i][8] = String.valueOf(osstuff.getSname()); // ����ҽ��
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//��鲿λ
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//����ժҪ
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //�ٴ�����
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//���Ŀ�ĺ�Ҫ��
				result[i][13] = String.valueOf(czacontent.getElseState());//����˵��
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
			
				result[i][14] = String.valueOf(list.get(i).getAkind()); // ��������
				result[i][15] = String.valueOf(list.get(i).getKindId());
				
				result[i][16] = String.valueOf(list.get(i).getAtime());//����ʱ��
				result[i][16] = result[i][16].substring(0, 10);  
				result[i][17] = String.valueOf(list.get(i).getExecuteTime()); //ִ��ʱ��
				result[i][17] = result[i][17].substring(0, 10); 
			

			}
		}

		return result;
	}
	public String[][] getStatisticInfo(int executeU,String QueryItem, String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		return disposeDao.getStatisticInfo( executeU,QueryItem, startTime,endTime);

	}

}


