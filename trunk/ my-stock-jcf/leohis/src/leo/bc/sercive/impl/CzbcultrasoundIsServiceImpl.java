package leo.bc.sercive.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import leo.bc.dao.iface.CzbcultrasoundIsDao;
import leo.bc.sercive.iface.CzbcultrasoundIsService;
import leo.entity.CzbcultrasoundIs;

public class CzbcultrasoundIsServiceImpl implements CzbcultrasoundIsService {
	CzbcultrasoundIsDao czbcultrasoundIsDao;

	public void setCzbcultrasoundIsDao(CzbcultrasoundIsDao czbcultrasoundIsDao) {
		this.czbcultrasoundIsDao = czbcultrasoundIsDao;
	}

	public Boolean addCzbcultrasoundIs(String reid,String id,String rename, String csId,
			String bdnDescribe, String bdnVerdict, String istime,
			String isdoctor, String isu, String alterId,String ischeck,String bc) {
		try {
			SimpleDateFormat dfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date datell = dfl.parse(istime);
			String tiem = dfl.format(datell);
			Timestamp te = Timestamp.valueOf(tiem);
			System.out.println(reid );
			
			CzbcultrasoundIs c = new CzbcultrasoundIs(reid,id,rename, new Long(csId),
					bdnDescribe, bdnVerdict,te, new Integer(isdoctor),
					new Integer(isu), alterId ,ischeck,bc);
			if (czbcultrasoundIsDao.addCzbcultrasoundIs(c)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getMaxID() {
		return czbcultrasoundIsDao.getMaxID();
	}
	public String[] getRecordByItemID(String ItemID){
		//0:报告单ID，1报告名称，2诊断描述，3，诊断结论，4，检查医生，5，检查科室，
		List<CzbcultrasoundIs> list = czbcultrasoundIsDao.getRecordByItemID(ItemID);
		String result[]=new String [6];
		if(list.size()==0)
		{
			for (int i=0;i<result.length;i++)
			{
				result[i]="";
			}
			
		}else
		{
			result[0]=String.valueOf(list.get(0).getReid());
			result[1]=String.valueOf(list.get(0).getRename());
			result[2]=String.valueOf(list.get(0).getBdnDescribe());
			result[3]=String.valueOf(list.get(0).getBdnVerdict());
			result[4]=String.valueOf(list.get(0).getIsdoctor());
			result[5]=String.valueOf(list.get(0).getIsu());
	
		}
		

		return result;
		
	}

}
