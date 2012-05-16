package leo.bc.test;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;
import leo.bc.sercive.iface.DisposeService;
import leo.cs.service.iface.CsconsumerService;
import leo.entity.Csconsumer;
import leo.entity.Czdispose;
import leo.mz.service.iface.MzopDnService;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Servicetest {

	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		DisposeService mdService = (DisposeService)ctx.getBean("DisposeService");
		
		//String  url="http://localhost:8080/leohis/services/DisposeService";   
		String  url="http://192.168.1.9:8080/leohis/services/DisposeService";   
        Service serviceModel=new ObjectServiceFactory().create(DisposeService.class);   
      try {   
        	
        	DisposeService disposeService=(DisposeService) new XFireProxyFactory().create(serviceModel, url);
//        	
//        	String result[][]=disposeService.getss(49,1);
//        //	System.out.print(result);
//        	for(int i=0;i<result.length;i++)
//        	{
//        		System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]+" "+result[i][3]+" "+result[i][4]+" "+result[i][5]+"  "+result[i][6]+" "+result[i][7]+" "+result[i][8]+" "+result[i][9]+" "+result[i][10]+" "+result[i][11]);
//        		
//        	}
        	
        	/*DisposeService disposeService=(DisposeService) new XFireProxyFactory().create(serviceModel, url);
        	
        	List<Czdispose> list =disposeService.getDisposeInfoByStatus();
          
            for (int i = 0; i < list.size(); i++) {
    			System.out.println(list.get(i).getAu() + ","+ list.get(i).getAproposer() +","+list.get(i).getStatus());
    		} */
           
          //  disposeService.setDisposeStatus("CZX2011070400001");
           
            
        	//System.out.println(disposeService.getDisposeConsumerInfo());
              
//            
//            List<String[]> list2 =disposeService.getYetDisposeInfo(1, 49);
//            System.out.println(list2.size());
//            for (int i = 0; i < list2.size(); i++) {
//    			System.out.println(list2.get(i)[0] + ","+ list2.get(i)[1] +","+list2.get(i)[2]+","+list2.get(i)[3] + ","+ list2.get(i)[7] +","+list2.get(i)[8]);
//    		} 
//            
//            
//            String  url2="http://localhost:8080/leohis/services/CInfoService";   
//            Service serviceMode2=new ObjectServiceFactory().create(CInfoService.class);   
//            
//
//            CInfoService cInfoService=(CInfoService) new XFireProxyFactory().create(serviceMode2, url2);
//         
//            List<Dispose> templist =disposeService.getDisposeInfoByStatus();
//    		Object[] obj=new Object[10];
//    		LinkedList<Object[]> list2= new LinkedList<Object[]>();
//    	
//    		for(int i=0;i<templist.size();i++)
//    		{
//    			
//    			Csconsumer csconsumer=cInfoService.getCInfoById(templist.get(i).getCsId());
//    			obj[0]=csconsumer.getCsId();
//    			obj[1]=csconsumer.getName();
//    			obj[2]=csconsumer.getSex();
//    			obj[3]=csconsumer.getBirthday();
//    			obj[7]=templist.get(i).getAu();
//    			obj[8]=templist.get(i).getAproposer();	
//    			list2.add(obj);
//    		}
//    		for (int i = 0; i < list2.size(); i++) {
//    			System.out.println(list2.get(i)[0] + ","+ list2.get(i)[1] +","+list2.get(i)[2]+","+list2.get(i)[3] + ","+ list2.get(i)[7] +","+list2.get(i)[8]);
//    		} 
//            
//		 List<Czdispose>list=mdService.getTest();
//		 System.out.println(list.size());
//		 System.out.println(list.get(0).getItemId());
//		String result[][]=disposeService.getDisposeConsumerInfo(49, 1);
//        	//System.out.println(list.size());
//		//String result[][]=mdService.getYetDisposeInfo(49,1);
//		for(int i=0;i<result.length;i++)
//        	{
//        		System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]+" "+result[i][3]+" "+result[i][4]+" "+result[i][5]+"  "+result[i][6]+" "+result[i][7]+" "+result[i][8]+" "+result[i][9]+" "+result[i][10]+" "+result[i][11]);
//        		
//        	}
////        System.out.println(list.size());
        	//System.out.println(disposeService.getTest());
        } catch (MalformedURLException e) {   
           e.printStackTrace();   
      } 
       
	}


}

