package leo.bc.sercive.iface;
import leo.entity.CzbcultrasoundImage;
import leo.entity.CzbcultrasoundIs;
public interface CzbcultrasoundImageService {
	public Boolean addCzbcultrasoundImage(String reID,String PicturePath);
	public String [] GetPicturePathByReID(String reID);
}
