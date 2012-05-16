package leo.rx.dao.iface;
import java.util.List;

import leo.entity.CzmilkGlandImage;

public interface CzmilkGlandImageDao {
	 public Boolean addCzmilkGlandImage(String reID,String PicturePath);
	 public List<CzmilkGlandImage> GetPicturePathByReID(String reID);
}
