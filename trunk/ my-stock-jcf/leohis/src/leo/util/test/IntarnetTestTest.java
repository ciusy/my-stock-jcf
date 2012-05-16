package leo.util.test;

import java.net.MalformedURLException;

import leo.util.service.iface.GetTime;
import leo.util.service.iface.IntarnetTest;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

public class IntarnetTestTest {
	public static void main(String[] args) {
		/*String url = "http://localhost:8080/leohis/services/IntarnetTest";
		Service serviceModel = new ObjectServiceFactory()
				.create(IntarnetTest.class);
		try {
			IntarnetTest intarnetTest = (IntarnetTest) new XFireProxyFactory()
					.create(serviceModel, url);
			System.out.println(intarnetTest.connectionStatament());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		String url = "http://localhost:8080/leohis/services/GetTime";
		Service serviceModel = new ObjectServiceFactory()
				.create(GetTime.class);
		try {
			GetTime time = (GetTime) new XFireProxyFactory()
					.create(serviceModel, url);
			System.out.println(time.getTime());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
