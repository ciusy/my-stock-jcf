package leo.mz.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import leo.entity.Czdispose;
import leo.entity.MzopDn;
import leo.mz.service.iface.MzopDnService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMzopDn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MzopDnService mdService = (MzopDnService)ctx.getBean("MzopDnService");
		mdService.deleteByopId("21");
//		List<Czdispose> czd = mdService.getCzdisposeByKindID("0220110929000003");
//		System.out.println(czd.get(0).getKindId());
//		List<MzopDn> list = mdService.getMzopDnByCondition("370823197301024844");
//		for (int i = 0; i < list.size(); i++) {
//			MzopDn md = list.get(i);
//			System.out.println(md.getOpnum());
//		}
//		MzopDn mz = new MzopDn();
//		mz.setChief(chief)
	}

}
