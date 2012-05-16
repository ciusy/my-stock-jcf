package leo.os.service.iface;

import java.util.List;

import leo.entity.OsfnAuthorityForm;

public interface LoginService {
	public String[] getLoginInfo(String loginName,String password);
	public List<OsfnAuthorityForm> getFnAuthorityFormBySid(long sid);
	public String changePassword (String loginname ,String oldpassword, String newpassword1, String newpassword2);	// 更改用户密码
}
