package leo.rx.service.impl;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import leo.rx.dao.iface.CzmilkGlandImageDao;
import leo.rx.dao.iface.CzmilkGlandIsDao;
import leo.rx.service.iface.CzmilkGlandImageService;
import leo.entity.CzmilkGlandImage;
import leo.entity.Czdispose;

public class CzmilkGlandImageServiceImpl implements CzmilkGlandImageService {
	CzmilkGlandImageDao czmilkGlandImageDao;
	public void setCzmilkGlandImageDao(CzmilkGlandImageDao czmilkGlandImageDao) {
		this.czmilkGlandImageDao = czmilkGlandImageDao;
	}
	public Boolean addCzmilkGlandImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		if (czmilkGlandImageDao.addCzmilkGlandImage(reID,PicturePath)) {
			return true;
		}
		return false;
	}
	public String [] GetPicturePathByReID(String reID){
		List<CzmilkGlandImage> list = czmilkGlandImageDao.GetPicturePathByReID(reID);
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
