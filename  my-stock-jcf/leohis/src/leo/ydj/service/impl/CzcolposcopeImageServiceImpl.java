package leo.ydj.service.impl;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import leo.ydj.dao.iface.CzcolposcopeImageDao;
import leo.ydj.dao.iface.CzcolposcopeIsDao;
import leo.ydj.service.iface.CzcolposcopeImageService;
import leo.entity.CzcolposcopeImage;
import leo.entity.Czdispose;

public class CzcolposcopeImageServiceImpl implements CzcolposcopeImageService {
	CzcolposcopeImageDao czcolposcopeImageDao;
	public void setCzcolposcopeImageDao(CzcolposcopeImageDao czcolposcopeImageDao) {
		this.czcolposcopeImageDao = czcolposcopeImageDao;
	}
	public Boolean addCzcolposcopeImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		if (czcolposcopeImageDao.addCzcolposcopeImage(reID,PicturePath)) {
			return true;
		}
		return false;
	}
	public String [] GetPicturePathByReID(String reID){
		List<CzcolposcopeImage> list = czcolposcopeImageDao.GetPicturePathByReID(reID);
		String result[]=new String[list.size()];
		if(list.size()>2)
		{
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			result[i]=String.valueOf(list.get(i).getPictureWay()); 
		}
		return result;
		
	}
}
