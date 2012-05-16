package leo.cf.test;

import java.util.ArrayList;
import java.util.List;
import leo.cf.service.iface.CfacontentFrameworkService;
import leo.entity.CfacontentFramework;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CFTest2JCF {

	private CfacontentFrameworkService rs;
	
	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (CfacontentFrameworkService) ctx.getBean("CfacontentFrameworkService");
	}
	
	@Test
	public void testGetCfacontentFrameworkByAffiliation(){
		List<CfacontentFramework> lst = new ArrayList<CfacontentFramework>();
		lst = rs.getCfacontentFrameworkByAffiliation(1,1);
		System.out.println(lst.size());
	}
}
