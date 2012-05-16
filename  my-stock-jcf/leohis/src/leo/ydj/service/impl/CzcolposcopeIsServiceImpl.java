package leo.ydj.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import leo.ydj.dao.iface.CzcolposcopeIsDao;
import leo.ydj.service.iface.CzcolposcopeIsService;
import leo.entity.CzcolposcopeIs;

public class CzcolposcopeIsServiceImpl implements CzcolposcopeIsService {
	CzcolposcopeIsDao czcolposcopeIsDao;

	public void setCzcolposcopeIsDao(CzcolposcopeIsDao CzcolposcopeIsDao) {
		this.czcolposcopeIsDao = CzcolposcopeIsDao;
	}

	public Boolean addCzcolposcopeIs(String reid,String id,String rename, String csId,
			String bdnDescribe, String bdnVerdict, String istime,
			String isdoctor, String isu, String alterId,String num,String ischeck) {
		try {
			
			SimpleDateFormat dfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date datell = dfl.parse(istime);
			String time = dfl.format(datell);
			Timestamp te = Timestamp.valueOf(time);
			//System.out.println(reid );
			//System.out.println(te);
			//System.out.println(istime);
			CzcolposcopeIs c = new CzcolposcopeIs(reid,id,rename, new Long(csId),
					bdnDescribe, bdnVerdict,te, new Integer(isdoctor),
					new Integer(isu), alterId,num ,ischeck);
			if (czcolposcopeIsDao.addCzcolposcopeIs(c)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getMaxID() {
		return czcolposcopeIsDao.getMaxID();
	}
	public String[]getRecordByItemID(String ItemID){
		List<CzcolposcopeIs> list = czcolposcopeIsDao.getRecordByItemID(ItemID);
		String result[]=new String [7];

		//0:报告单ID，1报告名称，2诊断描述，3，诊断结论，4，检查医生ID，5，检查科室ID，6检查号
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
			result[2]=String.valueOf(list.get(0).getCdnDescribe());
			result[3]=String.valueOf(list.get(0).getCdnVerdict());
			result[4]=String.valueOf(list.get(0).getIsdoctor());
			result[5]=String.valueOf(list.get(0).getIsu());
			result[6]=String.valueOf(list.get(0).getIsnum());
		}
		return result;
		
	}

}
