package leo.common.validata.impl;

import leo.common.validata.ifac.IValiData;
/**
 * 数据验证接口实现
 * @author abc
 *
 */
public class ValiDataImpl implements IValiData {
	/**
	 * Email验证
	 */
	public String valiEmail(String email) {
		// TODO Auto-generated method stub
		int a = email.indexOf("@");
		if(email.indexOf("@") == -1)
			return "必须包含一个@符号";
		if(email.indexOf("@") == 0)
			return "@符号不能在第一位";
		if(email.indexOf(".") == -1)
			return "必须包含一个.符号";
		if(email.indexOf("@") != email.lastIndexOf("@"))
			return "只能有一个@符号";
		if(email.indexOf(".") != email.lastIndexOf("."))
			return "只能有一个.符号";
		if(email.indexOf("@") > email.lastIndexOf("."))
			return "@符号只能在.符号之前";
		if(email.substring(email.indexOf("@") + 1, email.indexOf(".")).equals(""))
			return "@符号与.符号之间不能为空";
		if(email.indexOf(".") + 1 == email.length())
			return "域名填写不完整，例如xxx@xxx.com";
		return "";
	}

}
