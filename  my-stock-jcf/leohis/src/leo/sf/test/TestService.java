package leo.sf.test;

import java.util.ArrayList;
import java.util.List;

import leo.sf.dao.iface.SfMzInvoiceContentDao;
import leo.sf.dao.iface.SfZyInvoiceContentDao;
import leo.sf.dao.iface.SfipdepositRecordDao;
import leo.sf.service.iface.MZChargeService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	MZChargeService service1 = null;

	SfipdepositRecordDao sfipdepositRecordDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		service1 = (MZChargeService) ctx.getBean("mZChargeService");

		sfipdepositRecordDao = (SfipdepositRecordDao) ctx
				.getBean("sfipdepositRecordDao");
		sfipdepositRecordDao = (SfipdepositRecordDao) ctx
				.getBean("sfipdepositRecordDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		// System.err.println(service1.getCosumer(1));
		System.out
				.println("$Label162@L|$Label163@L|$Label164@L|$Label165@L|$Label166@L|$Label167@L|$Label168@L|$Label169@L|$Label170@L|$Label171@L|$Label172@L|$Label173@L|$Label174@L|$Label175@L|$Label176@L|$Label177@L|$Label178@L|$Label179@L|$Label180@L|$Label181@L|$Label182@L|$Label183@L|$Label184@L|$Label185@L|$Label186@L|$Label187@L|$Label188@L|$Label189@L|$Label190@L|$Label191@L|$Label192@L|$Label193@L|$Label194@L|$Label195@L|$Label196@L|$Label197@L|$Label198@L|$Label199@L|$Label200@L|$Label201@L|$Label202@L|$Label203@L|$Label204@L|$Label205@L|$Label206@L|$Label207@L|$Label208@L|$Label209@L|$Label210@L|$Label211@L|$Label212@L|孔丽$Edit1@E|38$Edit2@E|$Edit3@E|$Edit4@E|山东济宁兖州鼓楼办事处二轻系统$Edit5@E|$Edit6@E|$Edit7@E|$Edit9@E|$Edit10@E|$Edit12@E|$Edit13@E|$Edit14@E|$Edit15@E|$Edit16@E|$Edit17@E|$Edit18@E|$ComboBox1@C|$Edit19@E|$ComboBox2@C|$ComboBox3@C|$Edit21@E|36.7$Edit22@E|78$Edit23@E|110/70$Edit24@E|未闻及病理性杂音$ComboBox4@C|双肺呼吸音清$ComboBox5@C|肋下未触及$ComboBox6@C|肋下未触及$ComboBox7@C|$Edit25@E|$ComboBox8@C|$ComboBox9@C|$ComboBox10@C|$ComboBox11@C|$ComboBox12@C|$ComboBox13@C|$ComboBox14@C|$ComboBox15@C|$Edit26@E|见化验单$Edit27@E|$ComboBox16@C|阴性$ComboBox17@C|阴性$ComboBox18@C|阴性$ComboBox19@C|$Edit28@E|$ComboBox20@C|$Edit32@E|$Edit33@E|$ComboBox21@C|$Edit34@E|$Edit35@E|$Edit36@E|$Edit37@E|$Edit38@E|$ComboBox22@C|$Edit39@E|$Edit40@E|$Edit41@E|$Edit42@E|$ComboBox23@C|$ComboBox24@C|$Edit43@E|$Edit44@E|$Edit45@E|头孢氨苄0.5tid$Edit48@E|$Edit49@E|2011年09月23日$Edit51@E|$Edit52@E|$ComboBox25@C|$ComboBox26@C|$ComboBox27@C|张三|1$ComboBox28@C|张八|8$ComboBox29@C|$ComboBox30@C|$ComboBox31@C|$ComboBox32@C|$ComboBox33@C|"
						.length());

	}

	@Test
	public void test2() {
		// System.err.println(service1.getCosumer("", "", "", "2011-07-20",
		// "2011-07-20"));

		List<String> list = new ArrayList<String>();
		list.add("1");
		List<String> list1 = new ArrayList<String>();
		list1.add("2");

		list.addAll(list1);

		System.out.println(list);

	}

	@Test
	public void test3() {
		// List<String> list = new ArrayList<String>();
		// list.add("2");
		// sfipdepositRecordDao.getTotalByIpIDS(list);

		String s = "(13212)gadsfasdf(456)gadf9090(87541)hsdfgsd";
		String test = s.replaceAll("\\([^)]+\\)", "");
		System.out.println(test);
	}

	@Test
	public void test4() throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		SfMzInvoiceContentDao sfMzInvoiceContentDao = (SfMzInvoiceContentDao) ctx
				.getBean("sfMzInvoiceContentDao");

		sfMzInvoiceContentDao.getOutPatientStatistics("", "", "0");
	}

}
