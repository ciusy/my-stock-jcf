package leo.bc.sercive.iface;

import java.util.List;

import leo.entity.CzbcultrasoundIs;
import leo.entity.Czdispose;
import leo.entity.CznkendIs;
import leo.entity.CzshbioIsre;

public interface DisposeService {
	public List<Czdispose> getDisposeInfo(int executeU, int fnBlockID, int day, String nowTime);
	public String[][] getDisposeConsumerInfo(int excuteU);
	public String[][] getDisposeConsumerInfoEx(int excuteU);
	public String[][] getStatisticInfo( int executeU,String QueryItem, String startTime,String endTime) ;
	public void setDisposeStatus(String itemid,Long executePerson,String executeTime);
	public boolean addCznkendIs(CznkendIs cznkendIs);//��д�ڿ������棻
	public boolean  addCzshbioIsre(CzshbioIsre czshbioIsre);//��д�������鱨�棻
	//public String[][] getYetDisposeInfo(int executeU, int fnBlockID);
	public String[][] getYetDisposeInfo(int executeU,String csName,String uname,String csage,String starttime,String endtime);//csName �������������uname ��������ڱ����ұ�			
	public String[][] getYetDisposeInfoEx(int executeU,String csName,String uname,String csage,String starttime,String endtime);
	public CzbcultrasoundIs getCzbcultrasoundIs(String itemId);		
	public boolean updateDepositBalance(String ZhuYuanHao, double FeiYong); 
	
}
