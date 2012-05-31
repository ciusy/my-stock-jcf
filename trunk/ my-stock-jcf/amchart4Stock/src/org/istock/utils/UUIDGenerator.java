package org.istock.utils;
import java.util.UUID;   
  
/**  
 * ���ȫ��Ψһ��ʾ UUID  
 *   
 * @author Metanoia.Lang  
 *   
 */  
public class UUIDGenerator {   
    /**  
     * ���һ��ȥ��"-"��UUID 32bits ��: "863a74e5c9a54395862179721918d7a7"  
     *    
     * @return String UUID  
     */  
    public static String getUUID() {   
        String s = UUID.randomUUID().toString();   
        return s;
        // ȥ��"-"���   
//        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)   
//                + s.substring(19, 23) + s.substring(24);   
    }   
  
    /**  
     * ���ָ����Ŀ��UUID  
     * ��:{"e7d83456191d4f8fa37c722df3af4017","196a0e99817f46679fb82d52d4ec39a3"}  
     *   
     * @param number  
     *            int ��Ҫ��õ�UUID����  
     * @return String[] UUID����  
     */  
    public static String[] getUUID(int number) {   
        if (number < 1) {   
            return null;   
        }   
        String[] ss = new String[number];   
        for (int i = 0; i < number; i++) {   
            ss[i] = getUUID();   
        }   
        return ss;   
    }   
  
  public static void main(String[] args) {   
//      String[] ss = getUUID(10);   
//      for (int i = 0; i < ss.length; i++) {   
//          System.out.println(ss[i]);   
//      }
	  
	  System.out.println(getUUID().length());
  }   
}  