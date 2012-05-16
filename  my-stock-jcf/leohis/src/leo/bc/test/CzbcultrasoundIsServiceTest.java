package leo.bc.test;

import leo.bc.sercive.iface.CzbcultrasoundIsService;
import leo.entity.CzbcultrasoundIs;
import leo.mz.service.iface.MzopDnService;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CzbcultrasoundIsServiceTest {

	public static void main(String args[]){
 
//	String url = "http://localhost:8080/leohis/services/CzbcultrasoundIsService";
//	Service serviceModel = new ObjectServiceFactory()
//			.create(CzbcultrasoundIsService.class);
		CzbcultrasoundIsService rs=null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (CzbcultrasoundIsService) ctx.getBean("CzbcultrasoundIsService");
	try {

//		CzbcultrasoundIsService czacontentService = (CzbcultrasoundIsService) new XFireProxyFactory()
//				.create(serviceModel, url);
//		CzbcultrasoundIs czbcultrasoundIs= new CzbcultrasoundIs();
//		czbcultrasoundIs.setItemId("DIS2011021910000");
//		czbcultrasoundIs.setRename("报告名称");
//		czbcultrasoundIs.setCsId((long)2);
//		czbcultrasoundIs.setBdnDescribe("诊断描述");
//		czbcultrasoundIs.setBdnVerdict("诊断结论");
//		
//		//System.out.println(czacontentService.addCzbcultrasoundIs(czbcultrasoundIs));
		Boolean b=rs.addCzbcultrasoundIs("2","2","2", "2", "2", "2", "2011-7-26 0:00:00", "11", "2", "22", "22","zhengchang");
		System.out.print(b);
		
		
}catch (Exception e)
{e.printStackTrace();}
}
}
