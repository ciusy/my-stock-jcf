package leo.os.test;



import leo.os.service.iface.LoginService;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

public class LoginServiceImplTest {
public static void main(String[] args) {
	
		
		String  url="http://localhost:8080/leohis/services/LoginService";   
        Service serviceModel=new ObjectServiceFactory().create(LoginService.class);   
        try {   
        	
        	LoginService loginService=(LoginService) new XFireProxyFactory().create(serviceModel, url);
        	
        	System.out.print(loginService.changePassword("zhangqi","1","2","2 "));
}catch (Exception e){
	e.printStackTrace();
	}
}
}
