package leo.cf.test;

import java.util.List;

import leo.cf.dao.iface.CfvillageDao;
import leo.cf.service.iface.CfGiveGhService;
import leo.cf.service.iface.CfdhpmodelService;
import leo.cf.service.iface.CfmedicalInstService;
import leo.entity.Cfdhpmodel;
import leo.entity.Cfgroup;
import leo.entity.CfhandleItemDetail;
import leo.entity.Cfmdetail;
import leo.entity.CfmedicalInst;
import leo.entity.Cfvillage;
import leo.entity.CzdisposeItemDescribe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����GhService
 * 
 * @author Administrator
 * 
 */
public class TownTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");		
		CfdhpmodelService cfdService = (CfdhpmodelService)ctx.getBean("CfdhpmodelService");
//		System.out.println(cfdService.getMaxItemId());
//		CzdisposeItemDescribe czd = cfdService.getCzdisposeItemDescribeByitemTypeId(1);
//		System.out.println(czd.getItemName());
//		Cfdhpmodel cfd = new Cfdhpmodel();
//		cfd.setModelName("�ϻ�");
//		cfd.setSuffererTell("b");
//		cfd.setOwer(1l);
//		cfd.setDiagnosis("b");
//		cfd.setDepartment(1);
//		cfd.setFatherId(4l);
//		
//		cfdService.addCfdhpmodel(cfd, 1, "������ҩ", 2, 1);
		// ɾ��ģ��
//		boolean b = cfdService.getCountByModelId(5l);
//		List<Cfmdetail> list = cfdService.getCfmdetailByModelId(1l);
//		for (int i = 0; i < list.size(); i++) {
//			Cfmdetail cfm = list.get(i);
//			System.out.println(cfm.getQuantity());
//		}
		
		
//		CfmedicalInstService cis = (CfmedicalInstService)ctx.getBean("CfmedicalInstService");
//		CfmedicalInst cfs = new CfmedicalInst();
//		cfs.setDisposeName("abc");
//		cfs.setCfvalue("bcd");
//		cfs.setMedicalInstId(1);
//		System.out.println(cis.addCfmedicalInstInfo(cfs) == true ? "��ӳɹ�" : "���ʧ��");
		
		//System.out.println(cis.delCfmedicalInstInfo(18L) == true ? "ɾ���ɹ�" : "ɾ��ʧ��");
		
//		CftownDao cd = (CftownDao) ctx.getBean("");
//		CfvillageDao cd = (CfvillageDao)ctx.getBean("CfvillageDao");
//		List<Cfvillage> list = cd.getVillageIdByVillageName("ͭɽ��1��");
//		System.out.println(list.get(0).getVillageId());
//		CfGiveGhService cg = (CfGiveGhService)ctx.getBean("CfGiveGhService");
//		List<Cfgroup> list = cg.getAllCfgroupsByVilleageName("ͭɽ��2��");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getGroupName());
//		}
//		cd.getTownIdByTownName("");
//		GhcostType gt = rs.getGhcostTypeByid(1);
//		System.out.println(gt.getCostType());
//		List<GhregisterType> list = rs.getGhregisterTypeByUid(1);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getRpname());
//		}
//		GhcostType ghcostType = new GhcostType();
//		ghcostType.setCostType("�Ϻ�");
//		ghcostType.setDerate(true);
//		ghcostType.setEnterAddress(false);
//		ghcostType.setRrp(10.0);
//		ghcostType.setRrv(20.0);
//		rs.addGhcostType(ghcostType);

//		 List<GhcostType> list = rs.getAllGhcostTypeByMid(1);
//		 for(int i=0;i<list.size();i++){
//		 System.out.println(list.get(i).getId()+","+list.get(i).getRrp()+","+list.get(i).getRrv());
//		 }
//		List<GhregisterType> list = rs.getAllGhregisterType();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getUid() + ","
//					+ list.get(i).getRpname() + "," + list.get(i).getIsAlter());
//		}
	}
}
