package leo.ydj.dao.iface;
import java.util.List;

import leo.entity.CzcolposcopeImage;

public interface CzcolposcopeImageDao {
	 public Boolean addCzcolposcopeImage(String reID,String PicturePath);
	 public List<CzcolposcopeImage> GetPicturePathByReID(String reID);
}
