package leo.os.test;


import java.util.List;

import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osuform;
import leo.os.service.iface.GiveGhService;
import leo.os.service.iface.OsuformService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	  
	/**  
	 * Client ���Զ�;  
	 * @author Administrator  
	 *  
	 */  
	public class OsTest {   
	  
	    /**  
	     * ������;  
	     * @param args  
	     */  
	    public static void main(String[] args) {
	    	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"classpath:applicationContext.xml");
	    	OsuformService ofs = (OsuformService)ctx.getBean("osuformService");
	    	int sid=20;
	    	int[] uidlist;
	    	uidlist = new int[2];
	    	uidlist[0]=1;
	    	uidlist[1]=2;
	    	ofs.addOsunitHasSBySidandUid(sid, uidlist);
	    	
//	    	List<OsfnBlocks> list = ofs.getFnBlocksByUID(50);
//	    	for (int i = 0; i < list.size(); i++) {
//				OsfnBlocks  ob = list.get(i);
//	    		System.out.println(ob.getFnBlocksName());
//			}
//	    	OsuformService ofs = (OsuformService)ctx.getBean("osuformService");
//	    	List<Osuform> list = ofs.getOsuformByMEIIDandOType(1, "�շ�");
//	    	for (int i = 0; i < list.size(); i++) {
//				Osuform osf = list.get(i);
//				System.out.println(osf.getUname());
//			}
//	    	LoginService ls = (LoginService) ctx.getBean("LoginService");
//	    	String[] strs = ls.getLoginInfo("zhangsan", "1");
//	    	for(int i=0;i<strs.length;i++){
//	    		System.out.println(strs[i]);
//	    	}
//	    	
	    	
//	    	GiveGhService ggs = (GiveGhService) ctx.getBean("GiveGhService");
////	    	OsmedicalInstInfo o = ggs.getOsmedicalInstInfoById(1);
////System.out.println(o.getTown());
//    	List<Osuform> list = ggs.getRegestUFormByMid(1);
//	    	for(int i=0;i<list.size();i++){
//	    		System.out.println(list.get(i).getUname());
//	    	}
//	    	
//	    	String[][] str = ggs.getExpertStuffByUid(1);	    	
//	    	for(int i=0;i<str.length;i++){
//	    		for(int j=0;j<str[i].length;j++){
//	    			System.out.println(str[i][j]);
//	    		}
//	    	}
	    	
//	    	String[] str = ggs.getUformByRidAndMid(1, 1);
//	    	for(int i=0;i<str.length;i++){
//	    		System.out.println(str[i]);
//	    	}
//	    	List<Osuform> list = ggs.getRegestUFormByMid(1);
//	    	for(int i =0;i<list.size();i++){
//System.out.println(list.get(i).getUname());
//	    	}
//	    	GiveGhService ggs = (GiveGhService) ctx.getBean("GiveGhService");
//	    	ggs.aaaa();
	    	/*----------��ɺ�����ר��-------------*/
//	    	OsuformService os = (OsuformService) ctx.getBean("osuformService");
//	    	String[] otypename = {
//					//�����������޸Ŀ���������޸Ĵ˴�
//					"�Һ�","����","�շ�","ҩ��","��Ӧ","סԺ","�칫","B��"
//				};
//	    	String[][] uinfo= os.getUidBySidAndOType(1,otypename);
//	    	int i,j;
//	    	for(i=0;i<otypename.length;i++)
//	    		for(j=0;j<2;j++)
//	    	{
//	    		System.out.println(uinfo[i][j]);
//	    	}
//	    	System.out.println(os.getUNameByUid(uid));
	    	/*----------��ɺ�����ר�ý���-------------*/
	    	
	    }   
	}  
