package leo.yf.test;

import java.util.ArrayList;
import java.util.List;

import leo.common.util.DateUtil;
import leo.entity.YfinbankAitem;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfaitemDao;
import leo.yf.dao.iface.YfinbankAitemDao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.service.iface.YfGiveSfService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 26, 2011 2:59:00 PM
 */
public class YfGiveSfServiceTest {

	YfGiveSfService service1 = null;
	YfaitemDao yfExbankAItemDao = null;

	private YfinbankAitemDao yfinbankAitemDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		service1 = (YfGiveSfService) ctx.getBean("yfGiveSfService");
		yfExbankAItemDao = (YfaitemDao) ctx.getBean("YfaitemDao");
		yfinbankAitemDao = (YfinbankAitemDao) ctx.getBean("YfinbankAitemDao");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		// yfExbankAItemDao.getCaiGouBiaoTao("", "", "", -2, "");
		// List<String[]> list2 = yfExbankAItemDao.getCF(list);
		// System.err.println(list.size());
		// System.err.println(list.get(0).length());
		// for (String[] str : list2) {
		// for (int i = 0; i < str.length; i++) {
		// System.err.println(str[i]);
		// }
		// }
		YfinbankAitem yfinbankAitem = new YfinbankAitem();
		yfinbankAitem.setApproveFormId("1");
		yfinbankAitem.setInbankP(1d);
		yfinbankAitem.setItemId(1l);
		yfinbankAitem.setMid(1);
		yfinbankAitem.setNum(1);
		yfinbankAitem.setReduceTotal(2323d);
		yfinbankAitem.setUnit("1");
		yfinbankAitem.setValidityPeriod(DateUtil.getNowTimeStamp());

		yfinbankAitemDao.save(yfinbankAitem);
	}

	@Test
	public void test2() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		YfminbankADao yfminbankADao = (YfminbankADao) ctx
				.getBean("YfminbankADao");

		System.out.println(yfminbankADao.getCFReturnCount("0120111222000001",
				"已入库"));

	}

}
