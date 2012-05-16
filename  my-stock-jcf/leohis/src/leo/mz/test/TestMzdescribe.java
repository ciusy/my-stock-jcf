package leo.mz.test;

import java.util.List;

import leo.entity.CzdisposeItemDescribe;
import leo.mz.service.iface.MzopDnService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMzdescribe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MzopDnService rs=null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rs = (MzopDnService) ctx.getBean("MzopDnService");
		
//		String number="1";
//		Long b=Long.parseLong(number);
//		List list=rs.getCzdItemById(b);
//		System.out.println(list.size());
		
		//CzdisposeItemDescribe c= new CzdisposeItemDescribe();
		//CzdisposeItemDescribe c=rs.getCzdisposeItemDescribeByitemTypeId(1);
		//System.out.println("出来了"+c.getSpell());
	//	rs.deleCzdisposeItemDescribebyItemTypeId(9);
//		c.setItemName("222");
//		c.setFunctionalModule(2);
//		c.setNeedWriteApply(true);
//		c.setCost(2.2);
//		c.setSpell("2");
//		c.setExecuteU(2);
//		c.setRemarks("2");
//		c.setCsu(2);
//		c.setDisposeItemType("222");
//		c.setMedicalInstId(2);
//		
//		rs.saveCzdisposeItemDescribe(c);
//		c.setItemTypeId(5);
//		c.setCost(4.4);
//		rs.updateCzdisposeItemDescribe(c);
//		
		//rs.deleCzdisposeItemDescribe(5);
		
		CzdisposeItemDescribe c=rs.getCzdisposeItemDescribeByitemName("213");
		System.out.println(c.getItemName()+"还有"+c.getCost());
	}

}
