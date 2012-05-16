package leo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Decoder;

public class FileUtil {
	public static boolean addFile(String name, byte[] bytes) {
		FileOutputStream fos = null;
		try {
			File file=new File("D:\\photo\\"+name+".jpg");
			if(file.isFile() && file.exists()){
				file.delete();
			}
			fos=new FileOutputStream(file); 
			fos.write(bytes); 
			fos.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
