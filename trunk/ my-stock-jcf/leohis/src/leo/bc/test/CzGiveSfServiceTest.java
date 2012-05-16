package leo.bc.test;

import leo.bc.dao.iface.DisposeDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 22, 2011 4:14:39 PM
 */
public class CzGiveSfServiceTest {

	DisposeDao rs = null;

	@Before
	public void setUp() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (DisposeDao) ctx.getBean("DisposeDao");
		System.out.println("setup");

	}

	@After
	public void tearDown() {
		System.out.println("teaDow");

	}

	// public static void main(String[] args) {
	//
	// List<GhcostType> list = rs.getAllGhcostType();
	// for(int i=0;i<list.size();i++){
	// System.out.println(list.get(i).getId()+","+list.get(i).getRrp()+","+list.get(i).getRrv());
	// }
	// List<Czdispose> list = rs.getDisposeInfo(13, 1, 1, "2011-07-20 20:00:00");
	// for (int i = 0; i < list.size(); i++) {
	// System.out.println(list.get(i).getAu() + "," + list.get(i).getAproposer());
	// }
	//
	// }

	@Test
	public void test1() {

		// String[][] strArrays = rs.getCZ("B超1", "3");
		//
		// for (String[] strArray : strArrays) {
		// for (int i = 0; i < strArray.length; i++) {
		// System.out.print(strArray[i]);
		// }
		// System.out.println();
		//
		//		}

		// rs.getCsId();

	}
}

