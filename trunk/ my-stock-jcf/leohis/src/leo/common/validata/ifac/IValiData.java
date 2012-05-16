package leo.common.validata.ifac;
/**
 * 数据验证接口
 * @author abc
 *
 */
public interface IValiData {
	/**
	 * Email验证
	 * @param email地址
	 * @return 验证结果
	 */
	public String valiEmail(String email);
}
