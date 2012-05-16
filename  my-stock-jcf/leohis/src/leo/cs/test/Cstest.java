package leo.cs.test;


import java.net.MalformedURLException;
import java.util.List;


import leo.cs.service.iface.CsconsumerService;
import leo.entity.Csconsumer;



import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cstest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"classpath:applicationContext.xml");
		
		CsconsumerService cscservice = (CsconsumerService)ctx.getBean("CsconsumerService");
		List<Csconsumer> list = cscservice.getCsInfo("ml", "", "370882", "370882001", "", "", "");
		
		for (Csconsumer csconsumer : list) {
			System.out.println(csconsumer.getCsId() + "\t" + csconsumer.getCsname());
		}
		
		System.out.println(list.size());
		
//		String  url="http://localhost:8080/leohis/services/CsconsumerService";   
//        Service serviceModel=new ObjectServiceFactory().create(CsconsumerService.class);   
//        try {   
//        	CsconsumerService cInfoService=(CsconsumerService) new XFireProxyFactory().create(serviceModel, url);
//        	
//            String[][] cs=cInfoService.getCInfo("", "","", "370882", "370882001", "","", "");
//          
//            System.out.println(cs.length);
//
////            System.out.println(list.size());
////            for (int i = 0; i < list.size(); i++) {
////    			System.out.println(list.get(i).getName() + ","
////    					+ list.get(i).getSex() + "," + list.get(i).getBirthday());
////    		} 
//   //         System.out.println(cs.getName() + ","	+ cs.getSex() + "," + cs.getBirthday());
//            
//        } catch (MalformedURLException e) {   
//            e.printStackTrace();   
//        } 
	}


}
