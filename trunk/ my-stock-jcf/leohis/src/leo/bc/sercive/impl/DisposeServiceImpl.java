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
	int medicalInstId=1;//定义变量表示医疗机构id,因为要调用医疗机构全局配置的service,要传入这个参数。

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
	 * 获得处置项的信息，输入参数：执行科室，功能块id,申请单有效期。 返回String[][]二维数组，存储内容：
	 * 1处置项目id,2 服务对象id，3服务对象姓名，4性别，5年龄，6送诊科室id，7送诊科室，8送诊医生id，9送诊医生，
//	 * 10检查部位，11病历摘要，12临床现象，13检查目的及要求，14其他说明，15申请时间,16应收
	 */
	public String[][] getDisposeConsumerInfo(int executeU) {
		String nowTime = getTime.getTime();
		int day = Integer.parseInt(cfmedicalInstService.getValueBydisposeName(
				"门诊号有效期", medicalInstId));//day表示获得的门诊有效期

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
				result[i][0] = String.valueOf(list.get(i).getItemId()); // 项目id
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // 服务对象姓名
				result[i][3] = String.valueOf(csconsumer.getSex()); // 服务对象性别
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // 年龄，先获得出生时间
				result[i][4] = result[i][4].substring(0, 4);//获得年份
		
				/* 获得现在年份减去出生年份得到年龄 */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // 申请科室id
				result[i][6] = String.valueOf(osuform.getUname()); // 申请科室
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // 申请医生id
				result[i][8] = String.valueOf(osstuff.getSname()); // 申请医生
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//检查部位
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//病历摘要
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //临床现象
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//检查目的和要求
				result[i][13] = String.valueOf(czacontent.getElseState());//其他说明
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//申请时间
				result[i][14] = result[i][14].substring(0, 10);  
				result[i][15] = String.valueOf(list.get(i).getAkind());//申请种类
				result[i][16] = String.valueOf(list.get(i).getKindId());//申请种类ID
				result[i][17] = String.valueOf(list.get(i).getReceivableP());//费用

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

	public boolean addCznkendIs(CznkendIs cznkendIs) {// 添写内窥镜报告；
		return cznkendIsDao.addCznkendIs(cznkendIs);
	}

	public boolean addCzshbioIsre(CzshbioIsre czshbioIsre) {// 填写生化检验报告；
		return czshbioIsreDao.addCzshbioIsre(czshbioIsre);
	}
     

										// csname  病人名字，uname 送诊科室名字，csage 年龄。
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
				
				result[i][0] = String.valueOf(list.get(i).getItemId()); // 项目id
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // 服务对象姓名
				result[i][3] = String.valueOf(csconsumer.getSex()); // 服务对象性别
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // 年龄，先获得出生时间
				result[i][4] = result[i][4].substring(0, 4);//获得年份
		
				/* 获得现在年份减去出生年份得到年龄 */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // 申请科室id
				result[i][6] = String.valueOf(osuform.getUname()); // 申请科室
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // 申请医生id
				result[i][8] = String.valueOf(osstuff.getSname()); // 申请医生
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//检查部位
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//病历摘要
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //临床现象
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//检查目的和要求
				result[i][13] = String.valueOf(czacontent.getElseState());//其他说明
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//申请时间
				result[i][14] = result[i][14].substring(0, 10);  
				result[i][15] = String.valueOf(list.get(i).getExecuteTime()); //执行时间
				result[i][15] = result[i][15].substring(0, 10); 

			}
		}

		return result;
		
	}

	public CzbcultrasoundIs getCzbcultrasoundIs(String itemId) {
		
		return czbcultrasoundIsDao.getCzbcultrasoundIs(itemId);
	}
	/*
	 * 获得处置项的信息，输入参数：执行科室，功能块id,申请单有效期。 返回String[][]二维数组，存储内容：
	 * 1处置项目id,2 服务对象id，3服务对象姓名，4性别，5年龄，6送诊科室id，7送诊科室，8送诊医生id，9送诊医生，
//	 * 10检查部位，11病历摘要，12临床现象，13检查目的及要求，14其他说明，15申请时间,16 申请种类，17该种类ID,18应收
	 */
	public String[][] getDisposeConsumerInfoEx(int executeU) {
		// TODO Auto-generated method stub
		String nowTime = getTime.getTime();
		int day = Integer.parseInt(cfmedicalInstService.getValueBydisposeName(
				"门诊号有效期", medicalInstId));//day表示获得的门诊有效期

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
				result[i][0] = String.valueOf(list.get(i).getItemId()); // 项目id
				result[i][1] = String.valueOf(list.get(i).getCsId());
				result[i][2] = String.valueOf(csconsumer.getCsname()); // 服务对象姓名
				result[i][3] = String.valueOf(csconsumer.getSex()); // 服务对象性别
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // 年龄，先获得出生时间
				result[i][4] = result[i][4].substring(0, 4);//获得年份
		
				/* 获得现在年份减去出生年份得到年龄 */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // 申请科室id
				if(osuform!=null)
				{
					result[i][6] = String.valueOf(osuform.getUname()); // 申请科室
				}
				else
				{
					result[i][6]="";
				}
				
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // 申请医生id
				if(osstuff!=null)
				{
					result[i][8] = String.valueOf(osstuff.getSname()); // 申请医生
				}
				else
				{
					result[i][8]="";
				}
			
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//检查部位
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//病历摘要
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //临床现象
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//检查目的和要求
				result[i][13] = String.valueOf(czacontent.getElseState());//其他说明
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
				
				result[i][14] = String.valueOf(list.get(i).getAtime());//申请时间
				result[i][14] = result[i][14].substring(0, 10);  
				
				result[i][15] = String.valueOf(list.get(i).getAkind()); // 申请种类
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
				
				result[i][0] = String.valueOf(list.get(i).getItemId()); // 项目id
				result[i][1] = String.valueOf(list.get(i).getCsId()); 
				result[i][2] = String.valueOf(csconsumer.getCsname()); // 服务对象姓名
				result[i][3] = String.valueOf(csconsumer.getSex()); // 服务对象性别
				result[i][4] = String.valueOf(csconsumer.getBirthday()); // 年龄，先获得出生时间
				result[i][4] = result[i][4].substring(0, 4);//获得年份
		
				/* 获得现在年份减去出生年份得到年龄 */
	
				int nowYear = Integer.parseInt(nowTime.substring(0, 4));
				int birthYear = Integer.parseInt(result[i][4]);
				int age = nowYear - birthYear;
				result[i][4] = String.valueOf(age);
				result[i][5] = String.valueOf(list.get(i).getAu()); // 申请科室id
				result[i][6] = String.valueOf(osuform.getUname()); // 申请科室
				result[i][7] = String.valueOf(list.get(i).getAproposer()); // 申请医生id
				result[i][8] = String.valueOf(osstuff.getSname()); // 申请医生
			if (czacontent != null){
				result[i][9] = String.valueOf(czacontent.getIscheck());//检查部位
				result[i][10] = String.valueOf(czacontent.getMedicalRecords());//病历摘要
				result[i][11] = String.valueOf(czacontent
							.getClinicalPhenomenon());  //临床现象
				result[i][12] = String.valueOf(czacontent
						.getIsobjectiveRequest());//检查目的和要求
				result[i][13] = String.valueOf(czacontent.getElseState());//其他说明
			}else
			{
				result[i][9]="";
				result[i][10]="";
				result[i][11]="";
				result[i][12]="";
				result[i][13]="";
			}
				
			
				result[i][14] = String.valueOf(list.get(i).getAkind()); // 申请种类
				result[i][15] = String.valueOf(list.get(i).getKindId());
				
				result[i][16] = String.valueOf(list.get(i).getAtime());//申请时间
				result[i][16] = result[i][16].substring(0, 10);  
				result[i][17] = String.valueOf(list.get(i).getExecuteTime()); //执行时间
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


