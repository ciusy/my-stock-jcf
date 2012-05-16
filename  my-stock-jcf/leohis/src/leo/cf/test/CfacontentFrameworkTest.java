package leo.cf.test;

import leo.cf.service.iface.CfacontentFrameworkService;
import leo.entity.CfacontentFramework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CfacontentFrameworkTest {
	public static void main(String[] args) {
		CfacontentFrameworkService rs=null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (CfacontentFrameworkService) ctx.getBean("CfacontentFrameworkService");
		
//		CfacontentFramework c=new CfacontentFramework("我们",1,"手","大嵩岛","大无畏","ccc","而额度是",1);
//		if(rs.addCfacontentFramework(c)){
//			System.out.println("成功");
//		}else{
//			System.out.println("失败");
//		}
		//System.out.println(rs.deleteCfacontentFramework(new Integer(3)));
//		CfacontentFramework c=new CfacontentFramework();
//		c.setFormworkId(new Integer(2));
//		c.setFormName("你们");
//		System.out.print(rs.updateCfacontentFrameworkById(c));
		CfacontentFramework c=rs.getCfacontentFrameworkByID(new Integer(1));
		System.out.println(c.getFormName());

	}

}
