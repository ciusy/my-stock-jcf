package leo.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.net.www.http.KeepAliveCache;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 9, 2011 10:15:34 AM
 */
public class CommonUtil {

	public static String GetNewFlowNum(String oldFlowNum) {
		String oldFront = oldFlowNum.substring(0, 10);
		String oldBack = oldFlowNum.substring(10);
		int i = Integer.parseInt(oldBack);
		i++;
		String newBack = String.format("%06d", i);
		String newFlowNum = oldFront + newBack;
		System.out.println(newFlowNum);
		return newFlowNum;
	}

	/**
	 * add by xu 把List<Object[]>转换成String[][]
	 * 
	 * @param list
	 * @return
	 */
	public static String[][] listObject2StringString(List<Object[]> list) {
		int rows = list.size();
		if (rows > 0) {
			int columns = ((Object[]) list.get(0)).length;
			String[][] strings = new String[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++)
					strings[i][j] = String.valueOf(((Object[]) list.get(i))[j]);
			}
			return strings;
		}
		return new String[0][0];

	}

	/**
	 * add by xu 把List<Object[]>转换成List<List<String>>
	 * 
	 * @param list
	 * @return
	 */
	public static List<List<String>> listObject2ListString(List<Object[]> list) {

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> list2 = null;

		for (Object[] objects : list) {

			list2 = new ArrayList<String>();
			for (Object object : objects) {
				list2.add(object.toString());
			}
			returnList.add(list2);

		}

		return returnList;
	}

	public static List<List<String>> addListToList(List<List<String>> list,
			List<List<String>> addedList) {
		if ((null == list || list.isEmpty())) {
			if (null == addedList || addedList.isEmpty())
				return Collections.EMPTY_LIST;
			else {
				return addedList;
			}
		} else {
			if (null == addedList || addedList.isEmpty())
				return list;
			else {
				list.addAll(addedList);
				return list;
			}
		}
	}

	/**
	 * 保留两位小数不是四舍五入，直接舍会2位小数后面 的
	 * 
	 * @param old
	 * @return
	 */
	public static String keep2Decimal(String old) {

		long round = Math.round(Double.parseDouble(old) * 100);
		double d3 = round / 100.0;
		return d3 + "";
	}

	public static void main(String[] args) {
		System.out.println(keep2Decimal("23.232"));
	}
}
