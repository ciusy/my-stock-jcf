package leo.os.test;

import java.util.List;

import leo.os.dao.iface.OsstuffDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 3, 2011 4:31:51 PM
 */
public class OsGiveSFTest {

	@Test
	public void test1() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		OsstuffDao osstuffDao = (OsstuffDao) ctx.getBean("OsstuffDao");
//		List<List<String>> list = osstuffDao.getAllOsstuff();
//		for (List<String> out : list) {
//			for (String in : out) {
//				System.out.print(in+"\t");
//			}
//			System.out.println();
//		}

	}

}
