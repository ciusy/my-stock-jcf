package leo.gy.test;

import java.util.List;

import leo.entity.GydisinfectPackUseRe;
import leo.gy.service.iface.GetCountOfGydisinfectPackUseReService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘GhService
 * 
 * @author Administrator
 * 
 */
public class GyTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
//		RegisterService rs = (RegisterService) ctx.getBean("RegisterService");
		GetCountOfGydisinfectPackUseReService g = (GetCountOfGydisinfectPackUseReService) ctx.getBean("GetCountOfGydisinfectPackUseReService");
		List<GydisinfectPackUseRe> list = g.getAllGydisinfectPackInUnit(1, "1");
		System.out.println(list.size());
		for(GydisinfectPackUseRe gydisinfectPackUseRe:list){
			System.out.println(gydisinfectPackUseRe.getDisinfectPackId());
			System.out.println(gydisinfectPackUseRe.getBespeakTime());
		}
		
//		org.springframework.web.context.ContextLoaderListener
		//getAllGydisinfectPackInfo
//		GysupplyDisinfectPackInfo g = new GysupplyDisinfectPackInfo();
//		gpkis.addPackKindInfo(g);
//		List<GysupplyDisinfectPackInfo> list = gpkis.getAllPackKindInfo();
//		System.out.println(list.size());
		// List<GhcostType> list = rs.getAllGhcostType();
		// for(int i=0;i<list.size();i++){
		// System.out.println(list.get(i).getId()+","+list.get(i).getRrp()+","+list.get(i).getRrv());
		// }
//		List<GhregisterType> list = rs.getAllGhregisterType();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getUid() + ","
//					+ list.get(i).getRpname() + "," + list.get(i).getIsAlter());
//		}
		
	}
}
