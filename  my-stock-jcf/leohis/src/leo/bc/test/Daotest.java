package leo.bc.test;

import java.util.List;

import leo.bc.dao.iface.DisposeDao;
import leo.cs.dao.iface.CsconsumerDao;
import leo.entity.Csconsumer;
import leo.entity.Czdispose;
import leo.entity.Osuform;
import leo.os.service.iface.GiveGhService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Daotest {
	
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			DisposeDao rs = (DisposeDao) ctx.getBean("DisposeDao");

			// List<GhcostType> list = rs.getAllGhcostType();
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).getId()+","+list.get(i).getRrp()+","+list.get(i).getRrv());
			// }
			List<Czdispose> list =rs.getDisposeInfo(13, 1, "2011-07-20 20:00:00");
			  for (int i = 0; i < list.size(); i++) {
	    			System.out.println(list.get(i).getAu() + ","+ list.get(i).getAproposer() );
	    		} 
			 
		}
	}
