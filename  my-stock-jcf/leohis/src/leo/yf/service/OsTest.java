package leo.yf.service;

import java.util.List;

import leo.entity.Osuform;
import leo.entity.Yfminfo;
import leo.yf.service.iface.YFMInFoService;
import leo.yf.service.iface.YfminbankAService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client ²âÊÔ¶Ë;
 * 
 * @author Administrator
 * 
 */
public class OsTest {

	/**
	 * Ö÷·½·¨;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	/*	ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		YFMInFoService ggs = (YFMInFoService) ctx.getBean("YFMInFoService");
		List<String[]> list = ggs.getYFMInfo("");
		for (int i = 0; i < list.size(); i++) {
//System.out.println(list.get(i).getMname());
		}*/
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"classpath:applicationContext.xml");
		YfminbankAService yfmService = (YfminbankAService)ctx.getBean("YfminbankAService");
		
	}
}
