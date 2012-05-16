package leo.mz.test;


import java.util.List;

import leo.entity.CzdisposeDivaricateU;
import leo.mz.service.iface.MzopDnService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMzdivaricateu {

	
	public static void main(String[] args) {
		MzopDnService rs=null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (MzopDnService) ctx.getBean("MzopDnService");
//		String number="1";
//		Long b=Long.parseLong(number);
//		CzdisposeDivaricateU a=rs.getCzdById(b);
//		System.out.println(a.getItemTypeId());
//		System.out.println(a.getUid());
		
		
		CzdisposeDivaricateU u=new CzdisposeDivaricateU();
//		u.setItemTypeId(2);
//		u.setUid(2);
//		rs.saveCzdisposeDivaricateU(u);
//		u.setId(new Long(8));
//		u.setItemTypeId(1);
//		u.setUid(4);
//		rs.updateCzdisposeDivaricateU(u);
		//rs.deleCzdisposeDivaricateU(new Long (7));
//		List<CzdisposeDivaricateU> list=rs.getCzdisposeDivaricateUList(2);
//		System.out.println(list.size());
		
		Integer a=new Integer(15);
		rs.deleCzdisposeDivaricateUByitemTypeId(a);
	}

}
