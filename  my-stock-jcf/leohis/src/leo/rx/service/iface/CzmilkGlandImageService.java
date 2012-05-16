package leo.rx.service.iface;
import leo.entity.CzmilkGlandImage;
import leo.entity.CzmilkGlandIs;
public interface CzmilkGlandImageService {
	public Boolean addCzmilkGlandImage(String reID,String PicturePath);
	public String [] GetPicturePathByReID(String reID);
}
