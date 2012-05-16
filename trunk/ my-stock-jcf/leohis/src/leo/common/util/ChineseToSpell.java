package leo.common.util;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
public class ChineseToSpell {
	/**
	 * 生成中文全拼
	 * @param 中文字符串
	 * @return 全拼字符串
	 */
	public static String getQuanPin(String chinese){
		char[] t1 = null; 
		t1 = chinese.toCharArray();// 将输入的中文转换为字符型数组
		
		// 声明t2数组用于保存所有种类全拼
		String[] t2 = new String[t1.length];
		
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 设置拼音大小写
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 设置输出方式
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);//设置音标类型
		
		String t4 = "";
		
		try {
			for (int i = 0; i < t1.length; i++) {
				// 判断是否为汉字字符
				if(Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")){
					// 将汉字的几种全拼都存到t2数组中
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					// 取出该汉字全拼的第一种读音并连接到字符串t4后
					t4 += t2[0];
				}else {
					// 如果不是汉字字符，间接取出字符并连接到字符串t4后
					t4 += Character.toString(t1[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t4;
	}
	/**
	 * 获取中文拼音首字母
	 * @param 中文字符串
	 * @return 拼音首字母字符串
	 */
	public static String getPinYinHeadChar(String chinese){
		String convert = "";
		for (int i = 0; i < chinese.length(); i++) {
			char word = chinese.charAt(i);
			// 提取汉字的首字母
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if(pinyinArray != null){
				convert += pinyinArray[0].charAt(0);
			}else{
				convert += word;
			}
		}
		return convert;
	}
	/**
	 * 将中文转换为ASCII码
	 * @param 中文字符串
	 * @return ASCII码字符串
	 */
	public static String getCnASCII(String chinese){
		StringBuffer strBuf = new StringBuffer();
		// 将字符串转换成字节序列
		byte[] bGBK = chinese.getBytes();
		for (int i = 0; i < bGBK.length; i++) {
			// 将每个字符串转换成ASCII码
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf.toString();
	}
}
