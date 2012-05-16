package leo.bc.sercive.impl;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import leo.bc.dao.iface.CzbcultrasoundImageDao;
import leo.bc.dao.iface.CzbcultrasoundIsDao;
import leo.bc.sercive.iface.CzbcultrasoundImageService;
import leo.entity.CzbcultrasoundImage;
import leo.entity.Czdispose;

public class CzbcultrasoundImageServiceImpl implements CzbcultrasoundImageService {
	CzbcultrasoundImageDao czbcultrasoundImageDao;
	public void setCzbcultrasoundImageDao(CzbcultrasoundImageDao czbcultrasoundImageDao) {
		this.czbcultrasoundImageDao = czbcultrasoundImageDao;
	}
	public Boolean addCzbcultrasoundImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		if (czbcultrasoundImageDao.addCzbcultrasoundImage(reID,PicturePath)) {
			return true;
		}
		return false;
	}
	public String [] GetPicturePathByReID(String reID){
		List<CzbcultrasoundImage> list = czbcultrasoundImageDao.GetPicturePathByReID(reID);
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
