package leo.cs.test;

import java.util.List;

import leo.cf.service.iface.CfmedicalInstService;
import leo.cs.dao.iface.CsconsumerDao;
import leo.cs.dao.impl.CsconsumerDaoImpl;
import leo.cs.service.iface.CsconsumerService;
import leo.entity.Csconsumer;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;
import leo.gh.service.iface.RegisterService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试GhService
 * 
 * @author Administrator
 * 
 */
public class CsTestDao {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		
		CsconsumerService rs = (CsconsumerService) ctx.getBean("CsconsumerService");
		Csconsumer cs = rs.getCInfoByIDCardNum("qqqqq");
		System.out.println(cs.getCsname());
//		CsmedicalCard cc = rs.getCsmedicalCardByCsid(1);
//System.out.println(cc.getMedicalCardNum());
//		String[][] str = rs.getCInfo("", "", "", "", "", "", "");
//		System.out.println(str.length);
//		for(int i=0;i<str.length;i++){
//			for(int j=0;j<str[i].length;j++){
//				System.out.println(str[i][j]);
//			}
//		}
//		System.out.println(str[0][0]+"&&&&"+str[0][1]);
//		String a;
//		String b;
//		a="2011-7-28 17:02:56";
//		b="2011-8-12 17:02:56";
//		String[][] str = rs.getCsmedicalCardDetailByDateandcsid(a, b, 10L);
//		for(int i=0;i<str.length;i++){
//			for(int j=0;j<str[i].length;j++){
//				System.out.println(str[i][j]);
//			}
//		}
		 //List<CsmedicalCardDetail> list = rs.getCsmedicalCardDetailByDateandcsid(a, b, 10L);
//		
//		 System.out.print(list.size());
//		 for(int i=0;i<list.size();i++){
//		 System.out.println(list.get(i).getCgItem());
//		 }
//		CsmedicalCardDetail ab=new CsmedicalCardDetail();
//		ab.setAmount(10.0);
//		ab.setCgItem("bc");
//		ab.setCsId(10L);
//		ab.setCgId("1");
//		ab.setReceiver(19L);
//		rs.addCsmedicalCardDetail(ab);
//		Csconsumer cs = rs.getCInfoById((long) 1);
//		 System.out.println(cs.getCsname() + ","	+ cs.getSex() + "," + cs.getBirthday());
//		//根据身份证查询服务对象
//		CsconsumerDao csDao = (CsconsumerDao) ctx.getBean("CsconsumerDao");
//		
//		String idCardNum = "37082219601223122X";
//		Csconsumer cs = null;
//		cs = csDao.getCInfoByIDCardNum(idCardNum);
//		System.out.println(cs.getBeenHereBefore());
//		boolean b = null == cs.getBeenHereBefore() ? false : true;
//		System.out.println(b);
//		
		// 根据id查询服务对象
//		CsconsumerDao csDao = new CsconsumerDaoImpl();
//		Csconsumer cs = new Csconsumer();
//		cs = csDao.getCInfoById(65611L);
//		System.out.println(cs.getCsname());
//		CfmedicalInstService cs = (CfmedicalInstService)ctx.getBean("CfmedicalInstService");
//		double mprice = Double.valueOf(cs.getValueBydisposeName("病历本价格", 1));
//		System.out.print(mprice);
	}
}
