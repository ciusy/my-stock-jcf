package leo.bc.dao.iface;
import java.util.List;

import leo.entity.CzbcultrasoundImage;

public interface CzbcultrasoundImageDao {
	 public Boolean addCzbcultrasoundImage(String reID,String PicturePath);
	 public List<CzbcultrasoundImage> GetPicturePathByReID(String reID);
}
