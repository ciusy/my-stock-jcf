package leo.yf.test;

import java.util.ArrayList;
import java.util.List;

import leo.yf.service.iface.YFApproveItemService;
import leo.yf.service.iface.YfmaliasService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试GhService
 * 
 * @author Administrator
 * 
 */
public class GhTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		YFApproveItemService rs = (YFApproveItemService) ctx.getBean("yFApproveItemService");
		System.out.println(rs.getChuKuLeiXingName(11));
//		
//		List list = new ArrayList();
//		list.add("张三");
//		list.add("李四");
//		list.add("王五");
//		list.add("赵六");
//		System.out.println(list.get(2));
//		list.remove(2);
//		System.out.println(list.get(2));
//		Yfmalias yf  = new Yfmalias();
//		yf.setManufacturer("a");
//		rs.addYfmmanufacturer(yf);
//		List<Yfmalias> list = rs.getYfmalias(-1, "", "", -1);
//		
////		Boolean b = rs.addYfmmanufacturer(yfmmanufacturer)
//		
//		
//		
//		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getAliasName());
//		}
		
		
	}
}
