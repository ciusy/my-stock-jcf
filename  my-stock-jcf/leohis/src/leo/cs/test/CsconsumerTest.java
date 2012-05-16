package leo.cs.test;

import leo.cs.dao.iface.CsconsumerDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsconsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"classpath:applicationContext.xml");
		
		CsconsumerDao csDao = (CsconsumerDao) ctx.getBean("CsconsumerDao");
		
		int number=csDao.getCountAge("1987","2011");
		System.out.print("Œ“µƒƒÍ¡‰:"+number);

	}

}
