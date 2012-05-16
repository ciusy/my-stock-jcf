package leo.common.util;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
public class ChineseToSpell {
	/**
	 * ��������ȫƴ
	 * @param �����ַ���
	 * @return ȫƴ�ַ���
	 */
	public static String getQuanPin(String chinese){
		char[] t1 = null; 
		t1 = chinese.toCharArray();// �����������ת��Ϊ�ַ�������
		
		// ����t2�������ڱ�����������ȫƴ
		String[] t2 = new String[t1.length];
		
		// ���ú���ƴ������ĸ�ʽ
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);// ����ƴ����Сд
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// ���������ʽ
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);//������������
		
		String t4 = "";
		
		try {
			for (int i = 0; i < t1.length; i++) {
				// �ж��Ƿ�Ϊ�����ַ�
				if(Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")){
					// �����ֵļ���ȫƴ���浽t2������
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					// ȡ���ú���ȫƴ�ĵ�һ�ֶ��������ӵ��ַ���t4��
					t4 += t2[0];
				}else {
					// ������Ǻ����ַ������ȡ���ַ������ӵ��ַ���t4��
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
	 * ��ȡ����ƴ������ĸ
	 * @param �����ַ���
	 * @return ƴ������ĸ�ַ���
	 */
	public static String getPinYinHeadChar(String chinese){
		String convert = "";
		for (int i = 0; i < chinese.length(); i++) {
			char word = chinese.charAt(i);
			// ��ȡ���ֵ�����ĸ
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
	 * ������ת��ΪASCII��
	 * @param �����ַ���
	 * @return ASCII���ַ���
	 */
	public static String getCnASCII(String chinese){
		StringBuffer strBuf = new StringBuffer();
		// ���ַ���ת�����ֽ�����
		byte[] bGBK = chinese.getBytes();
		for (int i = 0; i < bGBK.length; i++) {
			// ��ÿ���ַ���ת����ASCII��
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf.toString();
	}
}
