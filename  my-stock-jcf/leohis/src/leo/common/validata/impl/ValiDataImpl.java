package leo.common.validata.impl;

import leo.common.validata.ifac.IValiData;
/**
 * ������֤�ӿ�ʵ��
 * @author abc
 *
 */
public class ValiDataImpl implements IValiData {
	/**
	 * Email��֤
	 */
	public String valiEmail(String email) {
		// TODO Auto-generated method stub
		int a = email.indexOf("@");
		if(email.indexOf("@") == -1)
			return "�������һ��@����";
		if(email.indexOf("@") == 0)
			return "@���Ų����ڵ�һλ";
		if(email.indexOf(".") == -1)
			return "�������һ��.����";
		if(email.indexOf("@") != email.lastIndexOf("@"))
			return "ֻ����һ��@����";
		if(email.indexOf(".") != email.lastIndexOf("."))
			return "ֻ����һ��.����";
		if(email.indexOf("@") > email.lastIndexOf("."))
			return "@����ֻ����.����֮ǰ";
		if(email.substring(email.indexOf("@") + 1, email.indexOf(".")).equals(""))
			return "@������.����֮�䲻��Ϊ��";
		if(email.indexOf(".") + 1 == email.length())
			return "������д������������xxx@xxx.com";
		return "";
	}

}
