package leo.gh.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import leo.gh.service.iface.RegisterService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘GhService
 * 
 * @author Administrator
 * 
 */
public class GhTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		RegisterService rs = (RegisterService) ctx.getBean("RegisterService");
		String[][] str = rs.getGhregisterByCondition("2011-07-29", "2011-07-30", "", "", "", "",3);
		for(int i=0;i<str.length;i++){
			for(int j=0;j<str[i].length;j++){
				System.out.println(str[i][j]);
			}
		}
//		List<GhregisterType> list = rs.getGhregisterTypeByUid(2, 1);
//		System.out.println(list.size());

//		List<GhregisterType> list = rs.getAllGhregisterType(1);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getRpname());
//		}

//		GhcostType gt = rs.getGhcostTypeByid(1);
//		System.out.println(gt.getCostType());
//		List<GhregisterType> list = rs.getGhregisterTypeByUid(1);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getRpname());
//		}
//		GhcostType ghcostType = new GhcostType();
//		ghcostType.setCostType("¿œ∫∫");
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
