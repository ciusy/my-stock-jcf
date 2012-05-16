package leo.ydj.service.iface;
import leo.entity.CzcolposcopeImage;
import leo.entity.CzcolposcopeIs;
public interface CzcolposcopeImageService {
	public Boolean addCzcolposcopeImage(String reID,String PicturePath);
	public String [] GetPicturePathByReID(String reID);
}
